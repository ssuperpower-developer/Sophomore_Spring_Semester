public class ShopService {
  // 싱글톤을 만드는 방법에 있어서 친숙해질 필요가 있다.
  private static ShopService singleton = new ShopService();

  private ShopService() {}

  static ShopService getInstance() { return singleton; }
}
