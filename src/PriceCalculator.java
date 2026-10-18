public class PriceCalculator {

    private static final int PRICE_PER_PAGE = 20;

    public int calculate(int pages, int copies) {
        if (pages <= 0 || copies <= 0) {
            throw new IllegalArgumentException(
                    "Pages and copies must be positive."
            );
        }

        return Math.multiplyExact(
                Math.multiplyExact(pages, copies),
                PRICE_PER_PAGE
        );
    }
}