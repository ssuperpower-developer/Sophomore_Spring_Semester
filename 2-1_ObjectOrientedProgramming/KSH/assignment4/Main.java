interface Shape{
    final double PI = 3.14;
    void draw();
    double getArea();
    default public void redraw(){
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape{
    private final int radius;
    Circle(int radius){
        this.radius = radius;
    }
    @Override
    public void draw(){
        System.out.println("반지름이 " + this.radius + "인 원입니다.");
    }
    @Override
    public double getArea(){
        return this.radius * this.radius * PI;
    }
}

class Oval implements Shape{
    private final int shortRadius;
    private final int longRadius;
    Oval(int shortRadius, int longRadius){
        this.shortRadius = shortRadius;
        this.longRadius = longRadius;
    }
    @Override
    public void draw(){
        System.out.println(shortRadius + "x" + longRadius + "사각형에 내접하는 타원입니다.");
    }
    @Override
    public double getArea(){
        return this.shortRadius * this.longRadius * PI;
    }
}

class Rect implements Shape{
    private final int width;
    private final int height;
    Rect(int width, int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(){
        System.out.println(width + "x" + height + "크기의 사각형 입니다.");
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] list = new Shape[3];
        list[0] = new Circle(10);
        list[1] = new Oval(20, 30);
        list[2] = new Rect(10, 40);

        for(int i = 0; i < list.length; i++) list[i].redraw();
        for(int i = 0; i < list.length; i++) System.out.println("면적은 " + list[i].getArea());
    }
}
