package spring.bai15;

public class BankAccount {
    public static long amount = 2000000;

    public void withdraw(String threadName, long withdrawAmount) {
        System.out.println(threadName + " need: " + withdrawAmount);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            if (withdrawAmount > amount) {
                System.out.println(threadName + " rut loi!");
            } else {
                System.out.println(threadName + " rut thanh cong " + withdrawAmount);
                amount = amount - withdrawAmount;
            }
            System.out.println(threadName + " see " + amount);
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        WithdrawThread husband = new WithdrawThread("Husband", bankAccount, 300);
        WithdrawThread wife = new WithdrawThread("Wife", bankAccount, 400);
        husband.start();
        wife.start();
    }
}

class WithdrawThread extends Thread {
    String name;
    long withdrawAmount;
    BankAccount bankAccount = new BankAccount();

    public WithdrawThread(String name, BankAccount bankAccount, long withdrawAmount) {
        this.bankAccount = bankAccount;
        this.name = name;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        bankAccount.withdraw(name, withdrawAmount);
    }
}