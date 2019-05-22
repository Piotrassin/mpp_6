package mainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BruteForce {

    private List<mainPackage.Element> trainList;
    private int capacity;
    private boolean isRunning = true;

    BruteForce(String trainPath){
        trainList = loadFile(new File(trainPath));
        System.out.println(trainList.toString());

    }

    private List<Element> loadFile(File file) {
        List<Element> elementList = new ArrayList<>();
        Scanner scanner = null;

        try {scanner = new Scanner(file);}
        catch (FileNotFoundException e) {e.printStackTrace();}

        if (scanner != null) {
            capacity = Integer.parseInt(scanner.nextLine());
            while(scanner.hasNext()) {
                String input = scanner.nextLine();
                String[] split = input.split(" ");
                elementList.add(new Element(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            }
        }
        if (scanner != null) { scanner.close(); }

        return elementList;
    }
}
