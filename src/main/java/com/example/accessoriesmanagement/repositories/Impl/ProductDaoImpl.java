package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ProductCategory;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IProductDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import javax.persistence.*;

public class ProductDaoImpl implements IProductDao {


    public static void insertProduct(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public User selectUser(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.email = :email";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

//    public static boolean emailExists(String email) {
//        User u = selectUser(email);
//        return u != null;
//    }

    public static List<User> selectUsers() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from User u";
        TypedQuery<User> q = em.createQuery(qString, User.class);

        List<User> users;
        try {
            users = q.getResultList();
            if (users == null || users.isEmpty())
                users = null;
        } finally {
            em.close();
        }
        return users;
    }

    public List<Product> getAllProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        String jpql = "SELECT p FROM Product p";

        try {
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    public List<Product> get8Last() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Product u where 1=1 ";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        try {
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Product> get4NikeLast() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT p FROM Product p WHERE p.product_category.productCategoryID = :categoryId ORDER BY p.productID DESC";
        try {
            Query query = em.createQuery(jpql, Product.class);
            query.setParameter("categoryId", 2L);
            query.setMaxResults(4);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Product> get4AdidasLast() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT p FROM Product p WHERE p.product_category.productCategoryID = :categoryId ORDER BY p.productID DESC";
        try {
            Query query = em.createQuery(jpql, Product.class);
            query.setParameter("categoryId", 1L);
            query.setMaxResults(4);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Product> get4PumaLast() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT p FROM Product p WHERE p.product_category.productCategoryID = :categoryId ORDER BY p.productID DESC";
        try {
            Query query = em.createQuery(jpql, Product.class);
            query.setParameter("categoryId", 3L);
            query.setMaxResults(4);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    public List<Product> get4AnanasLast() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT p FROM Product p WHERE p.product_category.productCategoryID = :categoryId ORDER BY p.productID DESC";
        try {
            Query query = em.createQuery(jpql, Product.class);
            query.setParameter("categoryId", 4L);
            query.setMaxResults(4);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public long countAllProduct() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT COUNT(p) FROM Product p";
        try {
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Product> getProductByIndex(int indexPage) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT p FROM Product p ORDER BY p.productID";
        try {
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
            query.setFirstResult((indexPage - 1) * 9);
            query.setMaxResults(9);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
