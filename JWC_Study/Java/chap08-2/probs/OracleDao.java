public class OracleDao implements DataAccessObject {
  @Override
  public void select() {
    System.out.println("Searching in OracleDB");
  }

  @Override
  public void insert() {
    System.out.println("Inserting in OracleDB");
  }

  @Override
  public void update() {
    System.out.println("Editing in OracleDB");
  }

  @Override
  public void delete() {
    System.out.println("Deleting in OracleDB");
  }
}
