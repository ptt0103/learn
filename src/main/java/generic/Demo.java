package generic;

import chap123.hello_world.Student;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    static <T> void printList(List<T> list){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Dictionary<String, String> learn = new Dictionary<>("subject", "math");

        System.out.println(learn.getKey() + ": " + learn.getValue());

        Dictionary<String, Integer> dic1 = new Dictionary<>("quantity", 10);

        Dictionary<Integer, Student> objDic = new Dictionary<>(1, new Student());

        Dictionary<String,String>[] learns = new Dictionary[10];
        learns[0] = learn;
        for (Dictionary ele: learns
             ) {
            System.out.print(ele + " ");
        }
        System.out.println();


        MyGeneric<String> myGeneric = new MyGeneric<>("Nam");
        myGeneric.sayHelloTo("ha");


        String a= "a";
        String b = "b";
        int num1 = 1, num2 = 2;

        List <String> strings = new ArrayList<>();
        strings.add(a);
        strings.add(b);

        printList(strings);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(num1);
        numbers.add(num2);

        printList(numbers);

    }
}
