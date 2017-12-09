package Singletons;

/**
 * Created by Lenovo on 02-Dec-17.
 */

public class DBSqlSingleton {
    private static final DBSqlSingleton ourInstance = new DBSqlSingleton();

    public static DBSqlSingleton getInstance() {
        return ourInstance;
    }

    private DBSqlSingleton() {
    }
}
