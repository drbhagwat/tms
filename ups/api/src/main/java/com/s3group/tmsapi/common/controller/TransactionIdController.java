package com.s3group.tmsapi.common.controller;

import com.s3group.tmsapi.common.entities.TransactionId;
import com.s3group.tmsapi.common.service.TransactionIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Thamilarasi
 * @version : 1.0
 */
@RestController
public class TransactionIdController {
  @Autowired
  private TransactionIdService transactionIdService;

  @GetMapping("/getTransactionNumber")
  public TransactionId get() {
    return transactionIdService.get();
  }
}