package org.example.jms;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;
import org.example.model.Product;

import java.util.logging.Logger;

@ApplicationScoped
public class ProductMessageProducer {
    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private JMSContext jmsContext;

    @Resource(lookup = "jms/ProductQueue")
    private Queue queue;

    public void sendProductCreated(Product product) {
        String message = "New Product Created: " + product.getName() + " - $" + product.getPrice();
        jmsContext.createProducer().send(queue, message);
       logger.info("[JMS] Sent: " + message);
    }
}
