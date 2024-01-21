/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restm;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author jacqueline
 */
public class UserController implements UserDAO, AutoCloseable {

    public boolean inserUser(User u) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(u);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
            return false;
        }
    }

//    public void deleteUser(int id) {
//        Transaction tx = null;
//        try (Session session = HibernateUtil.getFactory().openSession()) {
//            tx = session.beginTransaction();
//            //esto estaria mal
////           User st= new User();
////           st.setId(studentId);
////           session.remove(st);
////            tx.commit();
//            User st = session.get(User.class, id); // esto es un select
//            if (st != null) {
//                session.remove(st);
//            }
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            System.err.println(e);
//        }
//    }
//
//    @Override //sobrecargar
//    public void deleteUser(User st) {
//        Transaction tx = null;
//        try (Session session = HibernateUtil.getFactory().openSession()) {
//            tx = session.beginTransaction();
//            if (st.getId() != 0) {
//                session.remove(st);
//            }
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            System.err.println(e);
//        }
//    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User", User.class);
            return query.list();// es lo mismo que .getResultList
        } catch (Exception e) {
            System.err.println(e);
            return new ArrayList<>();
        }
    }

//    public void updateUser(User u) {
//
//        Transaction tx = null;
//        try (Session session = HibernateUtil.getFactory().openSession()) {
//            tx = session.beginTransaction();
//            if (u.getId() != 0) {
//                session.merge(u);
//            }
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            System.err.println(e);
//        }
//    }

//    @Override
//    public List<User> getUserByName(String name) {
//        try (Session session = HibernateUtil.getFactory().openSession()) {//:value no hace falta que sea value, puede ser lo que sea siempre que sea unico (no se puede repetir) ya que ese value se reemplaza por el nombre
//            Query<User> query = session.createQuery("FROM User where name= :valueName ", User.class);
//            query.setParameter("valueName", name);//aqui se sustituye ese lo que esta despues de : por nombre;
//            return query.getResultList();// hace lo mismo query.list()
//        } catch (Exception e) {
//            System.err.println(e);
//            return null;
//
//        }
//    }
       @Override
    public List<User> getUsersById(int id) {
        try (Session session = HibernateUtil.getFactory().openSession()) {//:value no hace falta que sea value, puede ser lo que sea siempre que sea unico (no se puede repetir) ya que ese value se reemplaza por el nombre
            Query<User> query = session.createQuery("FROM User where id= :valueName ", User.class);
            query.setParameter("valueName", id);//aqui se sustituye ese lo que esta despues de : por nombre;
            return query.getResultList();// hace lo mismo query.list()
        } catch (Exception e) {
            System.err.println(e);
            return null;

        }
    }
       @Override
    public List<User> getUsersByYear(int yearB) {
        try (Session session = HibernateUtil.getFactory().openSession()) {//:value no hace falta que sea value, puede ser lo que sea siempre que sea unico (no se puede repetir) ya que ese value se reemplaza por el nombre
            Query<User> query = session.createQuery("FROM User where yearB= :valueName ", User.class);
            query.setParameter("valueName", yearB);//aqui se sustituye ese lo que esta despues de : por nombre;
            return query.getResultList();// hace lo mismo query.list()
        } catch (Exception e) {
            System.err.println(e);
            return null;

        }
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
