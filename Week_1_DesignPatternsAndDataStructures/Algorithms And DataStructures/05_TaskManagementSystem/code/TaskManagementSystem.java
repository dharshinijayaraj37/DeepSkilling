import java.util.Scanner;

public class TaskManagementSystem {

    // Step 2: Task Class
    static class Task {
        int taskId;
        String taskName;
        String status;

        public Task(int id, String name, String status) {
            this.taskId = id;
            this.taskName = name;
            this.status = status;
        }

        public String toString() {
            return "ID: " + taskId + ", Task: " + taskName + ", Status: " + status;
        }
    }

    // Node for Linked List
    static class Node {
        Task data;
        Node next;

        public Node(Task data) {
            this.data = data;
            this.next = null;
        }
    }

    // Step 3: Linked List Implementation
    static class TaskLinkedList {
        Node head;

        // Add to end
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            System.out.println("Task added.");
        }

        // Search task by ID
        public Task searchTask(int id) {
            Node temp = head;
            while (temp != null) {
                if (temp.data.taskId == id)
                    return temp.data;
                temp = temp.next;
            }
            return null;
        }

        // Traverse tasks
        public void listTasks() {
            if (head == null) {
                System.out.println("No tasks available.");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        // Delete task by ID
        public void deleteTask(int id) {
            if (head == null) {
                System.out.println("Task list is empty.");
                return;
            }

            if (head.data.taskId == id) {
                head = head.next;
                System.out.println("Task deleted.");
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.data.taskId != id) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Task not found.");
            } else {
                temp.next = temp.next.next;
                System.out.println("Task deleted.");
            }
        }
    }

    // Step 4: Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskLinkedList taskList = new TaskLinkedList();

        while (true) {
            System.out.println("\n1. Add Task  2. Search Task  3. Delete Task  4. View All Tasks  5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID, Name, Status: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String status = sc.next();
                    taskList.addTask(new Task(id, name, status));
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    Task found = taskList.searchTask(searchId);
                    System.out.println(found != null ? found : "Task not found.");
                    break;

                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    taskList.deleteTask(deleteId);
                    break;

                case 4:
                    System.out.println("Task List:");
                    taskList.listTasks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
