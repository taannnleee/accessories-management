package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IShoppingCartRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShoppingCartRepositoryImpl implements IShoppingCartRepository {
    @Override
    public List<ShoppingCart> selectShoppingCart() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from ShoppingCart p";
        TypedQuery<ShoppingCart> q = em.createQuery(qString, ShoppingCart.class);

        List<ShoppingCart> shoppingCarts;
        try {
            shoppingCarts = q.getResultList();
            if (shoppingCarts == null || shoppingCarts.isEmpty())
                shoppingCarts = null;
        } finally {
            em.close();
        }
        return shoppingCarts;
    }

    @Override
    public void insertShoppingCart(ShoppingCart shoppingCart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(shoppingCart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    @Override
    public ShoppingCart getShoppingCartById(Long shoppingCartId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(ShoppingCart.class, shoppingCartId);
        } finally {
            em.close();
        }
    }

    @Override
    public void updateShoppingCart(ShoppingCart shoppingCart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(shoppingCart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public void deleteShoppingCart(ShoppingCart shoppingCart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(shoppingCart));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public ShoppingCart getShoppingCartByUser(User user) {
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<ShoppingCart> query = entityManager.createQuery(
                "SELECT s FROM ShoppingCart s WHERE s.user = :user", ShoppingCart.class);
        query.setParameter("user", user);

        ShoppingCart shoppingCart = null;
        try {
            shoppingCart = query.getSingleResult();
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu không tìm thấy giỏ hàng nào cho người dùng
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return shoppingCart;
    }

}
