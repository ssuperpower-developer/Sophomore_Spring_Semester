public class Board {
  String title, content, writer, date;
  int hitCount;

  Board() {
    //
  }

  Board(String title, String content) {
    this(title, content, "Logined Member ID", "Current PC Date", 0);
  }

  Board(String title, String content, String writer) {
    this(title, content, writer, "Current PC Date", 0);
  }

  Board(String title, String content, String writer, String date) {
    this(title, content, writer, date, 0);
  }

  Board(String title, String content, String writer, String date,
        int hitCount) {
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.date = date;
    this.hitCount = hitCount;
  }
}
