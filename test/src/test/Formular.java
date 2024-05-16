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
public class Formular extends javax.swing.JFrame
{
    public Formular ()
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
        JButton add = new JButton("Adauga");
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Abonat abonat = new Abonat(numetf.getText(), prenumetf.getText(), cnptf.getText(), telfixtf.getText(), telmobtf.getText());
                    Test.carteTelefon.adauga(abonat);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(Formular.this, ex.getMessage(), "Eroare!", JOptionPane.ERROR_MESSAGE);
                }
                Formular.this.dispose();
            }
        });
        JButton cal = new JButton("Anuleaza");
        cal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                Formular.this.dispose();
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
