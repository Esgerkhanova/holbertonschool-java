import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.FRANCE); // bu virgul (,) formatını aktiv edir

        try {
            BasicBankAccount account1 = new BasicBankAccount("AAA", 50.0);
            System.out.printf("Account %s - balance: %.2f%n", account1.getAccountNumber(), account1.getBalance());
            account1.deposit(100);
            System.out.printf("Account %s - balance: %.2f%n", account1.getAccountNumber(), account1.getBalance());
            account1.withdraw(25);
            System.out.printf("Account %s - balance: %.2f%n", account1.getAccountNumber(), account1.getBalance());
            account1.applyMonthlyUpdate();
            System.out.printf("Account %s - balance: %.2f%n", account1.getAccountNumber(), account1.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            BasicBankAccount account2 = new BasicBankAccount("BBB", 100.0);
            System.out.printf("Account %s - balance: %.2f%n", account2.getAccountNumber(), account2.getBalance());
            account2.deposit(10);
            System.out.printf("Account %s - balance: %.2f%n", account2.getAccountNumber(), account2.getBalance());
            account2.withdraw(10);
            System.out.printf("Account %s - balance: %.2f%n", account2.getAccountNumber(), account2.getBalance());
            account2.applyMonthlyUpdate();
            System.out.printf("Account %s - balance: %.2f%n", account2.getAccountNumber(), account2.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            BasicBankAccount account3 = new BasicBankAccount("CCC", 60.0);
            System.out.printf("Account %s - balance: %.2f%n", account3.getAccountNumber(), account3.getBalance());
            account3.deposit(1600);
            System.out.printf("Account %s - balance: %.2f%n", account3.getAccountNumber(), account3.getBalance());
            account3.withdraw(150);
            System.out.printf("Account %s - balance: %.2f%n", account3.getAccountNumber(), account3.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            BasicBankAccount account4 = new BasicBankAccount("DDD", 80.0);
            System.out.printf("Account %s - balance: %.2f%n", account4.getAccountNumber(), account4.getBalance());
            account4.deposit(0);
            System.out.printf("Account %s - balance: %.2f%n", account4.getAccountNumber(), account4.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            BasicBankAccount account5 = new BasicBankAccount("EEE", 90.0);
            System.out.printf("Account %s - balance: %.2f%n", account5.getAccountNumber(), account5.getBalance());
            account5.deposit(25);
            System.out.printf("Account %s - balance: %.2f%n", account5.getAccountNumber(), account5.getBalance());
            account5.withdraw(30);
            System.out.printf("Account %s - balance: %.2f%n", account5.getAccountNumber(), account5.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
