package Solutions.FiftDezember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FiftDezemberSolution {
    public void Solution(){
        List<String> input = new ArrayList<String>();
        String s="";
        File inputFile = new File("rsc/input5Dezember.txt");
        Scanner scan;
        try {
            scan = new Scanner(inputFile);
            while(scan.hasNext()) {
                s = scan.nextLine();
                input.add(s);
            }
            int partTwo = solution(input);
            //PartOne and Two in Python
            int partOne = 6687;
            System.out.println("The Solution is/ Part 1: " + partOne + " Part 2: " + partTwo);

        } catch (FileNotFoundException e) {
        }

    }
    public static int solution(List<String> input) {
        String[] line,point;List<Coords> vent;
        GraphSpot[][] graph =  initializeGraph(1000);
        Coords c1,c2;
        for (String pipe : input) {// 0,9 -> 5,9
            line = pipe.split("->");//(x1,y1) ,(x2,y2)
            line[0]= line[0].strip();//(x1,y1)
            line[1]= line[1].strip();//(x2,y2)
            point = line[0].split(",");
            c1= new Coords(Integer.valueOf(point[0]),Integer.valueOf(point[1]));
            point = line[1].split(",");
            c2 = new Coords(Integer.valueOf(point[0]),Integer.valueOf(point[1]));
            vent= c1.checkPoints(c2);
            graph = addPoint(graph, vent);
        }
        return getPoints(graph);
    }
    public static GraphSpot[][] addPoint(GraphSpot[][] graph, List<Coords> vent) {
        if(!vent.isEmpty()) {
            for(Coords c : vent) {
                graph[c.getX()][c.getY()].setCounter();
            }
        }
        return graph;
    }
    public static int getPoints(GraphSpot[][] graph) {
        int sum=0;
        for(GraphSpot[] row : graph){
            for(GraphSpot spot : row){
                if(spot.getCounter() > 1) {
                    sum+= 1;
                }
            }
        }
        return sum;
    }
    public static GraphSpot[][] initializeGraph(int len){
        GraphSpot[][] graph =  new GraphSpot[len][len];
        for(int i =0; i< graph.length;i++){
            for(int j=0; j< graph[0].length;j++){
                graph[i][j] = new GraphSpot(new Coords(i,j));
            }
        }
        return graph;
    }
//    public static GraphSpot[][] printgraph(GraphSpot[][] graph){
//        for(GraphSpot[] row : graph){
//            for(GraphSpot spot : row){
//                System.out.print(spot.getCounter() + ",");
//            }
//        }
//        return graph;
//    }
//    public static GraphSpot[][] printgraph2(GraphSpot[][] graph){
//        System.out.println();
//        for(GraphSpot[] row : graph){
//            for(GraphSpot spot : row){
//                System.out.print(spot.getC().toString() + ";");
//            }
//            System.out.println();
//        }
//        return graph;
//    }
}



