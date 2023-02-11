package circus;

import circus.animal.*;
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
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a: animalArrayList) {
            System.out.println(a);
        }
    }
}
