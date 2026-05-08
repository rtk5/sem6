public class Main {
    public static void main(String[] args) {
        // with Facade

        PackageFacade facade = new PackageFacadeImpl();
        facade.book();

        // Without Facade
        // book flight
        Booking flightBooking = new Flight();
        flightBooking.book();

        // book hotle
        Booking hotelBooking = new Hotel();
        hotelBooking.book();

        // book cab
        Booking cabBooking = new Cab();
        cabBooking.book();
    }
}
