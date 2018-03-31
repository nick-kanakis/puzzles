package LinkedList.helper;

/**
 * Created by Nicolas on 8/11/2017.
 */
public class LinkedListNode {

    public LinkedListNode next;
    public int data;

    public LinkedListNode(LinkedListNode next, int data) {
        this.next = next;
        this.data = data;
    }

    public LinkedListNode(int data) {
        this.data = data;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode clone(){
        LinkedListNode next2 = null;
        if(next != null){
            next2 = next.clone();
        }
        LinkedListNode head2 = new LinkedListNode(next2,data);
        return head2;
    }
}
