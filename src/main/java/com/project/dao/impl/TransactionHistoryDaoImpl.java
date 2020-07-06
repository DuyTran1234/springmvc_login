package com.project.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.TransactionHistoryDao;
import com.project.entity.TransactionHistory;

@Repository
@Transactional
public class TransactionHistoryDaoImpl implements TransactionHistoryDao  {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addTransactionHistory(TransactionHistory transactionHistory) {
		sessionFactory.getCurrentSession().save(transactionHistory);
	}

	public void updateTransactionHistory(TransactionHistory transactionHistory) {
		sessionFactory.getCurrentSession().merge(transactionHistory);
	}

	public void deleteTransactionHistory(String id) {
		sessionFactory.getCurrentSession().delete(this.getTransactionHistoryById(id));
	}

	public TransactionHistory getTransactionHistoryById(String id) {
		return (TransactionHistory) sessionFactory.getCurrentSession().get(TransactionHistory.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TransactionHistory> getTransactionHistoryByUserId(int id) {
		String hql = "FROM TransactionHistory WHERE userId = :userId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userId", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<TransactionHistory> getTransactionHistoryByProductId(int id) {
		String hql = "FROM TransactionHistory WHERE productId = :productId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("productId", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<TransactionHistory> getAllTransactionHistory() {
		String hql = "FROM TransactionHistory";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
