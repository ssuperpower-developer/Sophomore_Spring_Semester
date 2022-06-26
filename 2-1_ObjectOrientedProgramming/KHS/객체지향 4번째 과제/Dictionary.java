import java.util.Scanner;
//Num10
public class Dictionary {

    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        int i = 0;
        for (; i < kor.length; i++) {
            if (kor[i].equals(word)) break;
        }
        return eng[i];
    }
}

class DicApp {
    public static void main(String[] args) {
        System.out.println("한영 단어 검색 프로그램입니다");
        while (true) {
            System.out.print("한글 단어 입력>>");
            String temp = null;

            try {
                temp = scanner.next();
                if (temp.equals("그만")) {
                    System.out.println("프로그램 종료합니다");
                    break;
                }
                System.out.println(temp+"은/는 "+Dictionary.kor2Eng(temp));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(temp + "은/는 저의 사전에 없습니다.");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}

