package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class convert {
    public static void main(String[] args) throws Exception {
        Rule rule = new Rule();
        rule.setRuleName("Enable 'aaa authentication login'");
        rule.setRuleCategory("Automated");
        rule.setRuleAutoRemediation("Configure AAA authentication method(s) for login authentication.");

        // ObjectMapper to convert the object to JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Enable custom property naming strategy
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        // Convert Rule object to JSON string
        String jsonString = objectMapper.writeValueAsString(rule);
        String updatedjsonString = jsonString.replace("_", ".");

        // Print JSON output
        System.out.println(updatedjsonString);
        // Write JSON string to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("temp.json"))) {
            writer.write(updatedjsonString);
            System.out.println("JSON string written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


