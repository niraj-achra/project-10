import java.util.Random;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
public class Password{

 public static void main(String[] args) {


 String upper= " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String lower= " abcdefghijklmnopqrstuvwxyz";
 String num="0123456789";
 String specialchars= "!@#$%^&*()_+-=<>?,./:";
 String combination=upper+lower+num+specialchars;

 int len=8;
 char[]password=new char[len];
 Random r=new Random();
 for(int i=0;i<len;i++){
 password[i]=combination.charAt(r.nextInt(combination.length()));

 }
 System.out.println("password is:"+new String(password));

 JFrame f=new JFrame("Paasword");
 f.setSize(600,600);
 f.setLayout(null);
 JTextField tf=new JTextField("");
 tf.setBounds(85,10,200,30);
 JLabel l=new JLabel("Email");
 l.setBounds(10,10,75,30);
 JLabel L2=new JLabel("username");
 L2.setBounds(10,50,75,30);
 JTextField tf2=new JTextField();
 tf2.setBounds(85,50,200,30);
 JButton bt=new JButton("submit");
 bt.setBounds(100,120,80,40);
 JLabel pas= new JLabel();
 pas.setBounds(10,160,200,40);


 f.add(L2);
 f.add(bt);
 f.add(pas);
 f.add(tf2);
 f.add(l);
 f.add(tf);
 f.setVisible(true);


 ActionListener ac=new ActionListener(){
 public void actionPerformed(ActionEvent e){
 pas.setText("password is:"+new String(password));


 }
 };bt.addActionListener(ac);
 }
}