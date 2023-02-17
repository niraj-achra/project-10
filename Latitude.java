import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Finder{
   static String city;
   static String state;
   static String lati;
   static String longi;

    void find(){
        JFrame frame= new JFrame("Status");
        frame.setSize(300,350);
        frame.setLayout(null);
        JLabel heading= new JLabel("for Lang & Lat plz enter!");
        heading.setBounds(20,00,300,30);
        frame.add(heading);
        JLabel label= new JLabel("city name");
        label.setBounds(0,50,100,30);
        frame.add(label);
        JLabel box= new JLabel();
        box.setBounds(70,50,120,30);
        JTextField tf= new JTextField();
        tf.setBounds(0,0,150,30);
        box.add(tf);
        JLabel sname= new JLabel("state name");
        sname.setBounds(0,90,100,30);
        frame.add(sname);
        JTextField tf1= new JTextField();
        tf1.setBounds(70,90,150,30);
        frame.add(tf1);
        frame.add(box);
        JButton button= new JButton("submit");
        button.setBounds(70,150,90,30);
        frame.add(button);
        JTextArea area = new JTextArea();
        area.setBounds(10,200,200,60);
        frame.add(area);

        ActionListener ac = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                city = tf.getText();
                state=tf1.getText();
                try {
                    URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+","+state+",IN&limit=1&appid=a021e43ac1f97ad82ceb29693d4f7403");
                    HttpURLConnection dat = (HttpURLConnection) url.openConnection();
                    dat.setRequestMethod("GET");
                    InputStreamReader in = new InputStreamReader(dat.getInputStream());
                    BufferedReader in1 = new BufferedReader(in);
                    String st = "";
                    while (st != null) {
                        st = in1.readLine();
                        in.close();
                        JSONParser par = new JSONParser();
                        JSONArray array = (JSONArray) par.parse(st);
                        JSONObject obj = (JSONObject) array.get(0);
                        System.out.println(obj.get("lat"));
                        System.out.println(obj.get("lon"));
                        Object lt=obj.get("lat");
                        String st1= lt.toString();
                        System.out.println(st1);
                        Object ln=obj.get("lon");
                        String st2= ln.toString();
                        System.out.println(st2);
                        area.setText("latitude is:-"+st1+"\n"+"longitude is:-"+st2);
                    }
                } catch (Exception t) {
                    System.out.println(t);
                }
            }
        }; button.addActionListener(ac);
         frame.setVisible(true);}
    }
public class Latitude {
    public static void main(String[] args) {
Finder f= new Finder();
f.find();
    }
}