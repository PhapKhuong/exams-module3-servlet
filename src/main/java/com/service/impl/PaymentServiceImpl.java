package com.service.impl;

import com.bean.Payment;
import com.repository.impl.PaymentRepositoryImpl;
import com.repository.itf.PaymentRepository;
import com.service.itf.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    PaymentRepository repository = new PaymentRepositoryImpl();
    @Override
    public List<Payment> display() {
        return repository.display();
    }

    @Override
    public Payment search(int id) {
        return repository.search(id);
    }
}
