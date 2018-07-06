package p01;
import java.util.Scanner;
import java.util.Random;

public class p01 {
    public static int numberOfGuesses=3;
    static Random rnd=new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        System.out.println("This is a game of heads and tails! What's your guess?");
        Scanner in=new Scanner(System.in);
        String inputString="";
        int total=0;
        int correctGuesses=0;
        boolean gameover=false;
        while(!gameover){
            boolean isinputincorrect=true;
            while(isinputincorrect) {
                 inputString= in.next();
                if (inputString.equals("head") || inputString.equals("tail")){
                    isinputincorrect=false;
                }
                else{
                    System.out.println("You should type \'head\' or \'tail\'");
                }
            }
            boolean toss=generateToss();
            if((inputString.equals("head") && toss||(inputString.equals("tail") && !toss ))){
                System.out.println("Correct!");
                correctGuesses++;
            }
            else{
                numberOfGuesses--;
                System.out.println("Wrong guess, darling. "+String.valueOf(numberOfGuesses)+" more tries left.");

            }
            if(numberOfGuesses==0){
                gameover=true;
            }
            total++;

        }
        System.out.println("You guessed correctly "+ String.valueOf(correctGuesses)+" out of "+String.valueOf(total)+" guesses.");
    }
    public static boolean generateToss(){
        return rnd.nextBoolean();
    }
}
