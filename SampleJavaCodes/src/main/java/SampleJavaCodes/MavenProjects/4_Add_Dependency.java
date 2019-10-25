/**
 * So what happens here is that we can add some repos to the cache of the maven project,
 * which then can be used directly inside of our projects.
 * 
 * ****Adding remote repos**************
 * So there are repos, and inside those repos are the libraries (jars) we seek.
 * To add a repo, we can something like below:
 * 
 * For example, to add a repo from the SUN repo, we add the following to POM:
 * <repositories>
        <repository>
          <id>maven2-repository.dev.java.net</id>
          <name>Java.net Repository for Maven</name>
          <url>http://download.java.net/maven/2/</url>
          <layout>default</layout>
        </repository>
      </repositories>
 * 
 * To add a dependency, we can do something like this:
 * To add an outsider ,jar library, for example in the maven project library, we can search
 *  (for example ij.) Then it will give the groupId at the top, and the bottom, together with 
 *  version.
    <dependency>
			<groupId>net.imagej</groupId>
            <version>1.52q</version>
			<artifactId>ij</artifactId>
		</dependency>

    which will add the imagej to our project.

 * **************Adding local repos*************************
 * Local: We can also download a 3rd party library, and then add this:
 * 	<dependency>
  		<groupId>com.google.code</groupId>
	  	<artifactId>kaptcha</artifactId>
		  <version>2.3</version>
		  <scope>system</scope>
		  <systemPath>d:/projects/kaptcha.jar</systemPath>
	  </dependency>

 */


