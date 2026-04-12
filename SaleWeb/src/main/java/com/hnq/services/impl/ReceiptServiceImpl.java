/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnq.services.impl;

import com.hnq.pojo.CartItem;
import com.hnq.repositories.ReceiptRepository;
import com.hnq.services.ReceiptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{
    
    @Autowired
    private ReceiptRepository receiptRepo;

    @Override
    public void addReceipt(List<CartItem> carts) {
        this.receiptRepo.addReceipt(carts);
    }
    
}
