package SampleJavaCodes.ThreadManagement;

/**
 * SetThreadPriority: It is possible to assign a priority to threads, that way
 * higher level priorities have a better chance of accessing the CPU. Of course
 * the priority of a thread is a static integer variable, whose range is between
 * MIN_PRIORITY=1 and MAX_PRIORITY=10 (at least in the most recent version of
 * JAVA). The priority is set using the setPriority() method. NORM_PRIORITY is
 * the normal priority, which is 5.
 * 
 * It is clear during the execution of the following program that the highest
 * priority thread is executed first.
 * 
 */

public class SetThreadPriority implements Runnable {
    public Thread thread;

    public SetThreadPriority(String name, int priority) {
        thread = new Thread(this, name);
        thread.setPriority(priority);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println("Thread is" + Thread.currentThread());
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Assigning higher priority to one thread.
        SetThreadPriority sPriority1 = new SetThreadPriority("Thread 1", Thread.MIN_PRIORITY);
        SetThreadPriority sPriority2 = new SetThreadPriority("Thread 2", Thread.MAX_PRIORITY);
        SetThreadPriority sPriority3 = new SetThreadPriority("Thread 3", Thread.NORM_PRIORITY);
        SetThreadPriority sPriority4 = new SetThreadPriority("Thread 3", 7);

        sPriority1.thread.start();
        sPriority2.thread.start();
        sPriority3.thread.start();
        sPriority4.thread.start();

        try {
            sPriority1.thread.join();
            sPriority2.thread.join();
            sPriority3.thread.join();
            sPriority4.thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
}