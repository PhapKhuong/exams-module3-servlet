package com.repository.impl;

import com.bean.Payment;
import com.bean.Room;
import com.database.DBConnection;
import com.database.MyQuery;
import com.repository.itf.PaymentRepository;
import com.util.MyUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {
    @Override
    public List<Payment> display() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Payment> paymentList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.SELECT_PAYMENT);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int payId = resultSet.getInt("payId");
                    String payName = resultSet.getString("payName");
                    Payment payment = new Payment(payId, payName);
                    paymentList.add(payment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return paymentList;
    }

    @Override
    public Payment search(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Payment payment = new Payment();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.SEARCH_PAYMENT);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int payId = resultSet.getInt("payId");
                    String payName = resultSet.getString("payName");
                    payment = new Payment(payId, payName);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return payment;
    }
}
