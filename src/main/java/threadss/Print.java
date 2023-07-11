package threadss;

public class Print <T> implements Runnable{
    private T obj;
    private int num;
    public Print(T obj, int num) {
        this.obj = obj;
        this.num = num;
    }

    @Override
    public void run() {
        for(int i = 0; i < this.num; i++){
            System.out.println(obj + " ");
        }
    }
}
