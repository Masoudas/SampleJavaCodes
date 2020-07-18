package SampleJavaCodes.ThreadManagement.ExecuterServices;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Executer service allows for asynchronous execution of tasks in java.
 * 
 * They're all located in the java.util.concurrent package.
 * The easiest way to  use ExecuterService classes is to use one of its factory methods.
 * 
 * Executors.newFixedThreadPool(20) is an example of creating a thread pool of 20 threads.
 * We can create SingleThreadApplications.
 * 
 * We can directly create the ExecuterService instances, which gives us more power over the
 * detail of how things work. But for now, we skip it.
 * 
 * We can assign runnable or callable tasks to the executer service, interesetingly
 * by a list. So we assign a list of tasks, and we tell the executer service to 
 * execute them. Or we can continuously add tasks, and ask the service to execute them.
 * The execute() method does not allow us to get any parameter, for checking the task
 * execution was done successfully or not. Whereas submit() returns a Future instance,
 * saying what happened to the tasks (executed, being executed).
 * invokeAny() method submits a tasks, and executes each, and returns the result of one that 
 * has been done successfully (could be useful).
 * 
 * invokeAll() is like invokeAny(), except that it returns the result of all.
 * 
 * Note that an executer service does not let go of JVM after its being garbage collected, because there 
 * might be exectures that need to be executed. Or we can actually later on add new runnables to them.
 * So we actually need to shutdown the service.
 * 
 * The shutdown() method doesn't cause immediate destruction of the ExecutorService.
 * It will make the ExecutorService stop accepting new tasks and shut down after all running.
 * 
 * The shutdownNow() method shuts all tasks down, including those being executed, or awaiting 
 * execution, and returns a list of such tasks.
 * 
 * // Shutting down execution
 * It's recommended by oracle to combine these two methods with awaitTermination(). That is,
 * we first shut down, then await the termination of all tasks.
 * but then if an exception is thrown, we completely shut the thing down.
 * 
 * // Future interface
 * The future interface lets us examine what's happening inside the thread. 
 * The get method either returns the result of callable, or null if we have a runnable
 * task. If we have a callable task and the result is not ready, it will block the thread the method is invoked inside,
 * and wait for the result to be generated, which would degrade the performance of task. We can also cancel the task directly from the future.
 * We better try and wait for a certain period for the result and if that does not work, throw an exception, like this
 * 
 * try{
 *  service.get(200, TimeUnit.MILLISECONDS);
 * }catch (InterruptedException | ExecutionException e) {
	    e.printStackTrace();
    }
 * 
 * The ScheduledExecutorService allow us to program a task to be performed regularly.
 */
public class BaeldungIntroduction {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        Runnable runnable = () ->{
            System.out.println("Inside runnable");
        };
    
        Callable<String> callable = () -> {
            System.out.println("Inside callable");
            return "Done";
        };

        Future<String> future = service.submit(callable);

        service.shutdown();
	try {
	    if (!service.awaitTermination(800, TimeUnit.MILLISECONDS)) {
	        service.shutdownNow();
	    } 
	} catch (InterruptedException e) {
	    service.shutdownNow();
    }
        
    }

    
    
}