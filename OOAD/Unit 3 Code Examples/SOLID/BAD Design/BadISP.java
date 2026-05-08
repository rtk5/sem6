/**
 *
 * @author shridevisawant
 */
/*
Bad Design:
One large interface → classes implement unnecessary methods.
*/

interface Machine {
    void print();
    void scan();
    void fax();
}

class OldPrinter implements Machine {

    public void print() {
        System.out.println("Printing document");
    }

    public void scan() {
        System.out.println("Cannot Scan");
    }

    public void fax() {
        System.out.println("Cannot fax");
    }
}

class MultiFunctionPrinter implements Machine {

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

class BadISP
{
	public static void main(String[] args)
	{
		OldPrinter oldPrinter = new OldPrinter();
        oldPrinter.print();
        oldPrinter.scan();
        oldPrinter.fax();

        MultiFunctionPrinter myPrinter = new MultiFunctionPrinter();
        myPrinter.print();
        myPrinter.scan();
        myPrinter.fax();
		
	}
}