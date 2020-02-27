/**
 * Steps to create a multi-module project:
 * 
 * 1- Create the parent folder (parent artifact)
 * 2- Put a POM in it, as follows:
 *     <groupId>example-proj</groupId>
        <artifactId>ExampleProject</artifactId>
        <packaging>pom</packaging>
        <version>1.0</version>

   Note: The groupId better be the common part of the package names we use
   (for some reason)     
 * 3- Define the dependency modules in the same POM:
*      <modules>
        <module>proj1</module>
        <module>proj2</module>
      </modules>
 * 
 * Which are the same name as the artifact of the subprojects.
 
 * 4- Create artifact of the subprojects.
 * 5- Declare the parent project in sub-projects as follows:
 *  <parent>
        <groupId>org.sonatype.mavenbook.multi</groupId>
        <artifactId>simple-parent</artifactId>
        <version>1.0</version>
    </parent>
 * 
 * 6- If there's a dependency between projects, it should be declared separately
 * as a dependency, for it to appear in the other projects.
 * 
 * 7- The packaging however is what is named after the src/main/java folder of
 * each project.
 * 
 * 
 * Note: If projects are not detected, we need to clean java server in VSCode.
 * 
 * Explaination:
 * There's a mechanism in the Maven project referred to as reactor, which allows
 * a multi-module project to be created. The important point is the dependency
 * of modules on one another (where one module depends on another and vice
 * versa.)
 * 
 * The reactor by itself takes care of creating the modules but there are
 * command line tools that we use to do some customizations.
 * 
 * The ExampleProject subfolder contains the full info.
 * 
 * Notice that the parent POM defines a set of Maven coordinates: the groupId is
 * org.sonatype.mavenbook.multi, the artifactId is simple-parent, and the
 * version is 1.0. The parent project doesn’t create a JAR or a WAR; instead, it
 * simply a POM that refers to other Maven projects. The appropriate packaging
 * for a project like simple-parent that simply provides a Project Object Model
 * is pom. The next section in the pom.xml lists the project’s submodules. These
 * modules are defined in the modules element, and each module element
 * corresponds to a subdirectory of the simple-parent directory. Maven knows to
 * look in these directories for pom.xml files, and it will add submodules to
 * the list of Maven projects included in a build.
 * 
 * 
 * Note that for example we can bound the JVM of the entire project using the parent POM.
 * 
 * The important part of the submodules is that they have the following line when defining the
 * groupId and the artifactId:
 
   <parent>
        <groupId>org.sonatype.mavenbook.multi</groupId>
        <artifactId>simple-parent</artifactId>
        <version>1.0</version>
    </parent>
    <artifactId>simple-weather</artifactId>
    <packaging>jar</packaging>

 * So instead of defining a groupId for the child project, we only refer to the
 * parent directory. Note how the groupID and the artifactId of the parent are 
 * both mentioned here. 
 * 
 * Notice that in the parent folder, the artifact is the same as the root folder that contains all
 * the projects. Also note that packaging is <packaging>POM</packaging>
 * 
 * Note however to use a project as a dependency in other projects, we need to define it as 
 * A DEPENDENCY of that project! That way, we can actually see that package.
 * 
 * Note also that the way a project appears as a dependency only depends on the pacakging
 * name, and not the artifact and groupId. Hence, eventhough the project folder is exampleProject,
 * the subprojects are proj1 and proj1, and the groupId is example-proj, 
 * we still see them as fr.fresnel.io and fr.fresnel.core in the dependencies.
 * 
 * 
 */