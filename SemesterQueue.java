package dsa_AB;

public class SemesterQueue {

	    private QueueNode front, rear; 
	    private int size = 0;

	    public void enqueue(Course course) {
	        QueueNode newNode = new QueueNode(course);
	        if (rear == null) {
	            front = rear = newNode; 
	        } else {
	            rear.setNext(newNode);
	            rear = newNode; 
	        }
	        size++;
	    }

	    public Course dequeue() {
	        if (isEmpty() == true) {
	            return null;
	        }
	        Course temp = front.getCourse();
	        front = front.getNext(); 
	        if (front == null) {
	            rear = null; 
	        }
	        size--;
	        return temp;
	    }

	    public boolean isEmpty() {
	    		return front == null;
	    }
	    public int getSize() {
	    	return size;
	    	}

	    public void displayQueue() {
	        QueueNode current = front;
	        while (current != null) {
	            System.out.println("-> " + current.getCourse().getCourseId());
	            current = current.getNext();
	        }
	    }
	}

