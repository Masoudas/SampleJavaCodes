/** 
 * Just to conclude the discussions we have had:
 * 
 * 1- Use char streams when dealing with text files, use byte streams
 * when dealing with binary files.
 * 
 * 2- Use buffered readers (BufferReader/BufferedInputStream or the writer
 * counterparts) to stream data, which increases efficiency.
 * 
 * 3- Always close the files of course
 */

package SampleJavaCodes.IO;