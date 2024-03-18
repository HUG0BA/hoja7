package uvg;

import static org.junit.Assert.*;

import org.junit.Test;

public class UVGBSTTest {

    @Test
    public void addNodeTest(){
        UVGBST<Integer> tree1 = new UVGBST<Integer>();
        UVGBST<Integer> tree2 = new UVGBST<Integer>();

        assertEquals(null, tree1.getRoot());
        assertEquals(null, tree1.getNode(1));

        assertEquals(null, tree2.getRoot());
        assertEquals(null, tree2.getNode(3));

        tree1.add(5);
        assertEquals(5, tree1.getRoot().value, 0);
        assertEquals(5, tree1.getNode(5).value, 0);

        tree2.add(3);
        assertEquals(3, tree2.getRoot().value, 0);
        assertEquals(3, tree2.getNode(3).value, 0);

        tree2.add(1);
        assertEquals(3, tree2.getRoot().value, 0);
        assertEquals(1, tree2.getNode(1).value, 0);

        tree2.add(20);
        assertEquals(3, tree2.getRoot().value, 0);
        assertEquals(20, tree2.getNode(20).value, 0);

    }

    @Test
    public void heightTest(){
        UVGBST<Integer> tree1 = new UVGBST<Integer>();

        tree1.add(5);
        assertEquals(0, tree1.getRoot().nodeHeight(), 0);

        tree1.add(3);
        assertEquals(1, tree1.getRoot().nodeHeight(), 0);

        tree1.add(7);
        assertEquals(1, tree1.getRoot().nodeHeight(), 0);

        tree1.add(2);
        assertEquals(2, tree1.getRoot().nodeHeight(), 0);

        tree1.add(1);
        assertEquals(3, tree1.getRoot().nodeHeight(), 0);

        tree1.add(0);
        assertEquals(4, tree1.getRoot().nodeHeight(), 0);

        tree1.add(10);
        assertEquals(4, tree1.getRoot().nodeHeight(), 0);
    }

    @Test
    public void depthTest(){
        UVGBST<Integer> tree1 = new UVGBST<Integer>();

        tree1.add(5);
        assertEquals(0, tree1.getRoot().nodeDepth(), 0);
        assertEquals(0, tree1.getNode(5).nodeDepth(), 0);

        tree1.add(3);
        assertEquals(0, tree1.getRoot().nodeDepth(), 0);
        assertEquals(1, tree1.getNode(3).nodeDepth(), 0);

        tree1.add(2);
        assertEquals(0, tree1.getRoot().nodeDepth(), 0);
        assertEquals(2, tree1.getNode(2).nodeDepth(), 0);

        tree1.add(1);
        assertEquals(0, tree1.getRoot().nodeDepth(), 0);
        assertEquals(3, tree1.getNode(1).nodeDepth(), 0);

        tree1.add(0);
        assertEquals(0, tree1.getRoot().nodeDepth(), 0);
        assertEquals(4, tree1.getNode(0).nodeDepth(), 0);

        tree1.add(10);
        assertEquals(0, tree1.getRoot().nodeDepth(), 0);
        assertEquals(1, tree1.getNode(10).nodeDepth(), 0);
    }
    
    @Test
    public void inOrderTraversalTest(){
        UVGBST<Integer> uvgbst = new UVGBST<Integer>();

        uvgbst.add(5);
        uvgbst.add(3);
        uvgbst.add(1);
        uvgbst.add(2);
        uvgbst.add(7);
        uvgbst.add(9);


        System.out.println(uvgbst.inOrderTraversal(uvgbst.getRoot(), 0));
        assertTrue(true);

    }
}
