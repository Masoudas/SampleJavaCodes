/* Usually we want to wait for a thread to finish, or if it is not going to finish just terminate it.
The method isAlive() in the Thread class shows whether a method is still alive or not.
The method join() is more commonly used. This method waits until the thread on which it is called terminates. 
Its name comes from the concept of the calling thread (for example the main thread
in the following code) waiting until the specified thread (child thread) joins it (Don't know,
maybe means be able to relinquish control).


So a main difference between isAlive() and join() is that with join(), the current thread stops
at the line this method is being executed, and has to wait there until the thread being
called finishes its execution, whereas with isAlive(), we just check a boolean
and continue the execution of the thread.

*/

package SampleJavaCodes.ThreadManagement;

/**
 * JoinAThread
 */
public class JoinAThread implements Runnable {
    public Thread thread;

    public JoinAThread(String threadName) {
        thread = new Thread(this, threadName);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(10);
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

/**
 * UseIsAlive
 */
class UseIsAlive {

    public static void main(String[] args) {
        JoinAThread jThread1 = new JoinAThread("Thread One");
        jThread1.thread.start();

        JoinAThread jThread2 = new JoinAThread("Thread two");
        jThread2.thread.start();

        while (jThread1.thread.isAlive() || jThread2.thread.isAlive()) {
            System.out.println("Thread one is alive:" + jThread1.thread.isAlive());
            System.out.println("Thread two is alive:" + jThread2.thread.isAlive());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread());
    }
}

/**
 * Use Join:
 * 
 */
class UseJoin {
    public static void main(String[] args) {
        JoinAThread jThread1 = new JoinAThread("Thread One");
        jThread1.thread.start();

        JoinAThread jThread2 = new JoinAThread("Thread two");
        jThread2.thread.start();

        System.out.println("Thread one is alive:" + jThread1.thread.isAlive());
        System.out.println("Thread two is alive:" + jThread2.thread.isAlive());

        try {
            jThread1.thread.join(); // We wait to joint the thread, and when it is done, we move forward. So long as this method is functioning,
                                    // the main thread will remain active heh, because you know, the thread has to be kept active for this
                                    // method to work!
            System.out.println("Is thread one alive:" + jThread1.thread.isAlive());
            
            jThread2.thread.join();
            System.out.println("Is thread two alive:" + jThread2.thread.isAlive());
        } catch (InterruptedException e) {
            // This exception is for when main thread is get interrupted.
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread());        
        
        

    }
 }