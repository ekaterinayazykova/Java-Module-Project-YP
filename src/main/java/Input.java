import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);
    ArrayList<String> DishesList = new ArrayList<>();
    double sum = 0;

    public int getAmountOfPeople() {
        System.out.println("Введите количество гостей");
        while (true) {
            if (scanner.hasNextInt()) {
                int AmountOfPeople = scanner.nextInt();
                if (AmountOfPeople < 2) {
                    System.out.println("Количество гостей должно быть больше единицы");
                    System.out.println("Введите количество гостей");
                } else {
                    System.out.println("Спасибо! Количество гостей " + AmountOfPeople);
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
            String nameOfTheDish = scanner.nextLine();

            while (true) {
                nameOfTheDish = scanner.nextLine();
                if (nameOfTheDish.equalsIgnoreCase("завершить")) {
                    String totalSum = getTotalSum(sum, getAmountOfPeople());
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
                                DishesList.add(nameOfTheDish);
                                sum = sum + priceOfTheDish;
                                System.out.println("Спасибо! Добавлено блюдо '" + nameOfTheDish + "'.\nХотите добавить еще одно блюдо?");
                                break;
                            }
                        } else {

                            System.out.println("Введен неверный формат стоимости, введите стоимость блюда в формате 'рубли.копейки', например 10.45 или 11.40.");
                            scanner.nextLine();
                        }
                    }
                    nameOfTheDish = scanner.nextLine();


                }
            }
            return nameOfTheDish;

            }

    private String getTotalSum(double sum, int amountOfPeople) {
//        double sum2 = 0;
//        for (Prices g : sum) {
//            sum2 += g.getAmount();
//        }

        double sumTotal = sum / amountOfPeople;
        double sumTotalRound = Math.floor(sumTotal);
        String sumTotal2 = String.format("%.2f", sumTotal);
        String result2;
        if (sumTotalRound == 1) {
            result2 = " рубль.";
        } else if (sumTotalRound >= 2 && sumTotalRound <=4) {
            result2 = " рубля.";
        } else {
            result2 = " рублей.";
        }
        System.out.println("Счёт на каждого: " + sumTotal2 + result2);
        return sumTotal2 + result2;
    }

}







