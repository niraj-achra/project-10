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

public class Weatherinformation{
    static String st1="";
    static String st2="";
    static double d,d1;
    static String  city="";
    static String state="";
    static JTextField tf,tf1;
    static String temprature="";
    static String humedity="";
    static String visibility="";
    static String pressure="";

   static  void weather() {
       try {
           try {
               city = tf.getText();
               state = tf1.getText();
               URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + city + "," + state + ",IN&limit=1&appid=a021e43ac1f97ad82ceb29693d4f7403");
               HttpURLConnection dat = (HttpURLConnection) url.openConnection();
               dat.setRequestMethod("GET");
               InputStreamReader in = new InputStreamReader(dat.getInputStream());
               BufferedReader in1 = new BufferedReader(in);
               String st = "";
               while (st != null) {
                   st = in1.readLine();
                   //System.out.println(st);
                   in.close();
                   JSONParser par = new JSONParser();
                   JSONArray array = (JSONArray) par.parse(st);
                   JSONObject obj = (JSONObject) array.get(0);
                   System.out.println(obj.get("lat"));
                   System.out.println(obj.get("lon"));
                   Object lt = obj.get("lat");
                   Object ln = obj.get("lon");
                   d = (Double) lt;
                   d1 = (Double) ln;
               }
           } catch (Exception t) {
               System.out.println(t);
           }
           URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + d + "&lon=" + d1 + "&limit=1&appid=6a07768660ff2343e9ecbacb198e79f6");
           HttpURLConnection dat = (HttpURLConnection) url.openConnection();
           dat.setRequestMethod("GET");
           InputStreamReader in = new InputStreamReader(dat.getInputStream());
           BufferedReader in1 = new BufferedReader(in);
           String st = "";
           String st1 = "";
           while (st != null) {
               st = in1.readLine();
               st1 = st1 + st;
               in.close();
               JSONParser par = new JSONParser();
               JSONObject obj = (JSONObject) par.parse(st1);
               System.out.println(obj.get("main"));
               JSONObject obj1 = (JSONObject) obj.get("main");
                temprature = obj1.get("temp").toString();
                humedity = obj1.get("humidity").toString();
                pressure = obj1.get("pressure").toString();
                visibility = obj.get("visibility").toString();
               System.out.println(temprature);
               System.out.println(pressure);
               System.out.println(humedity);
               System.out.println(visibility);
           }
       } catch (Exception t) {
           System.out.println(t);
       }
   }
    public static void main(String[] args) {
        JFrame frame= new JFrame("Weather report");
        frame.setSize(600,650);
        frame.setLayout(null);
        JLabel heading= new JLabel("please enter city name for weather info!");
        heading.setBounds(40,10,400,40);
        frame.add(heading);
        JLabel cit= new JLabel("Enter city name");
        cit.setBounds(10,70,180,30);
        frame.add(cit);
        JLabel box= new JLabel();
        box.setBounds(110,70,150,30);
         tf= new JTextField();
        tf.setBounds(0,0,150,30);
        box.add(tf);
        JLabel stt= new JLabel("Enter state name");
        stt.setBounds(10,120,180,30);
        frame.add(stt);
         tf1= new JTextField();
        tf1.setBounds(110,120,150,30);
        frame.add(tf1);
        frame.add(box);
        JButton bt1= new JButton("submit");
        bt1.setBounds(100,180,90,30);
        frame.add(bt1);
        JTextArea area= new JTextArea();
        area.setBounds(20,240,300,200);
        area.setEditable(false);
        frame.add(area);

        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               weather();
               area.setText("temperature is:"+temprature+"\n\n"+"pressure is:"+pressure+"\n\n"+"humidity is:"+humedity+"\n\n"+"visibility is:"+visibility);
            }
        }; bt1.addActionListener(action);
         frame.setVisible(true);
    }
}
