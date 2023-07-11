package ChatBot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class ChatBotLogic {
    private LocalTime time = LocalTime.now();
    private LocalDate date = LocalDate.now();
    private Random random = new Random();

    public String generateResponse(String message) {
        if (message.contains("how are you")) {
            int num = random.nextInt(3);
            if (num == 0) {
                return "I'm fine! What about you?";
            } else if (num == 1) {
                return "I am good, thanks for asking!";
            } else {
                return "I am great, thanks for asking!";
            }
        } else if (message.contains("you") && (message.contains("smart") || message.contains("good"))) {
            return "Thank you!";
        } else if (message.contains("welcome")) {
            return "You are so polite. How can I help you?";
        } else if (message.contains("hi") && message.charAt(0) == 'h' || message.contains("hello")
                || message.contains("hey")) {
            int num = random.nextInt(4);
            if (num == 0) {
                return "Hii";
            } else if (num == 1) {
                return "Hello";
            } else if (num == 2) {
                return "Heyy";
            } else {
                return "Hello buddy";
            }
        } else if (message.contains("by")) {
            return "Bye, see you soon!";
        } else if (message.contains("i am good") || message.contains("i am great")
                || message.contains("i am ") && message.contains("fine")) {
            return "Good to hear.";
        } else if (message.contains("thank")) {
            int num = random.nextInt(4);
            if (num == 0) {
                return "Welcome..";
            } else if (num == 1) {
                return "My pleasure";
            } else if (num == 2) {
                return "Happy to help";
            } else {
                return "That's why I'm here for..";
            }
        } else if (message.contains("what") && message.contains("name")) {
            if (message.contains("your")) {
                return "I'm Bot...";
            }
            if (message.contains("my")) {
                return "Your name is Ajaysinh";
            }
        } else if (message.contains("change")) {
            return "Sorry, I can't change anything...";
        } else if (message.contains("time")) {
            String ctime = "";
            if (time.getHour() > 12) {
                int hour = time.getHour() - 12;
                ctime = ctime + hour + ":" + time.getMinute() + ":" + time.getSecond() + " PM";
            } else {
                ctime = ctime + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " AM";
            }
            return ctime;
        } else if (message.contains("date") || message.contains("month") || message.contains("year")
                || message.contains("day")) {
            String cdate = "";
            cdate = cdate + date.getDayOfWeek() + "," + date.getDayOfMonth() + " " + date.getMonth() + " "
                    + date.getYear();
            return cdate;
        } else if (message.contains("good morning")) {
            return "Good morning! Have a nice day!";
        } else if (message.contains("good night")) {
            return "Good night! Have nice dreams!";
        } else if (message.contains("good evening")) {
            return "Good evening...!";
        } else if (message.contains("good") && message.contains("noon")) {
            return "Good Afternoon...!";
        } else if (message.contains("clear") && (message.contains("screen") || message.contains("chat"))) {
            return "Wait a few seconds...";
        } else {
            try {
                // Handle other queries or perform a web search
                // ...
            } catch (Exception e) {
                int num = random.nextInt(3);
                if (num == 0) {
                    return "Sorry, I can't understand you!";
                } else if (num == 1) {
                    return "Sorry, I don't understand";
                } else {
                    return "My apologies... I don't understand";
                }
            }
        }

        return "";
    }


}
