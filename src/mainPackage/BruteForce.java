package mainPackage;

import com.sun.xml.internal.bind.v2.model.core.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BruteForce {

    private static int numOfAttributes;
    private List<Element> trainList;
    private List<String> outcomes;
    private List<HashSet<String>> countOfAttrCategories;
    private boolean isRunning = true;

    BruteForce(String trainPath){
        trainList = loadFile(new File(trainPath));
    }


    private List<Element> loadFile(File file) {
        List<Element> elementList = new ArrayList<>();
        Scanner scanner = null;
        String input;

        try {scanner = new Scanner(file);}
        catch (FileNotFoundException e) {e.printStackTrace();}

        if (scanner != null) {
            while(scanner.hasNext()) {
                input = scanner.nextLine();
                String[] splitInput = input.split(",");

                if(numOfAttributes == 0){
                    numOfAttributes = splitInput.length - 1;
                }
                String[] attributesArray = new String[numOfAttributes];
                System.arraycopy(splitInput, 0, attributesArray, 0, numOfAttributes);
                elementList.add((Element) new mainPackage.Element(attributesArray, splitInput[numOfAttributes]));
            }
        }
        if (scanner != null) { scanner.close(); }

        return elementList;
    }
}
