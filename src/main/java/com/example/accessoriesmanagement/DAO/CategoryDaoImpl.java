package com.example.accessoriesmanagement.DAO;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;
import jdk.jfr.Category;

import javax.persistence.EntityManager;
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

}