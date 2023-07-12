import ChatBot.ChatBotGUI;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        ChatBotGUI chatBotGUI = new ChatBotGUI("Chat Bot");
        chatBotGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        chatBotGUI.setVisible(true);
        System.out.println("Chat window has been opened.");
    }
}
