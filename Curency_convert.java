import javax.swing.*;
import java.awt.event.*;

class curency{
    void rupees(){
        JFrame frame=new JFrame("currency_converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);

       JLabel label=new JLabel("convert currency bilow option's:");
       label.setBounds(10,10,200,20);
        JTextField text=new JTextField();
        text.setBounds(10,50,90,30);
        JLabel label2=new JLabel("=");
        label2.setBounds(130,50,30,20);
        JTextField text1=new JTextField();
        text1.setBounds(170,50,190,30);

        ButtonGroup btgroup=new ButtonGroup();
        JRadioButton button1 =new JRadioButton("rupees to dollar");
        button1.setBounds(10,120,150,30);
        JRadioButton button2=new JRadioButton("rupees to pound");
        button2.setBounds(10,160,150,30);
        JRadioButton button3=new JRadioButton("rupees to yen");
        button3.setBounds(10,200,150,30);

        frame.add(label2);
       frame.add(label);
        frame.add(text);
        frame.add(text1);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        btgroup.add(button1);
        btgroup.add(button2);
        btgroup.add(button3);
        ActionListener dollar=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String a=text.getText();
                double x=Double.parseDouble(a);
               double y= x/80;
               String c=String.valueOf(y);
               text1.setText(c);

            }
        };
        ActionListener pound=new  ActionListener(){
            public void actionPerformed(ActionEvent e){
                String a= text.getText();
                double x=Double.parseDouble(a);
                double y= x/101;
                String c=String.valueOf(y);
                text1.setText(c);
            }
        };
        ActionListener yen=new  ActionListener(){
            public void actionPerformed(ActionEvent e){
                String a= text.getText();
                double x=Double.parseDouble(a);
                double y= x*1.59;
                String c=String.valueOf(y);
                text1.setText(c);
            }
        };
        button1.addActionListener(dollar);
        button2.addActionListener(pound);
        button3.addActionListener(yen);

        frame.setVisible(true);

    }
}



public class Curency_convert {

    public static void main(String[] args) {
        curency c=new curency();
        c.rupees();
    }
    
}
