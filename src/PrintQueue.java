import java.util.ArrayDeque;
import java.util.Queue;

public class PrintQueue {

    private static final int MAX_JOBS = 3;
    private final Queue<String> jobs = new ArrayDeque<>();

    public void addJob(String fileName, int pages, int copies) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name is required.");
        }

        if (pages <= 0 || copies <= 0) {
            throw new IllegalArgumentException(
                    "Pages and copies must be positive."
            );
        }

        if (jobs.size() >= MAX_JOBS) {
            throw new IllegalStateException("Print queue is full.");
        }

        jobs.add(fileName + " | Pages: " + pages
                + " | Copies: " + copies);
    }

    public String processNext() {
        if (jobs.isEmpty()) {
            throw new IllegalStateException("Print queue is empty.");
        }

        return jobs.remove();
    }

    public int getJobCount() {
        return jobs.size();
    }
}