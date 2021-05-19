import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Check {
    String expression = "";
    public Check(String enterExpression)
    {
        this.expression = enterExpression;
    }

    // проверяем на арбскую строку регулрням
    public boolean itArabian()
    {
        String chPat =  "^([0-9]|10)[ ][+,-,/,*][ ]([0-9]|10)$";
        Pattern pattern = Pattern.compile(chPat);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find())
            return true;
        else
            return  false;
    }

    // проверяем на римскую регулярным
    public boolean itsRomania(){
        String chPat ="^([I]{1,3}|[X]|[V][I]{0,3})[ ][+,-,/,*][ ]([I]{1,3}|[X]|[V][I]{0,3})$";

        Pattern pattern = Pattern.compile(chPat);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find())
            return true;
        else
            return  false;
    }
}
