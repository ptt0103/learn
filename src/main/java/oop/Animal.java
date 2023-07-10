package oop;

abstract class Animal implements Action{

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void makeSound();

    public void hello(){
        System.out.println("hello");
    }
}
