package dsa_AB;

//Feature 5

public class CourseGraph {
 private CustomStringList vertices; 
 private CourseLinkedList[] adjacencyList; 
 private int maxVertices = 50; 
 private int currentIndex = 0;

 public CourseGraph() {
     vertices = new CustomStringList();
     adjacencyList = new CourseLinkedList[maxVertices];
 }

 public void addCourseVertex(String courseId) {
     if (hasCourse(courseId) == false && currentIndex < maxVertices) {
         vertices.add(courseId);
         adjacencyList[currentIndex] = new CourseLinkedList(); 
         currentIndex++;
     }
 }

 private int getIndex(String courseId) {
     StringNode current = vertices.getHead();
     int index = 0;
     while (current != null) {
         if (current.getData().equalsIgnoreCase(courseId)) {
             return index;
         }
         current = current.getNext();
         index++;
     }
     return -1; 
 }

 public boolean hasCourse(String courseId) {
     if (getIndex(courseId) == -1) {
         return false;
     } else {
         return true;
     }
 }

 public void addPrerequisiteEdge(String prereqId, String targetId) {
     addCourseVertex(prereqId); 
     addCourseVertex(targetId);
     
     int index = getIndex(prereqId);
     adjacencyList[index].addCourse(new Course(targetId, "", 0, 0, false));
 }

 public CourseLinkedList getUnlockedCourses(String courseId) {
     int index = getIndex(courseId);
     if (index != -1) {
         return adjacencyList[index];
     }
     return null;
 }

 public void displayUnlocked(String courseId) {
     CourseLinkedList unlocked = getUnlockedCourses(courseId);
     if (unlocked != null && unlocked.getSize() > 0) {
         System.out.print(courseId + " unlocks: ");
         unlocked.browseList(); 
     } else {
         System.out.println(courseId + " does not unlock any courses.");
     }
 }
}