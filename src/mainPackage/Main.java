package mainPackage;

public class Main {

    public static void main(String[] args) {
        long poczatek = System.currentTimeMillis();
        BruteForce bf = new BruteForce("resources/13");
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - poczatek));
    }
}
