
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends JFrame implements ActionListener {

    static JFrame f;


    static JTextField l;


    String s0, s1, s2;


    Calculator()
    {
        s0 = s1 = s2 = "";
    }


    public static void main(String args[])
    {

        f = new JFrame("calculator");
        

        Calculator d = new Calculator();


        l = new JTextField(16);

        l.setEditable(false);


        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, badd, bsub, bdiv, bmul, be, bequel, bCanc;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bequel = new JButton("=");
        badd = new JButton("+");
        bsub = new JButton("-");
        bdiv = new JButton("/");
        bmul = new JButton("*");
        bCanc = new JButton("C");
        be = new JButton(".");

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        bmul.addActionListener(d);
        bdiv.addActionListener(d);
        bsub.addActionListener(d);
        badd.addActionListener(d);
        b9.addActionListener(d);
        b8.addActionListener(d);
        b7.addActionListener(d);
        b6.addActionListener(d);
        b5.addActionListener(d);
        b4.addActionListener(d);
        b3.addActionListener(d);
        b2.addActionListener(d);
        b1.addActionListener(d);
        b0.addActionListener(d);
        be.addActionListener(d);
        bequel.addActionListener(d);
        bCanc.addActionListener(d);
        panel.add(l);
        panel.add(badd);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bsub);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bmul);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bdiv);
        panel.add(be);
        panel.add(b0);
        panel.add(bequel);
        panel.add(bCanc);



        f.add(panel);

        f.setSize(220, 250);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();


        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {

            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;


            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {

            s0 = s1 = s2 = "";


            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;


            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));


            l.setText(s0 + s1 + s2 + "=" + te);


            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {

            if (s1.equals("") || s2.equals(""))
                s1 = s;

            else {
                double te;


                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));


                s0 = Double.toString(te);


                s1 = s;


                s2 = "";
            }


            l.setText(s0 + s1 + s2);
        }
    }
}


