import java.util.Scanner;

// Gabriel Jesus de Sena
// Separetes street name and number from the adress, won't work for the "Calle 44 No 1991" case
public class TestePwc
{
    public static void main(String[] args) {     
        Scanner keyboard = new Scanner(System.in);
        String st="",num="";
        String input = keyboard.nextLine().replace(",", "");
        
        // Find out where the first number is
        int indexFirstNum=0;
        for (int i = 0; i < input.length(); i++){
            if(isNumeric(input.charAt(i))){
                indexFirstNum=i;
                break;
            }
        }
        
        // Find out where the number ends
        int indexLastNum=0;
        for (int i = indexLastNum+1; i < input.length(); i++){
            if(!isNumeric(input.charAt(i))){
                indexLastNum=i;
                break;
            }
        }
        
        if(indexFirstNum!=0){
            // Number at the end of the input
            for (int i = indexFirstNum; i < input.length(); i++) {
                num += input.charAt(i);
            }
            for(int i= 0; i<indexFirstNum-1; i++){
                st += input.charAt(i);
            }
        }else{
            // Number at the start of the input
            int i=0;
            for (i = indexFirstNum; i < indexLastNum; i++) {
                num += input.charAt(i);
            }
            for(i++; i <input.length(); i++){
                st += input.charAt(i);
            }
        }
        
        System.out.println(st);
        System.out.println(num);
    }
    
    // Find out whether a char is numeric or text
    public static boolean isNumeric(char ch) {
        try {
            Integer.parseInt(String.valueOf(ch));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}