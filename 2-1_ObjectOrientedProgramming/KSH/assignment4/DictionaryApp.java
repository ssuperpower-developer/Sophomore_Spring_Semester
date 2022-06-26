abstract class PairMap{
    protected String[] keyArray;
    protected String[] valueArray;
    abstract String get(String key);
    abstract void put(String key, String value);
    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap{
    protected int size;
    Dictionary(int size){
        this.size = size;
        this.keyArray = new String[size];
        this.valueArray = new String[size];
        // size 만큼 keyArray 와 valueArray 생성
    }
    @Override
    // get 함수 오버라이딩
    String get(String key){
        for(int i = 0; i < size; i++){
            // i = 0 부터 size까지 반복
            if(keyArray[i] != null && keyArray[i].equals(key)){
                // keyArray[i] 값이 null이 아니고 keyArray 값과 key 값이 일치하면
                // .equals() 의 경우 null 과 비교할 수 없다.
                // null 을 처리하지 않으면 NullPointerException 발생
                return valueArray[i];
            }
        }
        return "null";
        // for 문에서 return 되지 않으면 key 값과 일치하는 keyArray[i] 가 없는 것이므로
        // null return
    }
    @Override
    // put 함수 오버라이딩
    void put(String key, String value){
        for(int i = 0; i < size; i++){
            if(keyArray[i] != null && keyArray[i].equals(key)){
                // keyArray[i] 값이 null이 아니고 keyArray 값과 key 값이 일치하면
                valueArray[i] = value;
                // valueArray[i] 값 수정
                return;
            }
        }
        // 만약 앞의 for 문이 끝까지 돌아 return 되지 않으면
        // key 값이 없는 것이므로
        for(int i = 0; i < size; i++){
            // 0부터 size 사이에
            if(keyArray[i] == null) {
                // keyArray에 아무 값도 들어있지 않으면
                keyArray[i] =key;
                valueArray[i] = value;
                return;
            }
        }


    }
    @Override
    // delete 오버라이딩
    String delete(String key){
        for(int i = 0; i < size; i++){
            if(keyArray[i] != null && keyArray[i].equals(key)){
                // keyArray[i] 값이 null이 아니고 keyArray 값과 key 값이 일치하면
                keyArray[i] = null;
                // keyArray[i] 를 null 로 변경
                valueArray[i] = null;
                // valueArray[i] 를 null 로 변경
            }
        }
        return null;
    }
    @Override
    // length 오버라이딩
    int length(){
        int count = 0;
        for(int i = 0; i < size; i++){
            // 0 부터 size 까지 반복
            if(keyArray[i] == null){
                count++;
                // 만약에 keyArray[i] 값이 null 이 되면 break
            }
        }
        return count;
        // i 값 출력
    }
}

public class DictionaryApp{
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++");
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}