package circus.animal;

public class Tiger extends Animal {
    @Override
    public String toString() {
        return "My name is " + name + ". I am a majestic Tiger!";
    }

    @Override
    public int getValue() {
        return 100;
    }

    @Override
    public String speak() {
        return toString() + ". I don't speak; I ROARRR!!!!";
    }

    public Tiger(String name) {
        this.name = name;
    }
}
