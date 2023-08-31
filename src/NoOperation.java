import java.util.concurrent.ExecutionException;

public class NoOperation extends Exception {
    public NoOperation(String description) {
        super(description);
    }
}
