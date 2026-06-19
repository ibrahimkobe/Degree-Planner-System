package dsa_AB;

public class CourseLinkedList {

	    private CourseNode head; 
	    private int size = 0;

	    public void addCourse(Course course) {
	        CourseNode newNode = new CourseNode(course);
	        if (head == null) {
	            head = newNode;
	        } else {
	            CourseNode current = head;
	            while (current.getNext() != null) {
	                current = current.getNext();
	            }
	            current.setNext(newNode);
	        }
	        size++;
	    }

	    public Course removeCourse(String courseId) {
	        if (head == null) {
	            return null;
	        }
	        
	        if (head.getCourse().getCourseId().equalsIgnoreCase(courseId)) {
	            Course removed = head.getCourse();
	            head = head.getNext(); 
	            size--;
	            return removed;
	        }
	        
	        CourseNode current = head;
	        while (current.getNext() != null && !current.getNext().getCourse().getCourseId().equalsIgnoreCase(courseId)) {
	            current = current.getNext();
	        }
	        
	        if (current.getNext() != null) {
	            Course removed = current.getNext().getCourse();
	            current.setNext(current.getNext().getNext());
	            size--;
	            return removed;
	        }
	        return null; 
	    }

	    public void browseList() {
	        if (head == null) {
	            System.out.println("List is empty.");
	            return;
	        }
	        CourseNode current = head;
	        while (current != null) {
	            current.getCourse().displayCourseDetails();
	            current = current.getNext(); 
	        }
	    }

	    public int getSize() { 
	    	return size;
	    	}
	}

