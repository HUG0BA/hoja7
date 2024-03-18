package uvg;

public class UVGBST<E extends Comparable<E>> {
    
    public class Node<E extends Comparable<E>>{
        public E value;
        public Node<E> leftChild = null;
        public Node<E> rightChild = null;
        public Node<E> parent = null;

        public Node(E cValue){
            this.value = cValue;
        }

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
                    leftChild = new Node<E>(newVal, this);
                    return leftChild;
                }else{
                    return leftChild.addNode(newVal);
                }
            }else if(compCase == 0){
                value = newVal;
                return this;
            }else if(rightChild == null){
                rightChild = new Node<E>(newVal, this);
                return rightChild;
            }
            return rightChild.addNode(newVal);
        }

        public Node<E> getNode(E key){
            int compCase = key.compareTo(value);
            if(compCase==0){
                return this;
            }else if(compCase < 0){
                if(leftChild != null){
                    return leftChild.getNode(key);
                }
            }else{
                if(rightChild != null){
                    return rightChild.getNode(key);
                }
            }

            return null;

        }

        public int nodeHeight(){
            int currHeight = -1;
            if(this.leftChild != null){
                currHeight = this.leftChild.nodeHeight();
            }
            if(this.rightChild != null){
                int rightHeight = this.rightChild.nodeHeight();
                if(rightHeight > currHeight){
                    currHeight = rightHeight;
                }
            }

            return currHeight + 1;
        }

        public int nodeDepth(){
            if(this.parent == null){
                return 0;
            }
            return 1 + this.parent.nodeDepth();
        }

        
    }

    private Node<E> root;

    public UVGBST(){
        this.root = null;
    }

    public E add(E newVal){
        if(root == null){
            root = new Node<E>(newVal);
            return root.value;
        }

        return root.addNode(newVal).value;
    }

    public Node<E> getRoot(){
        return root;
    }

    public Node<E> getNode(E key){
        if(root == null){
            return null;
        }
        return root.getNode(key);
    }

    public String inOrderTraversal(Node<E> node, int nodeDepth){
        String str = "";
        if(node.leftChild != null){
            str = str + inOrderTraversal(node.leftChild, nodeDepth + 1) + "\n";

        }
        str = " ".repeat(nodeDepth);
        str = str + "->" +node.toString() + "\n";
        if(node.rightChild != null){
            str = str + inOrderTraversal(node.rightChild, nodeDepth + 1) + "\n";
        }
        return str;
         
    }

    


}
