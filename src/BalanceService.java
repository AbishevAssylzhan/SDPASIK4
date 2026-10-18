public class BalanceService {

    private int balance;

    public BalanceService(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative."
            );
        }
        balance = initialBalance;
    }

    public void withdraw(int amount) {
        validateAmount(amount);

        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance.");
        }

        balance -= amount;
    }

    public void refund(int amount) {
        validateAmount(amount);
        balance = Math.addExact(balance, amount);
    }

    public int getBalance() {
        return balance;
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be positive."
            );
        }
    }
}