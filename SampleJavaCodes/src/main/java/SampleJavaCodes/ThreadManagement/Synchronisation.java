package SampleJavaCodes.ThreadManagement;

/**
 * Synchronisation: When two or more threads need access to a shared resource,
 * they need some way to ensure that the resource will be used by only one
 * thread at a time. The process by which this is achieved is called
 * synchronization. This may happen when for example one thread tries to write on a
 * file and another trying to read from it.
 * 
 * 
 * First, we need to understand what being unsynchronised mean. 
 * In the following example, three threads try to access the same resource, which
 * in this case is an instance of the CallMe class. We see that Because of multithreading
 * we relinquish control of execution to allow for execution of other methods and then
 * come back. Hence, we see a bizzare behavior in the output. That is for two threads,
 * the arr is shown to be zero, then for the thrid one it is printed as one (if this was not
 * the case, try and increase the array size). All this happens because nothing exists to stop
 * simultaneous call to the same method. In other words, we do not wait for the execution of one
 * method to end, before allowing access by another method.
 * 
 * An interesting phenomenon that happens here is the racing, where the three methods
 * are in competition to complete the method.
 * 
 * Now to prevent this situation, we use the synchronization keyword. Note that the only entity
 * that is allowed to be synchronized inside a class is a method. This implies that the fields
 * of a class or variables cannot be declared synchronized. In other words, access to content
 * of a class can only be synchronised through the methods of that class.
 * 
 */

class CallMe {
    // This would be the resource used by the threads.
    int[] arr = new int[10];

    void call(String which) {
        System.out.println("The thread that is accessing is: " + which);
        for (int var : arr) {
            System.out.println(var);
        }

        arr[0] = 1;
        arr[1] = 1;
    }
}

class Caller implements Runnable {
    Thread thread;
    CallMe callMe;
    String str;

    public Caller(CallMe callMe, String str) {
        thread = new Thread(this);
        this.callMe = callMe;
        this.str = str;
    }

    @Override
    public void run() {
        callMe.call(str);
    }

}

class UnSynch {
    public static void main(String[] args) {
        CallMe callMe = new CallMe();   // The same object is used on three different threads.
                                        // First, we call a print method, but due to lack of synchronization,
                                        // the execution of command is not terminated.

        Caller caller1 = new Caller(callMe, "Thread one");
        Caller caller2 = new Caller(callMe, "Thread two");
        Caller caller3 = new Caller(callMe, "Thread three");

        caller1.thread.start();
        caller2.thread.start();
        caller3.thread.start();

        try {

            caller1.thread.join();
            caller2.thread.join();
            caller3.thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

// Synchronizing the whole process.
// Note however this is not necessarily the solution. What if for example another thread tries
// to access the elements of this class (not the method, just the class field) 
// while it is being updated? It is very important to think of these things during synchronization.
// One alternative is to make the entire class synchronized, as in the next example.

class SynchronizedCallMe {
    int[] arr = {0,0};

    // Basically by adding synchronized, we tell other threads that you have to wait for the execution of
    // this method in a thread to end, and then call it.
    synchronized void call(String which) {
        System.out.println("The thread that is accessing is: " + which);
        
        for (int var : arr) {
            System.out.println(var);
        }

        arr[0] = 1;
        arr[1] = 1;
    }
}

class CallerToSynchronized implements Runnable {
    String thrdName;
    Thread thread;
    SynchronizedCallMe callMe;

    public CallerToSynchronized(SynchronizedCallMe callMe, String thrdName) {
        thread = new Thread(this);
        this.callMe = callMe;
        this.thrdName = thrdName;
    }

    @Override
    public void run() {
        callMe.call(thrdName);

    }

    public static void main(String[] args) {
        SynchronizedCallMe callMe = new SynchronizedCallMe();   // The same object is used on three different threads.
                                        // First, we call a print method, but due to lack of synchronization,
                                        // the execution of command is not terminated.

        CallerToSynchronized caller1 = new CallerToSynchronized(callMe, "Thread One");
        CallerToSynchronized caller2 = new CallerToSynchronized(callMe, "Thread Two");
        CallerToSynchronized caller3 = new CallerToSynchronized(callMe, "Thread Three");

        caller1.thread.start();
        caller2.thread.start();
        caller3.thread.start();

        try {
            for (int var : callMe.arr) {
                System.out.println("Values on execution of the threads:" + var);                
            }
            
            caller1.thread.join();
            // We are certain after the execution of the thread that this would be 1.
            for (int var : callMe.arr) {
                System.out.println("Values after execution of the threads:" + var);                
            }

            caller2.thread.join();
            caller3.thread.join();



        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}

/* Now suppose not all methods of a class are synchronized (for example in a code written by
someone else). Then how can we restrict access to just one thread?
The answer is through a synchronization block.

In the following example, we use the CallMe class that does not have synchronization in a block.
Note that a resource is synchronized by reference. Hence when using a synchronized block, the JAVA VM
momentarily prohibits access by other threads.


Note again that a synchronization block does not synchronize the fields, only the methods of the object. synchronization
of the fields does not exist!
*/

class CallerWithSynchBlock implements Runnable {
    Thread thread;
    CallMe callMe;
    String str;

    public CallerWithSynchBlock(CallMe callMe, String str) {
        thread = new Thread(this);
        this.callMe = callMe;
        this.str = str;
    }

    @Override
    public void run() {
        synchronized(callMe){
            callMe.call(str);
        }
        

    }

    public static void main(String[] args) {
        CallMe callMe = new CallMe();   // The same object is used on three different threads.
                                        // First, we call a print method, but due to lack of synchronization,
                                        // the execution of command is not terminated.

        CallerWithSynchBlock caller1 = new CallerWithSynchBlock(callMe, "Thread One");
        CallerWithSynchBlock caller2 = new CallerWithSynchBlock(callMe, "Thread Two");
        CallerWithSynchBlock caller3 = new CallerWithSynchBlock(callMe, "Thread Three");

        caller1.thread.start();
        caller2.thread.start();
        caller3.thread.start();

        try {

            caller1.thread.join();
            caller2.thread.join();
            caller3.thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

