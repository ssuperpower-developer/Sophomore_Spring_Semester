
public class Rectangle {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int square() {
        return width * height;
    }

    public void show() {
        System.out.printf("(%d,%d)에서 크기가 %dx%d인 사각형\n", x, y, width, height);
    }

    public boolean contains(Rectangle r) {
        return (x < r.x && r.x + r.height < x + height) && (y < r.y && r.y + r.width < x + width);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);

        r.show();
        System.out.println("s의 면적은 " + s.square());
        if (t.contains(r)) System.out.println("t는 r을 포함합니다");
        if (t.contains(s)) System.out.println("t는 s을 포함합니다");


    }


}

