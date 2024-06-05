package GraphsAndTrees.Trees;

public class BinarySearchTree {
    node rootNode;
    public BinarySearchTree(){
        rootNode = null;
    }
    public void insertNode(int value){
        rootNode = insertNode(value, rootNode);
    }
    private node insertNode(int value, node rootNode){
        if(rootNode == null){
            rootNode = new node();
            rootNode.value = value;
            return rootNode;
        }
        if(rootNode.value<value){
            rootNode.right = insertNode(value, rootNode.right);
        } else {
            rootNode.left = insertNode(value, rootNode.left);
        }
        return rootNode;
    }

    public void inorder() {
        inorderRec(rootNode);
    }

    private void inorderRec(node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    public void delete(int value) {
        delete(rootNode, value);
    }
    private void delete(node rootNode, int value){
        if (rootNode == null){
            return;
        }
        if (rootNode.value == value){
           /** To be continue......*/
            return;
        }
        delete(rootNode.left,value);
        delete(rootNode.right,value);
    }
}

class node{
    int value;
    node left; node right;
    node(){
        left = null;
        right = null;
    }

}

class testingTree{
    public static void main(String [] args){
        BinarySearchTree bt = new BinarySearchTree();
        bt.insertNode(13);
        bt.insertNode(15);
        bt.insertNode(12);
        bt.insertNode(11);
        bt.insertNode(1);
        bt.insertNode(12);
        bt.insertNode(16);
        bt.insertNode(6);
        bt.insertNode(8);
        bt.insertNode(10);

        bt.inorder();
        System.out.println(" after deletion ");
        bt.delete(12);
        bt.inorder();
    }
}