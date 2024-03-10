package Threads;

public class Bank {
    private int credit;

    public /* synchronized */ void withdraw(int amount) {
        /* credit = credit - amount; */

        synchronized (this) {
            credit = credit - amount;
        }
    }

    public /* synchronized */  void deposit(int amount) {
        /*credit = credit + amount; */

        synchronized (this) {
            credit = credit + amount;
        }
    }

    public int getCredit() {
        return credit;
    }
}