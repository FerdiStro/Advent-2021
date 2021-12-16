package Solutions.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scann {
   protected List<String> scannFile(String filePath){
        List<String> raw = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()){
                raw.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  raw;
    }
   public Integer binarInDezimal(String binar){
       String[] bits = binar.split("");
       int length = bits.length-1;
       int dezimal = 0 ;
       for(int i = 0 ; i != bits.length; i++){
           if(bits[i].equals("1")){
               dezimal = (int) (dezimal + (Math.pow(2, length-i)));
           }
       }
       return dezimal;
   }




   public List<String> hexInBinar(List<String> raw){
       List<String> returnList = new ArrayList<>();
       for(String listRaws: raw){
           String[] split = listRaws.split("");
           String binar = "";
           for(String hex : split){
               switch (hex){
                   case "0":
                        binar = binar + "0000";
                        break;
                   case "1":
                       binar = binar + "0001";
                       break;
                   case "2":
                       binar = binar + "0010";
                       break;
                   case "3":
                       binar = binar + "0011";
                       break;
                   case "4":
                       binar = binar + "0100";
                       break;
                   case "5":
                       binar = binar + "0101";
                       break;
                   case "6":
                       binar = binar + "0110";
                       break;
                   case "7":
                       binar = binar + "0111";
                       break;
                   case "8":
                       binar = binar + "1000";
                       break;
                   case "9":
                       binar = binar + "1001";
                       break;
                   case "A":
                       binar = binar + "1010";
                       break;
                   case "B":
                       binar = binar + "1011";
                       break;
                   case "C":
                       binar = binar + "1100";
                       break;
                   case "D":
                       binar = binar + "1101";
                       break;
                   case "E":
                       binar = binar + "1110";
                       break;
                   case "F":
                       binar = binar + "1111";
                       break;
               }
           }
           returnList.add(binar);
       }
       return  returnList;
   }



}
