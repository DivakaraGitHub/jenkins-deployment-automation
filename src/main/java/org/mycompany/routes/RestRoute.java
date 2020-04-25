package org.mycompany.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		/*
		 * rest("/{{api.ver}}/say").id("test-route1").description("Test Route POST API")
		 * .consumes("application/json") .produces("application/json").post("/bye").
		 * description("Post supplier purchase orders status")
		 * .outType(Json.class).type(Json.class).to("direct:bye");
		 * 
		 * from("direct:bye").log("I am here").transform().constant("Bye World");
		 */

	}

}
