Implement the following use case using a Chain of Responsibility pattern.
Write both the class diagram and the code snippet for building the chain.
A logging system provides functionality to write INFO messages to the console
(terminal), ERROR messages to an error log file and DEBUG messages to a debug
log file. The client invokes the console logger irrespective of the type of message.
The console logger will check the type and if the message is INFO message then it
writes it to the console. Else, it invokes the next level logger that is the error logger.
The error logger does the same and if the message is not an ERROR message it
invokes the debug logger. The same applies to DEBUG logger, however, it does not
have any next level logger.

Java Code Snippet
Abstract Logger Class
abstract class Logger {

    protected Logger nextLogger;

    void setNextLogger(Logger nextLogger) {

        this.nextLogger = nextLogger;
    }

    abstract void logMessage(String level,
                             String msg);
}
Console Logger
class ConsoleLogger extends Logger {

    void logMessage(String level,
                    String msg) {

        if(level.equals("INFO")) {

            System.out.println(
                "Console Logger: " + msg);
        }
        else if(nextLogger != null) {

            nextLogger.logMessage(level, msg);
        }
    }
}
Error Logger
class ErrorLogger extends Logger {

    void logMessage(String level,
                    String msg) {

        if(level.equals("ERROR")) {

            System.out.println(
                "Error Log File: " + msg);
        }
        else if(nextLogger != null) {

            nextLogger.logMessage(level, msg);
        }
    }
}
Debug Logger
class DebugLogger extends Logger {

    void logMessage(String level,
                    String msg) {

        if(level.equals("DEBUG")) {

            System.out.println(
                "Debug Log File: " + msg);
        }
    }
}
Building the Chain
public class Main {

    public static void main(String[] args) {

        Logger consoleLogger =
                new ConsoleLogger();

        Logger errorLogger =
                new ErrorLogger();

        Logger debugLogger =
                new DebugLogger();

        // Build chain
        consoleLogger.setNextLogger(errorLogger);

        errorLogger.setNextLogger(debugLogger);

        // Client always starts with console logger
        consoleLogger.logMessage(
                "INFO",
                "System Started");

        consoleLogger.logMessage(
                "ERROR",
                "File Missing");

        consoleLogger.logMessage(
                "DEBUG",
                "Variable x = 10");
    }
}
Output
Console Logger: System Started
Error Log File: File Missing
Debug Log File: Variable x = 10
Flow of Chain
Client
   ↓
ConsoleLogger
   ↓
ErrorLogger
   ↓
DebugLogger

Each logger:

handles the request if possible
otherwise forwards it to the next logger in the chain.
Voice chat ended
15s