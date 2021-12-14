package Solutions.ThirteenthDezember;

import Solutions.Scanner.Scann;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TirteenthDezemberSolution  extends Scann {
    private List<String> list = this.scannFile("rsc/inputThirteentDezember.txt");
    private HashMap<Integer, List<Integer>> cords = new HashMap<>();
    private List<String> commands  = new ArrayList<>();


    private void Calculate(){
        int roundCount = 0 ;
        int partOne = 0 ;
        int hightest = 0 ;
        boolean commadsHelp = false;
        for(String string : list) {
            if (string.equals("")) {
                commadsHelp = true;
            }else {
                if (!commadsHelp) {
                    String[] split = string.split(",");
                    if (cords.get(Integer.parseInt(split[1])) == null) {
                        cords.put(Integer.parseInt(split[1]), new ArrayList<>());
                        if(hightest<Integer.parseInt(split[1])){hightest = Integer.parseInt(split[1]);}
                    }
                    cords.get(Integer.parseInt(split[1])).add(Integer.parseInt(split[0]));
                } else {
                    commands.add(string);
                }
            }
        }
        for(int i = 0 ;  i != cords.size(); i++){
            if(cords.get(i) == null){ cords.put(i, new ArrayList<>());}
        }
       for(int i = 0 ; i != commands.size() ; i++) {
           String[] split = commands.get(i).split(" ");
           String[] finalSplit = split[split.length - 1].split("=");
           if (finalSplit[0].equals("x")) {
               faultX(Integer.parseInt(finalSplit[1]));
           } else if (finalSplit[0].equals("y")) {
               faultY(Integer.parseInt(finalSplit[1]));
           } else {
               System.out.println("ERROR");
           }
           if(roundCount ==  0){
               for(int j = 0 ;  j != cords.size(); j ++){
                   List<Integer> blockedNummbers = new ArrayList<>();
                   int size =  cords.get(j).size();
                   for(Integer ints : cords.get(j)){
                       if(blockedNummbers.contains(ints)){

                           partOne = partOne -1;
                       }
                       blockedNummbers.add(ints);
                   }
                   partOne = partOne  + size;
               }
               roundCount = 1;
           }


       }
//        drawinConsole();



        System.out.println("The Solution is/ Part 1: " + partOne + "  Part 2: " );
    }
    private void drawinConsole(){
        for(int i = 0; i != cords.size(); i++){
            List<Integer> list = cords.get(i);
            Collections.sort(list);
            for(int j = 0 ; j != list.get(list.size()-1) ; j++){
                if(list.contains(j)){
                    System.out.print("X");
                }else if( j  == list.get(list.size()-1)-1 && list.contains(list.get(list.size()-1))){
                    System.out.print("X");
                }else{
                    System.out.print("-");
                }

            }
            System.out.println();
        }

    }



    private void faultX(int faultPoint){
        for(int i = 0 ; i != cords.size(); i++){
            List<Integer> integers = cords.get(i);
            Collections.sort(integers);

            for(int k =0 ; k != integers.size(); k++){
                    int posX;
                    if( integers.get(k) > faultPoint-1){
                        if(integers.get(k) == faultPoint){
                            posX = faultPoint -1;
                        }else {
                            posX = integers.get(k) - faultPoint ;
                            posX = faultPoint-posX;
                            if(posX  == faultPoint ){
                                posX = 0;
                            }
                        }
                        integers.remove(k);
                        integers.add(posX);
                        Collections.sort(integers);
                        cords.put(i,  integers);
                    }

                }


        }

        }



    private void faultY(int faultPoint){
        for(int i = 0 ; i != cords.size();  i++ ) {
            if(i < faultPoint-1) {
                List<Integer> integers = cords.get(cords.size() -  1);
                List<Integer> integers1 = cords.get(i);
                if(integers.size() != 0 ){
                for (Integer ints : integers) {
                    integers1.add(ints);
                }
                cords.put(i, integers1);}
                cords.remove(cords.size()-1);
            }

        }

    }

    public void Solution(){
        Calculate();
    }



}

