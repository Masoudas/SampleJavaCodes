
package SampleJavaCodes.ThreadManagement;

/**
 * Consider this problem. Suppose that one class produceses a variable (producer
 * class) and the consumer class uses that data (say an integer). Also suppose
 * that the producer has to wait for the consumer to finish before it can update
 * the data.
 * 
 * Suppose we have three entities: Class Q: the queue object, produced by the
 * producer, Class Producer: The producer of Q, Class Consumer: The class that
 * consumes the data What happens is that we produce and object of type Q. The
 * producer fills it, and then the consumer tries to consume it.
 * 
 * 
 * 
 * 
 * Go to the end of this document to see the formal defintion of all the methods.
 */

// Consider the first implementation. The obvious problem here is that we are
// not synchronized,
// hence we get jibberish outputs, i.e., set method is run several times before
// get method.
// Note that we can improve this method defining a boolean that checks whether
// the reading has been
// done, to then set the value. However, this is not the best solution. Suppose
// for example if there were
// many users. Also, the CPU clock wasted on calling the thread, checking the
// flag and so forth is not
// worth it.

class Q {
    private int n;

    public int get() {
        System.out.println("Got: " + n);
        return n;

    }

    public void set(int n) {
        this.n = n;
        System.out.println("Set: " + n);
    }
}

class Producer implements Runnable {
    private Q q;
    public Thread t;

    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer thread");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.set(i++);
        }

    }

}

class Consumer implements Runnable {
    private Q q;
    public Thread t;

    Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer thread");
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }

    }

    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        producer.t.start();
        consumer.t.start();
    }

}

// Now notice that we cannot use the join or isAlive methods here, because the
// threads are
// working forever. Now, let's try synchronizing them using a block. Meaning we
// change producer 1
// run method to prohibit unsynchronized access.
// The problem here is that synchronization is defined for a method, not the
// variables. Hence,
// 1- The integer value is not synchronized among the two producer-consumer
// classes (remember that synchronization only
// synchronizes the use of methods).
// 2- The two methods are not used by both threads. Hence, synchronization does
// not even make sense here,
// because we are not even accessing the same methods here

class Producer1 implements Runnable {
    private Q q;
    public Thread t;

    Producer1(Q q) {
        this.q = q;
        t = new Thread(this, "Producer thread");
    }

    @Override
    public void run() {
        int i = 0;

        synchronized (q) {
            while (true) {
                q.set(i++);
            }

        }

    }

    public static void main(String[] args) {
        Q q = new Q();
        Producer1 producer1 = new Producer1(q);
        Consumer consumer = new Consumer(q);

        producer1.t.start();
        consumer.t.start();
    }

}

/*
 * Now to properly solve the problem, we modify the resource as follows. First
 * we add the wait method. What it does is that
 * 
 * As we call the wait(), the thread stops. 
 * What triggers the continuation of the thread? If we use the notify()
 * method of the same class. 
 * Note again that the notify and wait methods are called inside different methods, 
 * but of course they affect the same object. So they synchronize the use of an object
 * in a way that the synchronize method cannot.
 
 * Normally, we want to set the notify method at the end of the execution of a method
 * to indicate that it has finished its job to the class (and hence other methods that use
 * that class). 
 * 
 * Also, why not wait at the end of a method, right after we have notified others that
 * the execution of the current method is over? Well, this is possible, but the whole premise
 * of producer consumer method was that we were supposed to wait for the producer to finish before
 * the consumer does its thing. Hence, makes sense to wait for a notification. Another problem with this 
 * approach is that we may lose synchronisation in between the two threads, especially if both threads
 * notify at the same time (because one class drags longer) then we get a problem!
 * Hence, we use a boolean to indicate that one method has finished, as well
 * as the notify method. What does the boolean valueSet do here? 
 * It notifies the other method whether or not it should still wait, just as a precaution.
 * We can put the boolean in an if loop and it will work just fine, however, there may be exceptional 
 * cases where suddenly the wait method stops functioning. To avoid such cases, it is best to 
 * use the while loop.
 * The official book says:
 * Before working through an example that illustrates interthread
*  communication, an important point needs to be made. Although wait( )
*  normally waits until notify( ) or notifyAll( ) is called, there is a possibility that
*  in very rare cases the waiting thread could be awakened due to a spurious
*  wakeup. In this case, a waiting thread resumes without notify( ) or notifyAll( )
*  having been called. (In essence, the thread resumes for no apparent reason.)
*  Because of this remote possibility, the Java API documentation recommends
*  that calls to wait( ) should take place within a loop that checks the condition on
*  which the thread is waiting. 
* 
*/

class QNotified {
    public int n;
    public boolean valueSet = false;

    synchronized public int get() {
        while (!valueSet) {
            try {
                wait(); // Wait, waits for receiving a notification.
            } catch (InterruptedException e) {
                System.out.println("Exception caught");
            }
        }

        this.valueSet = false;
        System.out.println("Get: " + n);

        notify(); // So notify tells that this method is over!
        return n;
    }

    synchronized public void set(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception caught");
            }
        }

        this.n = n;
        this.valueSet = true;
        System.out.println("Set: " + n);

        notify();

    }

}

class Producer2 implements Runnable {
    private QNotified q;
    public Thread t;

    Producer2(QNotified q) {
        this.q = q;
        t = new Thread(this, "Producer thread");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.set(i++);
        }

    }

}

class Consumer2 implements Runnable {
    private QNotified q;
    public Thread t;

    Consumer2(QNotified q) {
        this.q = q;
        t = new Thread(this, "Consumer thread");
    }

    @Override
    public void run() {
        while (true) {
            q.get();

        }

    }

    public static void main(String[] args) {
        QNotified q = new QNotified();
        Producer2 producer = new Producer2(q);
        Consumer2 consumer = new Consumer2(q);

        producer.t.start();
        consumer.t.start();
    }

}
/*
* wait( ): Tells the calling thread to give up the monitor and go to sleep until
* some other thread enters the same monitor and calls notify( ) or
* notifyAll( ): Wakes up all the threads that called wait( ) on the same
* object. One of the threads will be granted access.
* notify(): Wakes up a thread that called wait( ) on the same object

*/
