package org.jzandag.web.JaxRsApp.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.jzandag.web.JaxRsApp.model.User;
import org.jzandag.web.JaxRsApp.service.UserService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	public UserService service = UserService.getInstance();
	
	@GET
	@Path("/{userId}")
	public Response getUser(@PathParam("userId") Long id) {
		User user = service.getUser(id);
		
		return Response.ok()
				.entity(user)
				.build();
	}
	
	@GET
	public Response getUsers() {
		GenericEntity<List<User>> users = new GenericEntity<List<User>>(service.getUsers()) {};
		
		return Response.ok()
				.entity(users)
				.build();
	}
	
	@POST
	public Response saveUser(User user, @Context UriInfo uriInfo) {
		User newUser = service.saveUser(user);
		return Response
				.created(uriInfo.getAbsolutePathBuilder()
						.path(String.valueOf(newUser.getId()))
						.build())
				.build();
	}
	
	@PUT
	@Path("/{userId}")
	public Response updateUser(@PathParam("userId") Long id, User user) {
		User updatedUser = service.updateUser(id, user);
		return Response.status(Status.ACCEPTED)
				.entity(updatedUser)
				.build();
	}
	
	@DELETE
	@Path("/{userId}")
	public Response deleteUser(@PathParam("userId") Long id) {
		service.deleteUser(id);
		return Response.noContent()
				.build();
	}
}
