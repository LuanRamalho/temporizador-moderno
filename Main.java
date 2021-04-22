import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Main 
{
    
    JFrame window;
    JLabel counterLabel;
    Font font1 = new Font("Arial", Font.PLAIN, 70);
    
    Timer timer;
    
    int second, minute;
    String ddSecond, ddMinute;
    
    DecimalFormat dFormat = new DecimalFormat("00");

    public static void main(String[] args)
    {
        new Main();
    }
    
    public Main()
    {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        
        counterLabel = new JLabel("");
        counterLabel.setBounds(300, 230, 200, 100);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font1);
        
        window.add(counterLabel);
        window.setVisible(true);        
        
        // Simple Timer
        //second = 0;
        //simpleTimer();
        //timer.start();
        
        // Normal Timer
        //counterLabel.setText("00:00");
        //second = 0;
        //minute = 0;
        //normalTimer();
        //timer.start();
       
        // Countdown Timer
        counterLabel.setText("00:15");
        second = 15;
        minute = 0;
        countdownTimer();
        timer.start();
        
    }
    
    public void simpleTimer() {
        timer = new Timer(1000, new ActionListener() {
            
        public void actionPerformed(ActionEvent e) {
            second = second + 1;
            counterLabel.setText(""+second);
        }

          
        });
    } 
    
    public void normalTimer()
    {
        timer = new Timer(1000, new ActionListener() {
            
           
            public void actionPerformed(ActionEvent e) 
            {
            
                second = second + 1;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute + ":" + ddSecond);
                
                if (second==60){
                    second = 0;
                    minute = minute + 1;
                    
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    counterLabel.setText(ddMinute + ":" + ddSecond);
                }
                        
            }
        });
    }
    
    
    public void countdownTimer()
    {
        timer = new Timer(1000, new ActionListener() {
            
           
            public void actionPerformed(ActionEvent e) 
            {
            
                second = second - 1;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute + ":" + ddSecond);
                
                if (second==-1){
                    second = 59;
                    minute = minute - 1;
                    
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    counterLabel.setText(ddMinute + ":" + ddSecond);
                }
                
                if (minute==0 && second==0)
                {
                    timer.stop();
                }
                        
            }
        });
    }
    
}


















