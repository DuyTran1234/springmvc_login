package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.TransactionHistoryDao;
import com.project.entity.TransactionHistory;
import com.project.model.CartItem;
import com.project.model.TransactionHistoryDTO;
import com.project.service.TransactionHistoryService;

@Transactional
@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
	@Autowired
	private TransactionHistoryDao transactionHistoryDao;

	public void addTransactionHistory(CartItem cartItem) {
		TransactionHistory transactionHistory = new TransactionHistory();
		transactionHistory.setId(cartItem.getId());
		transactionHistory.setUserId(cartItem.getUserId());
		transactionHistory.setProductId(cartItem.getProductId());
		transactionHistory.setDate(cartItem.getDate());
		transactionHistory.setQuantityOrder(cartItem.getQuantityOrder());
		transactionHistoryDao.addTransactionHistory(transactionHistory);
	}

	public void addTransactionHistory(TransactionHistoryDTO transactionHistoryDTO) {
		TransactionHistory transactionHistory = new TransactionHistory();
		transactionHistory.setId(transactionHistoryDTO.getId());
		transactionHistory.setUserId(transactionHistoryDTO.getUserId());
		transactionHistory.setProductId(transactionHistoryDTO.getProductId());
		transactionHistory.setDate(transactionHistoryDTO.getDate());
		transactionHistory.setQuantityOrder(transactionHistoryDTO.getQuantityOrder());
		transactionHistoryDao.addTransactionHistory(transactionHistory);
	}

	public void updateTransactionHistory(TransactionHistoryDTO transactionHistoryDTO) {
		TransactionHistory transactionHistory = new TransactionHistory();
		transactionHistory.setId(transactionHistoryDTO.getId());
		transactionHistory.setUserId(transactionHistoryDTO.getUserId());
		transactionHistory.setProductId(transactionHistoryDTO.getProductId());
		transactionHistory.setDate(transactionHistoryDTO.getDate());
		transactionHistory.setQuantityOrder(transactionHistoryDTO.getQuantityOrder());
		transactionHistoryDao.updateTransactionHistory(transactionHistory);
	}

	public void deleteTransactionHistory(String id) {
		transactionHistoryDao.deleteTransactionHistory(id);
	}

	public TransactionHistoryDTO getTransactionHistoryById(String id) {
		TransactionHistory transactionHistory = this.transactionHistoryDao.getTransactionHistoryById(id);
		if(transactionHistory == null) {
			return null;
		}
		TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO();
		transactionHistoryDTO.setId(transactionHistory.getId());
		transactionHistoryDTO.setUserId(transactionHistory.getUserId());
		transactionHistoryDTO.setProductId(transactionHistory.getProductId());
		transactionHistoryDTO.setDate(transactionHistory.getDate());
		transactionHistoryDTO.setQuantityOrder(transactionHistory.getQuantityOrder());
		return transactionHistoryDTO;
	}

	public List<TransactionHistoryDTO> getTransactionHistoryByUserId(int id) {
		List<TransactionHistory> listTransactionHistory = this.transactionHistoryDao.getTransactionHistoryByUserId(id);
		if(listTransactionHistory == null) {
			return null;
		}
		List<TransactionHistoryDTO> listTransactionHistoryDTO = new ArrayList<TransactionHistoryDTO>();
		for(TransactionHistory transactionHistory : listTransactionHistory) {
			TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO();
			transactionHistoryDTO.setId(transactionHistory.getId());
			transactionHistoryDTO.setUserId(transactionHistory.getUserId());
			transactionHistoryDTO.setProductId(transactionHistory.getProductId());
			transactionHistoryDTO.setDate(transactionHistory.getDate());
			transactionHistoryDTO.setQuantityOrder(transactionHistory.getQuantityOrder());
			listTransactionHistoryDTO.add(transactionHistoryDTO);
		}
		return listTransactionHistoryDTO;
	}

	public List<TransactionHistoryDTO> getTransactionHistoryByProductId(int id) {
		List<TransactionHistory> listTransactionHistory = transactionHistoryDao.getTransactionHistoryByProductId(id);
		if(listTransactionHistory == null) {
			return null;
		}
		List<TransactionHistoryDTO> listTransactionHistoryDTO = new ArrayList<TransactionHistoryDTO>();
		for(TransactionHistory transactionHistory : listTransactionHistory) {
			TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO();
			transactionHistoryDTO.setId(transactionHistory.getId());
			transactionHistoryDTO.setUserId(transactionHistory.getUserId());
			transactionHistoryDTO.setProductId(transactionHistory.getProductId());
			transactionHistoryDTO.setDate(transactionHistory.getDate());
			transactionHistoryDTO.setQuantityOrder(transactionHistory.getQuantityOrder());
			listTransactionHistoryDTO.add(transactionHistoryDTO);
		}
		return listTransactionHistoryDTO;
	}

	public List<TransactionHistoryDTO> getAllTransactionHistory() {
		List<TransactionHistory> listTransactionHistory = transactionHistoryDao.getAllTransactionHistory();
		if(listTransactionHistory == null) {
			return null;
		}
		List<TransactionHistoryDTO> listTransactionHistoryDTO = new ArrayList<TransactionHistoryDTO>();
		for(TransactionHistory transactionHistory : listTransactionHistory) {
			TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO();
			transactionHistoryDTO.setId(transactionHistory.getId());
			transactionHistoryDTO.setUserId(transactionHistory.getUserId());
			transactionHistoryDTO.setProductId(transactionHistory.getProductId());
			transactionHistoryDTO.setDate(transactionHistory.getDate());
			transactionHistoryDTO.setQuantityOrder(transactionHistory.getQuantityOrder());
			listTransactionHistoryDTO.add(transactionHistoryDTO);
		}
		return listTransactionHistoryDTO;
	}

}
