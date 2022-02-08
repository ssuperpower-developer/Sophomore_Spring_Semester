public class CheckBox {
  public interface OnSelectListener {
    void onSelect();
  }

  OnSelectListener listener;

  void setOnSelectListener(OnSelectListener listener) {
    this.listener = listener;
  }

  void select() { listener.onSelect(); }
}
