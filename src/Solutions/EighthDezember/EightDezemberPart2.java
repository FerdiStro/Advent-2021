package Solutions.EighthDezember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//From Python
public class EightDezemberPart2 {

    private List<String[]> Scann(){
        List<String[]> splittedList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("rsc/inputEighthDezember.txt"));
            while (scanner.hasNext()){
                String[] split = scanner.nextLine().split(" \\| ");
                splittedList.add(split);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return splittedList;

    }
    private void  solve(List<String[]> a ){
        int ans = 0;

        for(String[] i  : a ){
            proc(i);
        }

    }
    private void proc(String[] s){
        List<String[]> nums = new ArrayList<>();
        List<String[]> res = new ArrayList<>();
        String[] numsStirng = s[0].split(" ");
        String[] resString = s[1].split(" ");
        Arrays.sort(numsStirng, Comparator.comparing(String::length));
        Arrays.sort(resString, Comparator.comparing(String::length));
        nums.add(numsStirng);
        res.add(resString);



//        String[] bylen[] = new String[11][8];
        HashMap<Integer , String[] > bylen =  new HashMap<>();

        for(String[] i : nums){
            for(String iString : i){
                String[] split = iString.split("");
                bylen.put(iString.length() , split) ;
            }
        }


        String[] four = bylen.get(4);
        String[] one =  bylen.get(2);
        String[] eight = bylen.get(7);
        String[] seven = bylen.get(3);


        String top = notin(one, seven);

        //BreakPoint
        String six = "" ;
        String[] temp = bylen.get(6);
        for(String i : temp){
            for(String iOne: one)
            if(i.equals(one)){
                continue;
            }
            six = six + i ;
        }


    }
    private String notin (String[] one , String[] seven){
        String returnString = "" ;
        for(String i : seven){
            for(String s: one){
                if(!i.equals(s)){
                  returnString = returnString+i;
                }
            }

        }
        return returnString;
    }


    public void Solution(){
        List<String[]> scann = Scann();
        solve(scann);

    }








}
