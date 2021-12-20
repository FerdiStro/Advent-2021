package Solutions.SeventeentDezember;

public class SeventeentDezemberSolution {
    public void Solution(){
        int partOne = part1();
        int partTwo = part2();
        System.out.println("The Solution is/ Part 1: " + partOne + " Part 2: " + partTwo);
    }
    private int xMin = 235, xMax = 259, yMin = -118, yMax = -62; // initialzed from input in constructor not shown

    public int part1() {
        int maxYPosition = (Math.abs(yMin) - 1) * (Math.abs(yMin)) / 2;
       return  maxYPosition;
    }

    public int  part2() {
        int minXVelocity, maxXVelocity, minYVelocity, maxYVelocity;

        maxXVelocity = xMax;
        minYVelocity = yMin;
        minXVelocity = (int) Math.ceil((-1 + Math.sqrt(1 + 8 * xMin)) / 2);
        maxYVelocity = Math.abs(yMin) - 1;

        int count = 0;
        for (int x = minXVelocity; x <= maxXVelocity; x++) {
            for (int y = minYVelocity; y <= maxYVelocity; y++) {
                if (runSimul(x, y)) {
                    count++;
                }
            }
        }
        return count;

    }

    private boolean runSimul(int xV, int yV) {
        int xP = 0, yP = 0;
        while (xP <= xMax && yP >= yMin) {
            xP += xV;
            yP += yV;
            if (xV > 0)
                xV--;
            yV--;
            if (xP >= xMin && xP <= xMax && yP >= yMin && yP <= yMax) {
                return true;
            }
        }
        return false;
    }
}
