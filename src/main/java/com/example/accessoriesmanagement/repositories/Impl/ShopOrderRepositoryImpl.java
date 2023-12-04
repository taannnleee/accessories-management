package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.ShopOrder;
import com.example.accessoriesmanagement.repositories.IShopOrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShopOrderRepositoryImpl implements IShopOrderRepository {
    @Override
    public List<ShopOrder> selectShopOrder() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from ShopOrder p";
        TypedQuery<ShopOrder> q = em.createQuery(qString, ShopOrder.class);

        List<ShopOrder> shopOrder;
        try {
            shopOrder = q.getResultList();
            if (shopOrder == null || shopOrder.isEmpty())
                shopOrder = null;
        } finally {
            em.close();
        }
        return shopOrder;
    }

    @Override
    public void insertShopOrder(ShopOrder shopOrder) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(shopOrder);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    @Override
    public ShopOrder getShopOrderById(Long shopOrderId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(ShopOrder.class, shopOrderId);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(ShopOrder shopOrder) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(shopOrder);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public void delete(ShopOrder shopOrder) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(shopOrder));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void deleteShopOrderById(Long shopOrderId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            // Tìm Product cần xóa bằng id trước khi thực hiện xóa
            ShopOrder shopOrder = em.find(ShopOrder.class, shopOrderId);

            if (shopOrder != null) {
                //product.getProduct_category().getProducts().remove(product);
                //product.setProduct_category(null);// Xóa liên kết ngược lại với Category

                em.remove(shopOrder);
                trans.commit();
            } else {
                // Nếu không tìm thấy Product có id tương ứng
                System.out.println("Không tìm thấy ShopOrder để xóa");
            }
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
