package uvg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {
    public String readTXTFile(String fileName) throws FileNotFoundException, IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/"+fileName)));

        String result = "";
        String line;

        while (( line = reader.readLine()) != null){
            result = result + line;
        } 

        reader.close();
        return result;
        
    }

}
