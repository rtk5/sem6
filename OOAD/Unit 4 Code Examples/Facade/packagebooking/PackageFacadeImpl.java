public class PackageFacadeImpl implements PackageFacade {

    private Booking cab;
    private Booking hotel;
    private Booking flight;

    public PackageFacadeImpl() {
        this.cab = new Cab();
        this.hotel = new Hotel();
        this.flight = new Flight();
    }

    @Override
    public void book() {
        cab.book();
        hotel.book();
        flight.book();
        System.out.println("Travel package booked successfully");
    }
}
