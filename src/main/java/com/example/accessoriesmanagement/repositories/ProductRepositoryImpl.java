package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> selectProduct() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Product p";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> products;
        try {
            products = q.getResultList();
            if (products == null || products.isEmpty())
                products = null;
        } finally {
            em.close();
        }
        return products;
    }


}
