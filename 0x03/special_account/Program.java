import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.FRANCE); 

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
            System.out.println(ex.getMessage());
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
            System.out.println(ex.getMessage());
        }

        try {
            ControlledBankAccount acc3 = new ControlledBankAccount("CCC", 30.0, 20, 5);
            System.out.printf("Account %s - balance: %.2f\n", acc3.getAccountNumber(), acc3.getBalance());
            acc3.deposit(125);
            System.out.printf("Account %s - balance: %.2f\n", acc3.getAccountNumber(), acc3.getBalance());
            acc3.withdraw(106);
            System.out.printf("Account %s - balance: %.2f\n", acc3.getAccountNumber(), acc3.getBalance());
            acc3.applyMonthlyUpdate();
            System.out.printf("Account %s - balance: %.2f\n", acc3.getAccountNumber(), acc3.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
