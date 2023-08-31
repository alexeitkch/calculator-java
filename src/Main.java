import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static boolean match = true; // Совпадение систем чисел
    private static boolean rom = true; // Если римская система чисел
    private static boolean overflow = false; // Если операнд не в диапазоне 1..10

    public static void main(String[] args) throws
            NumeralSystemsDiffer,
            InputOverFlowNumber,
            RomanNumNoNegative,
            IncorrectInput,
            NoOperation {
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

    public static  String calc(String input) throws
            NumeralSystemsDiffer,
            InputOverFlowNumber,
            RomanNumNoNegative,
            IncorrectInput,
            NoOperation {
        //Формируем массив String из строки, должно быть два операнда и знак действия
        String [] operands = input.split(" ");

        // Если соблюдаются все условия выбираем действие
        if(operands.length == 3) {
            // Преобразуем операнды String в int
            int operand1 = strToInt(operands[0]);
            int operand2 = strToInt(operands[2]);
            //Проверка систем счисления и целочисленных операндов
            if(!match) {throw new NumeralSystemsDiffer("Системы счисления не совпадают");}
            if(overflow) {throw new InputOverFlowNumber("Операнд вне диапазона 1..10");}

            int result;
            switch (operands[1]) {
                case "+" -> result = operand1 + operand2;
                case "-" -> result = operand1 - operand2;
                case "*" -> result = operand1 * operand2;
                case "/" -> result = operand1 / operand2;
                default -> {
                    //throw Exeption
                    throw new NoOperation("Введена недопустимая операция");
                }
            }
            if(rom && result < 1) {
                //throw Exeption
                throw new RomanNumNoNegative("В Римской системе отсутствуют числа меньше единицы");
            } else {
                return "" + result;
            }
        } else {
            //throw Exeption
            throw new IncorrectInput("Неверный порядок ввода операндов,действий");
        }
    }

    private static int strToInt(String operand) throws IncorrectInput {
        int a = 0;
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
                try {
                    a = Integer.parseInt(operand);
                } catch (RuntimeException e) {
                    //throw Exeption
                    throw new IncorrectInput("Неверный операнд");
                }
                match = !match;
                rom = false;
            }
        }
        // Проверка операнда
        if(a < 1 || a > 10) {
            overflow = true;
        }
        return a;
    }
}