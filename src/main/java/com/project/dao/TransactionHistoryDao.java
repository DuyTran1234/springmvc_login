package com.project.dao;

import java.util.List;

import com.project.entity.TransactionHistory;

public interface TransactionHistoryDao {
	public void addTransactionHistory(TransactionHistory transactionHistory);
	public void updateTransactionHistory(TransactionHistory transactionHistory);
	public void deleteTransactionHistory(String id);
	public TransactionHistory getTransactionHistoryById(String id);
	public List<TransactionHistory> getTransactionHistoryByUserId(int id);
	public List<TransactionHistory> getTransactionHistoryByProductId(int id);
	public List<TransactionHistory> getAllTransactionHistory();
}
