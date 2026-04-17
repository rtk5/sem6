import java.util.HashMap;
import java.util.Map;

// Subject interface
interface Video {
    void loadVideo(String name);
    void playVideo();
}

// Real object — expensive to create
class RealVideo implements Video {
    private String name;

    public RealVideo(String name) {
        this.name = name;
        loadVideo(name); // Loading happens at construction
    }

    public void loadVideo(String name) {
        System.out.println("Loading video from disk: " + name);
    }

    public void playVideo() {
        System.out.println("Playing video: " + name);
    }
}

// Proxy — controls access and caches instances
class VideoProxy {
    private Map<String, RealVideo> cache = new HashMap<>();

    public void playVideo(String name) {
        if (!cache.containsKey(name)) {
            System.out.println("Cache miss — creating new RealVideo for: " + name);
            cache.put(name, new RealVideo(name));
        } else {
            System.out.println("Cache hit — reusing loaded video for: " + name);
        }
        cache.get(name).playVideo();
    }
}

public class StreamingPlatform {
    public static void main(String[] args) {
        VideoProxy proxy = new VideoProxy();

        proxy.playVideo("Inception.mp4");
        System.out.println();
        proxy.playVideo("Interstellar.mp4");
        System.out.println();
        proxy.playVideo("Inception.mp4"); // Reused from cache
    }
}