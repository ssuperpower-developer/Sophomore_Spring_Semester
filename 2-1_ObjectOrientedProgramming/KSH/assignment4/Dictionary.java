abstract class PairMap{
    protected String[] keyArray;
    protected String[] valueArray;
    abstract String get(String key);
    abstract void put(String key, String value);
    abstract String delete(String key);
    abstract int length();
}

public class Dictionary extends PairMap{
    protected int size;
    Dictionary(int size){
        this.size = size;
        this.keyArray = new String[size];
        this.valueArray = new String[size];
    }
    @Override
    String get(String key){
        int i = 0;
        for(; i < size; i++){
            if(keyArray[i].equals(key)){
                return valueArray[i];
            }
        }
        return key + "가 존재하지 않습니다.";
    }
    @Override
    void put(String key, String value){
        int i = 0;
        for(; i < size; i++){
            if(keyArray[i].equals(key)){
               valueArray[i] = value;
            }
        }
        if(i == size){
            for(int k = 0; k < size; k++){
                if(keyArray[i] != null){
                    keyArray[i] = key;
                    valueArray[i] = value;
                    break;
                }
            }
        }

    }
    @Override
    String delete(String key){
        for(int i = 0; i < size; i++){
            if(keyArray[i].equals(key)){
                keyArray[i] = null;
                valueArray[i] = null;
            }
        }
        return null;
    }
    @Override
    int length(){
        int i = 0;
        for(; i < size; i++){
            if(keyArray[i] != null){
                break;
            }
        }
        return i;
    }
}

class DictionaryApp{
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