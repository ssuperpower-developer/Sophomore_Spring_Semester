package sec03.verify.exam03;

public class Board {
	String title;
	String content;
	String writer;
	String date;
	int hitcount;

	Board(String title, String content) {
		this(title, content, "로그인한 회원아이디", "현재 컴퓨터 날짜", 0);
	}

	Board(String title, String content, String writer) {
		this(title, content, writer, "현재 컴퓨터 날짜", 0);
	}

	Board(String title, String content, String writer, String date) {
		this(title, content, writer, date, 0);
	}

	Board(String title, String content, String writer, String date, int hitcount) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = hitcount;
	}
}
