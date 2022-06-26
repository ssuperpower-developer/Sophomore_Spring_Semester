public class Dictionary extends PairMap {
  private int dictionaryMaxSize;
  private int dictionaryItemSize;

  // 사전의 기본 세팅값을 Empty로 설정했음
  // 이 사전에는 Empty라는 아이템을 사용할 수 없음
  private void settingEmptyDictionary() {
    for (int i = 0; i < dictionaryMaxSize; ++i) {
      keyArray[i] = "Empty";
      valueArray[i] = "Empty";
    }
  }

  Dictionary(int dictionaryMaxSize) {
    this.dictionaryMaxSize = dictionaryMaxSize;
    this.dictionaryItemSize = 0;
    keyArray = new String[dictionaryMaxSize];
    valueArray = new String[dictionaryMaxSize];

    this.settingEmptyDictionary();
  }

  @Override
  public String get(String key) {
    for (int i = 0; i < dictionaryMaxSize; ++i) {
      if (key.equals(keyArray[i])) {
        return valueArray[i];
      }
    }

    return null;
  }

  @Override
  public void put(String key, String value) {
    for (int i = 0; i < dictionaryMaxSize; ++i) {
      if (keyArray[i].equals("Empty")
          || keyArray[i].equals(key)) {
        if (keyArray[i].equals("Empty"))
          ++dictionaryItemSize;
        keyArray[i] = key;
        valueArray[i] = value;
        break;
      }
    }
  }

  @Override
  public String delete(String key) {
    for (int i = 0; i < dictionaryMaxSize; ++i) {
      if (key.equals(keyArray[i])) {
        String returnValue = valueArray[i];
        keyArray[i] = "Empty";
        valueArray[i] = "Empty";
        return returnValue;
      }
    }

    return null;
  }

  @Override
  public int length() {
    return this.dictionaryItemSize;
  }

}