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
    private int itemChecker = 0;

    Dictionary() {
    }

    Dictionary(int size) {
        keyArray = new String[size];
        valueArray = new String[size];
    }

    @Override
    String get(String key)//key값을 지닌
    {
        int i = 0;
        for (; i < keyArray.length; i++) {
            if (keyArray[i]==key) {
                return valueArray[i];
            }
        }
        return null;//check Num
    }

    int getIndex(String key)//for index
    {
        int i = 0;
        for (; i < keyArray.length; i++) {
            if (keyArray[i]==key) break;
        }
        if (i == keyArray.length) return -1;//check Num for Exception
        return i;
    }

    @Override
    void put(String key, String value) {
        int temp = getIndex(key);


        try {
            if (indexChecker == 0) {
                keyArray[0] = key;
                valueArray[0] = value;
                indexChecker++;
                itemChecker++;
            } else if (indexChecker != 0 && (get(key) != null)) {
                valueArray[temp] = value;
            } else if(indexChecker != 0 && (get(key) == null)){
                keyArray[indexChecker] = key;
                valueArray[indexChecker] = value;
                indexChecker++;
                itemChecker++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("");
        }
    }

    @Override
    String delete(String key) {
        int temp = getIndex(key);
        if (temp != -1) {
            String temps = valueArray[temp];
            keyArray[temp] = null;
            valueArray[temp] = null;
            return temps;
        }
        return null;
    }

    @Override
    int length() {
        int temp = 0;
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null) temp++;
        }
        return temp;
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
        System.out.println("황기태의 값은" + dic.get("황기태"));
    }
}
