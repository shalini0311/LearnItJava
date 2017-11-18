import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;  
/**
 *
 * @author shalini.dwivedi
 */
 public class NewClass {
    JFrame f;  
    int row = 8;
    int col = 8;
    int[][] centre_of_mass = new int[row][col];
    int[][] weight = new int[row][col];
    JLabel[][] grid= new JLabel[row][col];
    
    public void updte_weight(int index_i, int index_j){
    			if(weight[index_i][index_j] > centre_of_mass[index_i][index_j]){
    	    		System.out.println("splitting....");
    	    		weight[index_i][index_j] = 0;
    	    		if((index_i == 0 && index_j == 0) )
    				{
    					weight[index_i+1][index_j] += 1;
    					weight[index_i][index_j+1] += 1;
    					weight[index_i+1][index_j+1] += 1;
    					
    					if(weight[index_i+1][index_j] > centre_of_mass[index_i+1][index_j]){
    						//weight[index_i+1][index_j] = 0;
    						updte_weight(index_i+1,index_j);
    					}
    					else if(weight[index_i][index_j+1] > centre_of_mass[index_i][index_j+1]){
    						//weight[index_i][index_j+1] = 0;
    						updte_weight(index_i,index_j+1);
    					}
    					else if(weight[index_i+1][index_j+1] > centre_of_mass[index_i+1][index_j+1]){
    						//weight[index_i+1][index_j+1] = 0;
    						updte_weight(index_i+1,index_j+1);
    					}
    					grid[index_i+1][index_j].setText(""+weight[index_i+1][index_j]);
    					grid[index_i][index_j+1].setText(""+weight[index_i][index_j+1]);
    					grid[index_i+1][index_j+1].setText(""+weight[index_i+1][index_j+1]);
    					
    					
    					
    				}
    	    		else if((index_i == 0 && index_j == col-1) )
    				{
    					weight[index_i+1][index_j] += 1;
    					weight[index_i][index_j-1] += 1;
    					weight[index_i+1][index_j-1] += 1;
    					
    					if(weight[index_i+1][index_j] > centre_of_mass[index_i+1][index_j]){
    						//weight[index_i+1][index_j] = 0;
    						updte_weight(index_i+1,index_j);
    					}
    					else if(weight[index_i][index_j-1] > centre_of_mass[index_i][index_j-1]){
    						//weight[index_i][index_j-1] = 0;
    						updte_weight(index_i,index_j-1);
    					}
    					else if(weight[index_i+1][index_j-1] > centre_of_mass[index_i+1][index_j-1]){
    						//weight[index_i+1][index_j-1] = 0;
    						updte_weight(index_i+1,index_j-1);
    					}
    					
    					grid[index_i+1][index_j].setText(""+weight[index_i+1][index_j]);
    					grid[index_i][index_j-1].setText(""+weight[index_i][index_j-1]);
    					grid[index_i+1][index_j-1].setText(""+weight[index_i+1][index_j-1]);
    					
    					
    				}
    	    		else if((index_i == row-1 && index_j == 0) )
    				{
    					weight[index_i-1][index_j] += 1;
    					weight[index_i][index_j+1] += 1;
    					weight[index_i-1][index_j+1] += 1;
    					
    					if(weight[index_i-1][index_j] > centre_of_mass[index_i-1][index_j]){
    						//weight[index_i-1][index_j] = 0;
    						updte_weight(index_i-1,index_j);
    					}
    					else if(weight[index_i][index_j+1] > centre_of_mass[index_i][index_j+1]){
    						//weight[index_i][index_j+1] = 0;
    						updte_weight(index_i,index_j+1);
    					}
    					else if(weight[index_i-1][index_j+1] > centre_of_mass[index_i-1][index_j+1]){
    						//weight[index_i-1][index_j+1] = 0;
    						updte_weight(index_i-1,index_j+1);
    					}
    					grid[index_i-1][index_j].setText(""+weight[index_i-1][index_j]);
    					grid[index_i][index_j+1].setText(""+weight[index_i][index_j+1]);
    					grid[index_i-1][index_j+1].setText(""+weight[index_i-1][index_j+1]);
    					
    					
    				}
    				else if((index_i == row-1 && index_j == col-1) )
    				{
    					weight[index_i-1][index_j] += 1;
    					weight[index_i][index_j-1] += 1;
    					weight[index_i-1][index_j-1] += 1;
    					
    					if(weight[index_i-1][index_j] > centre_of_mass[index_i-1][index_j]){
    						//weight[index_i-1][index_j] = 0;
    						updte_weight(index_i-1,index_j);
    					}
    					else if(weight[index_i][index_j-1] > centre_of_mass[index_i][index_j-1]){
    						//weight[index_i][index_j-1] =0;
    						updte_weight(index_i,index_j-1);
    					}
    					else if(weight[index_i-1][index_j-1] > centre_of_mass[index_i-1][index_j-1]){
    						//weight[index_i-1][index_j-1] = 0;
    						updte_weight(index_i-1,index_j-1);
    					}
    					
    					grid[index_i-1][index_j].setText(""+weight[index_i-1][index_j]);
    					grid[index_i][index_j-1].setText(""+weight[index_i][index_j-1]);
    					grid[index_i-1][index_j-1].setText(""+weight[index_i-1][index_j-1]);
    					
    					
    				}
    				else if((index_i == 0) )
    				{
    					weight[index_i][index_j-1] += 1;
    					weight[index_i][index_j+1] += 1;
    					weight[index_i+1][index_j] += 1;
    					weight[index_i+1][index_j-1] += 1;
    					weight[index_i+1][index_j+1] += 1;
    					grid[index_i][index_j-1].setText(""+weight[index_i][index_j-1]);
    					grid[index_i][index_j+1].setText(""+weight[index_i][index_j+1]);
    					grid[index_i+1][index_j].setText(""+weight[index_i+1][index_j]);
    					grid[index_i+1][index_j-1].setText(""+weight[index_i+1][index_j-1]);
    					grid[index_i+1][index_j+1].setText(""+weight[index_i+1][index_j+1]);
    					
    					
    					
    				}
    				else if((index_i == row-1) )
    				{
    					weight[index_i][index_j-1] += 1;
    					weight[index_i][index_j+1] += 1;
    					weight[index_i-1][index_j] += 1;
    					weight[index_i-1][index_j-1] += 1;
    					weight[index_i-1][index_j+1] += 1;
    					
    					if(weight[index_i][index_j-1] > centre_of_mass[index_i][index_j-1]){
    						//weight[index_i][index_j-1] = 0;
    						updte_weight(index_i,index_j-1);
    					}
    					else if(weight[index_i][index_j+1] > centre_of_mass[index_i][index_j+1]){
    						//weight[index_i][index_j+1] = 0;
    						updte_weight(index_i,index_j+1);
    					}
    					else if(weight[index_i-1][index_j] > centre_of_mass[index_i-1][index_j]){
    						//weight[index_i-1][index_j] = 0;
    						updte_weight(index_i-1,index_j);
    					}
    					else if(weight[index_i-1][index_j-1] > centre_of_mass[index_i-1][index_j-1]){
    						//weight[index_i-1][index_j-1] = 0;
    						updte_weight(index_i-1,index_j-1);
    					}
    					else if(weight[index_i-1][index_j+1] > centre_of_mass[index_i-1][index_j+1]){
    						//weight[index_i-1][index_j+1] = 0;
    						updte_weight(index_i-1,index_j+1);
    					}
    					
    					grid[index_i][index_j-1].setText(""+weight[index_i][index_j-1]);
    					grid[index_i][index_j+1].setText(""+weight[index_i][index_j+1]);
    					grid[index_i-1][index_j].setText(""+weight[index_i-1][index_j]);
    					grid[index_i-1][index_j-1].setText(""+weight[index_i-1][index_j-1]);
    					grid[index_i-1][index_j+1].setText(""+weight[index_i-1][index_j+1]);
    					
    					
    				}
    				else if((index_j == 0) )
    				{
    					weight[index_i-1][index_j] += 1;
    					weight[index_i+1][index_j] += 1;
    					weight[index_i][index_j+1] += 1;
    					weight[index_i-1][index_j+1] += 1;
    					weight[index_i+1][index_j+1] += 1;
    					
    					if(weight[index_i-1][index_j] > centre_of_mass[index_i-1][index_j]){
    						//weight[index_i-1][index_j] = 0;
    						updte_weight(index_i-1,index_j);
    					}
    					else if(weight[index_i+1][index_j] > centre_of_mass[index_i+1][index_j]){
    						//weight[index_i+1][index_j] = 0;
    						updte_weight(index_i+1,index_j);
    					}
    					else if(weight[index_i][index_j+1] > centre_of_mass[index_i][index_j+1]){
    						//weight[index_i][index_j+1] = 0;
    						updte_weight(index_i,index_j+1);
    					}
    					else if(weight[index_i-1][index_j+1] > centre_of_mass[index_i-1][index_j+1]){
    						//weight[index_i-1][index_j+1] = 0;
    						updte_weight(index_i-1,index_j+1);
    					}
    					else if(weight[index_i+1][index_j+1] > centre_of_mass[index_i+1][index_j+1]){
    						//weight[index_i+1][index_j+1] = 0;
    						updte_weight(index_i+1,index_j+1);
    					}
    					grid[index_i-1][index_j].setText(""+weight[index_i-1][index_j]);
    					grid[index_i+1][index_j].setText(""+weight[index_i+1][index_j]);
    					grid[index_i][index_j+1].setText(""+weight[index_i][index_j+1]);
    					grid[index_i-1][index_j+1].setText(""+weight[index_i-1][index_j+1]);
    					grid[index_i+1][index_j+1].setText(""+weight[index_i+1][index_j+1]);
    					
    					
    				}
    				else if((index_j == col-1) )
    				{
    					weight[index_i-1][index_j] += 1;
    					weight[index_i+1][index_j] += 1;
    					weight[index_i][index_j-1] += 1;
    					weight[index_i-1][index_j-1] += 1;
    					weight[index_i+1][index_j-1] += 1;
    					
    					if(weight[index_i-1][index_j] > centre_of_mass[index_i-1][index_j]){
    						//weight[index_i-1][index_j] = 0;
    						updte_weight(index_i-1,index_j);
    					}
    					else if(weight[index_i+1][index_j] > centre_of_mass[index_i+1][index_j]){
    						//weight[index_i+1][index_j] = 0;
    						updte_weight(index_i+1,index_j);
    					}
    					else if(weight[index_i][index_j-1] > centre_of_mass[index_i][index_j-1]){
    						//weight[index_i][index_j-1] = 0;
    						updte_weight(index_i,index_j-1);
    					}
    					else if(weight[index_i-1][index_j-1] > centre_of_mass[index_i-1][index_j-1]){
    						//weight[index_i-1][index_j-1] = 0;
    						updte_weight(index_i-1,index_j-1);
    					}
    					else if(weight[index_i+1][index_j-1] > centre_of_mass[index_i+1][index_j-1]){
    						//weight[index_i+1][index_j-1] = 0;
    						updte_weight(index_i+1,index_j-1);
    					}
    					grid[index_i-1][index_j].setText(""+weight[index_i-1][index_j]);
    					grid[index_i+1][index_j].setText(""+weight[index_i+1][index_j]);
    					grid[index_i][index_j-1].setText(""+weight[index_i][index_j-1]);
    					grid[index_i-1][index_j-1].setText(""+weight[index_i-1][index_j-1]);
    					grid[index_i+1][index_j-1].setText(""+weight[index_i+1][index_j-1]);
    					
    					
    				}
    				else{
    					weight[index_i-1][index_j] += 1;
    					weight[index_i+1][index_j] += 1;
    					weight[index_i][index_j-1] += 1;
    					weight[index_i][index_j+1] += 1;
    					weight[index_i-1][index_j-1] += 1;
    					weight[index_i-1][index_j+1] += 1;
    					weight[index_i+1][index_j-1] += 1;
    					weight[index_i+1][index_j+1] += 1;
    					
    					if(weight[index_i-1][index_j] > centre_of_mass[index_i-1][index_j]){
    						//weight[index_i-1][index_j] = 0;
    						updte_weight(index_i-1,index_j);
    					}
    					else if(weight[index_i+1][index_j] > centre_of_mass[index_i+1][index_j]){
    						//weight[index_i+1][index_j] = 0;
    						updte_weight(index_i+1,index_j);
    					}
    					else if(weight[index_i][index_j-1] > centre_of_mass[index_i][index_j-1]){
    						//weight[index_i][index_j-1] = 0;
    						updte_weight(index_i,index_j-1);
    					}
    					else if(weight[index_i][index_j+1] > centre_of_mass[index_i][index_j+1]){
    						//weight[index_i][index_j+1] = 0;
    						updte_weight(index_i,index_j+1);
    					}
    					else if(weight[index_i-1][index_j-1] > centre_of_mass[index_i-1][index_j-1]){
    						//weight[index_i-1][index_j-1] = 0;
    						updte_weight(index_i-1,index_j-1);
    					}
    					else if(weight[index_i-1][index_j+1] > centre_of_mass[index_i-1][index_j+1]){
    						//weight[index_i-1][index_j+1] = 0;
    						updte_weight(index_i-1,index_j+1);
    					}
    					else if(weight[index_i+1][index_j-1] > centre_of_mass[index_i+1][index_j-1]){
    						//weight[index_i+1][index_j-1] = 0;
    						updte_weight(index_i+1,index_j-1);
    					}
    					else if(weight[index_i+1][index_j+1] > centre_of_mass[index_i+1][index_j+1]){
    						//weight[index_i+1][index_j+1] = 0;
    						updte_weight(index_i+1,index_j+1);
    					}
    					
    					grid[index_i-1][index_j].setText(""+weight[index_i-1][index_j]);
    					grid[index_i+1][index_j].setText(""+weight[index_i+1][index_j]);
    					grid[index_i][index_j-1].setText(""+weight[index_i][index_j-1]);
    					grid[index_i][index_j+1].setText(""+weight[index_i][index_j+1]);
    					grid[index_i-1][index_j-1].setText(""+weight[index_i][index_j-1]);
    					grid[index_i-1][index_j+1].setText(""+weight[index_i-1][index_j+1]);
    					grid[index_i+1][index_j-1].setText(""+weight[index_i+1][index_j-1]);
    					grid[index_i+1][index_j+1].setText(""+weight[index_i+1][index_j+1]);
    					
    					
    				}
    	    		grid[index_i][index_j].setText(""+weight[index_i][index_j]);
    	    	}
    	System.out.println("COM: "+centre_of_mass[index_i][index_j]); 
    	
    }
    public NewClass() {
    	GridLayout layt = new GridLayout(row,col);
        f = new JFrame();
        f.setTitle("new frame");
        f.setBounds(100, 100, 500, 500);
        
       // JLabel[][] grid= new JLabel[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                grid[i][j] = new JLabel();
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                grid[i][j].setText(i+","+j);
                f.add(grid[i][j]);
                weight[i][j] = 0;
                if(i == 0 && j == 0 || i == 0 && j == col-1 || i == row-1 && j == 0 || i == row-1 && j == col-1){
                	centre_of_mass[i][j]= 1;
                }
                else if(i == 0 || j == 0 || i == row-1 || j == col-1){
                	centre_of_mass[i][j]= 2;
                }
                else{
                	centre_of_mass[i][j]= 3;
                }
            }
        }
        
        grid[0][0].setBackground(Color.red);
        f.setLayout(layt);
        f.setVisible(true);
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                final int index_i = i;
                final int index_j = j;
                grid[index_i][index_j].setText(""+weight[index_i][index_j]);
                grid[i][j].addMouseListener(new MouseAdapter() { 
                public void mousePressed(MouseEvent me) { 
                	weight[index_i][index_j] += 1;
                	grid[index_i][index_j].setText(""+weight[index_i][index_j]); 
                	updte_weight(index_i, index_j);
                }
    }); 
            }
        } 
        
        
    }
    
    
    public static void main(String[] args) {
        new NewClass();
        
    }
    
 }
