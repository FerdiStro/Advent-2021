package Solutions.FiftDezember;
// helper class Coords

import java.util.LinkedList;
import java.util.List;

public class Coords {
    private int x;
    private int y;
    Coords(int x1,int y1){
        this.x= x1;
        this.y=y1;
    }
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public List<Coords> checkPoints(Coords c){
        int num1, num2;
        List<Coords> len = new LinkedList<Coords>();
        if(c.getX() == this.x && c.getY() == this.y) {
            len.add(new Coords(this.x,this.y));
            return len;
        }
        if (c.getX() == this.x) {//share same x coords then check along the y's
            num1 = Math.max(c.getY(), this.y);
            num2 = Math.min(c.getY(), this.y);
            for(int i = num2;i <= num1;i++) {
                len.add(new Coords(this.x, i));
            }
            return len;
        }
        if (c.getY() == this.y) {//share same y coords then check along the x's
            num1 = Math.max(c.getX(), this.x);
            num2 = Math.min(c.getX(), this.x);
            for(int i = num2;i <= num1;i++) {
                len.add(new Coords(i, this.y));
            }
            return len;
        }
        //for part 2 add these following **start adding
//		An entry like 1,1 -> 3,3 covers points 1,1, 2,2, and 3,3.
        if(c.getX() == c.getY() && this.x == this.y) {//first point and second point have the same x and y respectively
            num1 = Math.max(c.getX(), this.x);
            num2 = Math.min(c.getX(), this.x);
            for(int i=num2 ; i<= num1; i++) {
                len.add(new Coords(i, i));
            }
            return len;
        }
//		An entry like 9,7 -> 7,9 covers points 9,7, 8,8, and 7,9.
        if(c.getX() ==  this.y && this.x == c.getY()) {//c1 has same x as c2's y and vice versa
            num1 = Math.abs(this.y - this.x);
            for(int i=0 ; i<= num1; i++) {
                if(this.x > c.getX()) {
                    len.add(new Coords(this.x - i, this.y + i));
                }
                else {
                    len.add(new Coords(this.x + i, this.y - i));
                }
            }
            return len;
        }
        //check by slope - 45 degrees meaning the slope must be 1 or -1 for it to work
        //slope formula is (y1-y2)/(x1-x2) math formula:) since its a straight line
        double m = (this.y - c.getY())/(this.x - c.getX());int cnt=0;
//        System.out.println(this.toString() + " -> " + c.toString() + " : "+ m);
        num1 = Math.abs(this.y - this.x);Coords point1,point2;
        if (m == 1) {
            if(this.x < c.getX()) {//start from the one with a lower x
                point1= new Coords(this.x, this.y);
                point2 =  new Coords(c.getX(), c.getY());
            }
            else {
                point1 =  new Coords(c.getX(), c.getY());
                point2 = new Coords(this.x, this.y);
            }
            for(int i= point1.getX() ; i<= point2.getX(); i++) {
                len.add(new Coords(i, point1.getY()+ cnt));
                cnt++;
            }
            return len;
        }
        cnt=0;
        if ( m == -1) {
            if(this.x > c.getX()) {
                point1= new Coords(this.x, this.y);
                point2 =  new Coords(c.getX(), c.getY());
            }
            else {
                point1 =  new Coords(c.getX(), c.getY());
                point2 = new Coords(this.x, this.y);
            }
            for(int i= point1.getX(); i>= point2.getX(); i--) {//8; i<= 2;
                len.add(new Coords(i, point1.getY() + cnt));
                cnt++;
            }
            return len;
        }
        // **finish part2 addition
        return len;
    }
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
