package SampleJavaCodes.Miscellaneous.ResourceBundleFiles;

/**
 * Instead of creating an actuall class, we can use properties file to back
 * a resource bundle. the class PropertyResourceBundle is backed by a properties file.
 * 
 * A properties file is a simple text file. You can create and maintain a
 * properties file with just about any text editor.
 * 
 * You should always create a default properties file. The name of this file
 * begins with the base name of your ResourceBundle and ends with the
 * .properties suffix. Here the base name is LabelsBundle. Therefore the default
 * properties file is called LabelsBundle.properties. The files for other lacales 
 * are created automatically, like LabelsBundle.properties, LabelsBundle_de.properties
 * and LabelsBundle_fr.properties
 * 
 * This file contains the following lines (same file exists in this folder): 
 * # This is the default LabelsBundle.properties file 
 * s1 = computer 
 * s2 = disk 
 * s3 = monitor 
 * s4 = keyboard
 * 
 * Note that in the preceding file the comment lines begin with a pound sign
 * (#). The other lines contain key-value pairs.
 * 
 * SO WHEN WE ASK FOR A BUNDLE AND IT CANNOT FIND IT, IT WILL CREATE THE BUNDLE FROM
 * THE PROPERTIES FILE.
 */