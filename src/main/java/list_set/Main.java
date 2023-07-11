package list_set;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2,4,3,5);
//        number.sort(((o1, o2) -> o1-o2));
        System.out.println("1st: " + number);
        Comparator.reverseOrder();
        System.out.println("2nd :" + number.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }).collect(Collectors.toList()));
        System.out.println("3rd :" + number.stream().sorted(((o1, o2) -> o2-o1)).collect(Collectors.toList()));

        System.out.println(number.stream().map(x -> x*x).collect(Collectors.toList()));
        System.out.println(number.stream().filter(x -> x==2 ));

        System.out.println(number.stream().map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        }).collect(Collectors.toList()));


        List <Integer> linkList = new LinkedList<>();


        //remove in iterator will remove in set
        Set <Integer> set = new HashSet<>(number);
        System.out.println(set.toString());


//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            Integer i = (Integer) iterator.next();
//            if(i == 2){
//                iterator.remove();
//            }
//
//        }
        System.out.println(set.toString());






    }

}
