package com.repository.impl;

import com.bean.Payment;
import com.bean.Room;
import com.database.DBConnection;
import com.database.MyQuery;
import com.repository.itf.RoomRepository;
import com.util.MyUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    @Override
    public List<Room> display() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Room> roomList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.SELECT_ROOM);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int roomId = resultSet.getInt("roomId");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");

                    Date d1 = resultSet.getDate("date");
                    LocalDate date = MyUtil.convertToLocalDateViaSqlDate(d1);

                    String note = resultSet.getString("note");

                    int payId = resultSet.getInt("payId");
                    String payName = resultSet.getString("payName");

                    Payment payment = new Payment(payId, payName);

                    Room room = new Room(roomId, name, phone, date, payment, note);

                    roomList.add(room);
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
        return roomList;
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.DELETE_ROOM);
                statement.setInt(1, id);
                statement.executeUpdate();
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
    }

    @Override
    public void create(Room room) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.CREATE_ROOM);

                statement.setString(1, room.getName());
                statement.setString(2, room.getPhone());

                Date date = MyUtil.convertToDateViaSqlDate(room.getDate());
                statement.setDate(3, date);

                statement.setString(4, room.getNote());
                statement.setInt(5, room.getPayment().getPayId());
                statement.executeUpdate();
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
    }

    @Override
    public List<Room> search(String str) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Room> roomList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.SEARCH_ROOM);
                statement.setString(1, str);
                statement.setString(2, '%' + str + '%');
                statement.setString(3, '%' + str + '%');

                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int roomId = resultSet.getInt("roomId");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");

                    Date d = resultSet.getDate("date");
                    LocalDate date = MyUtil.convertToLocalDateViaSqlDate(d);

                    String note = resultSet.getString("note");

                    int payId = resultSet.getInt("payId");
                    String payName = resultSet.getString("payName");

                    Payment payment = new Payment(payId, payName);

                    Room room = new Room(roomId, name, phone, date, payment, note);

                    roomList.add(room);
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
        return roomList;
    }
}
