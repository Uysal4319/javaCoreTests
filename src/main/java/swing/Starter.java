package swing;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Starter {

    private static List<User> users;

    public static void main(String[] args) throws IOException {

        JsonFactory jsonFactory = new JsonFactory();

        final JTextField user = new JTextField();
        user.setBounds(150, 50, 150, 20);
        JTextField password = new JTextField();
        password.setBounds(150, 80, 150, 20);


        JButton b = new JButton("Giriş");
        b.setBounds(190, 120, 70, 30);

        JTextField table = new JTextField();
        table.setBounds(30, 200, 400, 100);
        Starter starter = new Starter();
        users = starter.loadJSON();
        JFrame f = new JFrame("Giriş");
        // User users = starter.readJSON();
        b.addActionListener(e -> {
            try {
                String result = isValidUser(user.getText(), password.getText());
                if (result.equals("Kullanıcı adi ve Password Doğru")) {
                    table.setText(result);
                    String[] arguments = new String[5];
                    FirstSheet.main(arguments);
                    f.setVisible(false);
                } else {
                    table.setText(result);
                }
            } catch (Exception eq) {
                table.setText("kullanıcı adi ve sifreyi kontrol ediniz");
            }
        });
        
        f.add(user);
        f.add(password);
        f.add(b);
        f.add(table);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(500, 500);
        f.setVisible(true);


    }
    public void writeJSON(User user) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("users.json"), user);
    }

    public User readJSON() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(new File("./src/main/resources/users.json"), User.class);
        return user;
    }

    public List<User> loadJSON() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        List user = mapper.readValue(new File("./src/main/resources/users.json"), new TypeReference<List<User>>() {
        });
        return user;
    }

    public static String isValidUser(String name, String password) {
        for (User u : users) {
            String userName = u.username;
            if (userName.equals(name)) {
                String userPassword = u.password;
                if (userPassword.equals(password)) {
                    return "Kullanıcı adi ve Password Doğru";
                }
                return "Password hatali";
            }
        }
        return "Kullanıcı adi ve password u kontrol ediniz";
    }
}
