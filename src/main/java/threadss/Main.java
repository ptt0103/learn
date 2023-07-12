package threadss;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
//    private static Account account = new Account();

    public static void main(String[] args) throws InterruptedException {

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for(int i = 0; i < 100; i ++) {
//            executorService.execute(new AddAPennyTask());
////            System.out.print(i + " ");
////             new AddAPennyTask().run();
//        }
//        System.out.println();
//        executorService.shutdown();
//        while (!executorService.isTerminated()){
//
//        }
//        System.out.println("new balance: " + account.getBalance());


        //False Sharing
        //run 2 thread waste about 15-17s
        //the count1 and count2 fields in the shared Counter instance

        Counter counter1 = new Counter();
//        Counter counter2 = counter1;

        //two thread use each their own Counter instance,
        Counter counter2 = new Counter();
        long iterations = 1_000_000_000;
        System.out.println(iterations);

        Thread thread1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for(long i=0; i<iterations; i++) {
                counter1.count1++;
            }
            System.out.println("count 1: " + counter1.count1);
            long endTime = System.currentTimeMillis();
            System.out.println("total time 1: " + (endTime - startTime));

        });


        Thread thread2 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for(long i=0; i<iterations; i++) {
                counter2.count2++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("count 2: " + counter2.count2);
            System.out.println("total time 2: " + (endTime - startTime));
        });

        ThreadLocal <Integer> local1 = new ThreadLocal<>();


        thread1.start();
        thread2.start();
    }

//    public static class AddAPennyTask implements Runnable {
//        @Override
//        public void run() {
//            account.deposit(1);
//        }
//    }



//    private static class Account{
//        private int balance = 0;
//
//        public int getBalance() {
//            return balance;
//        }
//
//        public void setBalance(int balance) {
//            this.balance = balance;
//        }
//
//        public void deposit(int amount){
//            int newBalance = balance+ amount;
//
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            this.setBalance(newBalance);
//        }
//    }

}
