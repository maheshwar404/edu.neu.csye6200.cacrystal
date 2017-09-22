package edu.neu.csye6200.cacrystal;

/**
 *
 * @author Maheshwar Gurav
 */
public class InitialSet {
    //giveMem method receives 2d cell array which assigns memory to each object
    //present in 2d cell array.
    public CAFlakeCell[][] giveMem(CAFlakeCell cell[][]){
        
        for(int i=0;i<cell.length;i++){
            for(int j=0;j<cell[i].length;j++){
             cell[i][j]=new CAFlakeCell();     
            }
        }
        return cell;
    }
    //state1 receives 2d cell array and set state and previous variable of each 
    //object of CAFlakeCell based on particular condition.
    public CAFlakeCell[][] state1(CAFlakeCell cell[][]){
        for(int i=0;i<cell.length;i++){
            for(int j=0;j<cell[i].length;j++){
             if(Math.sqrt(Math.pow((i-50),2)+Math.pow((j-50),2))<=2 || Math.sqrt(Math.pow((i-25),2)+Math.pow((j-25),2))<=2 ||
               Math.sqrt(Math.pow((i-25),2)+Math.pow((j-75),2))<=2 || Math.sqrt(Math.pow((i-75),2)+Math.pow((j-25),2))<=2
                     || Math.sqrt(Math.pow((i-75),2)+Math.pow((j-75),2))<=2)
             {cell[i][j].state=1;cell[i][j].previous=1;}
             else {cell[i][j].state=0;cell[i][j].previous=0;}  
             cell[i][j].x=i*10;
             
             cell[i][j].y=j*10;
             
            }
           
        }
        return cell;
    }
    //state2 method is used to generate initial 2D Flake for rule 2 applying on 
    //f1 object of CAFlake.
    public CAFlakeCell[][] state2(CAFlakeCell cell[][]){
       for(int i=0;i<cell.length;i++){
            for(int j=0;j<cell[i].length;j++){
             if(i==50&j==50)
             {cell[i][j].state=1;cell[i][j].previous=1;}
             else {cell[i][j].state=0;cell[i][j].previous=0;}  
             cell[i][j].x=i*10;
             cell[i][j].y=j*10;
            }
           
        }
        return cell;
    }

    
    
}
