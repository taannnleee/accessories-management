package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.ProductCategory;

import javax.persistence.EntityManager;
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
}
