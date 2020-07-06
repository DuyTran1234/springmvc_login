package com.project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductDao;
import com.project.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().merge(product);
	}

	public void deleteProduct(int id) {
		sessionFactory.getCurrentSession().delete(this.getProductById(id));
	}

	public Product getProductById(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		String hql = "FROM Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
