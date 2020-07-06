package com.project.service;

import java.util.List;

import com.project.model.CartItem;
import com.project.model.TransactionHistoryDTO;

public interface TransactionHistoryService {
	public void addTransactionHistory(CartItem cartItem);
	public void addTransactionHistory(TransactionHistoryDTO transactionHistoryDTO);
	public void updateTransactionHistory(TransactionHistoryDTO transactionHistoryDTO);
	public void deleteTransactionHistory(String id);
	public TransactionHistoryDTO getTransactionHistoryById(String id);
	public List<TransactionHistoryDTO> getTransactionHistoryByUserId(int id);
	public List<TransactionHistoryDTO> getTransactionHistoryByProductId(int id);
	public List<TransactionHistoryDTO> getAllTransactionHistory(); 
}
