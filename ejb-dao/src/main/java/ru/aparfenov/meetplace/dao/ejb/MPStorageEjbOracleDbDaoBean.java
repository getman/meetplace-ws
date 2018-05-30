package ru.aparfenov.meetplace.dao.ejb;

import ru.aparfenov.meetplace.dao.db.DbQuery;
import ru.aparfenov.meetplace.dao.db.DbQueryProcessor;
import ru.aparfenov.meetplace.dao.db.PreparedStatementParam;
import ru.aparfenov.meetplace.model.MeetPoint;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by ArtemParfenov on 01.04.2018.
 */
@Stateless
public class  MPStorageEjbOracleDbDaoBean implements MPStorageEjbDAO {
    private static final String GET_MP_LIST_QUERY = "select * from meet_point";
    private static final String ADD_MP_QUERY = "insert into meet_point(id,x,y) values(?, ?, ?)";
    private static final String DELETE_MP_QUERY = "delete from meet_point where id=?";
    @Resource(name="jdbc/myOracleDataSource")
    private DataSource myDs;
    private Connection conn;

    @Override
    public List<MeetPoint> getMPList() {
        return performOracleQuery(new DbQuery() {
            @Override
            public void execute(Connection conn) {
                try {
                    Statement ps = conn.createStatement();
                    rs = ps.executeQuery(GET_MP_LIST_QUERY);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }, new DbQueryProcessor() {
            @Override
            public List<MeetPoint> receiveProcessedData(DbQuery dbQuery) {
                ResultSet rs = dbQuery.getResult();
                List<MeetPoint> result = new ArrayList<>();
                try {
                    while (rs.next()) {
                        String id = rs.getString(1);
                        long x = rs.getLong(2);
                        long y = rs.getLong(3);
                        MeetPoint newMP = new MeetPoint(id, x, y);
                        result.add(newMP);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result.isEmpty() ? null : result;
            }

            @Override
            public void processData() {
            }
        });
    }

    @Override
    public List<MeetPoint> getMPListByParams(Map<String, PreparedStatementParam> params) {
        return performOracleQuery(new DbQuery() {
            @Override
            public void execute(Connection conn) {
                try {
                    Statement ps = conn.createStatement();
                    StringBuilder sqlParamsQueries = new StringBuilder();
                    boolean firstParam = true;
                    for (Map.Entry<String, PreparedStatementParam> nextEntry: params.entrySet()) {
                        if (firstParam) {
                            firstParam = false;
                        } else {
                            sqlParamsQueries.append(" and ");
                        }
                        sqlParamsQueries.append(nextEntry.getKey());
                        sqlParamsQueries.append("=");
                        PreparedStatementParam param = nextEntry.getValue();
                        sqlParamsQueries.append(param.getQuotationMark());
                        sqlParamsQueries.append(String.valueOf(
                                ((PreparedStatementParam)nextEntry.getValue()).getValue()));
                        sqlParamsQueries.append(param.getQuotationMark());
                    }
                    rs = ps.executeQuery(GET_MP_LIST_QUERY +
                            (sqlParamsQueries.length() > 0 ? " where " + sqlParamsQueries.toString() : ""));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }, new DbQueryProcessor() {
            @Override
            public List<MeetPoint> receiveProcessedData(DbQuery dbQuery) {
                ResultSet rs = dbQuery.getResult();
                List<MeetPoint> result = new ArrayList<>();
                try {
                    while (rs.next()) {
                        String id = rs.getString(1);
                        long x = rs.getLong(2);
                        long y = rs.getLong(3);
                        MeetPoint newMP = new MeetPoint(id, x, y);
                        result.add(newMP);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result.isEmpty() ? null : result;
            }

            @Override
            public void processData() {
            }
        });
    }

    @Override
    public MeetPoint getMP(String id) {
        return performOracleQuery(new DbQuery() {
            @Override
            public void execute(Connection conn) {
                try {
                    Statement ps = conn.createStatement();
                    rs = ps.executeQuery(GET_MP_LIST_QUERY);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }, new DbQueryProcessor() {
            @Override
            public List<MeetPoint> receiveProcessedData(DbQuery dbQuery) {
                ResultSet rs = dbQuery.getResult();
                List<MeetPoint> result = new ArrayList<>();
                try {
                    while (rs.next()) {
                        String id = rs.getString(1);
                        long x = rs.getLong(2);
                        long y = rs.getLong(3);
                        MeetPoint newMP = new MeetPoint(id, x, y);
                        result.add(newMP);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result.isEmpty() ? null : result;
            }

            @Override
            public void processData() {
            }
        }).get(0);
    }

    @Override
    public void addMP(final MeetPoint newMP) {
        performOracleQuery(new DbQuery() {
            @Override
            public void execute(Connection conn) {
                try {
                    PreparedStatement ps = conn.prepareStatement(ADD_MP_QUERY);
                    ps.setString(1, newMP.getId());
                    ps.setLong(2, newMP.getX());
                    ps.setLong(3, newMP.getY());
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void deleteMp(String mpId) {
        performOracleQuery(new DbQuery() {
            @Override
            public void execute(Connection conn) {
                try {
                    PreparedStatement ps = conn.prepareStatement(DELETE_MP_QUERY);
                    ps.setString(1, mpId);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private List<MeetPoint> performOracleQuery(DbQuery dbQuery, DbQueryProcessor dbQueryProcessor) {
        performOracleQuery(dbQuery);
        return dbQueryProcessor.receiveProcessedData(dbQuery);
    }

    private void performOracleQuery(DbQuery dbQuery) {
        try {
            this.conn = myDs.getConnection();
            Locale.setDefault(Locale.ENGLISH);
            this.conn = myDs.getConnection();
            dbQuery.execute(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
