public class PositivePoint extends Point{
    PositivePoint(){
        a = 0;
        b = 0;
    }
    PositivePoint(int a, int b){
        this.move(a, b);
    }
    @Override
    public void move(int a, int b){
        if(a > 0 && b > 0){
            super.move(a, b);
        }
    }
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();
        p.move(10, 10);
        System.out.println(p.toString() + "입니다.");

        p.move(-5, 5);
        System.out.println(p.toString() + "입니다.");

        PositivePoint p2 = new PositivePoint(-10, -10);
        System.out.println(p2.toString() + "입니다.");
    }
}

class Point{
    protected int a, b;
    public void move(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString(){
        return "(" + a + "," + b + ")의 점";
    }
}