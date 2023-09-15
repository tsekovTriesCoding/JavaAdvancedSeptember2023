package A7Workshop.Lab.SmartArray;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartArray arr = new SmartArray();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);

        arr.add(2,6);
        arr.remove(3);

    }
}
