/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    String uuid;

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume() {

    }

    @Override
    public String toString() {
        return uuid;
    }
}
