import java.util.Scanner;

//Num08
public class Phonebook {
    public static void main(String[] args) {
        Phonebook a = new Phonebook();
        a.Push();
        a.Find();
    }

    Phone db[];
    private int Number;
    static public Scanner scanner = new Scanner(System.in);

    public int checkNum() {
        System.out.print("인원수>>");
        Number = scanner.nextInt();
        return Number;
    }

    public void Push() {
        this.db = new Phone[checkNum()];
        for (int i = 0; i < this.Number; i++) {
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>>");
            String tempName = scanner.next();
            String tempTel = scanner.next();
            db[i] = new Phone(tempName, tempTel);
        }
        System.out.println("저장되었습니다...");
    }

    public void Find() {
        int i = 0;

        while (true) {
            System.out.print("검색할 이름>>");
            String temp = scanner.next();
            if (temp.equals("그만")) {
                System.out.print("검색을 종료합니다.");
                break;
            }
            for (; i < db.length; i++) {
                if (db[i].name.equals(temp)) break;
            }
            try {
                System.out.println(db[i].tel);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(temp + "에 해당하는 사람은 없습니다.");
            }
            i = 0;
        }
    }
}

class Phone {
    String name;
    String tel;

    Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
}



