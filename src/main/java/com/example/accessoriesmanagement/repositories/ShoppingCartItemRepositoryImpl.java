package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.repositories.IShoppingCartItemRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShoppingCartItemRepositoryImpl implements IShoppingCartItemRepository {
    @Override
    public List<ShoppingCartItem> selectShoppingCartItem() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from ShoppingCartItem p";
        TypedQuery<ShoppingCartItem> q = em.createQuery(qString, ShoppingCartItem.class);

        List<ShoppingCartItem> shoppingCartItems;
        try {
            shoppingCartItems = q.getResultList();
            if (shoppingCartItems == null || shoppingCartItems.isEmpty())
                shoppingCartItems = null;
        } finally {
            em.close();
        }
        return shoppingCartItems;
    }

    @Override
    public void insertShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(shoppingCartItem);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    @Override
    public ShoppingCartItem getShoppingCartItemById(Long shoppingCartItemId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(ShoppingCartItem.class, shoppingCartItemId);
        } finally {
            em.close();
        }
    }

    @Override
    public void updateShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(shoppingCartItem);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public void deleteShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(shoppingCartItem));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
