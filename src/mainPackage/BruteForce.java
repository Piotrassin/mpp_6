package mainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BruteForce {

    /**
     *
     * DONE     generator wektorow charakterystycznych
     * DONE     translator wektora, na zbior rozwazanych elementow
     * DONE     obliczanie sumy wag i wartosci zbioru i porownywanie ich z najlepszym do tej pory
     */

    /**
     * Best solution:
     * 111100110111001110111011111111
     * value 894 i weight 400
     * Time elapsed: 303862
     */


    private List<mainPackage.Element> elementList;
    private int backpackCapacity;
    private int bestValue;
    private int bestWeight;
    private int[] bestCombination;

    BruteForce(String trainPath){
        elementList = loadFile(new File(trainPath));

        generateVectors(elementList.size());

        System.out.println("Best combination is ");
        for (int i1 : bestCombination) {
            System.out.print(i1);
        }
        System.out.println("with a value of " + bestValue + " and weight of " + bestWeight);
    }

    private List<Element> loadFile(File file) {
        List<Element> elementList = new ArrayList<>();
        Scanner scanner = null;

        try {scanner = new Scanner(file);}
        catch (FileNotFoundException e) {e.printStackTrace();}

        if (scanner != null) {
            backpackCapacity = Integer.parseInt(scanner.nextLine());
            while(scanner.hasNext()) {
                String input = scanner.nextLine();
                String[] split = input.split(" ");
                elementList.add(new Element(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            }
        }
        if (scanner != null) { scanner.close(); }

        return elementList;
    }

    private void generateVectors(int elementCount1){
        long combinationCount1 = (long) Math.pow(2, elementCount1);
        System.out.println("Number of combinations " + combinationCount1);

        for (int i = 0; i < combinationCount1; i++) {
            int n = i;
            int[] combination = new int[elementCount1];
            int k = 0;

            while(n > 0){
                combination[k] = n % 2;
                n /= 2;
                k++;
            }
            translateVectorToCombination(combination);
        }
    }

    private void translateVectorToCombination(int[] vector){
        List<Element> list = new ArrayList<>();

        for (int i = 0; i < vector.length; i++) {
            if(vector[i] == 1) {
                list.add(elementList.get(i));
            }
        }
        checkCombination(list, vector);
    }

    private void checkCombination(List<Element> combination, int[] vector){
        int totalVal = 0;
        int totalWeight = 0;

        for (Element e : combination) {
            totalVal += e.getValue();
            totalWeight += e.getWeight();
        }
        if(totalWeight <= backpackCapacity){
            if(totalVal > bestValue){
                bestValue = totalVal;
                bestWeight = totalWeight;
                bestCombination = vector;
            }
        }
    }
}
