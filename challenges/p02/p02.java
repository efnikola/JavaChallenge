package p02;
import java.util.Scanner;

public class p02 {
    public static void main(String[] args) {
        System.out.println("This program will convert your temperature to other scales");
        System.out.println("Input your temperature with a letter K-for Kelvins, C-for Celsius,F-farenheit");
        Scanner in=new Scanner(System.in);
        double tempIn=0.0d;
        String strIn="C";
        int isinputcorrect=0;
        while(isinputcorrect!=2) {
            isinputcorrect=0;
            try {
                tempIn = Double.parseDouble(in.next());
                isinputcorrect++;
            } catch (NumberFormatException e) {
                System.out.println("It should have been a legit number. Try again");
            }
            strIn = in.next();
            if(strIn.equals("C")||strIn.equals("K")||strIn.equals("F")){
                isinputcorrect++;
            }
            else{
                System.out.println("The letter is \'K\' \'F\' or \'C\'. Be wiser next time");
            }

        }
        convertAndDisplay(tempIn,strIn);
    }
    public abstract static class Temperature{
        protected double temp;
        public void setTemp(double temp){
            this.temp=temp;
        }
        public abstract void convert();
    }
    public static class Farenheit extends Temperature{

        @Override
        public void convert() {
            System.out.println("in Celsius: "+String.valueOf(5.0/9.0 * (this.temp - 32.0)));
            System.out.println("in Kelvin: "+String.valueOf(5.0/9.0 * (this.temp+ 459.67)));
        }
    }
    public static class Celsius extends Temperature{

        @Override
        public void convert() {
            System.out.println("in Farenheit: "+String.valueOf(9.0/5.0 * this.temp + 32.0));
            System.out.println("in Kelvin: "+String.valueOf(this.temp + 273.15));
        }
    }
    public static class Kelvin extends Temperature{

        @Override
        public void convert() {
            System.out.println("in Celsius: "+String.valueOf(this.temp - 273.15));
            System.out.println("in Farenheit: "+String.valueOf(9.0/5.0 * this.temp - 459.67));
        }
    }
    public static void convertAndDisplay(double temp, String str){
        Temperature t = null;
        switch(str) {
            case "F":
                t=new Farenheit();
                break;
            case "C":
                t=new Celsius();
                break;
            case "K":
                t=new Kelvin();
                break;
        }
        t.setTemp(temp);
        t.convert();

    }
}
