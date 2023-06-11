package com.service.itf;

import com.bean.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> display();
    Payment search(int id);
}
