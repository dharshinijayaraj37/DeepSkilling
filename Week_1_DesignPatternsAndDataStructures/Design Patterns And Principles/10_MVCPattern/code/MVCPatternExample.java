// Model Class
class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// View Class
class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}

// Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Controller methods to update model
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentName() {
        return model.getName();
    }

    public String getStudentId() {
        return model.getId();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Main Class to test MVC
public class MVCPatternExample {
    public static void main(String[] args) {
        // Step 1: Create the Model
        Student student = new Student("Alice", "S001", "A");

        // Step 2: Create the View
        StudentView view = new StudentView();

        // Step 3: Create the Controller
        StudentController controller = new StudentController(student, view);

        // Initial view
        controller.updateView();

        System.out.println("---- Updating Student Details ----");

        // Update data using controller
        controller.setStudentName("Bob");
        controller.setStudentId("S002");
        controller.setStudentGrade("B+");

        // Updated view
        controller.updateView();
    }
}
