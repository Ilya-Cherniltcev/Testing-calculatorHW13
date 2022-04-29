package pro.sky.calculatorsimple;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorServiceInterface{
    public String welcome() {
        return "<b>Добро пожаловать в калькулятор!</b>";
    }

    private int[] checkInt(String n1, String n2) { // Проверяем на корректность ввода чисел
        int[] i = new int[2];
        i[0] = -1;
        i[1] = -1;
        if (n1 != null && n2 != null) {
            try {
                i[0] = Integer.parseInt(n1.trim());
                i[1] = Integer.parseInt(n2.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("Введено не число: " + nfe.getMessage());
            }
        }
        return i;
    }               // ================================================================

    public String sum(String n1, String n2) { // ------ метод сложения
        int[] i = new int[2];
        i = checkInt(n1, n2);
        if (i[0] == -1 || i[1] == -1) {
            return "Ошибка. Один или оба параметра отсутствует либо не являются числом";
        }
        int sum = i[0] + i[1];
        return n1 + "+" + n2 + "=" + sum;
    }

    public String subtraction(String n1, String n2) { // ------ метод вычитания
        int[] i = new int[2];
        i = checkInt(n1, n2);
        if (i[0] == -1 || i[1] == -1) {
            return "Ошибка. Один или оба параметра отсутствует либо не являются числом";
        }
        int sub = i[0] - i[1];
        return n1 + "-" + n2 + "=" + sub;
    }

    public String multiply(String n1, String n2) { // ------ метод умножения
        int[] i = new int[2];
        i = checkInt(n1, n2);
        if (i[0] == -1 || i[1] == -1) {
            return "Ошибка. Один или оба параметра отсутствует либо не являются числом";
        }
        int multi = i[0] * i[1];
        return n1 + "*" + n2 + "=" + multi;
    }

    public String divide(String n1, String n2) { // ------ метод деления
        int[] i = new int[2];
        i = checkInt(n1, n2);
        if (i[0] == -1 || i[1] == -1) {
            return "Ошибка. Один или оба параметра отсутствует либо не являются числом";
        }
        if (i[1] == 0) {
            return "Деление на ноль НЕВОЗМОЖНО!";
        }
        float div = (float)i[0] / i[1];
        return n1 + "/" + n2 + "=" + div;
    }
}
