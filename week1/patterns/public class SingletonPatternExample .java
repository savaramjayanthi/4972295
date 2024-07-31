public class SingletonPatternExample {

    // Singleton Logger class
    public static class Logger {
        // Private static instance of the Logger class
        private static Logger instance;

        // Private constructor to prevent instantiation
        private Logger() {
            // Initialization code, if necessary
        }

        // Public static method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Test class to verify the Singleton implementation
    public static class SingletonTest {
        public static void main(String[] args) {
            Logger logger1 = Logger.getInstance();
            Logger logger2 = Logger.getInstance();

            // Log messages using both instances
            logger1.log("This is the first log message.");
            logger2.log("This is the second log message.");

            // Check if both references point to the same instance
            if (logger1 == logger2) {
                System.out.println("Both logger1 and logger2 are the same instance.");
            } else {
                System.out.println("logger1 and logger2 are different instances.");
            }
        }
    }
}
