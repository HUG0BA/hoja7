package uvg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; 

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {

        

        UVGBST<Association<String, String>> bst = null;
        Scanner scanner = new Scanner(System.in);
        String option;
        String phraseToTranslate = "";
        FileManager fileManager = new FileManager();
        boolean program = true;

        System.out.println("¡Bienvenido al Arbol Binario de Búsqueda de la Universidad del Valle de Guatemala!");
        System.out.println("Sistema especializado de traducción entre cualesquiera dos idiomas ingresados por el usuario");
        System.out.println("Descargo de Responsabilidad: los diccionarios de cualquier idioma NO están incluidos, compra por separado.");


        while(program){
            System.out.println("Ingrese el modo de ejecución");
            System.out.println("1. Correr archivos de prueba \n 2. Correr archivos ingresados por el usuario (Deben estar en el folder de resources) \n 3. Salir");

            option = scanner.nextLine();

            switch (option) {
                case "1":
                    phraseToTranslate = fileManager.readTXTFile("translationTest.txt");
                    bst = getTestFilesBST();
                    innerMenu(bst, phraseToTranslate, scanner);
                    break;

                case "2":
                    System.out.println("Ingrese el nombre del archivo con el diccionario de palabras");
                    System.out.println("Formato: nombreArchivo.txt");
                    option = scanner.nextLine();
                    bst = getTestUserBST(option);

                    System.out.println("Ingrese el nombre del archivo con la frase a traducir");
                    System.out.println("Formato: nombreArchivo.txt");
                    option = scanner.nextLine();
                    phraseToTranslate = fileManager.readTXTFile("translationTest.txt");

                    innerMenu(bst, phraseToTranslate, scanner);
                
                    break;
                case "3":
                    System.out.println("Apagando el sistema...");
                    program = false;
        
                default:
                    break;
        }
        }
        

        

        scanner.close();
    }

    public static UVGBST<Association<String, String>> getTestFilesBST() throws IOException, FileNotFoundException{
        FileManager fileManager = new FileManager();
        Tokenizer tokenizer = new Tokenizer();

        String wordDictionaryFile = fileManager.readTXTFile("wordsTest.txt");
        
        ArrayList<Association<String, String>> associations = tokenizer.getAssociations(wordDictionaryFile);

        UVGBST<Association<String, String>> bst = new UVGBST<Association<String, String>>();

        for(Association<String, String> association : associations){
            bst.add(association);
        }

        return bst;
    }

    public static UVGBST<Association<String, String>> getTestUserBST(String fileName) throws IOException, FileNotFoundException{
        FileManager fileManager = new FileManager();
        Tokenizer tokenizer = new Tokenizer();

        String wordDictionaryFile = fileManager.readTXTFile(fileName);
        
        ArrayList<Association<String, String>> associations = tokenizer.getAssociations(wordDictionaryFile);

        UVGBST<Association<String, String>> bst = new UVGBST<Association<String, String>>();

        for(Association<String, String> association : associations){
            bst.add(association);
        }

        return bst;
    }

    public static void innerMenu(UVGBST<Association<String, String>> bst, String phraseToTranslate,Scanner scanner){
        boolean program = true;

        while(program){
            System.out.println("Ingrese la opción a ejecutar");
            System.out.println("1. Imprimir el arbol binario en modo In-Order \n 2. Traducir la frase cargada en el archivo de texto \n 3. Salir ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println(bst.inOrderTraversal(bst.getRoot(), 0));
                    break;

                case "2":
                    System.out.println(Translator.translate(bst, phraseToTranslate));
                    break;

                case "3":
                    program = false;
                    break;
        
                default:
                    break;
        }
        }
        
    }
}
