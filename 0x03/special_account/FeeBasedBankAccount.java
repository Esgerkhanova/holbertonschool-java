import exceptions.InvalidOperationException;

public class FeeBasedBankAccount extends BasicBankAccount {
    private static final double TRANSACTION_FEE = 0.10;
    private int transactionCount = 0;

    public FeeBasedBankAccount(String accountNumber, double annualInterestRate) {
        super(accountNumber, annualInterestRate);
    }

    @Override
    public void deposit(double value) throws InvalidOperationException {
        super.deposit(value);
        transactionCount++;
        chargeTransactionFee();
    }

    @Override
    public void withdraw(double value) throws InvalidOperationException {
        super.withdraw(value);
        transactionCount++;
        chargeTransactionFee();
    }

    private void chargeTransactionFee() {
        try {
            super.withdraw(TRANSACTION_FEE);
        } catch (InvalidOperationException ignored) {
            // Əgər balans 0-a bərabərdirsə, cərimə tətbiq olunmur
        }
    }

    public int getTransactionCount() {
        return transactionCount;
    }
}
