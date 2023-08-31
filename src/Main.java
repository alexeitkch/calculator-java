import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static boolean match = true; // Совпадение систем чисел
    private static boolean rom = true; // Если римская система чисел
    private static boolean overflow = false; // Если операнд не в диапазоне 1..10

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Инициализация переменных
            match = true;
            rom = true;
            overflow = false;
            // Ввод данных
            System.out.println("Input:");
            input = scanner.nextLine();
            // Результат
            System.out.println("Output:");
            System.out.println(calc(input));
            System.out.println(" ");
            //in.close();
        }
    }

    public static  String calc(String input) {
        //Формируем массив String из строки, должно быть два операнда и знак действия
        String [] operands = input.split(" ");
        int result;

        // Преобразуем операнды String в int
        int operand1 = strToInt(operands[0]);
        int operand2 = strToInt(operands[2]);

        // Если соблюдаются все условия выбираем действие
        if(operands.length == 3 && match && !overflow) {
            switch (operands[1]) {
                case "+" -> result = operand1 + operand2;
                case "-" -> result = operand1 - operand2;
                case "*" -> result = operand1 * operand2;
                case "/" -> result = operand1 / operand2;
                default -> {
                    return "throw Exeption";
                }
            }
            if(rom && result < 0) {
                return "throw Exeption";
            } else {
                return "" + result;
            }
        } else {
            return "throw Exeption";
        }
    }

    private static int strToInt(String operand) {
        int a;
        switch (operand) {
            case "I"  -> a = 1;
            case "II" -> a = 2;
            case "III" -> a = 3;
            case "IV" -> a = 4;
            case "V" -> a = 5;
            case "VI" -> a = 6;
            case "VII" -> a = 7;
            case "VIII" -> a = 8;
            case "IX" -> a = 9;
            case "X" -> a = 10;
            default -> {
                a = Integer.parseInt(operand);
                match = !match;
                rom = false;
            }
        }
        // Проверка операнда
        if(a < 0 || a > 10) {
            overflow = true;
        }
        return a;
    }
}