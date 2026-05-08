
// Protection Proxy
class VideoServiceProxy implements VideoService {

    private RealVideoService realService;
    private User user;

    public VideoServiceProxy(User user) {
        this.realService = new RealVideoService();
        this.user = user;
    }

    @Override
    public void playVideo(String title, boolean isRestricted) {
        if (isRestricted && user.getAge() < 18) {
            System.out.println("Access Denied: Age restriction");
        } else {
            realService.playVideo(title, isRestricted);
        }
    }
}