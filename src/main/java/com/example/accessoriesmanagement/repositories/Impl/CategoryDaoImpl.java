package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.ProductCategory;
import com.example.accessoriesmanagement.repositories.ICategoryDao;
import jdk.jfr.Category;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {

    public List<ProductCategory> getAllCategory() {
        EntityManager em = new DBUtil().getEmFactory().createEntityManager();
        String jpql = "SELECT c FROM ProductCategory c";
        try {
            TypedQuery<ProductCategory> query = em.createQuery(jpql, ProductCategory.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Long getCateIDByProductID(Long id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT p.product_category.productCategoryID FROM Product p WHERE p.productID = :productID";
        try {
            Query query = em.createQuery(jpql);
            query.setParameter("productID", id);

            // Retrieve the result of the query
            Long categoryId = (Long) query.getSingleResult();

            return categoryId;
        } finally {
            em.close();
        }
    }


}
