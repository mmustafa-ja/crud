package com.crud.crudjava;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("users")
public class MyResource {

	
	
	CRUDrepo userrepo=new CRUDrepo();
	
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Users> getUsers() {
        System.out.println("GetUsers called.");
        return userrepo.getUsers();
    }
    @GET
    @Path("alien/{score}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Users getUser(@PathParam("int")int score) {
    	return userrepo.getUser(score);
    }
    
    @Path("users")
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Users createUser(Users user) {
    	System.out.println(user);
    	userrepo.create(user);
    	return user;
    }
    @Path("users")
    @PUT
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Users UpdateUser(Users user) {
    	System.out.println(user);
    	if(userrepo.getUser(user.getScore()).getScore()==0) {
    		userrepo.create(user);
    	}else {
    		userrepo.update(user);
    	}
    	return user;	
    	
    }
    @Path("users/{score}")
    @DELETE
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Users DeleteUser(@PathParam("score")int score) {
		Users u=userrepo.getUser(score);
		if(u.getScore()!=0)
		userrepo.delete(u);
		
		return u;
		
    	
    	return null;
    	
    }
}
