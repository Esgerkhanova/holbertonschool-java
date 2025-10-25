public class Program {
    public static void main(String[] args) {
        try {
            BasicBankAccount account1 = new BasicBankAccount("AAA", 50.0);
            System.out.printf("Account %s - balance: %.2f\n", account1.getAccountNumber(), account1.getBalance());
            account1.deposit(100);
            System.out.printf("Account %s - balance: %.2f\n", account1.getAccountNumber(), account1.getBalance());
            account1.withdraw(25);
            System.out.printf("Account %s - balance: %.2f\n", account1.getAccountNumber(), account1.getBalance());
            account1.applyMonthlyUpdate();
            System.out.printf("Account %s - balance: %.2f\n\n", account1.getAccountNumber(), account1.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        try {
            BasicBankAccount account2 = new BasicBankAccount("BBB", 100.0);
            System.out.printf("Account %s - balance: %.2f\n", account2.getAccountNumber(), account2.getBalance());
            account2.deposit(10);
            System.out.printf("Account %s - balance: %.2f\n", account2.getAccountNumber(), account2.getBalance());
            account2.withdraw(10);
            System.out.printf("Account %s - balance: %.2f\n", account2.getAccountNumber(), account2.getBalance());
            account2.applyMonthlyUpdate();
            System.out.printf("Account %s - balance: %.2f\n\n", account2.getAccountNumber(), account2.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n");
        }
    }
}
