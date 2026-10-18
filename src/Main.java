public class Main {

    public static void main(String[] args) {
        PrintingFacade printing = new PrintingFacade(1000);

        printing.printDocument("assignment.pdf", 5, 2);
        System.out.println("Order added. Balance: " + printing.getBalance());

        printing.printDocument("lecture.pdf", 3, 1);
        printing.printDocument("notes.pdf", 2, 1);
        System.out.println("Three orders added. Balance: " + printing.getBalance());

        try {
            printing.printDocument("extra.pdf", 1, 1);
        } catch (IllegalStateException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        System.out.println("Balance after failed order: " + printing.getBalance());
        System.out.println("Processing: " + printing.processNextJob());

        try {
            printing.printDocument("photo.jpg", 1, 1);
        } catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}