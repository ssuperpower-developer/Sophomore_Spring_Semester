abstract class PairMap {
    protected String keyArray[];
    protected String valueArray[];
    abstract String get(String key);
    abstract void put(String key, String value);
    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap {
    private int indexChecker = 0;
    private int size;

    Dictionary(int size) {
        keyArray = new String[size];
        valueArray = new String[size];
        this.size = size;
    }

    @Override
    String get(String key)
    {
        int i = 0;
        boolean isNull = true;
        for (; i < keyArray.length; i++) {
            if (key.equals(keyArray[i])) {
                isNull = false;
                break;
            }
        }
        if (isNull == false) {
            return keyArray[i];
        } else {
            return null;
        }
    }

    @Override
    void put(String key, String value) {
        if (get(key) == null) {
            keyArray[indexChecker] = key;
            valueArray[indexChecker] = value;
            indexChecker++;
        } else {
            int i = 0;
            boolean isNull = true;
            for (; i < keyArray.length; i++) {
                if (key.equals(keyArray[i])) break;
            }
            valueArray[i] = value;
        }
    }

    @Override
    String delete(String key) {
        if(!get(key).equals(key)){
            System.out.println("해당하는 값은 없습니다");
            return "";
        }
        else {
            int i=-1;
            for (int j = 0; j <keyArray.length ; j++) {
                if (key.equals(keyArray[j])) {
                    i=j;
                    keyArray[j]=null;
                    valueArray[j]=null;
                    break;
                }
            }
            return valueArray[i];
        }
    }

    @Override
    int length() {
        int counter = 0;
        for (int i=0; i < size; i++) {
            if (keyArray[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}

class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이썬");
        dic.put("이재문", "C++");
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
