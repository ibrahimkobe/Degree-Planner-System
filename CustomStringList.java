package dsa_AB;

	
	public class CustomStringList {
	    private StringNode head;
	    private int size = 0;

	    public void add(String data) {
	        StringNode newNode = new StringNode(data);
	        if (head == null) {
	            head = newNode; 
	        } else {
	            StringNode current = head;
	            while (current.getNext() != null) {
	                current = current.getNext(); 
	            }
	            current.setNext(newNode); 
	        }
	        size++;
	    }

	    public boolean contains(String data) {
	        StringNode current = head;
	        while (current != null) {
	            if (current.getData().equalsIgnoreCase(data)) {
	                return true; 
	            }
	            current = current.getNext();
	        }
	        return false;
	    }
	    
	    public StringNode getHead() {
	    	return head; 
	    	}
	    public int getSize() {
	    	return size; 
	    }
	}

