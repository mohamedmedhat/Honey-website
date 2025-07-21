package org.example.jms;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

import java.util.logging.Logger;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/productQueue"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
        }
)
public class ProductMessageConsumer implements MessageListener {

    private static final Logger logger = Logger.getLogger(ProductMessageConsumer.class.getName());

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage textMessage) {
                String body = textMessage.getText();
                logger.info("[JMS] Received: " + body);
            }
        } catch (Exception e) {
            logger.severe("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
