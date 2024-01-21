/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restm;

import jakarta.persistence.*;//es un mapeador va con el @Entity
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jacqueline
 */

@Entity
@Table(name="users") //LAS TABLAS EN PLURAL
@XmlRootElement
public class User {//SIEMPRE TIENE QUE TENER UN ID
    @Id // esto ya da por hecho que es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//esto es para la autoincremento del ID
    private int id;
    
    @Column(name="nombre")//por si en la bbdd la columna se llama nombre
    private String name;
    @Column(name="rol")
    private String rol;
    @Column(name="yearB")
    private int yearB;

    public User() { //siempre un constructor vacio para el ORM
    }

    public User(int id, String name, String rol, int yearB) {
        this.id = id;
        this.name = name;
        this.rol = rol;
        this.yearB = yearB;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", rol=" + rol + ", yearB=" + yearB + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getYearB() {
        return yearB;
    }

    public void setYearB(int yearB) {
        this.yearB = yearB;
    }

   
    
}
