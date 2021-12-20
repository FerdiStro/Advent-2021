package Solutions.FiftDezember;


// helper class graphspot


public class GraphSpot {
    private Coords c;
    private int counter;
    GraphSpot(Coords c1){
        this.c = c1;
        this.counter= 0;
    }
    public Coords getC() {
        return this.c;
    }
    public int getCounter() {
        return this.counter;
    }
    public void setCounter() {
        this.counter+=1;
    }
    public void setC(Coords c) {
        this.c = c;
    }
}
