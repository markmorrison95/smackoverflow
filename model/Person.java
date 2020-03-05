package model;

public class Person {

    private String name;

    public Person(String name) {
        /**
         * name as only variable
         * used for other classes to inherit
         */
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return name;
    }

}
