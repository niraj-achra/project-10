import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;

public class Client {

    static ServerSocket servers;
    static Socket s;
    static Scanner sc;
    static Scanner scanner=new Scanner(System.in);
    static PrintWriter pwrite;
    static String str1="",str2="";
    static JTextArea recive;
    static JTextField sendmsg;
    public static void write(){
        Thread tw=new Thread(new Runnable() {
            
            public void run() {
                if(!(sendmsg.getText().equals(""))){
                    str1=sendmsg.getText();
                    pwrite.println(str1);
                    sendmsg.setText("");
                }
            }
        });
        tw.start();
    }
    public static void read(){
        Thread tr=new Thread(new Runnable() {
            
            public void run() {
                while (true){
                    str2=sc.nextLine();
                    recive.append(str2+"\n");
                    if(str2.equals("Bye")){
                        break;
                    }
                }
            }
        });

        tr.start();
    }
    public static void jframe(){
        JFrame frame=new JFrame("My Friend");
        frame.setSize(600,600);
        frame.setLayout(null);
         recive=new JTextArea();
         recive.setBounds(10,10,200,70);
         
         sendmsg=new JTextField();
         sendmsg.setBounds(10,80,200,70);
         JButton send =new JButton("send");
         send.setBounds(10,250,100,30);
         frame.add(send);
         frame.add(sendmsg);
         frame.add(recive);
         frame.setVisible(true);
         ActionListener ac = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                write();

            }

         };send.addActionListener(ac);
         read();
    }

    public static void main(String[] args) {
        try {

            s=new Socket("localhost",8000);
            System.out.println("connected to server");
            sc=new Scanner(s.getInputStream());
            scanner=new Scanner(System.in);
            pwrite=new PrintWriter(s.getOutputStream(),true);
            
            jframe();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

