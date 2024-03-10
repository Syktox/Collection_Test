package Threads;

public class RichPersonThread implements Runnable {
    private final Bank bank;

    RichPersonThread(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        while (true) {
            bank.deposit(1);
        }
    }
    
}