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
public class Text {
    flappyduck.asset.Duck duck;
    
    public void judul(java.awt.Graphics g){
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;        
        g2.setColor(java.awt.Color.BLUE);
        g2.fillRoundRect(180, 50, 440, 90, 15, 15);
        g2.setColor(java.awt.Color.WHITE);
	g2.setFont(new java.awt.Font("Arial", 1, 70));
        g2.drawString("Flappy Duck", 190, 115); 
    }
    
    public void skor(java.awt.Graphics g){
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.setColor(java.awt.Color.RED);
        g2.fillRoundRect(620, 10, 160, 40, 15, 15);
        g2.setColor(java.awt.Color.WHITE);
        g2.setFont(new java.awt.Font("Roboto", 1, 30));
    }
    
    public void gagal(java.awt.Graphics g){
       java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
       g2.setColor(java.awt.Color.WHITE);
       g2.fillRoundRect(190, 200, 420, 60, 15, 15);
       g2.setColor(java.awt.Color.BLACK);
       g2.setFont(new java.awt.Font("Arial", 1, 30));
       g2.drawString("Permainan Selesai", 210, 240);
       judul(g2);
       duck = new flappyduck.asset.Duck();
       duck.duckFail(g2);
    }
    
     public void tombol(java.awt.Graphics g){
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;        
        g2.setColor(java.awt.Color.MAGENTA);
        g2.setFont(new java.awt.Font("Helvetica", 1, 20));
        g2.fillRoundRect(100, 540, 275, 50, 15, 15);
        g2.setColor(java.awt.Color.WHITE);
        g2.drawString("Tekan [Spasi] untuk Mulai", 110, 570); 
        
        g2.setColor(java.awt.Color.MAGENTA);
        g2.fillRoundRect(430, 540, 285, 50, 15, 15);
        g2.setColor(java.awt.Color.WHITE);
	g2.setFont(new java.awt.Font("Helvetica", 1, 20));
        g2.drawString("Tekan [Atas] untuk Lompat", 440, 570);
    }
}