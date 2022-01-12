package com.company;

public class POLIMORFIZM {

    public static void main(String[] args) {

        Animal animal1 = new Cat("Tekir");
        Animal animal2 = new Dog("Rocky");
        Animal animal3 = new Horse("Kemal");

        System.out.println(animal1.talk());
        System.out.println(animal2.talk());
        System.out.println(animal3.talk());

        System.out.println("--------------------");
        talk(new Cat("LORD"));
        talk(new Dog("PASHA"));
        talk(new Horse("BEYAZIT"));
    }
    public static void talk(Object object){

        if (object instanceof Dog){
            Dog dog = (Dog) object;
            System.out.println(dog.talk());
        }
        else if(object instanceof  Cat){
            Cat cat = (Cat) object;
            System.out.println(cat.talk());
        }
        else if (object instanceof Horse){
            Horse horse = (Horse) object;
            System.out.println(horse.talk());
        }
        else if (object instanceof Animal){
            Animal animal = (Animal) object;
            System.out.println(animal.talk());
        }
    }
}
class Animal{

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
    public String talk(){
        return "Animal is talking";
    }
}

class Cat extends  Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    public String talk() {
        return this.getName() + ": is meowing";
    }
}
class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public String talk() {
        return this.getName() + ": is barking";
    }
}
class Horse extends Animal{
    public Horse(String name) {
        super(name);
    }

    @Override
    public String talk() {
        return this.getName()  +  ": is neighing";
    }
}


