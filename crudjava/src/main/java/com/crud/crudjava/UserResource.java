package com.crud.crudjava;
import javax.ws.rs.Path;

@Path("users")

public class UserResource {
	public Users getUser() {
		System.out.println("GetUser called.");
		Users u1=new Users();
		u1.setName("Mustafa");
		u1.setScore(30);
		return u1;
	}
}
