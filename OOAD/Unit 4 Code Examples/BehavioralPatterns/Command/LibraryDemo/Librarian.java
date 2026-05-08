//Invoker 
class Librarian {
    private LibraryCommand command;

    public void setCommand(LibraryCommand command) {
        this.command = command;
    }

    public void processRequest() {
        command.execute();
    }
}