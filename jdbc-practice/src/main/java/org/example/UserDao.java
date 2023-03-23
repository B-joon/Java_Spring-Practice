package org.example;

import java.sql.*;

public class UserDao {
//    private Connection getConnection() {
//        String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
//        String id = "sa";
//        String password = "";
//
//        try {
//            Class.forName("org.h2.Driver");
//            return DriverManager.getConnection(url, id, password);
//        } catch (Exception e) {
//            return null;
//        }
//    }

//    public void create(User user) throws SQLException {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            con = ConnectionManager.getConnection();
//            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, user.getUserId());
//            pstmt.setString(2, user.getPassword());
//            pstmt.setString(3, user.getName());
//            pstmt.setString(4, user.getEmail());
//
//            pstmt.executeUpdate();
//        } finally {
//            if (pstmt != null) {
//                pstmt.close();
//            }
//
//            if (con != null) {
//                con.close();
//            }
//        }
//    }

    public void create2(User user) throws SQLException {
        JDBCTemplate jdbcTemplate = new JDBCTemplate();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(user, sql, pstmt -> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
        });
//        jdbcTemplate.executeUpdate(user, sql, new PreparedStatementSetter() {
//            @Override
//            public void setter(PreparedStatement pstmt) throws SQLException {
//                pstmt.setString(1, user.getUserId());
//                pstmt.setString(2, user.getPassword());
//                pstmt.setString(3, user.getName());
//                pstmt.setString(4, user.getEmail());
//            }
//        });
    }

//    public User findByUserId(String userId) throws SQLException {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = ConnectionManager.getConnection();
//            String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, userId);
//
//            rs = pstmt.executeQuery();
//
//            User user = null;
//            if (rs.next()) {
//                user = new User(rs.getString("userId"), rs.getString("password"),
//                        rs.getString("name"), rs.getString("email"));
//            }
//            return user;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pstmt != null) {
//                pstmt.close();
//            }
//
//            if (con != null) {
//                con.close();
//            }
//        }
//    }

    public User findByUserId2(String userId) throws SQLException {
        JDBCTemplate jdbcTemplate = new JDBCTemplate();
        String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
        return (User) jdbcTemplate.executeQuery(userId, sql,
                pstmt -> pstmt.setString(1, userId),
                resultSet -> new User(
                        resultSet.getString("userId"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                ));
//        return jdbcTemplate.executeQuery(userId, sql, new PreparedStatementSetter() {
//            @Override
//            public void setter(PreparedStatement pstmt) throws SQLException {
//                pstmt.setString(1, userId);
//            }
//        }, new RowMapper() {
//            @Override
//            public Object map(ResultSet resultSet) throws SQLException {
//                return new User(resultSet.getString("userId"), resultSet.getString("password"),
//                        resultSet.getString("name"), resultSet.getString("email"));
//            }
//        });

    }
}