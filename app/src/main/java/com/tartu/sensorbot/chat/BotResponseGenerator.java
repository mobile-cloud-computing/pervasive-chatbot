package com.tartu.sensorbot.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BotResponseGenerator {

    private final String condition;

    public BotResponseGenerator(String condition) {
        this.condition = condition;
    }

    public List<Message> generateResponse(String userQuery) {
        List<Message> responses = new ArrayList<>();
        responses.add(new Message("Sure! Here are some suggestions on how you can do that", true));
        responses.add(generateStepsAndTimes(userQuery));
        responses.add(new Message("Will that be all?", true));
        return responses;
    }

    private Message generateStepsAndTimes(String userQuery) {
        if (Objects.equals(condition, ChatbotCondition.pervasive)) {
            return generatePCStepsAndTimes(userQuery);
        }
        return generateRCStepsAndTimes(userQuery);
    }

    // pervasive chatbot
    private Message generatePCStepsAndTimes(String userQuery) {
        if (userQuery.toLowerCase().contains("how to save energy")) {
            String[] steps = new String[] {
                    "Close all the apps",
                    "Activate saving mode",
                    "Migrate computation to your friends or surrounding devices?"
            };
            String[] times = new String[] {"2 min", "2 min", "6 min"};
            return new Message(steps, times);
        }
        return new Message("Thanks", true);
    }

    // reference chatbot
    private Message generateRCStepsAndTimes(String userQuery) {
        if (userQuery.toLowerCase().contains("how to save energy")) {
            String[] steps = new String[] {
                    "Close all apps",
                    "Activate battery saving mode",
                    "Migrate computation to your friends or surrounding devices?",
                    "Step 1: Make sure you are connected to the same network with the other device by switching on your bluetooth\n\n" +
                            "Step 2: Search for the device that's within a range\n\n " +
                            "Step 3: Select the device you want to migrate computation to \n\n " +
                            "Step 4: Navigate to your process manager and select the process you want to migrate to\n\n"
            };
            String[] times = new String[] {"2 min", "2 min", "6 min"};
            return new Message(steps, times);
        }
        return new Message("Thanks", true);
    }

}