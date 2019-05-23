package mainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BruteForce {

    /**
     * TODO
     * DONE     generator wektorów charakterystycznych
     * DONE     translator wektora, na zbior rozwazanych elementow
     * DONE     obliczanie sumy wag i wartosci zbioru i porownywanie ich z najlepszym do tej pory
     *
     */

    private List<mainPackage.Element> elementList;
    private int backpackCapacity;
    private int bestValue;
    private int bestWeight;
    private String bestCombination;

    BruteForce(String trainPath){
        elementList = loadFile(new File(trainPath));

//        System.out.println(elementList.toString());

        generateVectors(elementList.size());

        System.out.println("Najlepsza kombinacja to " + bestCombination + " o wartosci " + bestValue + " i wadze " + bestWeight);
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

    private void generateVectors(int elementCount){
        long combinationCount = (long) Math.pow(2, elementCount);
        System.out.println("liczba kombinacji " + combinationCount);

        for (int i = 0; i < combinationCount; i++) {
            String s = "";
            int j = i;

            if(i % 1000000 == 0){
                System.out.println("beep");
            }

            for (int k = 0; k < elementCount; k++) {
//                s = j % 2 + s;     //ta linia kodu spowalnia program z 800ms do 8000ms dla 10mln obrotow zewn. petli.
                                    //3500ms bez tej linijki dla wszystkich rozwiązań.
                j = j / 2;
            }
//            System.out.println("s");
//            translateVectorToCombination(s);
        }
    }

    private void translateVectorToCombination(String vector){
        List<Element> list = new ArrayList<>();

        for (int i = 0; i < vector.length(); i++) {
            if(vector.charAt(i) == '1') {
                list.add(elementList.get(i));
            }
        }
        checkCombination(list, vector);
    }

    private void checkCombination(List<Element> combination, String vector){
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
