/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flappyduck;
/**
 *
 * @author Compaq
 */
public class Panel extends javax.swing.JPanel implements java.awt.event.KeyListener{
    flappyduck.asset.Arena arena;
    flappyduck.asset.Pipe pipe;
    flappyduck.asset.Duck duck;    
    flappyduck.asset.Text text;
    public java.util.ArrayList<java.awt.Rectangle> pipes;
    public boolean menu, start, finish;
    public int score, speed;
    public javax.sound.sampled.Clip duckClip, playClip ,pointClip, bgmClip;
    
    public Panel(){
        inisialisasi();
    }
    
    final void inisialisasi(){
        setPreferredSize(new java.awt.Dimension(800,600));
        arena = new flappyduck.asset.Arena();
        pipe = new flappyduck.asset.Pipe();
        duck = new flappyduck.asset.Duck();
        text = new flappyduck.asset.Text();
        pipes = new java.util.ArrayList<>();
        speed = 5;
        
        try{
            javax.sound.sampled.AudioInputStream audio = javax.sound.sampled.AudioSystem.getAudioInputStream(getClass().getResource("sound/point.wav"));
            pointClip = javax.sound.sampled.AudioSystem.getClip();
            pointClip.open(audio);
            
            audio = javax.sound.sampled.AudioSystem.getAudioInputStream(getClass().getResource("sound/play.wav"));
            playClip = javax.sound.sampled.AudioSystem.getClip();
            playClip.open(audio);
            
            audio = javax.sound.sampled.AudioSystem.getAudioInputStream(getClass().getResource("sound/bgm.wav"));
            bgmClip = javax.sound.sampled.AudioSystem.getClip();
            bgmClip.open(audio);
            bgmClip.loop(javax.sound.sampled.Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception ex){
        }
    }
    
    public void soundDuck(){
        if(start ==true){
            try{
                javax.sound.sampled.AudioInputStream audio = javax.sound.sampled.AudioSystem.getAudioInputStream(getClass().getResource("sound/duck.wav"));
                duckClip = javax.sound.sampled.AudioSystem.getClip();
                duckClip.open(audio);
            }catch(Exception ex){
                
            }
            
        duckClip.setFramePosition(0);
        duckClip.start();
        }       
    }
    public void soundPlay(){
        playClip.setFramePosition(0);
        playClip.start(); 
        
    }
    public void soundPoint(){
        pointClip.setFramePosition(0);
        pointClip.start();
    }
    public void soundBGM(){
        bgmClip.setFramePosition(0);
        bgmClip.start();
    } 
    
    public void Starts(){
	if (finish == true){
            finish = false;
            duck = new flappyduck.asset.Duck(); 
            pipe.pipes.clear();
            score = 0;
            speed = 5;
            
            pipe.addPipe(true);
            pipe.addPipe(true);
            pipe.addPipe(true);
            pipe.addPipe(true);
	}if(start == false){ 
            soundBGM();
            soundPlay();
            start= true;
        }
        if(menu == false){
           menu =true;
        }
    }
 
    @Override
    public void paint(java.awt.Graphics g){
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        arena.arena(g2);
        pipe.showPipe(g2);
        duck.duckPlay(g2);
        
        if (start == true) {    
            duck.duckFall();
            for (int i = 0; i < pipe.pipes.size(); i++) {
                java.awt.Rectangle pipes2 = pipe.pipes.get(i);
                pipes2.x -=speed;
            }
            for (int i = 0; i < pipe.pipes.size(); i++){
                java.awt.Rectangle pipes2 = pipe.pipes.get(i);
                if (pipes2.x + pipes2.width < 0){
                    pipe.pipes.remove(pipes2);
                    if (pipes2.y == 0){
                        pipe.addPipe(false);
                    }
                }
            }
        }
        for (java.awt.Rectangle pipes2 : pipe.pipes){
            if (pipes2.y == 0 && duck.x + duck.besar / 2 > pipes2.x + pipes2.width / 2 - 4 
                    && duck.x + duck.besar / 2 < pipes2.x + pipes2.width / 2 + 3){
		score++;
                soundPoint();
                if(score >= 5){
                    speed = 8;
                }if(score >= 10){
                    speed = 10;
                }if(score >= 15){
                    speed = 12;
                }if(score >= 20){
                    speed = 14;
                }if(score >= 25){
                    speed = 16;   
                }
            }
            
            if (pipes2.intersects(duck.getX(),duck.getY(), duck.getBesar(),duck.getBesar())) {
                start = false;
                finish = true;
            }else if(duck.y <= -50){
                duck.y = -50;
                start = false;
                finish = true;
            }else if(duck.y >= 460){
                duck.duckStay();                      
                start = false;
                finish = true; 
            }
        }
        
        if (finish == true){
            text.gagal(g2);  
	}if (menu == false) {
            text.judul(g2);
        }if (start == true || finish == true){
            text.skor(g2);
            g2.drawString("Skor : " + String.valueOf(score), 630, 40);  
	}
        text.tombol(g2);
    }
    
    @Override
    public void keyTyped(java.awt.event.KeyEvent evt){
    
    }
    @Override
    public void keyPressed(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()){
            case 32:                
                Starts();
                break;
            case 38:
                duck.duckJump();
                soundDuck();
                break;
        }
    }  
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt){
    
    }
}