package dsa_AB;


//It holds pointers to a left child smaller grades and right child larger grades

public class BSTNode {
 private Course course;
 private float grade; 
 private BSTNode left, right;

 public BSTNode(Course course) {
     this.course = course;
     this.grade = course.getGrade();
 }
 
 public Course getCourse() {
	 return course; 
	 }
 public float getGrade() { 
	 return grade; 
	 }
 public BSTNode getLeft() { 
	 return left; 
	 }
 public BSTNode getRight() {
	 return right; 
	 }
 public void setLeft(BSTNode left) { 
	 this.left = left; 
	 }
 public void setRight(BSTNode right) { 
	 this.right = right;
	 }
}