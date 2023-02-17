import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Login_register {
    String user,pass,name1,name2,Mobile,Add;
    void register() {
        JFrame frame = new JFrame("Registeration Page");
        frame.setSize(600, 500);
        frame.setLocation(650, 40);
        frame.setLayout(null);
        JPanel p = new JPanel();
        p.setBounds(10, 10, 580, 480);
        p.setLayout(null);
        frame.add(p);
        JLabel l = new JLabel("First Name");
        l.setBounds(10, 10, 120, 30);
        JTextField tf = new JTextField();
        tf.setBounds(130, 10, 300, 30);
        p.add(l);
        p.add(tf);
        JLabel l1 = new JLabel("Last Name");
        l1.setBounds(10, 50, 120, 30);
        JTextField t1 = new JTextField();
        t1.setBounds(130, 50, 300, 30);
        p.add(l1);
        p.add(t1);
        JLabel l2 = new JLabel("Username/email");
        l2.setBounds(10, 90, 120, 30);
        JTextField t2 = new JTextField();
        t2.setBounds(130, 90, 300, 30);
        p.add(l2);
        p.add(t2);
        JLabel l3 = new JLabel("Password");
        l3.setBounds(10, 130, 120, 30);
        JPasswordField pwd = new JPasswordField();
        pwd.setBounds(130, 130, 300, 30);
        p.add(l3);
        p.add(pwd);
        JLabel l5 = new JLabel("Mobile No.");
        l5.setBounds(10, 170, 120, 30);
        JTextField t5 = new JTextField();
        t5.setBounds(130, 170, 300, 30);
        p.add(l5);
        p.add(t5);
        JLabel l4 = new JLabel("Address");
        l4.setBounds(10, 210, 120, 30);
        JTextArea area = new JTextArea();
        area.setBounds(130, 210, 300, 50);
        p.add(l4);
        p.add(area);
        JButton b1 = new JButton("Register");
        b1.setBounds(180, 280, 120, 30);
        b1.setBackground(Color.CYAN);
        JLabel label = new JLabel();
        label.setBounds(100, 320, 400, 30);
        p.add(b1);
        p.add(label);
        frame.setVisible(true);

        ActionListener ac = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user = t2.getText();
                pass = pwd.getText();
                name1 = tf.getText();
                name2 = t1.getText();
                Mobile = t5.getText();
                Add = area.getText();
                try {
                    if (!user.equals("") && !pass.equals("") && !name1.equals("") && !name2.equals("")
                            && !Mobile.equals("") && !Add.equals("")) {
                        if (user.contains("@") && user.contains(".") && Mobile.length()==10) {
                            FileReader rd = new FileReader("src/DataInput.txt");
                            //BufferedReader b = new BufferedReader(rd);
                            Scanner b = new Scanner(rd);
                            String data = "";
                            b.close();
                            while (b.hasNextLine()) {
                                data = b.nextLine();
                                System.out.println(data);
                                System.out.println(user);
                                if (data.contains(user)) {
                                    System.out.println(data);
                                    System.out.println(user);
                                    label.setText("You are already registered try Login");
                                    System.out.println("already");
                                } else {
                                    FileWriter fw = new FileWriter("src/DataInput.txt", true);
                                    fw.write(name1 + name2 + "\n" + user + "\n" + pass + Mobile + Add + "\n");
                                    fw.close();
                                    label.setText("Congratulation you are registered successfully ");
                                    System.out.println("congratulations");
                                    name1 = "";
                                    name2 = "";
                                    break;
                                }
                            }

                        } else {
                            System.out.println("Invalid Username/Email");
                            label.setText("Invalid Username/Email or Mobile no. ");
                        }
                    }else{
                            label.setText("Empty Fields!!!!");
                        }
                }catch(Exception i){
                        System.out.println(i);
                    }
                }
            }
            ;b1.addActionListener(ac);
    }
    void login(){
        JFrame f=new JFrame("Login page");
        f.setSize(600,500);
        f.setLocation(50,20);
        f.setLayout(null);
        JPanel p=new JPanel();
        p.setBounds(10,10,580,480);
        p.setLayout(null);
        f.add(p);
        JLabel l=new JLabel("Username");
        l.setBounds(10,10,60,30);
        JLabel l1=new JLabel("Password");
        l1.setBounds(10,60,60,30);
        JButton Login=new JButton("Login");
        Login.setBounds(180,110,100,30);
        Login.setBackground(Color.PINK);
        JTextField tf=new JTextField();
        tf.setBounds(100,10,300,30);
        JPasswordField pwd=new JPasswordField();
        pwd.setBounds(100,60,300,30);
        JLabel l2=new JLabel("New user ? Register here/Activate ");
        l2.setBounds(120,180,300,30);
        l2.setBackground(Color.YELLOW);
        JButton Register=new JButton("Register");
        Register.setBounds(180,240,100,30);
        Register.setBackground(Color.CYAN);
        p.add(l);p.add(l1);p.add(pwd);p.add(Login);p.add(tf);p.add(l2);p.add(Register);
        f.setVisible(true);
        JFrame f1=new JFrame("Login data");
        f1.setSize(300,300);
        f1.setLocation(400,500);
        f1.setLayout(null);
        ActionListener click=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user1=tf.getText();
                try{
                FileReader rd = new FileReader("src/DataInput.txt");
                //BufferedReader b = new BufferedReader(rd);
                Scanner b = new Scanner(rd);
                b.close();
                String data = "";
                while (b.hasNextLine()) {
                    data = b.nextLine();
                    System.out.println(data);
                    System.out.println(user1);
                    if (data.contains(user1)) {
                        System.out.println(data);
                        System.out.println(user1);
                        System.out.println("sucessfully Login");
                    } else { System.out.println("Not registred");}
                }
                }      catch (Exception n){
                        System.out.println(n);
                    }
                f1.setVisible(true);
            }
        };Login.addActionListener(click);
        ActionListener ok=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        };Register.addActionListener(ok);
    }
    public static void main(String[] args) {
        Login_register l=new Login_register();
        l.login();
    }
}

