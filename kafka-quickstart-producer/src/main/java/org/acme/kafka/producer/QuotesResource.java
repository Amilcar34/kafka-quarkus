package org.acme.kafka.producer;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.acme.kafka.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.reactive.RestSseElementType;
import org.jboss.resteasy.reactive.RestStreamElementType;
import org.reactivestreams.Publisher;

//import io.reactivex.Flowable;
import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/quotes")
public class QuotesResource {

	@Channel("quote-requests")
	Emitter<String> quoteRequestEmitter;

	@Channel("quotes")
	Multi<Quote> quotes;

	/**
	 * Endpoint to generate a new quote request id and send it to "quote-requests"
	 * Kafka topic using the emitter.
	 */
	@POST
	@Path("/request")
	@Produces(MediaType.TEXT_PLAIN)
	public String createRequest() {
		UUID uuid = UUID.randomUUID();
		quoteRequestEmitter.send(uuid.toString());
		System.out.println(uuid);
		return uuid.toString();
	}

	/**
	 * Endpoint retrieving the "quotes" Kafka topic and sending the items to a
	 * server sent event.
	 */
	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public Multi<Quote> stream() {
		System.out.println("stream");
		System.out.println(quotes);
		return quotes;
	}
	
}