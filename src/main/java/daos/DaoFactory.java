package daos;

public class DaoFactory {
    public static Users userDao(){
        return new ArrayListUsers();
    }
}
