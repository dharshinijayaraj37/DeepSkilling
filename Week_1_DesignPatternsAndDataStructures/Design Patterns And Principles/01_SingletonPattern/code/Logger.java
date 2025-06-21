public class Logger {

    // Step 1: Private static instance
    private static Logger instance;

    // Step 2: Private constructor
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Public method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log a message
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
