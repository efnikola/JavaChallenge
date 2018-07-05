package p1;
import java.io.IOException;
import java.util.Random;
// Namegenerator


public class p1 {

    static Random rnd=new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        int n=1;
        System.out.println("Hey there fellow! This program will generate some names for you. How many names do you need?");
        try {
            n=System.in.read()-'0';
        } catch (IOException e) {
            e.printStackTrace();
        }
        n=(n>9)?9:n;
        for(int i=0;i<n;i++) {
            System.out.println("Your "+String.valueOf(i+1)+" generated name is " + generate());
        }
        System.out.println("\n*In demo-version the choice is not that great*");
    }
    public static String generate(){

        String Karl="Karl";
        String Klara="Klara";
        if(rnd.nextBoolean())
            return Karl;
        return Klara;
    }
}
