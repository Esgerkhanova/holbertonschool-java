public class Program {
    public static void main(String[] args) {
        try {
            FeeBasedBankAccount acc1 = new FeeBasedBankAccount("AAA", 30.0);
            System.out.printf("Account %s - balance: %.2f\n", acc1.getAccountNumber(), acc1.getBalance());
            acc1.deposit(125);
            System.out.printf("Account %s - balance: %.2f\n", acc1.getAccountNumber(), acc1.getBalance());
            acc1.withdraw(30);
            System.out.printf("Account %s - balance: %.2f\n", acc1.getAccountNumber(), acc1.getBalance());
            acc1.deposit(10);
            System.out.printf("Account %s - balance: %.2f\n", acc1.getAccountNumber(), acc1.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        try {
            ControlledBankAccount acc2 = new ControlledBankAccount("BBB", 30.0, 20, 5);
            System.out.printf("Account %s - balance: %.2f\n", acc2.getAccountNumber(), acc2.getBalance());
            acc2.deposit(125);
            System.out.printf("Account %s - balance: %.2f\n", acc2.getAccountNumber(), acc2.getBalance());
            acc2.withdraw(105);
            System.out.printf("Account %s - balance: %.2f\n", acc2.getAccountNumber(), acc2.getBalance());
            acc2.applyMonthlyUpdate();
            System.out.printf("Account %s - balance: %.2f\n", acc2.getAccountNumber(), acc2.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n");
        }
    }
}
