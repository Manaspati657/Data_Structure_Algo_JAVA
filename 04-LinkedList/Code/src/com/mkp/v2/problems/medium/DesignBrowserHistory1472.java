package src.com.mkp.v2.problems.medium;

public class DesignBrowserHistory1472 {
    private Node head;
    private Node visitPointer;
    public DesignBrowserHistory1472(String homepage) {
        head=new Node(homepage);
        visitPointer=head;
    }

    public void visit(String url) {
        Node newVisit=new Node(url);
        if(visitPointer.next != null) visitPointer.next.prev=null;
        visitPointer.next=newVisit;
        newVisit.prev=visitPointer;
        visitPointer=newVisit;
    }

    public String back(int steps) {

        for(int i = 0 ;i<steps;i++){
            if(visitPointer.prev == null) break;
            visitPointer=visitPointer.prev;
        }
        return visitPointer.url;
    }

    public String forward(int steps) {
        for(int i = 0 ;i<steps;i++){
            if(visitPointer.next == null) break;
            visitPointer=visitPointer.next;
        }
        return visitPointer.url;
    }
    //  doubly linkedList
    class Node{
        String url;
        Node prev;
        Node next;
        Node(String newurl){
            url=newurl;
            prev=null;
            next=null;
        }
    }
}
