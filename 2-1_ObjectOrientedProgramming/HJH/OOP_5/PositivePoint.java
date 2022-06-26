class Point{
    protected int x;
    protected int y;
    Point(){
        x = 0;
        y = 0;
    }
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void move(int goX,int goY){
        x = x + goX;
        y = y + goY;
    }
}

class PositivePoint extends Point {
    final private Point myPoint;
    PositivePoint(){
        myPoint = new Point();
    }
    PositivePoint(int x,int y){
        if(x<0 && y<0) myPoint = new Point();
        else {
            myPoint = new Point(x, y);
        }
    }
    public void move(int goX,int goY){
        if (goX>0 && goY>0) {
            myPoint.x = myPoint.x + goX;
            myPoint.y = myPoint.y + goY;
        }

    }
    public String toString(){
        System.out.printf("(%d,%d)의 점",myPoint.x,myPoint.y);
        return"";
    }
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();
        p.move(10,10);
        System.out.println(p.toString()+"입니다. ");

        p.move(-5,5);
        System.out.println(p.toString()+"입니다. ");

        PositivePoint p2 = new PositivePoint(-10,-10);
        System.out.println(p2.toString()+"입니다. ");
    }
}
