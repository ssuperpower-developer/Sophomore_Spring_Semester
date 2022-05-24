class PositivePoint extends Point {
  PositivePoint() {
    super(0, 0);
  }

  PositivePoint(int x, int y) {
    super(0, 0);
    move(x, y);
  }

  @Override
  public void move(int x, int y) {
    if (x >= 0 && y >= 0) {
      super.move(x, y);
    }
  }

  public String toString() {
    return "(" + this.getX() + ", " + this.getY() + ")의 점";
  }
}