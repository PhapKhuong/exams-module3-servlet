package com.bean;

import java.time.LocalDate;

public class Room {
    private int roomId;
    private String name;
    private String phone;
    private LocalDate date;
    private Payment payment;
    private String note;

    public Room() {
    }

    public Room(String name, String phone, LocalDate date, Payment payment, String note) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.payment = payment;
        this.note = note;
    }

    public Room(int roomId, String name, String phone, LocalDate date, Payment payment, String note) {
        this.roomId = roomId;
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.payment = payment;
        this.note = note;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

