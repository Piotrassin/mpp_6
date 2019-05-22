package mainPackage;


public class Element {
    private int value;
    private int weight;

    Element (int v, int w){
        value = v;
        weight = w;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Element{" + "value=" + value + ", weight=" + weight + '}';
    }
}
