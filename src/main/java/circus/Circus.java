package circus;

import circus.animal.*;//bad coding practice that happens because of settings
// => will convert to * if importing a lot from the same package
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("Number of animals: " + animals.length);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        //animals[3] = new Parrot("Dolly"); => will cause array out of bound exception
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        //^ converting the array into an arrayList, and assign it to the newly created list
        //if you now print all the items inside the arrayList, it will print the ToString function of each class inside

        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        //Adding new animals to the arrayList
        Parrot andy = new Parrot("Andy");
        animalArrayList.add(andy);

        Elephant strongOne = new Elephant("StrongOne");
        animalArrayList.add(strongOne);

        System.out.println("Before sorting ......");
        printAllAnimals(animalArrayList);
        System.out.println("Number of animals: " + animalArrayList.size());

        //finding a particular animal
        //You cannot find the items added by converting the initial array like how you find the newly
        //added ones (In O(1)), like below:
        System.out.println("Louie is at: " + animalArrayList.indexOf(louie));
        //You would have to iterate through the whole array and search one by one
        //Note: the arrayList is a 0-based array (start from 0)

        System.out.println("After sorting ......");
        //You can sort the list like below, using a comparator:
        animalArrayList.sort(Animal.AnimalNameComparator);
        //You can create a comparator in the animal class
        printAllAnimals(animalArrayList);
        System.out.println("Louie is at: " + animalArrayList.indexOf(louie));


        animalArrayList.add(new Tiger("Sherkhan"));;

        printAllAnimals(animalArrayList);
        //things below are new, thus we may want to keep it
        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Akshay");
        //if you attempt to lick a parrot in duckCage, you will get an error
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Akshay too");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        //ArrayList is a generic, using Cage as the parameter
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
