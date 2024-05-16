/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class Caut extends javax.swing.JFrame
{
    public Caut ()
        {initComponents();}
    private void initComponents()
    {
        JLabel numel = new JLabel("Nume:");
        JLabel prenumel = new JLabel("Prenume:");
        JLabel cnpl = new JLabel("CNP:");
        JLabel telfixl = new JLabel("Telefon fix:");
        JLabel telmobl = new JLabel("Telefon mobil:");
        final JTextField numetf = new JTextField();
        final JTextField prenumetf = new JTextField();
        final JTextField cnptf = new JTextField();
        final JTextField telfixtf = new JTextField();
        final JTextField telmobtf = new JTextField();
        JButton add = new JButton("Cauta");
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if((numetf.getText().length()>0)&&(!Abonat.letcont(numetf.getText())))
                        throw new Exception("Nume invalid!");
                    if((prenumetf.getText().length()>0)&&(!Abonat.letcont(prenumetf.getText())))
                        throw new Exception("Prenume invalid!");
                    if((telfixtf.getText().length()>0)&&(Abonat.parsable(telfixtf.getText())))
                            throw new Exception("Numar telefon fix invalid!");
                    if((telmobtf.getText().length()>0)&&(Abonat.parsable(telmobtf.getText())))
                            throw new Exception("Numar telefon mobil invalid!");
                    if(numetf.getText().length()>0)
                        for(Object o : Test.carteTelefon.c)
                        {
                            Abonat a = (Abonat) o;
                            if((a.deAfisat)&&(!a.nume.contains(numetf.getText().subSequence(0,numetf.getText().length()))))
                                a.deAfisat=false;
                        }
                   if(prenumetf.getText().length()>0)
                        for(Object o : Test.carteTelefon.c)
                        {
                            Abonat a = (Abonat) o;
                            if((a.deAfisat)&&(!a.prenume.contains(prenumetf.getText().subSequence(0,prenumetf.getText().length()))))
                                a.deAfisat=false;
                        }
                    if(cnptf.getText().length()>0)
                        for(Object o : Test.carteTelefon.c)
                        {
                            Abonat a = (Abonat) o;
                            if((a.deAfisat)&&(!a.cnp.contains(cnptf.getText().subSequence(0,cnptf.getText().length()))))
                                a.deAfisat=false;
                        }
                    if(telfixtf.getText().length()>0)
                        for(Object o : Test.carteTelefon.c)
                        {
                            Abonat a = (Abonat) o;
                            if((a.deAfisat)&&(!a.telfix.contains(telfixtf.getText().subSequence(0,telfixtf.getText().length()))))
                                a.deAfisat=false;
                        }
                    if(telmobtf.getText().length()>0)
                        for(Object o : Test.carteTelefon.c)
                        {
                            Abonat a = (Abonat) o;
                            if((a.deAfisat)&&(!a.telmob.contains(telmobtf.getText().subSequence(0,telmobtf.getText().length()))))
                                a.deAfisat=false;
                        }
                    Test.carteTelefon.refresh();
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(Caut.this, ex.getMessage(), "Eroare!", JOptionPane.ERROR_MESSAGE);
                }
                Caut.this.dispose();
            }
        });
        JButton cal = new JButton("Anuleaza");
        cal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                Caut.this.dispose();
            }
        });
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(6, 2));
        this.add(numel);    this.add(numetf);
        this.add(prenumel); this.add(prenumetf);
        this.add(cnpl);     this.add(cnptf);
        this.add(telfixl);  this.add(telfixtf);
        this.add(telmobl);  this.add(telmobtf);
        this.add(add);      this.add(cal);
        this.pack();
    }
}