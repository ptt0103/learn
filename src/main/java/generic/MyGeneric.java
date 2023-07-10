package generic;

public class MyGeneric <T>{
    private T obj;

    public MyGeneric(T obj) {
        this.obj = obj;
    }

    public <T> void sayHelloTo(T obj){
        System.out.println(this.obj + " hello " + obj);
    }
}
