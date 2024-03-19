package uvg;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    
    public ArrayList<Association<String, String>> getAssociations(String str){

        String regex = "\\(([^,]*) *\\, *([^,]*)\\)";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(str);
        ArrayList<Association<String, String>> resultArr = new ArrayList<Association<String, String>>();

        while(matcher.find()){
            resultArr.add(new Association<String,String>(matcher.group(1).toLowerCase(), matcher.group(2).toLowerCase()));
        }

        return resultArr;
        
    }
}
