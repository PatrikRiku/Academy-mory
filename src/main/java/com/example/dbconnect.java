package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class dbconnect implements dbconnectrep {
    @Autowired
    private DataSource dataSource;

    @Override
    public List<String> getImgUrl() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT url FROM dbo.images")) {
            List<String> urls = new ArrayList<>();
            while (rs.next()) urls.add(rs.getString("url"));
            return urls;
        } catch (SQLException e) {
            List<String> urls = new ArrayList<>();
            return urls;
        }
    }

//    private List<String> rsBlog(ResultSet rs) throws SQLException {
//        return new Blog(rs.getLong("id"), rs.getString("title"));
//    }
}