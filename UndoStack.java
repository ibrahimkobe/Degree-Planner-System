package dsa_AB;

public class UndoStack {
	
	    private StackNode top; 
	    private int size = 0;

	    public void push(Object state) {
	        StackNode newNode = new StackNode(state);
	        newNode.setNext(top);
	        top = newNode;
	        size++;
	    }

	    public Object pop() {
	        if (isEmpty() == true) {
	            return null;
	        }
	        Object state = top.getState();
	        top = top.getNext();
	        size--;
	        return state;
	    }

	    
	    public Object peek() { 
	        if (isEmpty() == true) {
	            return null;
	        } else {
	            return top.getState(); 
	        }
	    }
	    
	    public boolean isEmpty() { 
	    	return top == null; 
	    	}
	    public int getSize() { 
	    	return size; 
	    	}
	}

