public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");

        // Image not loaded yet
        image.display(); // loads + displays
        image.display(); // only displays (no reload)
    }
}