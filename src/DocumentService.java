public class DocumentService {

    public void validate(String fileName, int pages) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name is required.");
        }

        if (!fileName.toLowerCase(java.util.Locale.ROOT).endsWith(".pdf")) {
            throw new IllegalArgumentException("Only PDF files are supported.");
        }

        if (pages <= 0) {
            throw new IllegalArgumentException("Page count must be positive.");
        }
    }
}