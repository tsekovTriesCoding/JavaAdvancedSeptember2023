package A5FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        // получаваме цената с ДДС:
        Function<Double, Double> addVAT = price -> price * 1.2;
        // отпечатване на новата цена:
        Consumer<Double> printFormatPrice = price -> System.out.printf("%.2f%n", price);

        System.out.println("Prices with VAT:");
        for (Double price : prices) {
            double priceWithVAT = addVAT.apply(price);
            printFormatPrice.accept(priceWithVAT);
        }

    }
}
