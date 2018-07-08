package p03;

import java.text.*;
import java.util.Date;
import java.util.Scanner;


public class p03 {

    public static void main(String[] args)  {
        Scanner in=new Scanner(System.in);
        System.out.println("Please, input your birth date(dd.mm.yyyy)");
        boolean isinputcorrect=false;
        String inputStr="";
        while(!isinputcorrect){
            DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
            inputStr=in.next();
            try {
                Date dateBirth=df.parse(inputStr);
                Date now=new Date();
                long difference=now.getTime()-dateBirth.getTime();
                double dif365= (double) (difference/(1000*60*60*24));
                dif365/=365;
                System.out.println("You were born "+dateBirth.toString()+"\nToday is "+now.toString()+
                        "\nYou lived for "+String.valueOf(difference)+" milliseconds\nWhich is "+String.valueOf(dif365)+" years in total.");
                isinputcorrect=true;
            } catch (ParseException e) {
                System.out.println("the format is dd.mm.yyyy");
            }
        }
    }
}
