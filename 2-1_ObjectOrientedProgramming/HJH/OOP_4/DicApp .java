import java.util.Scanner;

public class DicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");
        while(true){
            System.out.print("한글 단어?");
            String input = scanner.next();
            if(input.equals("그만")) break;
            System.out.println(Dictionary.kor2Eng(input));
        }
    }
}

class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        if(word.equals("사랑"))  return "사랑은 love";
        else if(word.equals("아기")) return "아기는 baby";
        else if(word.equals("돈")) return "돈은 money";
        else if(word.equals("미래")) return "미래는 future";
        else if(word.equals("희망")) return "희망은 hope";
        else{
            System.out.print(word);
            return "는 저의 사전에 없습니다.";
        }
    }
}
