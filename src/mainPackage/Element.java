package mainPackage;

import java.util.Arrays;

public class Element {

    private String[] attributes;
    private String name;

    Element (String[] attrs, String name){
        attributes = attrs;
        this.name = name;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public String getAttribute(int i){
        return attributes[i];
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "mainPackage.Element{" +
                "attributes=" + Arrays.toString(attributes) +
                ", name='" + name + '\'' +
                '}';
    }
}
