//client

public class Main {
    public static void main(String[] args) {

        User teen = new User(15);
        User adult = new User(21);

        VideoService teenService = new VideoServiceProxy(teen);
        VideoService adultService = new VideoServiceProxy(adult);

        teenService.playVideo("Comedy Clip", false);     // allowed
        teenService.playVideo("Restricted Movie", true); // denied

        System.out.println("----");

        adultService.playVideo("Restricted Movie", true); // allowed
    }
}