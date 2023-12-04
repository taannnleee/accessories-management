package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.ShopOrder;
import com.example.accessoriesmanagement.entity.ShoppingCart;
import com.example.accessoriesmanagement.entity.ShoppingCartItem;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IShopCartDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShopCartImpl implements IShopCartDao {
    public void deleteShoppingCartByUserId(Long userId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();

            // Tìm User dựa trên user_id
            User user = em.find(User.class, userId);

            if (user != null) {
                // Lấy ShoppingCart từ thuộc tính shoppingCart của User
                ShoppingCart shoppingCart = user.getShoppingCart();

                if (shoppingCart != null) {
                    // Xóa tất cả các ShoppingCartItem thuộc ShoppingCart
                    List<ShoppingCartItem> shoppingCartItems = shoppingCart.getShoppingCartItems();
                    for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
                        em.remove(shoppingCartItem);
                    }

                    // Xóa ShoppingCart
                    em.remove(shoppingCart);
                    trans.commit();
                } else {
                    System.out.println("Không tìm thấy ShoppingCart để xóa cho user_id: " + userId);
                }
            } else {
                // Nếu không tìm thấy User có user_id tương ứng
                System.out.println("Không tìm thấy User để xóa ShoppingCart cho user_id: " + userId);
            }
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public List<ShopOrder> getAllShopOrders() {
        EntityManager em = new DBUtil().getEmFactory().createEntityManager();
        String jpql = "SELECT s FROM ShopOrder s";
        try {
            TypedQuery<ShopOrder> query = em.createQuery(jpql, ShopOrder.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
