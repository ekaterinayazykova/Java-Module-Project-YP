import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> dishesList = new ArrayList<>();
    private double sum = 0;
    private int amountOfPeople = 0;

    public int getAmountOfPeople() {
        System.out.println("Введите количество гостей");
        while (true) {
            if (scanner.hasNextInt()) {
                amountOfPeople = scanner.nextInt();
                if (amountOfPeople < 2) {
                    System.out.println("Количество гостей должно быть больше единицы");
                    System.out.println("Введите количество гостей");
                } else {
                    System.out.println("Спасибо! Количество гостей " + amountOfPeople);
                    break;
                }
            } else {
                System.out.println("Введите количество гостей");
                scanner.next();
            }
        }
        return 0;
    }

    public String getNameOfTheDish(String message) {
        System.out.println(message);
        String nameOfTheDish;

        while (true) {
            nameOfTheDish = scanner.next();
            if (nameOfTheDish.equalsIgnoreCase("завершить")) {
                System.out.println("Добавленные блюда:\n" + String.join("\n",dishesList));
                String totalSum = getTotalSum(sum, amountOfPeople);
                System.out.println("Каждый гость должен заплатить " + totalSum);
                break;
            } else {
                System.out.println("Введите стоимость блюда в формате 'рубли.копейки', например 10.45 или 11.40.");
                double priceOfTheDish;
                while (true) {
                    if (scanner.hasNextDouble()) {
                        priceOfTheDish = scanner.nextDouble();

                        if (priceOfTheDish <= 0) {
                            System.out.println("Введена отрицательная стоимость, введите стоимость блюда в формате 'рубли.копейки', например 10.45 или 11.40.");
                        } else {
                            dishesList.add(nameOfTheDish);
                            sum = sum + priceOfTheDish;
                            System.out.println("Спасибо! Добавлено блюдо '" + nameOfTheDish + "'.\nХотите добавить еще одно блюдо?");
                            break;
                        }
                    } else {
                        System.out.println("Введен неверный формат стоимости, введите стоимость блюда в формате 'рубли.копейки', например 10.45 или 11.40.");
                        scanner.nextLine();
                    }
                }
                scanner.nextLine();
            }
        }
        return nameOfTheDish;
    }

    private String getTotalSum(double sum, int amountOfPeople) {
        double sumTotal = sum / amountOfPeople;
        double sumTotalRound = Math.floor(sumTotal);
        String sumTotal2 = String.format("%.2f", sumTotal);
        String result2;
        if (sumTotalRound % 10 == 1 && sumTotalRound % 100 != 11) {
            result2 = " рубль.";
        } else if (sumTotalRound % 10 >= 2 && sumTotalRound % 10 <= 4 && !(sumTotalRound % 100 >= 12 && sumTotalRound % 100 <= 14)) {
            result2 = " рубля.";
        } else {
            result2 = " рублей.";
        }
        return sumTotal2 + result2;
    }
}
