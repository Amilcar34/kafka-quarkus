package org.acme.kafka.processor;

import java.util.Random;

import jakarta.enterprise.context.ApplicationScoped;

import org.acme.kafka.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Blocking;

/**
 * A bean consuming data from the "quote-requests" Kafka topic (mapped to "requests" channel) and giving out a random quote.
 * The result is pushed to the "quotes" Kafka topic.
 */
@ApplicationScoped
public class QuotesProcessor {

    private Random random = new Random();

    @Incoming("requests") //Indica que el método consume los elementos del canal de requests.
    @Outgoing("quotes")//Indica que los objetos devueltos por el método se envían al canal de quotes.
    @Blocking //Indica que el procesamiento está bloqueando, no puede ser ejecutado en el hilo de la llamada.
    public Quote process(String quoteRequest) throws InterruptedException {
        // simulate some hard working task
    	System.out.println(quoteRequest);
        Thread.sleep(200);
        Quote quote = new Quote(quoteRequest, random.nextInt(100));
        
        System.out.println(quote);
		return quote;
    }
}