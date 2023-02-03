package circus;

import circus.animals.Animal;
import circus.animals.Bird;
import circus.animals.Duck;

public class Trainer {
    public static void main(String[] args) {
        //DO NOT use single letter to name a variable
        Duck duck = new Duck();
        getToSpeak(duck);

        Bird bird = (Bird) duck;  // upcasting
        getToSpeak(bird);

        Animal animal = (Animal) bird; // upcasting
        getToSpeak(animal);

        Duck duck2 = (Duck) animal; // downcasting
        getToSpeak(duck2);

        train(new Duck());
        //the code below will cause class cast exception
        //since Parrot do not have the function swim
        // train(new Parrot());

        //Animal a2 = new Animal();
        //Bird b2 = new Bird();

    }

    private static void getToSpeak(Animal animal) {
        System.out.println(animal.speak());
    }

    private static void train(Bird bird) {
        if (bird instanceof Duck) {
            //ensures that only Duck class is processed here
            //Bad practice
            Duck d = (Duck) bird;
            d.swim();
        } else {
            System.out.println("I'm not a duck!");
        }
    }
}
