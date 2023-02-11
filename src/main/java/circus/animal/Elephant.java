package circus.animal;

public class Elephant extends Animal {
    @Override
    public String toString() {
        return "My name is " + name + ". I am an Elephant!";
    }

    @Override
    public int getValue() {
        return 100;
    }

    @Override
    public String speak() {
        return toString() + ". I am the strongest";
    }

    public Elephant(String name) {
        this.name = name;
    }

}
