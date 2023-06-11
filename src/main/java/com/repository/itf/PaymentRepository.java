package com.repository.itf;

import com.bean.Payment;

import java.util.List;

public interface PaymentRepository {
    List<Payment> display();

    Payment search(int id);
}
