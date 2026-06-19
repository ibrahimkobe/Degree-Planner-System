package dsa_AB;

public class CourseBST {

	    private BSTNode root; 

	  
	    public void insert(Course course) {
	        if (course.isCompleted() == false) {
	            return; 
	        }

	        BSTNode newNode = new BSTNode(course);

	        if (root == null) {
	            root = newNode;
	            return;
	        }

	        BSTNode current = root;
	        while (true) {
	            if (course.getGrade() < current.getGrade()) {
	                if (current.getLeft() == null) {
	                    current.setLeft(newNode); 
	                    break;
	                } else {
	                    current = current.getLeft(); 
	                }
	            } else {
	                if (current.getRight() == null) {
	                    current.setRight(newNode); 
	                    break;
	                } else {
	                    current = current.getRight(); 
	                }
	            }
	        }
	    }

	    public Course searchByGrade(float grade) {
	        BSTNode current = root;
	        
	        while (current != null) {
	            if (current.getGrade() == grade) {
	                return current.getCourse(); 
	            } else if (grade < current.getGrade()) {
	                current = current.getLeft(); 
	            } else {
	                current = current.getRight(); 
	            }
	        }
	        return null; 
	    }

	    public Course getHighestGrade() {
	        if (root == null) 
	        	{
	        	return null;
	        	}
	        BSTNode current = root;
	        while (current.getRight() != null) {
	            current = current.getRight(); 
	        }
	        return current.getCourse();
	    }

	    public Course getLowestGrade() {
	        if (root == null) return null;
	        BSTNode current = root;
	        while (current.getLeft() != null) {
	            current = current.getLeft(); 
	        }
	        return current.getCourse();
	    }
	}

