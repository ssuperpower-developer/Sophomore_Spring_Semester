import java.util.Scanner;

class Dictionary{
    private static String [] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String [] eng = {"love", "baby", "moneiy", "future", "hope"};
    public static String kor2Eng(String word){
        int i;
        String noExist = "저의 사전에 없습니다.";
        for(i = 0; i < kor.length; i++){
            if(word.equals(kor[i])){
                return eng[i];
            }
        }
        return noExist;
    }
}

public class DicApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");

        while(true){
            String changeWord;
            System.out.print("한글 단어?");
            String word = s.next();
            changeWord = Dictionary.kor2Eng(word);
            if(word.equals("그만")) break;
            System.out.println(word + "는 " + changeWord);
        }

        s.close();
    }
}
