package uvg;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        UVGBST<Integer> uvgbst = new UVGBST<Integer>();

        uvgbst.add(5);
        uvgbst.add(3);
        uvgbst.add(1);
        uvgbst.add(2);
        uvgbst.add(7);
        uvgbst.add(9);


        System.out.println(uvgbst.inOrderTraversal(uvgbst.getRoot(), 0));
        
    }
}
