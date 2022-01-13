package swing;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FirstSheet {
    public static User addedUser;
    public static void main(String[] args) {
        JFrame f = new JFrame("FirstSheet");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(500, 500);
        f.setVisible(true);

        JButton b = new JButton("Kullanıcı Ekle");
        b.setBounds(100, 120, 150, 30);
        f.add(b);
        b.addActionListener(e -> {
            try {
                addUser();
                writeJSON(addedUser);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void addUser(){
        JFrame dialog = new JFrame("ekleme ekranı");
        dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        dialog.setLayout(null);
        dialog.setSize(500, 500);
        dialog.setVisible(true);

        JTextField firstName = new JTextField();
        firstName.setBounds(150, 50, 150, 20);


        JTextField lastName = new JTextField();
        lastName.setBounds(150, 80, 150, 20);

        JTextField username = new JTextField();
        username.setBounds(150, 120, 150, 20);

        JTextField email = new JTextField();
        email.setBounds(150, 150, 150, 20);

       JTextField password = new JTextField();
        password.setBounds(150, 180, 150, 20);

        JTextField role = new JTextField();
        role.setBounds(150, 210, 150, 20);


        JButton kullanıcı_ekle = new JButton("Kullanıcı Ekle");
        kullanıcı_ekle.setBounds(100, 240, 150, 30);

        dialog.add(firstName);
        dialog.add(role);
        dialog.add(lastName);
        dialog.add(email);
        dialog.add(password);
        dialog.add(username);
        dialog.add(kullanıcı_ekle);
        addedUser = new User(firstName.getText(),lastName.getText(),username.getText(),email.getText(),password.getText(),role.getText());

        kullanıcı_ekle.addActionListener(e -> {
            dialog.setVisible(false);
        });

    }

    public static void writeJSON(User user) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("users.json"), user);
    }
}
