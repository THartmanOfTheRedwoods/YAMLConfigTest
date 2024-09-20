package edu.redwoods.cis18.jackson.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;


public class MyApp {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try {
            Order order = mapper.readValue(
                    MyApp.class.getClassLoader().getResourceAsStream("orderInput.yaml"),
                    Order.class);

            System.out.println(order);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
