import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        String Input;
            System.out.print("인원수>> ");
            num = scanner.nextInt();
            Phone[] phones = new Phone[num];
            for(int i=0;i<num;i++) {
                System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>> ");
//                Phone temp = new Phone(scanner.next(),scanner.next());
                String tempForInput = scanner.next();
                String tempForInputNum = scanner.next();
                Phone temp = new Phone(tempForInput,tempForInputNum);
                phones[i] = temp;
//                phones[i].name    // 이게 오류!
            }
            System.out.println("저장되었습니다...");
            while(true) {
                System.out.print("검색할 이름>>");
                String find_name = scanner.next();
                if(find_name.equals("그만")) break;
                boolean isHave = false;
                for (int i = 0; i < num; i++) {
                    if (phones[i].getName().equals(find_name)) {    // 이렇게 입력받아야 하네
                        System.out.printf("%s의 번호는 %s 입니다.\n", find_name, phones[i].getTel());
                        isHave = true;
                    }
                }
                if (isHave == false) System.out.printf("%s 이 없습니다.\n", find_name);
            }
        }
}
class Phone{
    private String name;
    private String tel;

    Phone(String name,String tel){
        this.name = name;
        this.tel = tel;
    }
    String getTel(){
        return  tel;
    }
    String getName(){
        return name;
    }
}