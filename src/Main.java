import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Запуск программы...");
        MyData[] busPlaces = new MyData[30];

        for (int i = 0; i < busPlaces.length; i++) {
            busPlaces[i] = new MyData(false, "");
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите 1, чтобы посмотреть все места в автобусе.");
            System.out.println("Введите 2, чтобы забронировать место в автобусе.");
            System.out.println("Введите 3, чтобы разбронировать место в автобусе.");
            System.out.println("Введите 4, чтобы выйти из программы.");
            String statement = scanner.next();

            switch (statement) {
                case "1":
                    int count = 1, trueCount = 0, falseCount = 0;
                    for (MyData place : busPlaces) {
                        System.out.println(count + " " + place.isMyBoolean() + " " + place.getMyString());
                        count++;
                        if (place.isMyBoolean()) {
                            trueCount++;
                        } else {
                            falseCount++;
                        }
                    }
                    System.out.println("Мест свободно: " + falseCount + "\nМест занято: " + trueCount);
                    break;

                case "2":
                    System.out.println("Введите номер места, которое вы хотели бы забронировать: ");
                    int index = scanner.nextInt();
                    int i = index - 1;
                    System.out.println("Введите фамилию человека: ");
                    String placeName = capitalizeFirstLetter(scanner.next());
                    if (i >= 0 && i < busPlaces.length) {
                        if (!busPlaces[i].isMyBoolean()) {
                            busPlaces[i].setMyBoolean(true);
                            busPlaces[i].setMyString(placeName);
                            System.out.println("Место под номером " + index + " забронировано человеком с фамилией " + placeName + ".");
                        } else {
                            System.out.println("Место под номером " + index + " уже забронировано человеком с фамилией " + placeName + ".");
                        }
                    } else {
                        System.out.println("Введен недопустимый номер места.");
                    }
                    break;

                case "3":
                    System.out.println("Введите номер места, которое вы хотели бы разбронировать: ");
                    int indexUn = scanner.nextInt();
                    int iUn = indexUn - 1;
                    if (iUn >= 0 && iUn < busPlaces.length) {
                        if (busPlaces[iUn].isMyBoolean()) {
                            busPlaces[iUn].setMyBoolean(false);
                            busPlaces[iUn].setMyString("");
                            System.out.println("Место под номером " + indexUn + " разбронировано.");
                        } else {
                            System.out.println("Место под номером " + indexUn + " не занято");
                        }
                    } else {
                        System.out.println("Введен недопустимый номер места.");
                    }
                    break;

                case "4":
                    System.out.println("Выход из программы...");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Неправильный ввод. Пожалуйста, выберите один из вариантов (1-4).");
                    break;
            }
        }
    }

    public static String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        String firstLetter = text.substring(0, 1).toUpperCase();
        String restOfText = text.substring(1).toLowerCase();
        return firstLetter + restOfText;
    }
}