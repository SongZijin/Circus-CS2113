package circus.animal;

import circus.Asset;

public abstract class Animal implements Asset {

    public String name;
    public abstract String speak();
}
