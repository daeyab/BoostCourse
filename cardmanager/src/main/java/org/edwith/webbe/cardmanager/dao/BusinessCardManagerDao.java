package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardManagerDao {

    private static String URL = "jdbc:mysql://localhost:3306/connectdb";
        private static String USER = "connectuser";
    private static String PASSWORD = "connect123!@#";

    public List<BusinessCard> searchBusinessCard(String keyword) {
        List<BusinessCard> businessCardList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select name,phone,company from businesscard where name like ?";
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, keyword);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    String company = resultSet.getString("company");
                    BusinessCard businessCard = new BusinessCard(name, phone, company);
                    businessCardList.add(businessCard);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return businessCardList;
    }

    public BusinessCard addBusinessCard(BusinessCard businessCard) {
        String sql = "insert into businesscard(name,phone,company) values(?,?,?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, businessCard.getName());
            preparedStatement.setString(2, businessCard.getPhone());
            preparedStatement.setString(3, businessCard.getCompanyName());
            preparedStatement.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return businessCard;
    }
}
