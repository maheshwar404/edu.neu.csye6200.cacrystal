
package edu.neu.csye6200.cacrystal;

/**
 *
 * @author Maheshwar Gurav
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public abstract class CAApp implements ActionListener, WindowListener {
    
    
    public CAApp(){
        System.out.println("Inside constructor of CAApp");
        initGUI();
    }
    
    static JFrame frame;
    public void initGUI(){
        System.out.println("Inside initGUI");
        frame = new JFrame();
		frame.setTitle("2D Cellular Automata");

		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.DISPOSE_ON_CLOSE)
		
		// Permit the app to hear about the window opening
		frame.addWindowListener(this); 
		
		frame.setLayout(new BorderLayout());
		frame.add(getNorthPanel(), BorderLayout.NORTH);          
    }
    public abstract JPanel getNorthPanel() ;

}

    
    
    
    

