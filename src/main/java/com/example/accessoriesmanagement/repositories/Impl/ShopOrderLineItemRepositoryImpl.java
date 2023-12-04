package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ShopOrderLineItem;
import com.example.accessoriesmanagement.repositories.IShopOrderLineItemRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShopOrderLineItemRepositoryImpl implements IShopOrderLineItemRepository {
    @Override
    public List<ShopOrderLineItem> selectShopOrderLineItem() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from ShopOrderLineItem p";
        TypedQuery<ShopOrderLineItem> q = em.createQuery(qString, ShopOrderLineItem.class);

        List<ShopOrderLineItem> shopOrderLineItems;
        try {
            shopOrderLineItems = q.getResultList();
            if (shopOrderLineItems == null || shopOrderLineItems.isEmpty())
                shopOrderLineItems = null;
        } finally {
            em.close();
        }
        return shopOrderLineItems;
    }

    @Override
    public void insertShopOrderLineItem(ShopOrderLineItem shopOrderLineItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(shopOrderLineItem);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public ShopOrderLineItem getShopOrderLineItemById(Long shopOrderLineItemId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(ShopOrderLineItem.class, shopOrderLineItemId);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(ShopOrderLineItem shopOrderLineItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(shopOrderLineItem);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public void delete(ShopOrderLineItem shopOrderLineItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(shopOrderLineItem));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteShopOrderLineItemById(Long shopOrderLineItemId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            // Tìm Product cần xóa bằng id trước khi thực hiện xóa
            ShopOrderLineItem shopOrderLineItem = em.find(ShopOrderLineItem.class, shopOrderLineItemId);

            if (shopOrderLineItem != null) {
                //shopOrderLineItem.getProduct_category().getProducts().remove(product);
                //product.setProduct_category(null);// Xóa liên kết ngược lại với Category

                em.remove(shopOrderLineItem);
                trans.commit();
            } else {
                // Nếu không tìm thấy Product có id tương ứng
                System.out.println("Không tìm thấy ShopOrderLineItem để xóa");
            }
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
