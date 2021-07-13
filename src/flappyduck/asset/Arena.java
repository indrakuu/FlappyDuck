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
public class Arena {
    final private int x,y, lebar,tinggi;
    private java.awt.Image bgArena;
    public Arena(){
        x = 0;
        y = 0;
        lebar = 800;
        tinggi = 600;
        bgArena = new javax.swing.ImageIcon("./src/flappyduck/img/bg-sky.gif").getImage();
    }
    
    public void arena(java.awt.Graphics g){
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.drawImage(bgArena, x, y, lebar, tinggi, null);
        
        java.awt.geom.Rectangle2D rumput = new java.awt.geom.Rectangle2D.Double(x, tinggi-90, lebar, 30);
        g2.setColor(java.awt.Color.GREEN.darker());
        g2.fill(rumput); 
        
        java.awt.geom.Rectangle2D tanah = new java.awt.geom.Rectangle2D.Double(x, tinggi-70, lebar, 150);
        g2.setColor(java.awt.Color.ORANGE);
        g2.fill(tanah);
    }   
}