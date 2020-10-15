package org.jzandag.web.JaxRsApp.errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoSuchResourceMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		
		return Response.status(Status.NOT_FOUND).entity("Resource not found!!!").build();
	}
	
}
