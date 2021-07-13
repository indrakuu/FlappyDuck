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
public class MainFrame extends javax.swing.JFrame implements java.awt.event.ActionListener{
    flappyduck.Panel panel;
    javax.swing.Timer timer;
    
    public MainFrame(){
        inisialisasi();
        
    }
    final void inisialisasi(){
        setTitle("Flappy Duck | by Indra Kurniawan 190155201051");
        setSize(800,600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);        
        panel = new Panel();
        getContentPane().add(panel);
        addKeyListener(panel);
        javax.swing.Timer timer = new javax.swing.Timer(15, this);
        timer.start();
        pack();
        setVisible(true);        
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        repaint();
    }
}