package com.example.helloworld.resource;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.models.Saying;
import com.google.inject.Inject;
import com.sun.jersey.api.core.HttpRequestContext;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

	private final String template;
	private final String defaultName;
	private final HttpHeaders headers;

	@Inject
	private HttpRequestContext ctx;

	@Inject
	public HelloWorldResource(@Named("template") String template, @Named("defaultName") String defaultName, HttpHeaders headers) {
		this.template = template;
		this.defaultName = defaultName;
		this.headers = headers;
	}

	@GET
	@Timed(absolute=true,name="sayHello")
	public Saying sayHello(@QueryParam("name") com.google.common.base.Optional<String> name) {
		return new Saying("hello");
	}
}
