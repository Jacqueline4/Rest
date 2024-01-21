package com.mycompany.restm;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jacqueline
 */
@Path("/users")
public class UserService {

    @GET
    @Path("/getUsersXml")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsers() {
        UserController uc = new UserController();
        List<User> l = uc.getAllUsers();
        return l;
    }

    @GET
    @Path("/getUsersByIdXml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsersById(@PathParam("id") int userId) {
        UserController uc = new UserController();
        List<User> l = uc.getUsersById(userId);
        return l;
    }

    @GET
    @Path("/getUsersByYearXml/{yearB}")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsersByYear(@PathParam("yearB") int yearB) {
        UserController uc = new UserController();
        List<User> l = uc.getUsersByYear(yearB);
        return l;
    }

//    @POST
//    @Consumes("resources/users")
//    public Response crearUser(@FormParam("user")User user, 
//            @FormParam("id")int id, @FormParam("name") String name,
//            @FormParam("rol") String rol, @FormParam("yearBirth") int yearBirth) {
//        //insert into User values(1, "Alex", "Eljefe", 1993);
//
//        return null;
//    }
//    @POST
//    @Consumes("resources/users")
//    public void crearUser(User u) {
//        
//
//    }
    @POST
    @Path("/createXML")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public List<User> createUser(List<User> lu) {
        List<User> r = new ArrayList<>();
        try (UserController uc = new UserController()) {
            for (User user : lu) {
                if (uc.inserUser(user)) {
                    r.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    @POST
    @Path("/createJSON")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> createUserJSON(List<User> lu) {
        List<User> r = new ArrayList<>();
        try (UserController uc = new UserController()) {
            for (User user : lu) {
                if (uc.inserUser(user)) {
                    r.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    @GET
    @Path("/getUsersJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersJson() {
        UserController uc = new UserController();
        List<User> l = uc.getAllUsers();
        return l;
    }
    @GET
    @Path("/getUsersByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersByIdJson(@PathParam("id") int userId) {
        UserController uc = new UserController();
        List<User> l = uc.getUsersById(userId);
        return l;
    }

    @GET
    @Path("/getUsersByYearJson/{yearB}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersByYearJson(@PathParam("yearB") int yearB) {
        UserController uc = new UserController();
        List<User> l = uc.getUsersByYear(yearB);
        return l;
    }
}
