package threadss;

public class MyThread extends Thread {
    private String name;
    static private long balance = 200000;
    private int mns;
    public MyThread(String name) {
        this.name = name;
    }

    public long getMoney() {
        return balance;
    }

    public void setMoney(long money) {
        this.balance = money;
    }

    public  void deposite(long money){
        this.balance += money;

        System.out.println(this.getMoney());
    };

    public static void withraw(long money) throws InterruptedException {
        Thread.sleep(2000);
        if(balance > money)
        balance -= money;
        System.out.println(balance);
    }

    @Override
    public synchronized void run(){
        int i = 0;
        while (i< 5){
            System.out.println(this.name + " lần chạy thứ " + i++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
