abstract class PairMap{
    protected String[] keyArray;
    protected String[] valueArray;
    abstract String get(String key);
    abstract void put(String key,String value);
    abstract String delete(String key);
    abstract int length();
}


class Dictionary extends PairMap{
    private int num;
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태","자바");
        dic.put("이재문","파이썬");
        dic.put("이재문","C++");
        System.out.println("이재문의 값은 "+dic.get("이재문"));
        System.out.println("황기태의 값은 "+dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 "+dic.get("황기태"));
        System.out.println(dic.length());
    }
    Dictionary(int n){
        this.keyArray = new String[n];
        this.valueArray = new String[n];
        num = 0;
    }
    @Override
    String get(String key) {
        for(int i=0;i< num;i++){
            if(keyArray[i].equals(key)) return valueArray[i];
        }
        return null;
    }

    @Override
    void put(String key, String value) {
        if(num == 0){
            keyArray[0] = key;
            valueArray[0] = value;
            ++num;
        }
        else{
            for(int i=0;i< num;i++){
                if(keyArray[i].equals(key)){
                    valueArray[i] = value;
                    return;
                }
            }
            keyArray[num] = key;
            valueArray[num] = value;
            ++num;
        }
    }

    @Override
    String delete(String key) {
        for(int i=0;i< num;i++){
            if(keyArray[i].equals(key)) valueArray[i] = null;
        }
        return null;
    }

    @Override
    int length() {
        int result=0;
        for(int i=0;i<num;i++){
            if(valueArray[i] != null){
                ++result;
            }
        }
        return result;
    }
}
