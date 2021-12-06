package thirdDezemberSolution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ThirdDezemberSolution {

    private List<String> Scann(){
        List<String> byteList = new ArrayList<>();
        try {
            Scanner sc =  new Scanner(new File("rsc/inputThirdDezember.txt"));
            while (sc.hasNext()){
                byteList.add(sc.nextLine());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  byteList;
    }
    private void calculate(List<String> byteList){
        String[] split = new String[byteList.size()*12];
        HashMap<Integer,String[]> map = new HashMap<>();
        HashMap<Integer,String[]> map1 = new HashMap<>();

        for(int i = 0 ;  i != byteList.size(); i++){
            String ByteString = byteList.get(i);
             split = ByteString.split("");
             map.put(i, split);
             map1.put(i,split);
        }
        String Answer  = "";
        //Part 1
        for(int k = 0 ; k != split.length; k++) {
            int Zeros = 0;
            int Ones = 0;
            for (int i = 0; i != byteList.size(); i++) {
                String[] string = map.get(i);
                if (string[k].equals("0")) {
                    Zeros = Zeros + 1;
                }
                if (string[k].equals("1")) {
                    Ones = Ones + 1;
                }
            }
            if(Zeros > Ones){
                Answer = Answer + "0";
            }else {
                Answer = Answer + "1";
            }
        }
        String[] split1 = Answer.split("");
        String Answer2 = "" ;
        for(int i =  0; i != split1.length; i++){
            switch (split1[i]){
                case "0":
                    Answer2 = Answer2 + "1";
                    break;
                case "1":
                    Answer2 = Answer2 + "0";
                    break;
            }
        }

        //Part 2
        String Oxygen = getOxygen(byteList, split, map);
        String CO2 = getCO2(byteList,split, map1);
        System.out.println("The Solution is/ Part 1: GAMMA: " + Answer +"  EPSILON: " + Answer2 + " Part 2:  OXYGEN: " + Oxygen + "  CO2: " +CO2   );
    }
    private String getCO2(List<String> byteList, String[] split, HashMap<Integer, String[]> map) {
        String check = "";

        for(int k = 0; k != split.length; k++) {
            if (map.size() > 1) {
                int Zeros = 0;
                int Ones = 0;
                for (int i = 0; i != byteList.size(); i++) {
                    String[] string = map.get(i);
                    try {
                        if (string[k].equals("0")) {
                            Zeros = Zeros + 1;
                        }
                        if (string[k].equals("1")) {
                            Ones = Ones + 1;
                        }
                    } catch (Exception e) {
                    }
                }
                if (Zeros > Ones) {
                    check = "1";
                } else if (Zeros == Ones) {
                    check = "0";

                } else {
                    check = "0";
                }

                for (int l = 0; l != byteList.size(); l++) {
                    String[] string = map.get(l);
                    String antiCheck;

                    if (check.equals("1")) {
                        antiCheck = "0";
                    } else {
                        antiCheck = "1";
                    }
                    try {
                        if (string[k].equals(antiCheck)) {
                            map.remove(l);
                        }
                    } catch (Exception e) {
                    }

                }

            }
        }
        String Oxygen = "" ;
        for(int i = 0 ; i != 1000  ; i ++ ){
            try {
                for (String s : map.get(i)) {
                    Oxygen = Oxygen+s;
                }
            }catch (Exception e){
            }
        }
        return Oxygen;
    }

    private String getOxygen(List<String> byteList, String[] split, HashMap<Integer, String[]> map) {
        String check = "";

        for(int k = 0; k != split.length; k++) {
            int Zeros = 0;
            int Ones = 0;
            for (int i = 0; i != byteList.size(); i++) {
                String[] string = map.get(i);
                try {
                    if (string[k].equals("0")) {
                        Zeros = Zeros + 1;
                    }
                    if (string[k].equals("1")) {
                        Ones = Ones + 1;
                    }
                }catch (Exception e){
                }
            }
            if(Zeros > Ones){
              check =  "0";
            }
            else {
                check =  "1";
            }

            for(int l = 0; l != byteList.size(); l++){
                String[] string = map.get(l);
                String antiCheck ;

                    if(check.equals("1")){
                        antiCheck = "0";
                    }else {
                        antiCheck = "1";
                    }
                    try {
                        if(string[k].equals(antiCheck)){
                            map.remove(l);
                        }
                    }catch (Exception e){
                    }

            }

        }
        String Oxygen = "" ;
        Set<Integer> integers = map.keySet();
        Integer o = (Integer) integers.toArray()[0];
        for (String s : map.get(o)) {
            Oxygen = Oxygen+s;
        }
        return Oxygen;
    }


    public void Solution(){
        List<String> scann = Scann();
        calculate(scann);
    }




}
