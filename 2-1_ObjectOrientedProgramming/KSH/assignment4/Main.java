interface Shape{
    final double PI = 3.14; // 변하지 않는 상수이므로 final
    void draw();
    double getArea();
    default public void redraw(){
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape{
    // 인터페이스 구현
    private final int radius;
    Circle(int radius){
        this.radius = radius;
    }
    @Override
    // draw 함수 오버라이딩
    public void draw(){
        System.out.println("반지름이 " + this.radius + "인 원입니다.");
        // Circle의 경우 반지름이 radius인 원입니다. 출력
    }
    @Override
    // getArea 함수 오버라이딩
    public double getArea(){
        return this.radius * this.radius * PI;
        // 원의 넓이이므로 radius * radius * PI 로 계산
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
    // draw 함수 오버라이딩
    public void draw(){
        System.out.println(shortRadius + "x" + longRadius + "사각형에 내접하는 타원입니다.");
        // 단축x장축 사각형에 내접하는 타원입니다. 출력
    }
    @Override
    // getArea 함수 오버라이딩
    public double getArea(){
        return 4 * PI * (this.shortRadius / 2.0) * (this.longRadius / 2.0);
        // 타원의 넓이인 4 * PI * (shortRadius / 2.0) * (longRadius / 2.0)
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
    // draw 함수 오버라이딩
    public void draw(){
        System.out.println(width + "x" + height + "크기의 사각형 입니다.");
    }
    // 가로x세로 크기의 사각형 입니다. 출력
    @Override
    // getArea 함수 오버라이딩
    public double getArea() {
        return width * height;
    }
    // 사각형의 넓이이므로 가로 * 세로 return
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

