package Solutions.SeventeenthDezember;

import Solutions.Scanner.Scann;

import java.util.List;

public class SeventeenthDezemberSolution extends Scann {
    private void calculate(){
        Integer xMax = null;
        Integer yMax = null;
        List<String> targetCords = this.scannFile("rsc/inputSeventeenthDezember.txt");
        String targetCordsLine = targetCords.get(0);
        String[] firstSplit = targetCordsLine.split(",");

            String[] xSplit = firstSplit[0].split("[..]");
            String[] xSplitFrist = firstSplit[0].split("=");
            xMax = Integer.parseInt(xSplit[2]);
            String[] ySplit = firstSplit[1].split("[..]");
            String[] ySplitFirst = ySplit[0].split("=");
            yMax = Integer.parseInt(ySplitFirst[1])*(-1);


        String[][] cords = new String[yMax+1][xMax+1];



        System.out.println("BREAKPOINT");
    }




    public void Solution(){
        calculate();

    }


}
