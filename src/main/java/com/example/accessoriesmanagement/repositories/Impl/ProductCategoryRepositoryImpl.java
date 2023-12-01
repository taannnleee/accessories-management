package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;
import com.example.accessoriesmanagement.repositories.IProductCategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductCategoryRepositoryImpl implements IProductCategoryRepository {
    @Override
    public List<ProductCategory> selectProductCategory() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from ProductCategory p";
        TypedQuery<ProductCategory> q = em.createQuery(qString, ProductCategory.class);

        List<ProductCategory> productCategories;
        try {
            productCategories = q.getResultList();
            if (productCategories == null || productCategories.isEmpty())
                productCategories = null;
        } finally {
            em.close();
        }
        return productCategories;
    }

    @Override
    public ProductCategory getProductCategoryById(Long productCategoryId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(ProductCategory.class, productCategoryId);
        } finally {
            em.close();
        }
    }
    @Override
    public void insertProductCategory(ProductCategory productCategory) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(productCategory);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
