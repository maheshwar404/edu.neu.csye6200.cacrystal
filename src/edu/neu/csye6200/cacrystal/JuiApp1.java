/*
to add lib, right click on project, select properties, click on libraries, then click on Add jar
*/
package edu.neu.csye6200.cacrystal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
/**
 *
 * @author Maheshwar Gurav
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//extending CAApp
public class JuiApp1 extends CAApp implements ActionListener, Runnable, WindowListener, Observer{
    
     private static Logger log = Logger.getLogger(JuiApp1.class.getName());
     static CAFlakeSet set;
     public static boolean start;
     public static boolean end;
     public static boolean resume;
     public static boolean pause;
     public static boolean rule1;
     public static boolean rule2;
     static Thread t;  
     static Thread t1;
     static int count;

     protected JPanel northpanel;
     protected static JButton butn0;
     public JButton getButn0(){
         return butn0;
     }
     protected static JButton butn1;
     public JButton getButn1(){
         return butn1;
     }
     protected static JButton butn2;
     public JButton getButn2(){
         return butn2;
     }
     protected static JButton butn3;
     public JButton getButn3(){
         return butn3;
     }
     protected JLabel  getCtnlable;//
     protected JTextField stepCntF;
     protected static  JComboBox<String> rulebox;
     protected CACanvas canvas; 
     public JuiApp1(){
         //constructor of JuiApp1 will create entrie application framework.
        frame.setSize(1000, 1000);	
    	canvas = new CACanvas();
    	frame.add(canvas, BorderLayout.CENTER); // Add to the center of our frame
        frame.setVisible(true); // The UI is built, so display it
        System.out.println("Inside Juiapp constructor");
     }
   
   public JPanel getNorthPanel(){
       System.out.println("Inside getPanel");
       northpanel = new JPanel();
       northpanel.setLayout(new FlowLayout());
       butn0 = new JButton("Start");
       butn1 = new JButton("Pause");
       butn2 = new JButton("Resume");
       butn3 = new JButton("End");
       //Keeping all buttons disabled initially.
       butn0.setEnabled(false); 
       butn1.setEnabled(false); 
       butn2.setEnabled(false);
       butn3.setEnabled(false);
       northpanel.add(butn0);
       northpanel.add(butn1);
       northpanel.add(butn2);
       northpanel.add(butn3);
       northpanel.setBackground(Color.orange);
       getCtnlable=new JLabel("Generation count:"); 
       northpanel.add(getCtnlable);
       stepCntF =new JTextField("20");
       count=Integer.parseInt(stepCntF.getText());
       northpanel.add(stepCntF);
       rulebox = new JComboBox<String>();
       rulebox.addItem("Rule 1");
       rulebox.addItem("Rule 2");
       northpanel.add(rulebox);
       butn0.addActionListener(this);
       butn1.addActionListener(this);
       butn2.addActionListener(this); 
       butn3.addActionListener(this); 
       rulebox.addActionListener(this);
       stepCntF.addActionListener(this);
       return northpanel;  
       
   }

    @Override
    synchronized public void actionPerformed(ActionEvent ae){
        log.info("We received an ActionEvent " + ae);
        
        count=Integer.parseInt(stepCntF.getText());
        String selectedBook = (String) rulebox.getSelectedItem();
        
       /*Every time when any rule is selected, following thing happens
        disable rulebox, set rule variables accordingly,enable start button,
        start a thread on CAFlakeSet object following that particular rule.
        Thread will only stop when run() method in CAFlakeSet ends.
        */
        if (selectedBook.equals("Rule 1")){
            System.out.println("rule 1 selected");
            stepCntF.setEnabled(false);
            
            count=Integer.parseInt(stepCntF.getText());
            rulebox.setEnabled(false);
            rule1=true;
            rule2=false;
            
            
            butn0.setEnabled(true);
            t=new Thread(set);
            t.start();
            notify();
            
            
        } else if (selectedBook.equals("Rule 2")) {
            System.out.println("rule2 selected");
            stepCntF.setEnabled(false);
            count=Integer.parseInt(stepCntF.getText());
            rulebox.setEnabled(false);
            rule2=true;
            rule1=false;
           
            butn0.setEnabled(true);
            t1=new Thread(set);
            t1.start();
            notify();
            
        }
        
    if(ae.getSource()==butn0)
    {  //enable pause and end button and disable start button
        //start button will remain disabled util rule is selected in rulebox
        butn1.setEnabled(true);
        butn3.setEnabled(true);
        butn0.setEnabled(false);
        start=true;
        
    }
    else if (ae.getSource()==butn1){
        //enable resume button, disable pause and end
        butn0.setEnabled(false);
        butn2.setEnabled(true);
        butn3.setEnabled(false);
        butn1.setEnabled(false);
        pause=true;
        resume=false;
    }
    else if(ae.getSource()==butn2){
       //enable pause and end button.
        butn1.setEnabled(true);
        pause=false;    
        butn0.setEnabled(false);
        butn3.setEnabled(true);
    }
    else if(ae.getSource()==butn3){
        //disable evrything, enable rulebox
        end=true;
        stepCntF.setEnabled(true);
        stepCntF.setEnabled(true);
        rulebox.setEnabled(true);
        butn0.setEnabled(false);
        butn1.setEnabled(false);
        butn2.setEnabled(false);
        butn3.setEnabled(false);
        start=false;
        pause=false;
        resume=false;
        rule1=false;
        rule2=false; 
        
        
        
        
    }  
}    
    @Override
	public void windowOpened(WindowEvent e) {
		log.info("Window opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
            log.info("Closing window");
	}

	@Override
	public void windowClosed(WindowEvent e) {
            log.info("Window is closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		log.info("Window iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {	
		log.info("Window deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		log.info("Window activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {	
        log.info("Window deactivated");
	}
        public static JFrame getFrame(){
        return frame;
         }
        public JComboBox<String> getRulebox(){
        return rulebox;
        }
public static void main(String args[]) throws InterruptedException{
   
    //object creation of CAFlakeSet and calling startIt() method will set initial states for all rules.
    set = new CAFlakeSet();
    set.startIt();
    log.info("creating app");
    
    //JuiApp1 app = new JuiApp1(); 
    
    SwingUtilities.invokeLater(new Runnable() {
    public void run() {
    new JuiApp1();
    }});
    }

    @Override
    public void run() {
        log.info("Run method of main");
    }

    @Override
    public void update(Observable o, Object o1) {
     
    }
    
  
}
