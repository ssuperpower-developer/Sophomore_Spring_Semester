public class Grade {
  private int math = 0, science = 0, english = 0;

  Grade() {
  }

  Grade(int math, int science, int english) {
    this.math = math;
    this.science = science;
    this.english = english;
  }

  public int average() {
    return (math + science + english) / 3;
  }

}
