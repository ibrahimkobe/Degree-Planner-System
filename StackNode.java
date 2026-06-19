package dsa_AB;

//(Feature 2)

public class StackNode {
 private Object state; 
 private StackNode next;
 
 public StackNode(Object state) {
	 this.state = state; 
	 }
 public Object getState() {
	 return state;
	 }
 public StackNode getNext() { 
	 return next; 
	 }
 public void setNext(StackNode next) {
	 this.next = next;
	 }
}