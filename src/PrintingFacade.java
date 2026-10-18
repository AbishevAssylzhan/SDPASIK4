public class PrintingFacade {

    private final DocumentService documentService;
    private final PriceCalculator priceCalculator;
    private final BalanceService balanceService;
    private final PrintQueue printQueue;

    public PrintingFacade(int initialBalance) {
        documentService = new DocumentService();
        priceCalculator = new PriceCalculator();
        balanceService = new BalanceService(initialBalance);
        printQueue = new PrintQueue();
    }

    public void printDocument(String fileName, int pages, int copies) {
        documentService.validate(fileName, pages);

        int price = priceCalculator.calculate(pages, copies);
        balanceService.withdraw(price);

        try {
            printQueue.addJob(fileName, pages, copies);
        } catch (RuntimeException exception) {
            balanceService.refund(price);
            throw exception;
        }
    }

    public String processNextJob() {
        return printQueue.processNext();
    }

    public int getBalance() {
        return balanceService.getBalance();
    }
}