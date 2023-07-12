package threadss;

public class Counter {

    public volatile int count1;
    public volatile int count2;

    public Counter() {
        this.count1 = 0;
        this.count2 = 0;
    }
}
