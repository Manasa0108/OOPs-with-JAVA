package numberguess;
import java.util.Scanner;

public class NumberGuess {
    void guess(int randNum,int guessNum)
    {
        System.out.println("Key in your guess: ");
        Scanner myObj = new Scanner(System.in);
        int i=1;
        do
        {
            guessNum = myObj.nextInt();
            if(guessNum>randNum)
                System.out.println("Try Lower!!");
            else if(guessNum<randNum)
                System.out.println("Try Higher!!");
            else 
            {
                System.out.println("You got it in "+i+" trials");
                break;
            }
            i++;          
        
        }while(1==1);
        System.out.println("The random number generated is: "+randNum);        
    }
    public static void main(String[] args) {
        double num=Math.random();
        num=num*100;
        int randNum=(int)num,i=1,guessNum=0;
        NumberGuess obj=new NumberGuess();
        obj.guess(randNum,guessNum);
    }
    
}