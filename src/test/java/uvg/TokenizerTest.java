package uvg;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TokenizerTest {
    
    @Test
    public void getAssociationsTest(){
        Tokenizer tokenizer = new Tokenizer();
        ArrayList<Association<String, String>> associations = new ArrayList<Association<String, String>>();
        associations.add(new Association<String,String>("house", "casa"));
        associations.add(new Association<String,String>("dog", "perro"));
        associations.add(new Association<String,String>("homework", "tarea"));
        associations.add(new Association<String,String>("woman", "mujer"));
        associations.add(new Association<String,String>("town", "pueblo"));
        associations.add(new Association<String,String>("yes", "si"));

        ArrayList<Association<String, String>> test = tokenizer.getAssociations("(house, casa)(dog, perro)(homework, tarea)(woman, mujer)(town, pueblo)(yes, si)");

        for(int i = 0; i < 6; i++){
            assertTrue(associations.get(i).equals(test.get(i)));
        }


    }
}
