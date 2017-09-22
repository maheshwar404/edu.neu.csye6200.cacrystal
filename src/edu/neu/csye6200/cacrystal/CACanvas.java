
package edu.neu.csye6200.cacrystal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CACanvas extends JPanel implements Observer
{   
    //CAFLake object 'f' is made static to that it will represent current 
    //generation based on rule.
    //Therefore CACanavs simply print current generation.
    static CAFlake f;
    double maxRows;
    double maxColoumn;
    double cellSize;
    Graphics2D g2d;
   // static Thread th;
    public CACanvas(){   
   }
    
 
    
  @Override
    synchronized public void paint(Graphics g){    
        drawCanvas(g);
    } 
    public void drawCanvas(Graphics g){
        System.out.println("inside draw canvas");
        g2d = (Graphics2D) g;
        AffineTransform tra = new AffineTransform();
        Dimension size =getSize();
        size.setSize(1000, 1000);
        g2d.scale(3.0, 3.0);
        g2d.setTransform(tra);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0,size.width*2, size.height*2);
        cellSize = 10;
        maxRows = size.height/cellSize;
        maxColoumn = size.width/cellSize;
        //this nested for loops draws cells on fame.
        for (int x=0;x<=maxRows-1;x++){
            for (int y=0;y<=maxColoumn-1;y++){ 
                int redVal = validColor(x*5);
			   int greenVal = validColor(255-x*5);
			   int blueVal = validColor((y*5)-(x*2));
		  Color col = new Color(redVal, greenVal, blueVal);
            
            paintCell( g2d, x*cellSize, y*cellSize + 20, cellSize-1, col); 
            }
           
            }
        //this block draws cells on canvas based on current 2d cwll array conditions 
        //stored in static object of CAFlake.
       if(JuiApp1.rule1==true|JuiApp1.rule2==true){
        try{
            System.out.println("draw canvas based on rules");
            System.out.println(f.cell.length);
            for(int i=0;i<f.cell.length;i++){
            for(int j=0;j<f.cell[i].length;j++){   
            if(f.cell[i][j].state==1)
            {
            Color col=new Color(30,75,110,135);
            paintCell(g2d,f.cell[i][j].x,f.cell[i][j].y,cellSize,col);
            }
            else 
            {
            Color col=new Color(255,255,255,255);
            paintCell(g2d,f.cell[i][j].x,f.cell[i][j].y,cellSize,col);
            }
            
            }
            }}catch(NullPointerException e){}
       }
            
          
    }
    private void paintCell(Graphics2D g2d, double x ,double y, double size , Color color){
        
        g2d.setColor(color);
        g2d.fillRect((int)x,(int)y,(int)size,(int)size);
        
    }
    
    private int validColor(int colorVal) {
		if (colorVal > 255)
			colorVal = 255;
		if (colorVal < 0)
			colorVal = 0;
		return colorVal;
	}
    //@Override
    public void update(Observable o, Object arg){
    System.out.println("gettting updates in canvas");
    f=(CAFlake) arg;   
    }  
    }
    

    
    


