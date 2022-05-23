public class Point {
    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point() {
    }//why?

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class PositivePoint extends Point {
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();
        p.move(10, 10);
        System.out.println(p.toString() + "의 점입니다.");

        p.move(-5, 5);
        System.out.println(p.toString() + "의 점입니다.");

        PositivePoint p2 = new PositivePoint(-10, -10);
        System.out.println(p2.toString() + "의 점입니다.");
    }

    private int x, y;

    PositivePoint() {
    }

    PositivePoint(int x, int y) {
        if (x < 0 || y < 0) {
            this.x = 0;
            this.y = 0;
        } else {
            this.x = x;
            this.y = y;
        }
    }

    protected void move(int x, int y) {
        if (x < 0 || y < 0) {
            return;
        } else {
            super.move(x, y);
        }
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
