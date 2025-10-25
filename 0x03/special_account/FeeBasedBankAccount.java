import exceptions.InvalidOperationException;

public class FeeBasedBankAccount extends BasicBankAccount {
    private int transactionCount = 0;

    public FeeBasedBankAccount(String accountNumber, double annualInterestRate) {
        super(accountNumber, annualInterestRate);
    }

    @Override
    public void deposit(double value) throws InvalidOperationException {
        super.deposit(value);
        transactionCount++;
        withdrawFee();
    }

    @Override
    public void withdraw(double value) throws InvalidOperationException {
        super.withdraw(value);
        transactionCount++;
        withdrawFee();
    }

    private void withdrawFee() {
        try {
            super.withdraw(0.10);
        } catch (Exception ignored) {}
    }

    public int getTransactionCount() {
        return transactionCount;
    }
}
