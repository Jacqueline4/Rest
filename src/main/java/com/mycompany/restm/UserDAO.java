/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restm;

import java.util.List;

/**
 *
 * @author jacqueline
 */
public interface UserDAO {

    boolean insertUser(User u);

    List<User> getAllUsers();

    public List<User> getUsersByYear(int yearB);

    public List<User> getUsersById(int id);

}
