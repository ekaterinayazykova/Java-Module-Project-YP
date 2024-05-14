import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Input input = new Input();

        input.getAmountOfPeople();
        input.getNameOfTheDish("Введите наименование блюда. Для завершения ввода введите \"Завершить\"");
    }
}