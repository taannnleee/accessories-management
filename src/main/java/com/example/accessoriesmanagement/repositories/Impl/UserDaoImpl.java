package com.example.accessoriesmanagement.repositories.Impl;
import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.Product;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IUserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class UserDaoImpl implements IUserDao {
    public User authenticateUser(String user, String pass) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT a FROM User a " +
                "WHERE a.userName = :user AND a.passWord = :pass";
        try {
            Query query = em.createQuery(jpql, User.class);
            query.setParameter("user", user);
            query.setParameter("pass", pass);

            User a = (User) query.getSingleResult();
            return a;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public void editProfile(Date dateOfBirth, String email, String fName, String lName, String phone,Long userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            String jpql = "UPDATE User u " +
                    "SET u.dateOfBirth = :dateOfBirth, u.email = :email, u.firstName = :fName, u.lastName = :lName, u.phone = :phone " +
                    "WHERE u.userID = :userID";


            Query query = em.createQuery(jpql);
            query.setParameter("dateOfBirth", dateOfBirth);
            query.setParameter("email", email);
            query.setParameter("fName", fName);
            query.setParameter("lName", lName);
            query.setParameter("phone", phone);
            query.setParameter("userID", userID);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }

    public User checkAccountExist(String user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        String jpql = "SELECT a FROM User a " +
                "WHERE a.userName = :user";

        try {
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("user", user);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public void signup(String user, String pass, String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            User account = new User();
            account.setUserName(user);
            account.setPassWord(pass);
            account.setEmail(email);

            em.persist(account);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }

    }
    @Override
    public User getUserById(Long UserId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(User.class, UserId);
        } finally {
            em.close();
        }
    }

    public List<User> getAllAccount() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        String jpql = "SELECT p FROM User p ";

        try {
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteAccount(Long id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            String jpql = "DELETE FROM User a WHERE a.userID = :userID";
            em.createQuery(jpql)
                    .setParameter("userID", id)
                    .executeUpdate();
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
