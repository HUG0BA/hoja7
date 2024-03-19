package uvg;


import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


public class FileManagerTest {
    
    @Test
    public void readTXTFileTest() throws FileNotFoundException, IOException{
        FileManager fileManager = new FileManager();
        String expected = "(house, casa)(dog, perro)(homework, tarea)(woman, mujer)(town, pueblo)(yes, si)";
        String result = fileManager.readTXTFile("wordsTest.txt");

        assertTrue(result.equals(expected));
    }
}
