
package filewritingtest;

import java.util.*;
import java.io.*;

public class FileWritingTest {  

    public static void main(String[] args) throws IOException {
        
        try {
            File f = new File("src//FileWritingTest//test.txt");
            
            FileWriter fw = new FileWriter(f, true);
            fw.write("hello\n");
            fw.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
            
        }
    }
}
