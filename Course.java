package dsa_AB;


//core of my system

public class Course {
 private String courseId;
 private String title;
 private int creditHours;
 private float grade;
 private boolean isCompleted;
 private CustomStringList prerequisites;

 public Course(String courseId, String title, int creditHours, float grade, boolean isCompleted) {
     this.courseId = courseId;
     this.title = title;
     this.creditHours = creditHours;
     this.grade = grade;
     this.isCompleted = isCompleted;
     this.prerequisites = new CustomStringList();
 }

 public String getCourseId() {
	 return courseId;
	 }
 public String getTitle() {
	 return title;
	 }
 public int getCreditHours() { 
	 return creditHours; 
	 }
 public float getGrade() { 
	 return grade; 
	 }
 public boolean isCompleted() { 
	 return isCompleted; 
	 }
 
 public void setGrade(float grade) {
	 this.grade = grade;
	 }
 public void setCompleted(boolean completed) {
	 this.isCompleted = completed; 
	 }
 public CustomStringList getPrerequisites() {
	 return prerequisites; 
	 }


 public void displayCourseDetails() {
     System.out.print(courseId + " - " + title + " (" + creditHours + " cr) | Completed: " + isCompleted);
     if (isCompleted == true) {
         System.out.print(" | Grade: " + grade);
     }
     System.out.println();
 }
}