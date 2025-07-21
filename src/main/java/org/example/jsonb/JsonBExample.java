package org.example.jsonb;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.example.model.Product;

import java.util.logging.Logger;

public class JsonBExample {
    static Logger logger = Logger.getLogger(JsonBExample.class.getName());

    public static void print(){
        Product p = new Product();
        p.setName("Forest Honey");
        p.setPrice(15.99);
        p.setDescription("Raw organic forest honey.");
        p.setImagePath("/images/honey.jpg");

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(p);
        logger.info("JSON Output:\n" + json);

    }
}
