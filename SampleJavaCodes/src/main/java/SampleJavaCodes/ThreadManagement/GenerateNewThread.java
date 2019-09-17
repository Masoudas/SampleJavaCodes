/* 
We can generate a new thread in two ways:
1- By implementing the runnable interface:
2- Extending the thread class.

Apparently, there can be a case where child threads can finish later than main threads,
if we imporperly manipulate them (for example using long sleeps). We must make sure that
the main thread finishes last (if necessary)!

So the point is that when starting a new thread, the scheduler may stop our thread,
execute another thread, and then come back to our current thread. This is
what happens when we run this code.

Notice that in the main method, when we run the threads, we naturally jump to the next line
of program, because that program is being run in another thread. Had we no other threads,
we should have waited for tGenerator1.startThread() to finish in order to go to
tGenerator2.startThread() for example. The problem with this program is that
the main thread ends before other threads, naturally, because the main thread is not extended!

*/

package SampleJavaCodes.ThreadManagement;

class ThreadGenerator implements Runnable {
    // When implementing the runnable interface, we need to have a thread class to
    // actually run the thread! For this end, we should give an object that
    // implements
    // runnable interface to the Thread object and then start the thread.
    private Thread thread;
    private String threadName;

    public ThreadGenerator(String threadName) {
        this.threadName = threadName;
        thread = new Thread(this, threadName);
        System.out.println(Thread.currentThread()); // This will still printout the main thread, because the thread has
                                                    // not started yet.
    }

    public void startThread() {
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Now we enter " + threadName + " territory");
        Thread cThread = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(cThread);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // The code that is written inside this method is executed in a separate thread.

    }

    public static void main(String[] args) {
        // This would be the first thread.
        ThreadGenerator tGenerator1 = new ThreadGenerator("Thread one");
        tGenerator1.startThread();

        // This would be the second thread.
        ThreadGenerator tGenerator2 = new ThreadGenerator("Thread two");
        tGenerator2.startThread();

        // This would be the second thread.
        ThreadGenerator tGenerator3 = new ThreadGenerator("Thread three");
        tGenerator3.startThread();

        System.out.println(Thread.currentThread());
        // Thread cThread = Thread.currentThread();
        // System.out.println(cThread);
    }

}

// We can achieve an identical goal by extending the thread class.

class ThreadGeneratorByExtension extends Thread {
    public ThreadGeneratorByExtension() {
        super("New Thread");
    }

    @Override
    public void run() {
        System.out.println("Now we enter the new thread territory");
        Thread cThread = Thread.currentThread();
        System.out.println(cThread);
        // The code that is written inside this method is executed in a separate thread.
        System.out.println("This code is generated in the new thread");
    }

    public static void main(String[] args) {
        Thread cThread = Thread.currentThread();
        System.out.println(cThread);

        ThreadGeneratorByExtension tGenerator = new ThreadGeneratorByExtension();
        tGenerator.start();

    }
}

// In order to assure that the main thread does not die before child threads, we set it to sleep after
// other threads have started performing, a longer sleep than other threads.

class MainThreadKeeper {
    public static void main(String[] args) {
        /* It is wrong to put the main thread to sleep here, because we still have not started the
        other threads
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
        // This would be the first thread.
        ThreadGenerator tGenerator1 = new ThreadGenerator("Thread one");
        tGenerator1.startThread();

        // This would be the second thread.
        ThreadGenerator tGenerator2 = new ThreadGenerator("Thread two");
        tGenerator2.startThread();

        // This would be the second thread.
        ThreadGenerator tGenerator3 = new ThreadGenerator("Thread three");
        tGenerator3.startThread();

        try {
            Thread.sleep(1000); // Question, why do we access through a static method, and do not
                                // give the name of the thread (main here)? What I mean is that would it not
                                // put another thread in sleep? The answer is that this part of the code is 
                                // being executed in the main thread. Hence, I don't need to specify that 
                                // I want to put the main thread in sleep. Hence, we see that the sleep function in
                                // the run method of other threads correspond to delay in those threads.
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread());


    }

}

// Now to keep the main thread alive, we may put it to sleep for example.
