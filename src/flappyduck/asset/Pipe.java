/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flappyduck.asset;

/**
 *
 * @author Compaq
 */
public class Pipe {
    public java.util.ArrayList<java.awt.Rectangle> pipes;
    public java.util.Random rand;
    public int space, width, height;
    
    public Pipe(){
        rand = new java.util.Random();
        pipes = new java.util.ArrayList<>();
        addPipe(true);
	addPipe(true);
	addPipe(true);
	addPipe(true);   
    }
    
    public void addPipe(boolean start){
        space = 250;
        width = 50;
        height = 100 + rand.nextInt(250);
        
        if(start){
            pipes.add(new java.awt.Rectangle(800 + width + pipes.size() * 300, 600 - height - 90, width, height));
            pipes.add(new java.awt.Rectangle(800 + width + (pipes.size() - 1) * 300, 0, width, 600 - height - space));
        }
        else{
            pipes.add(new java.awt.Rectangle(pipes.get(pipes.size() - 1).x + 600, 600 - height - 90, width, height));
            pipes.add(new java.awt.Rectangle(pipes.get(pipes.size() - 1).x, 0, width, 600 - height - space));
	}
    }
    
    public void paintPipe(java.awt.Graphics g, java.awt.Rectangle pipe){
        g.setColor(java.awt.Color.GREEN.darker());
        g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
    }
     
    public void showPipe(java.awt.Graphics g){
        for (java.awt.Rectangle pipe : pipes){
            paintPipe(g, pipe);
        }
    }    
}