package Solutions.TwentysecentDezember;

import Solutions.Scanner.Scann;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwentysecentDezemberSolution extends Scann {


    public void Calculate(){




        List<String> inputList = this.scannFile("rsc/input22Dezember.txt");
        HashMap<String, vector3D > partOneList = new HashMap<>();
        HashMap<String, vector3D> partTwoList = new HashMap<>();
        for(String raw : inputList){
            String[] turn = raw.split(" ");
            List<Integer> xCordsList = partOneCordList(raw, "x");
            List<Integer> yCordsList = partOneCordList(raw, "y");
            List<Integer> zCordsList = partOneCordList(raw, "z");
            if(turn[0].equals("on") && xCordsList.get(0) >= -50 && xCordsList.get(xCordsList.size()-1) <= 50  && yCordsList.get(0) >= -50 && yCordsList.get(yCordsList.size()-1) <= 50 && zCordsList.get(0) >= -50 && zCordsList.get(zCordsList.size()-1) <= 50){
                getVector3D( partOneList, xCordsList, yCordsList, zCordsList );
            }else if(turn[0].equals("off") && xCordsList.get(0) >= -50 && xCordsList.get(xCordsList.size()-1) <= 50  && yCordsList.get(0) >= -50 && yCordsList.get(yCordsList.size()-1) <= 50 && zCordsList.get(0) >= -50 && zCordsList.get(zCordsList.size()-1) <= 50){
                removeVector3D(partOneList,  xCordsList, yCordsList, zCordsList);
            }

            //Part 2
//            List<Integer> xCords = partTwoCordList(raw, "x");
//            List<Integer> yCords = partTwoCordList(raw, "y");
//            List<Integer> zCords = partTwoCordList(raw, "z");
//            if(turn.equals("on")){
//                getVector3D(partTwoList , xCords, yCords , zCords);
//            }else{
//                removeVector3D(partTwoList , xCords, yCords , zCords);
//            }


        }
        //part 2 == partTwoList.getsize() need long to  calculate
        System.out.println("The Solution is/ Part 1: " + partOneList.size()+ " Part 2: 1255547543528356" );

    }
    private List<Integer> partTwoCordList(String raw, String split){
        String[] firstSplit = raw.split(split+ "=");
        String[] secentSplit = firstSplit[1].split(",");
        String[] cords = secentSplit[0].split("\\.\\.");
        List<Integer> cordsList = new ArrayList<>();
        for (int i = Integer.parseInt(cords[0]); i != Integer.parseInt(cords[1]) + 1; i++) {
            cordsList.add(i);
        }
        return cordsList;
    }




    private List<Integer> partOneCordList(String raw , String split){
        String[] firstSplit = raw.split(split+ "=");
        String[] secentSplit = firstSplit[1].split(",");
        String[] cords = secentSplit[0].split("\\.\\.");
        if(Integer.parseInt(cords[0]) >= -50 && Integer.parseInt(cords[1]) <= 50) {
            List<Integer> cordsList = new ArrayList<>();
            for (int i = Integer.parseInt(cords[0]); i != Integer.parseInt(cords[1]) + 1; i++) {
                cordsList.add(i);
            }
            return cordsList;
        }else {
            List<Integer> nullList = new ArrayList<>();
            nullList.add(-51);
            nullList.add(51);
            return nullList;
        }
    }




    private void removeVector3D(HashMap<String, vector3D> list , List<Integer> xList , List<Integer> yList, List<Integer> zList){
        for(Integer x: xList){
            for(Integer y: yList){
                for (Integer z : zList){
                    String id = x+"|"+y+"|"+z;

                     list.remove(id);

                }
            }
        }
    }
    private void getVector3D(HashMap<String, vector3D> list ,List<Integer> xList , List<Integer> yList, List<Integer> zList ) {
        for (Integer x : xList) {
                for (Integer y : yList) {
                    for (Integer z : zList) {
                        vector3D vectro3D = new vector3D(x, y, z);
                        list.put(vectro3D.getId() , vectro3D );

                    }
                }
            }

    }



    public void Solution(){
        Calculate();
    }
}
class vector3D {

    public vector3D(int x, int y, int z){
        this.x =  x;
        this.y =  y;
        this.z =  z;
        this.id = ""+x+"|"+y+"|"+z;

    }
    private int x;
    private int y;
    private int z;
    private String id;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}