package dsa_AB;

public class QueueNode {

	    private Course course;
	    private QueueNode next;
	    
	    public QueueNode(Course course) { 
	    	this.course = course; 
	    	}
	    public Course getCourse() { 
	    	return course;
	    	}
	    public QueueNode getNext() { 
	    	return next;
	    	}
	    public void setNext(QueueNode next) { 
	    	this.next = next; 
	    	}
	}

