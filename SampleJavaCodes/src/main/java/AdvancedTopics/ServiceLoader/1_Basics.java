/**
 * See
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-se-api/service-loader.html
 * for more detail.
 * 
 * The class java.util.ServiceLoader is based on SPI (Service Provider
 * Interface) pattern.
 * 
 * SPI is an API intended to be implemented or extended by plugins/modules.
 * Let's understand that with an example.
 * 
 * Assume we are designing an application framework F ( Say F is ImageJ, then
 * those services are view, load and other services it provides for us). We want
 * F to be extensible. We will create API interfaces/classes visible to outside
 * world and typically called Services to describe what F does. A particular
 * application A will call the API to achieve a goal. A set of same
 * interfaces/classes (SPI) of F are treated as extension points by plugins and
 * modules. These plugins/modules are typically called Service Provider. They
 * either provide concrete implementation or extend those interfaces/classes of
 * the framework to provide functionality.
 * 
 * **Discovering and Loading Services** The service provider must specify what
 * implementation of a SPI they are providing. Suppose there's a service
 * interface com.service.MyService and a provider implements that interface as
 * com.provider.MyServiceImpl. Before packaging his project, the provider has to
 * include a file under META-INF/services. The file name should be fully
 * qualified service name without any extension. Inside file the provider has to
 * specify fully qualified implementation. The content of file
 * META-INF/services/com.service.MyService will look like this:
 * 
 * *----------------------------------------------------------------------------
 * com.provider.MyServiceImpl
 * *----------------------------------------------------------------------------
 * 
 * The SPI implementation is typically packaged in a jar and has to be in class
 * path of the discovering code:
 * *----------------------------------------------------------------------------
 * ServiceLoader<MyService> services =
 * java.util.ServiceLoader.load(MyService.class); 
 * services.forEach(service ->
 * {//use service instance here } );
 * *----------------------------------------------------------------------------
 * 
 * See the java-view-service folder in this project to understand how this works.
 * Notice:
 * 1- META-INF folder in the resource folder contains the name of the class that provides
 * the implementation for the interface VIEW. 
 * 2- Notice service loader, and how it loads all the service providers in the main method. 
 */