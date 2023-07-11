package ChatBot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBotGUI extends JFrame implements ActionListener {
    private JTextArea area;
    private JTextField field;
    private JScrollPane sp;
    private JButton send;
    private ChatBotLogic chatBotLogic;

    public ChatBotGUI(String title) {
        super(title);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.CYAN);
        field = new JTextField();
        send = new JButton(">");
        send.setFont(new Font("Serif", Font.BOLD, 25));
        send.setBackground(Color.WHITE);
        send.setBounds(735, 520, 50, 35);
        add(send);

        // For Text area
        area = new JTextArea();
        area.setEditable(false);
        area.setBackground(Color.WHITE);
        add(area);
        area.setFont(new Font("Serif", Font.PLAIN, 20));

        // Scrollbar
        sp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setBounds(10, 20, 775, 470);
        add(sp);

        // For TextField
        field.setSize(725, 35);
        field.setLocation(10, 520);
        field.setForeground(Color.BLACK);
        field.setFont(new Font("Serif", Font.BOLD, 25));
        add(field);

        send.addActionListener(this);
        getRootPane().setDefaultButton(send);

        chatBotLogic = new ChatBotLogic();
    }

    public void actionPerformed(ActionEvent e) {
        String message = field.getText().toLowerCase();
        area.append("You : " + field.getText() + "\n");
        field.setText("");

        String response = chatBotLogic.generateResponse(message);
        bot(response);
    }

    public void bot(String message) {
        area.append("Bot : " + message + "\n");
    }
}
