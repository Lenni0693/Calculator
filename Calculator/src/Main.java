import java.util.Scanner;

public class Main {

    public static void main(String [] args)
    {
        System.out.println("Hello in calculator from Lenni \n" + "Enter the expression");
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        Check checkExp = new Check(expression);

        // проверяем попадает по арабскую строку
        if (checkExp.itArabian())
        {
            Calculate calc = new Calculate(expression.split(" "));
            int resultAr = calc.calculateArabian();
            System.out.println("Result:" + resultAr);
        }
        // а под римскую
        else if(checkExp.itsRomania())
        {
            Calculate calc = new Calculate(expression.split(" "));
            String resultAr = calc.calculateRomania();
            System.out.println("Result:" + resultAr);
        }
        // ну значит ввели не то
        else
        {
            System.out.println(" введено неверное выражение. Правильный вид x + y, \n где x и y Это целые числа от" +
                    " 1 до 10. Цифры могут быть только арабскими или только римскими одновременно");
            throw new ArithmeticException();
        }
    }
    
}
