package chap123.hello_world;

public class HelloWorld {


    public static void main(String[] args) {
        final double PI = 3.141;
        int a = 10;
        boolean b = false;

//        System.out.println(a*a *PI);

        Student student = new Student();
        // switch required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum
//        switch (student){// error
//
//        }
//        int switch_expression;
//        switch_expression = (int) Math.round(Math.random()*10);
//        System.out.println(switch_expression);
//        switch (switch_expression){
//            case 0:
//                System.out.println(0);
//                break;
//            case 1:
//                System.out.println(1);
//                break;
//            case 2:
//                System.out.println(2);
//                break;
//            case 3:
//                System.out.println(3);
//                break;
//            default:
//                System.out.println("default ");
//
//        }

        //run scope do first
//        do{
//            System.out.println("1");
//        }while (false);

//        int arr[] = {1,2,3,4,5,6,7,8,9,10};
//        chap1234.hee.Student students[] = new chap1234.hee.Student[10];
//        System.out.println(students[0]);//null
//        int[] ar = new int [10];
//        System.out.println(ar[0]);//0
//        for (int ele: arr
//             ) {
//            System.out.print(ele + " ");
//        }
        String x= "a";
        String y = "a";

        System.out.println(System.identityHashCode(x.hashCode()));
        System.out.println(System.identityHashCode(y.hashCode()));

        x = "b";

        System.out.println(System.identityHashCode(x.hashCode()));
        System.out.println(System.identityHashCode(y.hashCode()));

    }
}
