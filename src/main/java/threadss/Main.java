package threadss;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static Account account = new Account();
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 100; i ++) {
            executorService.execute(new AddAPennyTask());
            System.out.print(i + " ");
        }
        System.out.println();
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("new balance: " + account.getBalance());
    }

    public static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account{
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public void deposit(int amount){
            int newBalance = balance+ amount;

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.setBalance(newBalance);
        }
    }

}
