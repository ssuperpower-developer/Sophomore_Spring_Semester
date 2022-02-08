public class AnimalExample {
  public static void main(String args[]) {
    Dog dog = new Dog();
    Cat cat = new Cat();

    dog.sound();
    cat.sound();
    System.out.println("-----");

    Animal animal = null;
    animal = new Dog();
    animal.sound();

    animal = new Cat();
    animal.sound();
    System.out.println("-----");

    // 매개변수로 변환을 할 수 있음을 알기 위한 코드
    animalSound(new Dog());
    animalSound(new Cat());
  }

  public static void animalSound(Animal animal) { animal.sound(); }
}
