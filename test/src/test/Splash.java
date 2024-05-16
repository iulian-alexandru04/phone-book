/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.FlowLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author black
 */
public class Splash extends javax.swing.JFrame
{
    public Splash ()
        {initComponents();}
    private void initComponents()
    {
        URL u = Splash.class.getResource("iconSplash.png");
        JLabel icon = new JLabel(); icon.setIcon(new ImageIcon(u));
        JLabel name = new JLabel("Dumitrache Iulian");
        this.setSize(256, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.add(icon);    this.add(name);
        this.setUndecorated(true);
    }    
}
