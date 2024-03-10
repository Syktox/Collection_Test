package Threads;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        Bank Raiffeisen = new Bank();
        Thread depositer = new Thread(() -> {
            Raiffeisen.deposit(1000);
        });

        Thread withdrower = new Thread(new Runnable() {
            @Override
            public void run() {
                Raiffeisen.withdraw(20);
            }
        });

        Thread Rich_Person = new Thread(new RichPersonThread(Raiffeisen));

        Rich_Person.start();
        depositer.start();
        withdrower.start();

        // Rich_Person.join(); // deadlock ( TRUE )
        
        depositer.join();
        withdrower.join();

        System.out.println(Raiffeisen.getCredit());
    }
    
}
