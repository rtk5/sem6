/**
 *
 * @author shridevisawant
 */
/*
ISP - Interface Segregation Principle states that classes 
should not be forced to implement interfaces they do not use.

Good Design:
Break interfaces into smaller, focused interfaces.
No class implements unnecessary methods. 
*/

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

//Implement Only What Is Needed
class OldPrinter implements Printer {

    public void print() {
        System.out.println("Printing document");
    }


}

class MultiFunctionPrinter implements Printer, Scanner, Fax {

    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        System.out.println("Scanning");
    }

    public void fax() {
        System.out.println("Faxing");
    }
}

class ISPDemo
{
	public static void main(String[] args)
	{
		OldPrinter oldPrinter = new OldPrinter();
        oldPrinter.print();
        

        MultiFunctionPrinter myPrinter = new MultiFunctionPrinter();
        myPrinter.print();
        myPrinter.scan();
        myPrinter.fax();
		
	}
}