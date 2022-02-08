public class CheckBox {
  static interface OnSelectListener { void onSelect(); }

  OnselectListener listener;

  void setOnSelectListener(OnSelectListener listener) {
    this.listener = listener;
  }

  void select() { listener.onSelect(); }
}
