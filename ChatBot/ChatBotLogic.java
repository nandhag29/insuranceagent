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
        responses.put("thank", getResponse("You are very welcome!", "My pleasure!", "Of course! Happy to help!"));

        //Scheduling
        responses.put("time", getTimeString());
        responses.put("date", getDateString());
        responses.put("month", getDateString());
        responses.put("year", getDateString());
        responses.put("day", getDateString());

    }

    public String generateResponse(String message) {
        for (String key : responses.keySet()) {
            if (message.toLowerCase().contains(key.toLowerCase())) {
                return responses.get(key);
            }
        }

        return getRandomResponse();
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
            ctime = ctime + hour + ":" + time.getMinute() + ":" + time.getSecond() + " PM";
        } else {
            ctime = ctime + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " AM";
        }
        return ctime;
    }

    private String getDateString() {
        String cdate = "";
        cdate = cdate + date.getDayOfWeek() + "," + date.getDayOfMonth() + " " + date.getMonth() + " "
                + date.getYear();
        return cdate;
    }
}
