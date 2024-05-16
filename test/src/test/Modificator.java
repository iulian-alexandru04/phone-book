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
public class Modificator extends javax.swing.JFrame
{
    public Modificator ()
        {initComponents();}
    private void initComponents()
    {
        JLabel cnpl = new JLabel("Introduceti CNP-ul persoanei dorite:");
        JLabel msg = new JLabel("Modificari aduse:");
        JLabel blnk = new JLabel("");
        JLabel prenumel = new JLabel("Prenume:");
        JLabel numel = new JLabel("Nume:");
        JLabel telfixl = new JLabel("Telefon fix:");
        JLabel telmobl = new JLabel("Telefon mobil:");
        final JTextField numetf = new JTextField();
        final JTextField prenumetf = new JTextField();
        final JTextField cnptf = new JTextField();
        final JTextField telfixtf = new JTextField();
        final JTextField telmobtf = new JTextField();
        JButton add = new JButton("Modifica");
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                Abonat abonat = null;
                String cnpcaut = cnptf.getText();
                for(Object o : Test.carteTelefon.c)
                {
                    Abonat a = (Abonat) o;
                    if(a.cnp.equals(cnpcaut))
                        {abonat=a;  break;}
                }
                try
                {
                    if(abonat==null)
                    {
                        throw new NullPointerException("Nu exista persoana cu CNP-ul introdus");
                    }
                    if(numetf.getText().length()>0)
                    {
                        if(Abonat.numeValid(numetf.getText()))
                        {
                            abonat.nume = numetf.getText();
                        }
                        else
                        {
                            throw new Exception("Nume invalid");
                        }
                    }
                    if(prenumetf.getText().length()>0)
                    {
                        if(Abonat.numeValid(prenumetf.getText()))
                        {
                            abonat.prenume = prenumetf.getText();
                        }
                        else
                        {
                            throw new Exception("Prenume invalid");
                        }
                    }
                    if(telfixtf.getText().length()>0)
                    {
                        if(Abonat.numarValid(telfixtf.getText()))
                        {
                            abonat.telfix = telfixtf.getText();
                        }
                        else
                        {
                            throw new Exception("Numar de telefon fix invalid");
                        }
                    }
                    if(telmobtf.getText().length()>0)
                    {
                        if(Abonat.numarValid(telmobtf.getText()))
                        {
                            abonat.telmob = telmobtf.getText();
                        }
                        else
                        {
                            throw new Exception("Numar de telefon mobil invalid");
                        }
                    }
                }
                catch(Throwable err)  
                {
                    JOptionPane.showMessageDialog(null,err.getMessage(),"Eroare!", JOptionPane.ERROR_MESSAGE);
                }
                Test.carteTelefon.refresh();
                Modificator.this.dispose();
            }
        });
        JButton cal = new JButton("Anuleaza");
        cal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                Modificator.this.dispose();
            }
        });
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(7, 2));
        this.add(cnpl);     this.add(cnptf);
        this.add(msg);      this.add(blnk);
        this.add(numel);    this.add(numetf);
        this.add(prenumel); this.add(prenumetf);
        this.add(telfixl);  this.add(telfixtf);
        this.add(telmobl);  this.add(telmobtf);
        this.add(add);      this.add(cal);
        this.pack();
    }
}
