package com.example.accessoriesmanagement.repositories.Impl;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.repositories.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> selectProduct() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Product p";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> products;
        try {
            products = q.getResultList();
            if (products == null || products.isEmpty())
                products = null;
        } finally {
            em.close();
        }
        return products;
    }

    @Override
    public void insertProduct(Product product) {
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
    @Override
    public Product getProductById(Long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(Product.class, productId);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void deleteProductById(Long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            // Tìm Product cần xóa bằng id trước khi thực hiện xóa
            Product product = em.find(Product.class, productId);

            if (product != null) {
                product.getProduct_category().getProducts().remove(product);
                product.setProduct_category(null);// Xóa liên kết ngược lại với Category

                em.remove(product);
                trans.commit();
            } else {
                // Nếu không tìm thấy Product có id tương ứng
                System.out.println("Không tìm thấy Product để xóa");
            }
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }



}
