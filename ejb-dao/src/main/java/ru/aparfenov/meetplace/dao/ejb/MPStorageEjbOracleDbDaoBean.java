package ru.aparfenov.meetplace.dao.ejb;

import ru.aparfenov.meetplace.jpa.enities.MeetPointEntity;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by ArtemParfenov on 01.04.2018.
 */
@Stateless
public class  MPStorageEjbOracleDbDaoBean implements MPStorageEjbDAO {
    @Resource(name="myOracleDataSource")
    private DataSource myDs;
    private Connection conn;

    @Override
    public MeetPointEntity getMP(String id) {
//        StringBuilder result = new StringBuilder();
        int rowCount = 0;
        try {
            this.conn = myDs.getConnection();
            Locale.setDefault(Locale.ENGLISH);
            this.conn = myDs.getConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery("select count(*) from meet_point");
            while (rs.next()) {
//                result.append(rs.getInt(1));
                rowCount = rs.getInt(1);
            }
        } catch (SQLException e) {
//            result.append("SQL exception while executing the query");
//            result.append(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
//                result.append("SQL exception while trying to close the connection");
//                result.append(e.getMessage());
                e.printStackTrace();
            }
        }
        MeetPointEntity mpEntity = new MeetPointEntity();
        mpEntity.setId("count=" + rowCount);
        return mpEntity;
    }

    @Override
    public void addMP(MeetPointEntity newMP) {

    }
}
