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
public class Duck{
    public int x,y, besar, yArah, step;
    private java.awt.Image play, fail;

    public Duck(){
        x = 350;
        y = 200;
        besar = 50;
        yArah = 0;
        step = 1;
        
        play = new javax.swing.ImageIcon("./src/flappyduck/img/duck-flying.gif").getImage();
        fail = new javax.swing.ImageIcon("./src/flappyduck/img/duck-fail.gif").getImage();
    }   
    
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public void setBesar(int besar){
        this.besar = besar;
    }
    public int getBesar(){
        return besar;
    }
    public void duckFall(){
        y = y + yArah;
        yArah = yArah + step;   
    }
    public void duckStay(){
        y = 460;
    }
    public void duckJump(){
        yArah = -10;        
    }
    
    public void duckPlay(java.awt.Graphics g){
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.drawImage(play, x, y, besar+30, besar+30, null);
    }
    public void duckFail(java.awt.Graphics g){
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.drawImage(fail, x+140, y-10, besar+40, besar+40, null);
    }
}