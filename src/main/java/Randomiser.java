import java.util.Locale;
import java.util.Random;

public class Randomiser {
    private Long numberResult=null;
    private String result="";
    private Random random=new Random();

    public String allRandom(){
        String[] AlphabetWithDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for(int i=0;i<5;i++){
            int k=random.nextInt(AlphabetWithDigits.length);
            result+=AlphabetWithDigits[k];
        }

        return result;
    }
    public String workersID(){
        result="";
        String[] Digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for(int i=0;i<Digits.length-5;i++){
            int k =random.nextInt(Digits.length);
            result+=Digits[k];
        }

        return result;
    }
    //public byte chooseOne(){
     //   return random.nextInt()
    //}

}
