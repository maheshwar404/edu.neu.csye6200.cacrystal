package edu.neu.csye6200.cacrystal;
/**
 *
 * @author Maheshwar Gurav
 */
public class CARule {
    
    /*
    newcell menthod receives '2d cell array. For each object it calculate next
    genaration and then stores next generation state info into previous genration set variable 
    so that this info can be used to calculate next gen again.
    This we need to do because while calculating neighbours of cell, we don't want
    to use updated values of neighbour but previous values of neighbour.
    */
    public CAFlakeCell[][] newcell(CAFlakeCell cell[][]){
      for (int x = 1; x < cell.length-1; x++) {
       for (int y = 1; y < cell[x].length-1; y++) {
 
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
           for (int j = -1; j <= 1; j++) {
            neighbors += cell[x+i][y+j].previous;    
           }
        }
    neighbors -= cell[x][y].previous; //cell[x+i][y+j].previous
   
    if      ((cell[x][y].state == 1) & (neighbors > 2& neighbors<=5)) {cell[x][y].state=1;}
    else if ((cell[x][y].state == 0) & (neighbors > 2)) {cell[x][y].state=1;}
    else if ((cell[x][y].state == 1) & (neighbors >5)) {cell[x][y].state=0;}

  }
}
        
      for (int x = 1; x < cell.length-1; x++) {
       for (int y = 1; y < cell[x].length-1; y++) {
           cell[x][y].previous=cell[x][y].state;
           
       }
       } 
     return cell; 
}
    //this method can be used to generate another pattern 
        public void newcell2(CAFlakeCell cell[][]){
      for (int x = 1; x < cell.length-1; x++) {
       for (int y = 1; y < cell[x].length-1; y++) {
 
        int neighbors = 0;
        
        for (int i = -1; i <= 1; i++) {
           for (int j = -1; j <= 1; j++) {
               if(i==-1&j==-1|i==1&j==-1|i==-1&j==1|i==1&j==1){continue;}
               else neighbors += cell[x+i][y+j].previous;    //cell[x+i][y+j].previous
           }
        }
    neighbors -= cell[x][y].previous;
   
    if      ((cell[x][y].state == 0) && (neighbors == 0)) {cell[x][y].state=0;}
    else if ((cell[x][y].state ==0) && (neighbors == 1)) {cell[x][y].state=1;}
    else if ((cell[x][y].state == 0) && (neighbors == 2)) {cell[x][y].state=0;}
    else if ((cell[x][y].state == 0) && (neighbors == 3)) {cell[x][y].state=1;}
    else if ((cell[x][y].state == 0) && (neighbors == 4)) {cell[x][y].state=0;}
    else if (cell[x][y].state == 1) {cell[x][y].state=1;}

  }
}
    for (int x = 1; x < cell.length-1; x++) {
       for (int y = 1; y < cell[x].length-1; y++) {
           cell[x][y].previous=cell[x][y].state;
           
       }
       }    
      
}
        
     public void newcell3(CAFlakeCell cell[][]){
       
     
      for (int x = 1; x < cell.length-1; x++) {
       for (int y = 1; y < cell[x].length-1; y++) {
 
        int neighbors = 0;
        
        for (int i = -1; i <= 1; i++) {
           for (int j = -1; j <= 1; j++) {
               if(i==1&j==-1|i==-1&j==1|i==1&j==+1|i==1&j==1){continue;}
               else neighbors += cell[x+i][y+j].previous;    //cell[x+i][y+j].previous
           }
        }
    neighbors -= cell[x][y].previous;
   
    if      ((cell[x][y].state == 0) && (neighbors == 0)) {cell[x][y].state=1;}
    else if ((cell[x][y].state ==0) && (neighbors == 1)) {cell[x][y].state=0;}
    else if ((cell[x][y].state == 0) && (neighbors == 2)) {cell[x][y].state=1;}
    else if ((cell[x][y].state == 0) && (neighbors == 3)) {cell[x][y].state=0;}
    else if ((cell[x][y].state == 0) && (neighbors == 4)) {cell[x][y].state=1;}
    else if (cell[x][y].state == 1) {cell[x][y].state=1;}

  }
}
    for (int x = 1; x < cell.length-1; x++) {
       for (int y = 1; y < cell[x].length-1; y++) {
           cell[x][y].previous=cell[x][y].state;
           
       }
       }    
      
}
    
}
