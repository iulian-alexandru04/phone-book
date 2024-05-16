/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author black
 */
public class Test
{

    /**
     * @param args the command line arguments
     */
    public static CarteTelefon carteTelefon = new CarteTelefon();
    public static File fa = new File("activator");
    public static TextArea lista;
    public static JRadioButton r1,r2,r3,r4,r5;
    public static Activator a;
    public static void load() throws Exception
    {
        if(a.f!=null)
        {
        FileInputStream fis = new FileInputStream(a.f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        carteTelefon = (CarteTelefon)ois.readObject();
        ois.close();
        }
    }
    public static void actualsave() throws Exception
    {
        if(a.f!=null)
        {
        FileOutputStream fos = new FileOutputStream(a.f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(carteTelefon);
        oos.close();
        savea();
        }
    }
    public static void savea()
    {
        try
        {
            FileOutputStream fosa = new FileOutputStream(fa);
            ObjectOutputStream oosa = new ObjectOutputStream(fosa);
            oosa.writeObject(a);
            oosa.close();
        }
        catch(Throwable e){}
    }
    public static void init()
    {
       try
       {
            FileInputStream fisa = new FileInputStream(fa);
            ObjectInputStream oisa = new ObjectInputStream(fisa);
            a = (Activator)oisa.readObject();
            oisa.close();
       }catch(Throwable e)
       {
            a = new Activator();
            savea(); 
       }
    }
    public static void main(String[] args)
    {
        Splash s = new Splash();
        s.setVisible(true);
        try
            {Thread.sleep(2000);}
        catch (InterruptedException ex)
            {Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);}
        s.dispose();
        
        init();
                 
        final JFrame main = new JFrame();
        main.setLayout(new BorderLayout());
        
        ActionListener open = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open");
                jfc.setMultiSelectionEnabled(false);
                if(jfc.showSaveDialog(main) == JFileChooser.APPROVE_OPTION);
                {
                    try
                    {
                        a.f = jfc.getSelectedFile();
                        load();
                        carteTelefon.refresh();
                    }
                    catch(Throwable e)
                    {}
                }
            }
        };
        ActionListener save = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Save");
                jfc.setMultiSelectionEnabled(false);
                if(jfc.showSaveDialog(main) == JFileChooser.APPROVE_OPTION);
                {
                    try
                    {
                        a.f = jfc.getSelectedFile();                    
                        actualsave();
                    }
                    catch(Throwable e)
                    {}
                }
            }
        };
        ActionListener add = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Formular f = new Formular();
                f.setVisible(true);
            }
        };
        ActionListener del = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                String cnp = (String)JOptionPane.showInputDialog("Introduceti CNP-ul persoanei dorite");
                if(cnp.length()>0)
                {
                    carteTelefon.sterge(cnp);
                }
            }
        };
        ActionListener find = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Caut f = new Caut();
                f.setVisible(true);
            }
        };
        ActionListener change = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Modificator m = new Modificator();
                m.setVisible(true);
            }
        };
        ActionListener sorteaza = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(r1.isSelected())
                {
                    carteTelefon.sort(1);
                }
                if(r2.isSelected())
                {
                    carteTelefon.sort(2);
                }
                if(r3.isSelected())
                {
                    carteTelefon.sort(3);
                }
                if(r4.isSelected())
                {
                    carteTelefon.sort(4);
                }
                if(r5.isSelected())
                {
                    carteTelefon.sort(5);
                }
            }
        };
        ActionListener all = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                for(Object o : carteTelefon.c)
                {
                    Abonat a = (Abonat) o;
                    a.deAfisat=true;
                }
                carteTelefon.refresh();
            }
        };
        ActionListener exit = new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                try 
                {actualsave();}
                catch (Exception ex){}
                System.exit(0);
            }
        };
        
        
        JMenuItem i;
        
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
            i = new JMenuItem("Open");
                i.addActionListener(open);
                if(!a.activ)
                    i.setEnabled(false);
                file.add(i);
            i = new JMenuItem("Save");
                i.addActionListener(save);
                if(!a.activ)
                    i.setEnabled(false);
                file.add(i);
            file.addSeparator();
            i = new JMenuItem("Iesire");
                i.addActionListener(exit);
                file.add(i);
        JMenu abonati = new JMenu("Abonati");
            i = new JMenuItem("Adaugare");
                i.addActionListener(add);
                abonati.add(i);
            i = new JMenuItem("Cauta");
                i.addActionListener(find);
                abonati.add(i);
            i = new JMenuItem("Sterge");
                i.addActionListener(del);
                abonati.add(i);
            i = new JMenuItem("Modifica");
                i.addActionListener(change);
                abonati.add(i);
        JMenu help = new JMenu("Help");
            i = new JMenuItem("Inregistrare");
            i.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String key = "e=mc2";
                    String cheie = (String)JOptionPane.showInputDialog("Introduceti cheia de activare");
                    if(cheie == null ? key == null : cheie.equals(key))
                    {
                        a.activ=true;
                        savea();
                        JOptionPane.showMessageDialog(main,
                        "Felicitari!Cheiea este corecta!\nReporniti aplicatia",
                        "Inregistrare",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(main,
                        "Gresit! Introduceti alta cheie!",
                        "Inregistrare",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                };
            });
            if(a.activ)
                    i.setEnabled(false);
            help.add(i);
            help.addSeparator();
            i = new JMenuItem("About");
                i.addActionListener(new java.awt.event.ActionListener()
                {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                        JOptionPane.showMessageDialog(main,
                        "Date despre autor",
                        "About",
                        JOptionPane.INFORMATION_MESSAGE);
                    }

                });
                help.add(i);
        menuBar.add(file);
        menuBar.add(abonati);
        menuBar.add(help);
        
        JPanel panel = new JPanel(new GridLayout(13,1));
        JButton b;        
        b = new JButton("Adaugare");
                b.addActionListener(add);
            panel.add(b);
        b = new JButton("Stergere");
                b.addActionListener(del);
            panel.add(b);
        b = new JButton("Modificare");
            b.addActionListener(change);
            panel.add(b);
        b = new JButton("Cautare");
            b.addActionListener(find);
            panel.add(b);
        b = new JButton("Afiseare integrala");
            b.addActionListener(all);
            panel.add(b);
        JLabel l = new JLabel("Sorteaza in functie de:");
            panel.add(l);
        ButtonGroup bg = new ButtonGroup();
        r1 = new JRadioButton("Nume");
            bg.add(r1);
            panel.add(r1);
        r2 = new JRadioButton("Prenume");
            bg.add(r2);
            panel.add(r2);
        r3 = new JRadioButton("CNP");
            bg.add(r3);
            panel.add(r3);
        r4 = new JRadioButton("Telefon fix");
            bg.add(r4);
            panel.add(r4);
        r5 = new JRadioButton("Telefon mobil");
            bg.add(r5);
            panel.add(r5);
        b = new JButton("Sorteaza!");
            b.addActionListener(sorteaza);
            panel.add(b);
        b = new JButton("Iesire");
            b.addActionListener(exit);
            panel.add(b);

        
        lista = new TextArea();
        lista.setFont(new Font("monospaced", Font.PLAIN, 15));
        lista.setEditable(false);
        carteTelefon.refresh();
        
        final JLabel banner = new JLabel();
        final URL[] u;    u=new URL[10];
        u[0] = Test.class.getResource("banner1.png");
        u[1] = Test.class.getResource("banner2.png");
        u[2] = Test.class.getResource("banner3.png");
        u[3] = Test.class.getResource("banner4.jpg");
        banner.setIcon(new ImageIcon(u[0]));
        ActionListener task = new ActionListener() {
            private int i=0;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                banner.setIcon(new ImageIcon(u[i]));
                i=(i+1)%4;
            }
        };
        javax.swing.Timer t = new javax.swing.Timer(2000,task);
        t.setRepeats(true); t.start();
        banner.setHorizontalAlignment(JLabel.CENTER);
        
        ActionListener tasksave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {actualsave();}
                catch (Exception ex){}
            }
        };
        javax.swing.Timer tsave = new javax.swing.Timer(10000,tasksave);
        tsave.setRepeats(true); tsave.start();
        
        main.setJMenuBar(menuBar);
        main.add(panel,BorderLayout.WEST);
        main.add(lista,BorderLayout.CENTER);
        if(!a.activ)
            main.add(banner,BorderLayout.SOUTH);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        
       
    }
}
