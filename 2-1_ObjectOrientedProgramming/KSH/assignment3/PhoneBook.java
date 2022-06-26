import java.util.Scanner;

class Phone{
    String name, tel;
    Phone(String name, String tel){
        this.name = name;
        this.tel = tel;
    }
}

public class PhoneBook {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("인원수>>");
        int count = s.nextInt();
        String name, tel, find;
        Phone[] book = new Phone[count];
        for(int i = 0; i < count; i++){
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
            name = s.next();
            tel = s.next();
            book[i] = new Phone(name, tel);
        }
        System.out.println("저장되었습니다...");
        while(true){
            int i = 0;
            System.out.print("검색할 이름>>");
            find = s.next();
            if(find.equals("그만")) break;
            for(i = 0; i < count; i++){
                if(find.equals(book[i].name)){
                    System.out.println(find + "의 번호는 " + book[i].tel
                     + " 입니다.");
                    break;
                }
            }
            if(i == count) System.out.println(find + " 이 없습니다.");
        }
        s.close();
    }
}
