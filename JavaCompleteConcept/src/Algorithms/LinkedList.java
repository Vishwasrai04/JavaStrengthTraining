package Algorithms;


public class LinkedList {

    Node head;
   public LinkedList(){
        head = null;
    }
   public void add(int data){

       if(head==null){
           head = new Node(data);
       }else{
           Node newNode = new Node(data);
           Node current = head;
          while (current.next !=null){
              current = current.next;
          }
          current.next = newNode;
       }
   }
   public void addAtIndex(int data, int index){
       Node current = head;
       Node newNode = new Node(data);
       for(int i = 0; i<index -1  && current.next != null; i++){
           current = current.next;
       }
       newNode.next = current.next;
       current.next = newNode;

   }
   public void delete(int data){
       Node current = head;
       int index = 0;
       while(current.next != null){
           if(current.data == data){
               new LinkedList().deleteAtIndex(index);
           }
           index++;
           current = current.next;
       }

   }
    public  void deleteAtIndex(int index){
       Node current = head;
       Node previous = current;
       for(int i = 0; i<index && current.next!=null; i++){
           previous = current;
           current = current.next;
       }
       previous.next = current.next;
    }

    }

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
class test{
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();

    }
}