package ru.aparfenov.meetplace.dao.db;

import java.sql.Connection;
import java.sql.ResultSet;

/** Represents the database query
 * Created by ArtemParfenov on 23.04.2018.
 */
public abstract class DbQuery {
    protected ResultSet rs;
    public abstract void execute(Connection conn);
    public ResultSet getResult() {
        return rs;
    }
}
