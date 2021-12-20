package Solutions.ElventhDezember;

import java.io.IOException;
import java.util.Stack;

public class ElvenetDezemberSolution {
    static int size;
    static int[] cells;
    int partTwo;
    int partOne;

    public void Solution(){

        octopus("rsc/input11Dezember.txt");
        System.out.println("The Solution is/ Part 1: " + partOne + " Part 2: " + partTwo);
    }


    public void octopus(String inputFile) {
        IntGrid grid = null;
        try {
            grid = IntGrid.fromFile(inputFile, line -> line.chars()
                    .map(Character::getNumericValue));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int totalFlashes = 0;
        int turn = 0;

        Stack<IntGrid.Pos> flashes = new Stack<>();
        while (++turn < Integer.MAX_VALUE) {
            grid = grid.stream().map(p -> p.add(1)).collect(grid.collector());
            grid = findFlashes(grid, flashes);

            while (!flashes.isEmpty()) {
                IntGrid.Pos flash = flashes.pop();
                totalFlashes++;
                grid = grid.stream()
                        .filter(p -> p.isNeighborOf(flash) && p.getVal() != 0)
                        .map(p -> p.add(1)).collect(grid.collector());
                grid = findFlashes(grid, flashes);
            }
            if (turn == 100) {
                partOne = totalFlashes;
            }
            if (grid.stream().filter(p -> p.getVal() != 0).findAny().isEmpty()) break;
        }
        partTwo = turn;
    }

    private IntGrid findFlashes(IntGrid grid, Stack<IntGrid.Pos> flashes) {
        grid.stream().filter(p -> p.getVal() > 9).forEach(flashes::add);
        return grid.stream().filter(p -> p.getVal() > 9)
                .map(p -> p.newVal(0)).collect(grid.collector());
    }






}
