/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author black
 */
public class CarteTelefon implements Serializable
{
    int strcomp (String s1, String s2)
    {
        int l1=s1.length();
        int l2=s2.length();
        int i=0;
        while((i<l1)&&(i<l2)&&(s1.charAt(i)==s2.charAt(i)))
        {
            i++;
        }
        if((i==l1)&&(i==l2))
        {
            return 0;
        }
        if((i==l1)&&(i<l2))
        {
            return -1;
        }
        if((i<l1)&&(i==l2))
        {
            return 1;
        }
        l1=(int)s1.charAt(i);
        l2=(int)s2.charAt(i);
        if(l1<l2)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
    class CompNume implements Comparator
    {
       @Override
        public int compare(Object o1, Object o2)
        {
            Abonat s1 = (Abonat)o1;
            Abonat s2 = (Abonat)o2;
            return strcomp(s1.nume,s2.nume);
        }
       
    }
    class CompPreume implements Comparator
    {
       @Override
        public int compare(Object o1, Object o2)
        {
            Abonat s1 = (Abonat)o1;
            Abonat s2 = (Abonat)o2;
            return strcomp(s1.prenume,s2.prenume);
        }
       
    }
    class CompCNP implements Comparator
    {
       @Override
        public int compare(Object o1, Object o2)
        {
            Abonat s1 = (Abonat)o1;
            Abonat s2 = (Abonat)o2;
            return strcomp(s1.cnp,s2.cnp);
        }
       
    }
    class CompFix implements Comparator
    {
       @Override
        public int compare(Object o1, Object o2)
        {
            Abonat s1 = (Abonat)o1;
            Abonat s2 = (Abonat)o2;
            return strcomp(s1.telfix,s2.telfix);
        }
       
    }
    class CompMob implements Comparator
    {
       @Override
        public int compare(Object o1, Object o2)
        {
            Abonat s1 = (Abonat)o1;
            Abonat s2 = (Abonat)o2;
            return strcomp(s1.telmob,s2.telmob);
        }
       
    }
    
    List c = new LinkedList();
    
    public void sort(int x)
    {
        switch(x)
        {
            case 1: Collections.sort(c,new CompNume());     break;
            case 2: Collections.sort(c,new CompPreume());   break;
            case 3: Collections.sort(c,new CompCNP());      break;
            case 4: Collections.sort(c,new CompFix());      break;
            case 5: Collections.sort(c,new CompMob());      break;
            default:    break;
        }
        refresh();
    }
    public void refresh()
    {
        Test.lista.setText("    NUME     "+" | "+"   PRENUME   "+" | "+"     CNP     "+" | "+" TELEFON FIX "+" | "+"TELEFON MOBIL"+"\n");
        Test.lista.append("-----------------------------------------------------------------------------\n");
        for(Object o : c)
        {
            Abonat a = (Abonat) o;
            if(a.deAfisat)
                Test.lista.append(a.toString());
        }
    }
    public void adauga(Abonat x)
    {
        c.add(x);
        refresh();
    }
    public void sterge(String x)
    {
        boolean gasit=false;
        for(Object o : c)
        {
            Abonat a = (Abonat) o;
            if(a.cnp == null ? x == null : a.cnp.equals(x))
            {   
                gasit=true;
                c.remove(o);
                break;
            }
        }
        if(!gasit)
        {
            JOptionPane.showMessageDialog(null,"Persoana nu a fost gasita!","Eroare!", JOptionPane.ERROR_MESSAGE);
        }
        refresh();
    }
}
