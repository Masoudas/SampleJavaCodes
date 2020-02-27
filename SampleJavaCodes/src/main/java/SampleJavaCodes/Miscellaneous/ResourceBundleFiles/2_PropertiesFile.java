/**
 * Properties files are like text files in nature (see 3_Backing... file)
 */

package SampleJavaCodes.Miscellaneous.ResourceBundleFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class PropertiesFileIO {
    public void write() {
        Properties prop = new Properties();

        // set the properties value
        prop.setProperty("waveLength == 5e-9,", "1.75");
        prop.setProperty("Channel1.CalibrationFactor.90-degree", "1.75");
        prop.setProperty("Channel1.CalibrationFactor.135-degree", "1.75");
        
        prop.setProperty("Channel2.CalibrationFactor.0-degree", "1.75");
        prop.setProperty("Channel2.CalibrationFactor.90-degree", "1.75");
        prop.setProperty("Channel2.CalibrationFactor.135-degree", "1.75");
        
        

        // save properties to project root folder
        File file = new File(
                "src/main/java/SampleJavaCodes/Miscellaneous/ResourceBundleFiles/PropertiesExample.properties");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            prop.store(outputStream, "This is a properties file");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) {
        new PropertiesFileIO().write();
    }

    
}