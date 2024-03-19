package uvg;

public class Translator {
    public static String translate(UVGBST<Association<String, String>> bst, String text){
        String[] arr = text.split(" ");
        String current = text;
        Association<String, String> association = null;

        for(String str : arr){
            association = new Association<String,String>(str.toLowerCase(), "");
            if(bst.getNode(association) != null){
                current = current.replaceFirst(str, bst.getNode(association).value.data); 
            }else{
                current = current.replaceFirst(str, "*" + str +"*");
            }   
            
        }

        return current;
    }

}
