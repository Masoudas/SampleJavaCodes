/**
 * See https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html 
 
 * Maven’s primary goal is to allow a developer to comprehend the complete state of a development effort 
 * in the shortest period of time. 
 * 
 * Maven allows a project to build using its project object model (POM), 
 * and a set of plugins that are shared by all projects using Maven, providing a uniform build system
 * 
 * To create a maven project, we can type the following command:
 * mvn archetype:generate -DartifactId=my-app -DgroupId=com.mycompany.app ...
 * -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
 * 
 * Where:
 *  archetype:generate: It tells to generate a project.
 *  DartifactId: It would be the name of the main folder of the project (solution in C# terms).
 *  DgroupId:  This would be the name of the base of the packages. So com would be the base package here.
 *  DarchetypeArtifactId: The type of the project to be created. Here it's a quick start simple project.
 *  DarchetypeVersion: The version of the current project, which also appears at the end of the jar name.
 *  
 * So for example we can for this particular project write:
 * "java -cp SampleJavaCodes/target/SampleJavaCodes-1.0.0.jar SampleJavaCodes.Basic.BasicTypes"
 * so naturally, the class path would be set to jar file, and then we can execute the 
 * classes in the jar library.
 * 
 
 * The command "mvn package" run in the project parent folder will package the project
 * and produce the output .jar file we need.
 * 
 * 
 * 
 * 
 */