package oop;

import oop.Animal;

public class Dog extends Animal implements Action {

    public Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("WOh");
    }

    @Override
    public void makeAction() {
        System.out.println("do something");
    }


}
