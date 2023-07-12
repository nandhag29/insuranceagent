package ChatBot;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChatBotLogic {
    private LocalTime time = LocalTime.now();
    private LocalDate date = LocalDate.now();
    private Random random = new Random();
    private Map<String, String> responses;

    public ChatBotLogic() {
        responses = new HashMap<>();
        initializeResponses();
    }

    private void initializeResponses() {
        //General
        responses.put("how are you", getResponse("I'm fine, thanks for asking! How can I assist you?",
                "I am good, thanks for asking! How can I assist you?", "I am great, thanks for asking! How can I help you?"));
        responses.put("hi", getResponse("Hello, how can I assist you?", "Hi, how can I assist you?", "Hi, how can I help you?", "Hello, how can I assist you?"));
        responses.put("hello", getResponse("Hello, how can I assist you?", "Hi, how can I assist you?", "Hi, how can I help you?", "Hello, how can I assist you?"));
        responses.put("hey", getResponse("Hello, how can I assist you?", "Hi, how can I assist you?", "Hi, how can I help you?", "Hello, how can I assist you?"));



        responses.put("good morning", "Good morning, how can I help you?");
        responses.put("good night", "Have a good night!");
        responses.put("good evening", "Good evening, how can I help you?");
        responses.put("good noon", "Good afternoon, how can I help you?");
        responses.put("good afternoon", "Good afternoon, how can I help you?");
        responses.put("thank", "Glad I could help! See you on " + getDateString() + " at " + getTimeString() + ". ");
        responses.put("sounds good", "Glad I could help! See you on " + getDateString() + " at " + getTimeString() + ". ");
        responses.put("bye", "Goodbye!");




        responses.put("ye", "Great, how would " + getDateString() + " at " + getTimeString() + " work for you? Say 'works' if it does.");
        responses.put("ok", "Great, how would " + getDateString() + " at " + getTimeString() + " work for you? Say 'works' if it does.");
        responses.put("no", "Hey, real quick, before I go; how many employees do you have? Enter the number only.");
        responses.put("work", "And your address is 1234 Springfield Lane, correct? Say 'correct' if it is.");
        responses.put("correct", "By the way, how many employees do you have?");





    }

    /*
    public String generateResponse(String message) {
            if (message.toLowerCase().contains("ye") || message.toLowerCase().contains("sure") || message.toLowerCase().contains("maybe") || message.toLowerCase().contains("ok")) {
                ChatBotGUI.bot("Great, how would " + getDateString() + " at " + getTimeString() + " work for you?");


            } else if (message.toLowerCase().contains("no") || message.toLowerCase().contains("nah") || message.toLowerCase().contains("not")) {
                ChatBotGUI.bot("Hey, real quick, before I go; how many employees do you have?");
                int number = getIntInput(message);
                ChatBotGUI.bot(number);
                ChatBotGUI.bot("Some of the companies I work with tell me that they are saving anywhere from $500 to $1,000 dollars per employee, per year. In your case, high-end, that would be about $" + number * 1000 + " dollars; is that even a big number to you?");
                        if (message.toLowerCase().contains("ye") || message.toLowerCase().contains("sure") || message.toLowerCase().contains("maybe") || message.toLowerCase().contains("ok")){
                    } else if (message.toLowerCase().contains("no") || message.toLowerCase().contains("nah") || message.toLowerCase().contains("not")) {
                        ChatBotGUI.bot("Alright, have a good day! Let me know if you are interested in the future.");
                    }
            }

            else {
                ChatBotGUI.bot("I'm sorry, I do not understand. Please try answering again.");
            }



       for (String key : responses.keySet()) {

            if (message.toLowerCase().contains(key.toLowerCase())) {
                return responses.get(key);
            }
        }

        return getRandomResponse();
}
        */

    public String generateResponse(String message) {
        for (String key : responses.keySet()) {
            if (message.toLowerCase().contains(key.toLowerCase())) {
                return responses.get(key);
            }
        }

        try {
            int number = Integer.parseInt(message);

            return("Some of the companies I work with tell me that they are saving anywhere from $500 to $1,000 dollars per employee, per year. In your case, high-end, that would be about $" + number * 1000 + " dollars.");
        } catch (NumberFormatException e) {

        }

        return getRandomResponse();
    }


    private void bot(String s) {
    }
    private int getIntInput(String message) {
        try {
            return Integer.parseInt(message);
        } catch (NumberFormatException e) {
            return -1; // Return a default value or handle the error case appropriately
        }
    }

    private String getRandomResponse() {
        int num = random.nextInt(3);
        if (num == 0) {
            return "Sorry, I can't understand you!";
        } else if (num == 1) {
            return "Sorry, I don't understand";
        } else {
            return "My apologies... I don't understand";
        }
    }

    private String getResponse(String... options) {
        int randomIndex = random.nextInt(options.length);
        return options[randomIndex];
    }

    private String getTimeString() {
        String ctime = "";
        if (time.getHour() > 12) {
            int hour = time.getHour() - 12;
            ctime = ctime + hour + ":00" + " PM";
        } else {
            ctime = ctime + time.getHour() + ":00 "+ "AM";
        }
        return ctime;
    }

    private String getDateString() {
        String cdate = "";
        cdate = cdate + capitalizeFirstLetter(date.getDayOfWeek().toString()) + ", " + date.getDayOfMonth() + " " +
                capitalizeFirstLetter(date.getMonth().toString().toLowerCase()) + " " + date.getYear();
        return cdate;
    }

    private String capitalizeFirstLetter(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }



}
