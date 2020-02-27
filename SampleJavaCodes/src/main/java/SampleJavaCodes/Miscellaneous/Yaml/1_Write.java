/**
 * We can use Jackson

    The getter methods have to be present for the object to be written.
 */

package SampleJavaCodes.Miscellaneous.Yaml;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;



class SubClass {
    String str = "1";
    double no = 5.34;

    /**
     * @return the no
     */
    public double getNo() {
        return no;
    }

    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }
}

class BigClass {
    int val = 10;
    SubClass[] sub = {new SubClass(), new SubClass()};

    
    /**
     * @return the sub
     */
    public SubClass[] getSub() {
        return sub;
    }

    /**
     * @return the val
     */
    public int getVal() {
        return val;
    }
}

class YamlParser {
    public static void main(String[] args) throws IOException {
        File file = new File("BigClass.yaml");

        BigClass big = new BigClass();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));
        mapper.findAndRegisterModules();

        mapper.writeValue(file, big);
         
    }
 }