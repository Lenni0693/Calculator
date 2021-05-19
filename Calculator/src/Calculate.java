

public class Calculate {
    String fistArg = "";
    String command = "";
    String secondArg = "";
    public Calculate(String [] argEx)
    {
        this.fistArg   = argEx[0];
        this.command   = argEx[1];
        this.secondArg = argEx[2];
    }

    // Будет два метода для арабских и римских

    public int calculateArabian()
    {
        // считаем, что нам пришло, то что нужно, все проверили
        int result = 0;
        int intSecondArg = Integer.parseInt(secondArg);
        result = Integer.parseInt(fistArg);
        if(command.equals("+")) result = result + intSecondArg;
        if(command.equals("-")) result = result - intSecondArg;
        if(command.equals("*")) result = result * intSecondArg;
        if(command.equals("/"))
            // тут может бфть деление на ноль
            try
            {
                result = result / intSecondArg;
            }
            catch (ArithmeticException e)
            {
                System.out.println("Нельзя делить на 0");
                result = 0;
            }

        return result;

    }
    public String calculateRomania()
    {
        // считаем римские. сначала переводим в арабские
        fistArg = getArabian(fistArg,true,0);
        secondArg = getArabian(secondArg,true,0);
        int resultAr = calculateArabian();
        return getArabian("",false,resultAr);
    }

    // переводим арабские в римские и обратно
    public String getArabian(String letter, boolean getArab,int arab)
    {
        String[]roman = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        if(getArab)
        {
            for (int i = 0;i<roman.length;i++)
            {
                if(letter.equals(roman[i]))
                    return Integer.toString(i+1);
            }
            return "error";
        }
        else
            {
                // если меньше 10, то у нас есть массив чисел
                if(arab <= 10)
                {
                    return roman[arab-1];
                }
                else
                {
                    String res = "X";
                    res = res + roman[(arab%10)-1];
                    return res;
                }
            }
    }
}
