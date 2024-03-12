package uvg;

public class UVGBST<E extends Comparable<E>> {
    
    public class Node<E extends Comparable<E>>{
        public E value;
        public Node<E> leftChild = null;
        public Node<E> rightChild = null;
        public Node<E> parent = null;

        public Node(E cValue, Node<E> parent){
            this.value = cValue;
            this.parent = parent;
        }

        public String toString(){
            return value.toString();
        }

        public Node<E> addNode(E newVal){
            int compCase = newVal.compareTo(value);

            if(compCase < 0){
                if(leftChild == null){
                    leftChild
                }
            }
        }
    }
}
