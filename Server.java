
import java.io.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.event.*;

import java.net.*;

public class Server {
    static ServerSocket servers;
    static Socket s;
    static Scanner sc;
    static Scanner scanner=new Scanner(System.in);
   
    static PrintWriter pwrite;
    static String str1="",str2="";
    static JTextArea sendmsg;
    static JTextArea recive;


    public static void jframe(){
        JFrame frame=new JFrame("ME");
        frame.setSize(600,600);
        frame.setLayout(null);
         recive=new JTextArea();
         recive.setBounds(10,10,200,70);
         
         sendmsg=new JTextArea();
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

        

        try{
            servers=new ServerSocket(8000);
            System.out.println("Listening");
            s=servers.accept();
            System.out.println("connected");
            sc=new Scanner(s.getInputStream());
            pwrite=new PrintWriter(s.getOutputStream(),true);
            
            jframe();
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    static void read(){
        Thread tr=new Thread(new Runnable() {
            
            public void run() {
            while(true)
             {
                    str1=sc.nextLine();
                    recive.append(str1+"\n");
                    if(str1.equals("Bye"))
                    
                    {break;}
              }
            }
        });
        tr.start();
    }
    static void write(){
        
        Thread tw=new Thread(new Runnable() {
            
            public void run() {
                if(!(sendmsg.getText().equals(""))){
                str2=sendmsg.getText();
                pwrite.println(str2);
               sendmsg.setText("");
                }
        }
        });
        tw.start();
    }

}
