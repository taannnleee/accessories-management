package com.example.accessoriesmanagement.repositories;

import com.example.accessoriesmanagement.JPAConfig.DBUtil;
import com.example.accessoriesmanagement.entity.User;
import com.example.accessoriesmanagement.repositories.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.*;
import java.util.Date;


public class UserRepositoryImpl implements IUserRepository {
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
}
