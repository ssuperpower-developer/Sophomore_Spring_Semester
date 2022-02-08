public class Cat extends Animal {
  public Cat() { this.kind = "manilla"; }

  @Override
  public void sound() {
    System.out.println("Meow");
  }
}
