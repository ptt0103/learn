package oop;

public class Run {
    public static void main(String[] args) {
        Animal dog = new Dog("dog");
        Animal dog2 = dog;
        System.out.println(dog2);
        dog.setName("dogg");

        System.out.println(dog2);
        System.out.println(dog == dog2);
//        System.out.println(dog instanceof Animal);
//        dog.hello();
//        dog.makeSound();
//        dog.makeAction();

//        Animal animal = new Animal("Cat") {
//            @Override
//            public void makeAction() {
//                System.out.println("animal do something");
//            }
//
//            @Override
//            void makeSound() {
//                System.out.println("meo");
//            }
//        };
//        animal.makeSound();
//        animal.makeAction();
//        animal.hello();


//        Dog dog2 = new Dog("dodd");
//        dog2.makeAction();
//        dog2.hello();
//        dog2.makeSound();

//        Person a = new Employee();
//        a.doSomething();
//        Person b= new Person();
//        b.doSomething();
    }
}
