package edu.neu.csye6200.cacrystal;
//import com.sun.beans.util.Cache;
import static java.lang.Math.sqrt;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.SetChangeListener;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Maheshwar Gurav
 */
public class CAFlakeSet extends Observable implements Runnable{  
    //This class is extending Observable. 
    /*
    Whenever setChanged() method will call along with notifyObservers(object)
    method, update method of observer (here CACanvas ) will receive object 
    that we pass through notifyObservers method. (here we pass object of CAFlake).
    */
        static int ro;
        InitialSet Iset;
        CAFlake f;
        CAFlake f2;
        CAFlake f3;
        CARule r;
        CACanvas obscanvas;
        Thread giveIt;
       
        
        

    @Override
    //program start exectuing run() method whenever Thread is created on object of this class
    //and we call start() methodd on that thread.
    synchronized public void run(){
        System.out.println("Inside run method of flakeset");
        //for rule1
        if(JuiApp1.rule1=true&JuiApp1.rule2==false)
        {
        int i=0;
        System.out.println("Inside rule1");
        //generating first Flake
        f.cell=Iset.state1(f.cell);
        
        setChanged();
        notifyObservers(f);
        //calling repaint() will automatically call paint() method of CACanvas
        obscanvas.repaint();
        //refreshing the frame
        SwingUtilities.updateComponentTreeUI(JuiApp1.getFrame());
        
        
       
        while(JuiApp1.rule1=true&i<JuiApp1.count)
        { 
          //after selecting rules, if butn0 is not selected, then start variable 
          //wont be set to true. So till then running thrad will wait cuz of
            //wait() method.
          while(JuiApp1.start==false)
          {
              System.out.println("waiting");
                try {
                    wait();
                } catch (InterruptedException ex) {}
          }
              
         // if(JuiApp1.resume==true&i>JuiApp1.count){break;}
          //if paused button is pressed, then stop generating
          //new generation by skipping current exection of while loop.
          
          if(JuiApp1.start==true)
          {
            //while loop is limited by count variable receving from textfield on GUI
           
            if(JuiApp1.pause==true){System.out.println("Paused");continue;}
            System.out.println("lets create new gen");
            r.newcell(f.cell);
            //notifying CACanvas about change in object of CAFlake.
            setChanged();
            notifyObservers(f);
            System.out.println("Refresing canvas"); 
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException ex) {
                  System.out.println("Thread interuppted");
              }
            //refreshing canvas and frame.
            obscanvas.repaint();
            SwingUtilities.updateComponentTreeUI(JuiApp1.getFrame());   
          } 
        i++;
        }
        JuiApp1.count=-1;JuiApp1.butn0.setEnabled(false); JuiApp1.butn1.setEnabled(false); JuiApp1.butn2.setEnabled(false);
        }
        
        if (JuiApp1.rule2=true&JuiApp1.rule1==false){
        int i=0;
        System.out.println(JuiApp1.count);
        f2.cell=Iset.state2(f2.cell);
        setChanged();
        notifyObservers(f2);
        obscanvas.repaint();
        SwingUtilities.updateComponentTreeUI(JuiApp1.getFrame());

        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
          
        while(JuiApp1.rule2=true&i<JuiApp1.count)
        { 
            while(JuiApp1.start==false){
                try {
                    System.out.println("waiting");
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CAFlakeSet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          
          
          if(JuiApp1.start==true)
          {
              if(JuiApp1.pause==true){System.out.println("Paused");continue;}
            System.out.println("lets create new gen");
              
            System.out.println(JuiApp1.count);
              
            r.newcell2(f2.cell);
            setChanged();
            notifyObservers(f2);
            
            System.out.println("Refresing canvas"); 
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException ex) {
                  System.out.println("Thread interuppted");
              }
              obscanvas.repaint();
              SwingUtilities.updateComponentTreeUI(JuiApp1.getFrame());
             
              
            
          }
        i++; 
        }
        JuiApp1.count=-1; JuiApp1.butn0.setEnabled(false); JuiApp1.butn1.setEnabled(false); JuiApp1.butn2.setEnabled(false);
        }
    }
    
        public void startIt(){                                 
        obscanvas = new CACanvas();
        addObserver(obscanvas);
        r = new CARule();
        //crating three object of CAFlake.
        //Each object will store 2D cell array.
        //2D cell array of each object is changed based on rules.
        f = new CAFlake(100); 
        f2= new CAFlake(100);
       
        Iset = new InitialSet();
        //giving memory to each object of CAFlakeCell stored in 2D cell array of 
        //CAFlake for all three object.
        f.cell=Iset.giveMem(f.cell);
        f2.cell=Iset.giveMem(f2.cell);
        }
}


        
        
    
        

            
   
      
      

    
    
    
    
  
 


