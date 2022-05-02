public class Week1 {

    public static void main(String[] args) {
        // 1.
        // static - 클래스의 멤버에 붙이는것이다, 지역변수에는 불가능
        // 멤버에만 붙이는 것
        // static에 따라 소유가 달라진다 - 붙으면 클래스 소유, 안 붙으면 객체 소유
        // 클래스 = 데이터 타입 -> static이 붙으면 타입의 소유
        A a = new A();

        int aa = a.n;
        a.g();

        int AA = A.m;
        A.f();
        // static의 유무에 따라 접근이 다르다

        // 2.
        // 배우긴 하는데 , 쓰지마 , 시험은 가능..
        a.m = 10;
        // static 멤버를 객체의 멤버로 접근하는 사례 - 근데, 쓰지마, 짤린다..
        A b = new A();
        b.m = 100;
        // m이라는 static 공간은 객체들이 공유하는 공간이다

        // 3.
        // 언제 static을 붙여야 하나, 처음 하는 사람은 거의 안쓴다
        // 중요 : 객체가 하나도 없어도 쓸수있어 !!!
        double pi = Math.PI;
//        public static final double PI = 3.14...   이렇게 되어있을 것이야 Math 클래스에서
//        static 없으면 new Math().PI 해야해
        // 객체에 영향을 미치지 않는 멤버에 static 선언, 객체 없이도 호출할 수 있기 때문이다

        // 4.
        // final class - 클래스에 붙이면 상속 불가
        // final method - 오버라이딩 불가

        // 5.
        // 상속
        // 부모, 자식 클래스 - super, sub class(type)
        // 코드로 경계가 있어도 가능하다 상속했으니까, this.이 대응되는 것이 자식 클래스에서 부모 클래스로 올가면 대응되면 그것에 접근하게 된다 !!!

        // 클래스의 다중 상속은 지원하지 않는다 , class A extends B,C 이게 안된다, B C의 멤버에 우연히 이름이 같을 수 있기 때문에 안되게 하였다.
        // 상속 횟수 무제한
        // 상속의 최상위 조상 클래스는 java.lang.Object 클래스 이다


    }
}

// 1.
class A{
    int n;  // 객체 마다 여러개가 생긴다.
    void g(){}
    static int m;   // 객체는 이걸 멤버로 갖지 않는다, 객체 생성과 상관없이 클래스를 통해 접근 가능
    static void f(){}
}
// 클래스가 로딩이 될 때 , 클래스는 코드 영역에 한 벌만 올라오는데 코드영역에는 공간은 없음 , static이 붙은 것만 따로 한벌이 생긴다 (마치 힙에 객체 생기듯이), 여기 까지가 클래스가 로딩이 된것
// 실행전 클래스는 코드 영역만, 로딩 중에는 코드영역 + static 영역
// heap에는 n개 여기는 객체 생성 공간으로 static 없는 것들만 포함, 코드영역 1개, static 영역 1개

// 3.
class human{
    String name;    // static no (이름)
    static int aveAge;     // static yes - type 의 속성 (평균연령)
}

class Model3{
    static int manyCar;    // static yes - type의 속성 (생산대수)
    int runSpeed; // static no , 특정 객체의 한정된 행위이기 때문에 static 붙이면 안된다
}

class Car{
    int speed;
    static void accel(int delta,Car target){  // 여기에 static은 아예 못 붙여
//        this.speed += delta; // static 붙이면, 여기서 컴파일 에러 떠
        target.speed += delta;  // 이건 static 가능, Car.accel(10,new Car()); 로 호출해서 가능하다
        // 기계적으로 외우지 말고, this를 쓰던 아니던, 내 클래스의 멤버 변수의 접근이 안되는 것이다 !!!
    }
    static void accceel(int dd){    // 여기서는 static 붙이는게 맞아, 지역변수만 건들어서
        dd++;
    }
}