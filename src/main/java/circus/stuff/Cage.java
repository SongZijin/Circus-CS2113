package circus.stuff;

public class Cage<T> {
    private T t;

    public void lockUp(T t) {
        this.t = t;
        System.out.println("In the cage: " + t);
    }

    public T release() {
        System.out.println(t + " out of cage");
        return t;
    }
}
