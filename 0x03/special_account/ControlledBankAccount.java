import exceptions.InvalidOperationException;

public class ControlledBankAccount extends BasicBankAccount {
    private double minimumBalance;
    private double penaltyAmount;

    public ControlledBankAccount(String accountNumber, double annualInterestRate, double minimumBalance, double penaltyAmount) {
        super(accountNumber, annualInterestRate);
        this.minimumBalance = minimumBalance;
        this.penaltyAmount = penaltyAmount;
    }

    @Override
    public void applyMonthlyUpdate() {
        super.applyMonthlyUpdate();
        if (getBalance() < minimumBalance) {
            try {
                withdraw(penaltyAmount);
            } catch (InvalidOperationException e) {
                // ignore
            }
        }
    }
}
