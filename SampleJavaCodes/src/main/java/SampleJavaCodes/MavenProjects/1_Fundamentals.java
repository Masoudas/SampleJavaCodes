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
 * 
 *  DarchetypeArtifactId: The type of the project to be created. Here it's a quick start simple project.
 *  DarchetypeVersion: The version of the current project, which also appears at the end of the jar name.
 * 
 * And four other parameters known as maven coordinates:
 *  DgroupId:  groupId is the general name given to several artifactId names.
 *           So in this example, all the projects will be under the com.mycompany.app, and a specific
 *           project here would be my-app.
 *  DartifactId: It would be the name of the main folder of the project. The generated jar file 
 *           would have this name.
 *  version: Specifies the project version. Notice that the definition 
 *          <version>${project.version}</version> sets the project to it's latest label.
 *  packaging: The packaging format (JAR or WAR for web based projects.)
 * 
 * What are coordinates for?
 * To put it simply, they are for connecting a group of projects together. They are not there
 * to show the packaging, the package name always starts from the folder after src/main/java.
 * Regardless of how we name the artifacts, the name that appears on the outside is the package
 * name, and not the artifact or groupId.
 * So for example, if the folder after main/java is a, the package name that appears in the code is 
 * a, and not a combination of groupId and artifactId.
 * 
 * 
 *              
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
 * A Maven Plugin is a collection of one or more goals. A goal is a specific task that may be executed 
 * as a standalone goal or along with other goals as part of a larger build. A goal is a “unit of work”
 * in Maven. Examples of goals include the compile goal in the Compiler plugin, which compiles all of 
 * the source code for a project, or the test goal of the Surefire plugin, which can execute unit tests
 * 
 * maven by itself has some plugins, which are used for doing various tasks, such as generating
 * the JAR, or comppiling code ... .
 * 
 * 
 * Note that when maven looks for dependencies, it starts from the local repo it has created on the 
 * computer (located at ~/.m2/repository in linux), and then looks elsewhere. This includes the local
 * JARs as well. When two projects depend on one another, they are read from the local repo.
 * 
 * Check out https://books.sonatype.com/mvnex-book/reference/simple-project-sect-simple-core.html for a more detailed
 * discussion.
 * 
 * 
 * 
 * 
 */