public class Add {
    public static void main(String[] args) {
        int sum = 0;
        for(String arr : args){
            try{        // 예외 생성
                sum += Integer.parseInt(arr);
                // args의 경우 String 배열이므로 int로 변환 후 sum에 합한다.
            }
            catch(NumberFormatException e){
                // 만약 int가 아닌 다른 값을 입력한 경우 예외 발생
            }
        }
        System.out.println(sum);
    }
}

