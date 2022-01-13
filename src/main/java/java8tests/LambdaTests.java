package java8tests;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LambdaTests {
    public static void main(String[] args) throws IOException {
        FileWriter fl = new FileWriter("src/main/resources/personals.txt",true);

        BufferedWriter bw = new BufferedWriter(fl);

        // Multiple parameters in lambda expression
        Operations ad1=(a, b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Multiple parameters with data type in lambda expression
        Operations ad2=(int a, int b)->(a+b);
        Operations ad3 = (a, b)->(a+b+5);
        ad3 = (a, b)->(a+b+10);

        System.out.println(ad2.add(100,200));
        System.out.println(ad3.add(3,4));

        CountAble s1 = () -> {
          return  "Hello World";
        };
        System.out.println(s1.count());
        
        List<String> list=new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(
                (n)->System.out.println(n)
        );

        list.stream().filter(n -> n.length() < 4).forEach(System.out::println);
        
        JTextField tf=new JTextField();
        tf.setBounds(50, 50,150,20);
        JButton b=new JButton("Add");
        b.setBounds(80,100,70,30);
        JButton b2=new JButton("listele");
        b2.setBounds(150,100,70,30);

        JTextField table = new JTextField();
        table.setBounds(30,150,300,300);

        // lambda expression implementing here.
        b.addActionListener(e-> {
            try {
                bw.append("\n"+tf.getText());
                bw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });

// yapilacak

        b2.addActionListener(e-> {

            list.add(tf.getText());
            list.stream().forEach(n->table.setText(n));

        });
        
        JFrame f=new JFrame();
        f.add(tf);f.add(b);f.add(table);f.add(b2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(500, 500);
        f.setVisible(true);

    }

    interface CountAble {
        public String count();
    }

    interface Operations {
        int add(int a,int b);
    }
}
