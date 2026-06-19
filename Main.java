package dsa_AB;

import java.util.Scanner;


public class Main {
 private CourseLinkedList courseList;
 private UndoStack undoStack;
 private SemesterQueue semesterQueue;
 private CourseBST completedBST;
 private CourseGraph courseGraph;
 private Scanner scanner;

 public Main() {
     courseList = new CourseLinkedList();
     undoStack = new UndoStack();
     semesterQueue = new SemesterQueue();
     completedBST = new CourseBST();
     courseGraph = new CourseGraph();
     scanner = new Scanner(System.in);

     
     courseGraph.addPrerequisiteEdge("CS101", "CS201");
     courseGraph.addPrerequisiteEdge("CS201", "CS301");
 }

 public void displayMenu() {
     System.out.println("\n--- Degree Planner System ---");
     System.out.println("1. Add a Course");
     System.out.println("2. Remove a Course");
     System.out.println("3. Undo Last Action");
     System.out.println("4. Queue Course for Semester");
     System.out.println("5. Display Semester Queue");
     System.out.println("6. Browse All Courses");
     System.out.println("7. Find Highest Graded Course");
     System.out.println("8. Check Unlocked Courses");
     System.out.println("9. Exit");
     System.out.print("Select an option: ");
 }

 public void handleUserInput() {
     boolean running = true;
     while (running) {
         displayMenu();
         String input = scanner.nextLine();
         
         try {
             switch (input) {
                 case "1":
                     System.out.print("Enter Course ID: ");
                     String id = scanner.nextLine();
                     System.out.print("Enter Grade (0 if not completed): ");
                     float grade = Float.parseFloat(scanner.nextLine());
                     boolean completed = false;
                     if (grade > 0) {
                         completed = true;
                     }
                     Course c = new Course(id, "Course Title", 3, grade, completed);
                     
                     courseList.addCourse(c); 
                     if (completed == true) {
                         completedBST.insert(c); 
                     }
                     undoStack.push("ADDED:" + id); 
                     System.out.println("Course successfully added.");
                     break;
                 case "2":
                     System.out.print("Enter Course ID to remove: ");
                     String remId = scanner.nextLine();
                     Course removed = courseList.removeCourse(remId); 
                     if (removed != null) {
                         System.out.println("Removed: " + remId);
                         undoStack.push("REMOVED:" + remId); 
                     } else {
                         System.out.println("Error: Course not found in the plan.");
                     }
                     break;
                 case "3":
                     Object lastAction = undoStack.pop(); 
                     if (lastAction != null) {
                         System.out.println("Undo functionality triggered for: " + lastAction);
                     } else {
                         System.out.println("Nothing to undo. Stack is empty.");
                     }
                     break;
                 case "4":
                     System.out.print("Enter Course ID to enqueue: ");
                     String qId = scanner.nextLine();
                     semesterQueue.enqueue(new Course(qId, "Queued", 3, 0, false)); 
                     System.out.println(qId + " added to the registration queue.");
                     break;
                 case "5":
                     System.out.println("\n--- Next Semester Queue ---");
                     if (semesterQueue.isEmpty()) {
                         System.out.println("Queue is currently empty.");
                     } else {
                         semesterQueue.displayQueue(); 
                     }
                     break;
                 case "6":
                     System.out.println("\n--- Full Degree Plan ---");
                     courseList.browseList(); 
                     break;
                 case "7":
                     Course high = completedBST.getHighestGrade(); 
                     if (high != null) {
                         System.out.println("Highest Grade: " + high.getCourseId() + " with " + high.getGrade());
                     } else {
                         System.out.println("No completed courses found.");
                     }
                     break;
                 case "8":
                     System.out.print("Enter completed Course ID (e.g., CS101): ");
                     String unlockId = scanner.nextLine();
                     courseGraph.displayUnlocked(unlockId); 
                     break;
                 case "9":
                     running = false;
                     System.out.println("Exiting Degree Planner...");
                     break;
                 default:
                     System.out.println("Invalid menu option.");
             }
         } catch (NumberFormatException e) {
             System.out.println("\n[INPUT ERROR]: Please enter a valid number. Action aborted.");
         } catch (Exception e) {
             System.out.println("\n[SYSTEM ERROR]: An unexpected error occurred.");
         }
     }
 }

 public void run() {
     handleUserInput();
 }

 public static void main(String[] args) {
     Main app = new Main();
     app.run();
 }
}