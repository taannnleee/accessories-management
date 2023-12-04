package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.repositories.IShoppingCartItemRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
    public ShoppingCartItem updateShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        ShoppingCartItem updatedItem = null;

        try {
            trans.begin();
            updatedItem = em.merge(shoppingCartItem);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }

        return updatedItem;
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

    @Override
    public List<ShoppingCartItem> selectShoppingCartItemByShoppingCart(ShoppingCart shoppingCart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        String qString = "SELECT sci FROM ShoppingCartItem sci WHERE sci.shopping_cart = :shoppingCart";
        TypedQuery<ShoppingCartItem> q = em.createQuery(qString, ShoppingCartItem.class);
        q.setParameter("shoppingCart", shoppingCart);

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
    public void deleteShoppingCartItemById(Long shoppingCartId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            // Tìm Product cần xóa bằng id trước khi thực hiện xóa
            ShoppingCartItem shoppingCartItem = em.find(ShoppingCartItem.class, shoppingCartId);

            if (shoppingCartItem != null) {
                shoppingCartItem.getShopping_cart().getShoppingCartItems().remove(shoppingCartItem);
                shoppingCartItem.setShopping_cart(null);

                shoppingCartItem.getProduct().getShoppingCartItems().remove(shoppingCartItem);
                shoppingCartItem.setProduct(null);

                em.remove(shoppingCartItem);
                trans.commit();
            } else {
                // Nếu không tìm thấy Product có id tương ứng
                System.out.println("Không tìm thấy ShoppingCartItem để xóa");
            }
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }


}
