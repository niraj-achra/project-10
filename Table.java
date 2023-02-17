import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class Table1 {
    int a=1;
   void email(){
    JFrame frame=new JFrame();
    frame.setSize(500,500);
    frame.setLayout(null);
    frame.setTitle("table");
    
    JLabel Email=new JLabel("Email address");
    Email.setBounds(02,10,150,30);
    JTextField jt=new JTextField();
    jt.setBounds(02,50,450,40);
    JLabel text=new JLabel("we'll never share your email with anyone else.");
    text.setBounds(02,80,290,30);
    JLabel Username=new JLabel("Username");
    Username.setBounds(02,120,150,40);
    JTextField jt2=new JTextField();
    jt2.setBounds(02,150,450,40);

    JButton button=new JButton("submit");
    button.setBounds(2,200,100,30);
    button.setBackground(Color.LIGHT_GRAY);

    // String[] [] f2={{"1","n@gmail.com","niraj"},
    // {"2","a@gmail.com","avin"} } ;
    // String[] f1={"s no.","Email","Username"};
    String[] columnNames = {"S.No.","Email","UserName"};
    Object[][] data = {};
    DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    JTable table= new JTable(tableModel);
     table.setBounds(2,230,500,200);
    
     JScrollPane sp=new JScrollPane(jt);

    frame.add(jt);
    frame.add(Email);
     frame.add(jt2);
     frame.add(Username); 
     frame.add(table); 
     frame.add(text);
    frame.add(button);
    frame.add(sp);

    frame.setVisible(true);

    ActionListener ac=new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
            String data=jt.getText();
            String userdata=jt2.getText();

          
            Object[] rowData = {a,data,userdata};
            tableModel.addRow(rowData);
            jt.setText("");
            jt2.setText("");
            a++;
        }
    };button.addActionListener(ac);
}


   }

public class Table{
    
    public static void main(String[] args) {
        Table1 t1=new Table1();
        t1.email();
    }
}
