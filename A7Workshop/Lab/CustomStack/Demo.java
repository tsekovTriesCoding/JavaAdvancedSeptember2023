package A7Workshop.Lab.CustomStack;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack stack = new CustomStack();

        stack.push(1);
        stack.push(200);
        stack.push(15);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
    }


}
