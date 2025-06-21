// Subject Interface
interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();  // Simulate loading from remote
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);  // Lazy initialization
        } else {
            System.out.println("Image already loaded (cached): " + filename);
        }
        realImage.display();
    }
}

// Test Class
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("mountain.jpg");
        Image image2 = new ProxyImage("river.png");

        // First-time loading (from server)
        image1.display();
        System.out.println("----------------------");

        // Second time: Should use cached image
        image1.display();
        System.out.println("----------------------");

        // New image: loads again
        image2.display();
    }
}
