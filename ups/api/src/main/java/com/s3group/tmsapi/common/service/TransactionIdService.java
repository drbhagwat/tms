package com.s3group.tmsapi.common.service;

import com.s3group.tmsapi.common.entities.TransactionId;
import com.s3group.tmsapi.common.repo.TransactionIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-06-26
 */
@Service
@Transactional
public class TransactionIdService {
  @Autowired
  private TransactionIdRepository transactionIdRepository;

  public TransactionId get() {
    TransactionId transactionId = new TransactionId();
    String prefix = "WFL";
    transactionId.setPrefix(prefix);
    transactionIdRepository.save(transactionId);
    transactionId.setTransactionNumber((prefix + transactionId.getId()));
    return transactionId;
  }
}