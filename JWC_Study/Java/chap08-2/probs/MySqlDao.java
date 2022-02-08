public class MySqlDao implements DataAccessObject {
  @Override
  public void select() {
    System.out.println("Searching in MySql DB");
  }

  @Override
  public void insert() {
    System.out.println("Inserting at MySql DB");
  }

  @Override
  public void update() {
    System.out.println("Editing at MySql DB");
  }

  @Override
  public void delete() {
    System.out.println("Deleting at MySql DB");
  }
}
