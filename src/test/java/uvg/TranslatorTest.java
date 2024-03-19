package uvg;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TranslatorTest {
     
    @Test
    public void translateTest(){
        ArrayList<Association<String, String>> associations = new ArrayList<Association<String, String>>();
        associations.add(new Association<String,String>("house", "casa"));
        associations.add(new Association<String,String>("dog", "perro"));
        associations.add(new Association<String,String>("homework", "tarea"));
        associations.add(new Association<String,String>("woman", "mujer"));
        associations.add(new Association<String,String>("town", "pueblo"));
        associations.add(new Association<String,String>("yes", "si"));

        UVGBST<Association<String, String>> bst = new UVGBST<Association<String, String>>();

        for(Association<String, String> association : associations){
            bst.add(association);
        }

        String text = "The woman asked me to do my homework about my town";

        String translation = Translator.translate(bst, text);

        System.out.println(translation);
    }
}
