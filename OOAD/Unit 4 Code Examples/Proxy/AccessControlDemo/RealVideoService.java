// Real Subject
class RealVideoService implements VideoService {

    @Override
    public void playVideo(String title, boolean isRestricted) {
        System.out.println("Playing video: " + title);
    }
}