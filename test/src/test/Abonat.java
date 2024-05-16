/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;

/**
 *
 * @author black
 */
public class Abonat implements Serializable
{
    String nume, prenume, cnp, telfix, telmob;
    boolean deAfisat = true;
    public static long pow (int x, int y)
    {
        long rez=1;
        for(int i=1;i<=y;i++)
        {
            rez*=x;
        }
        return rez;
    }
    public static boolean parsable(String sir)
    {
        try
        {
            int x = Integer.parseInt(sir);
        }
        catch(Throwable e)  {return false;}
        return true;
    }
    public static boolean letcont(String sir)
    {
        byte[] n = sir.getBytes();
        for(int i=0;i<n.length;i++)
        {
            if((n[i]<65)||((90<n[i])&&(n[i]<97))||(122<n[i]))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean numarValid(String sir)
    {
        try
        {
            if(sir.length()!=10)
            {
                throw new Exception();
            }
            int x = Integer.parseInt(sir);
        }
        catch(Throwable e)  {return false;}
        return true;
    }
    public static boolean cnpValid(String sir)
    {
        try
        {
            if(sir.length()!=13)
            {
                throw new Exception("CNP-ul nu are lungimea potrivita");
            }
            long x = Long.parseLong(sir);
            if((x/pow(10,12)==3)||(x/pow(10,12)==4))
            {
                throw new Exception("nu poti introduce persoan nascute in 1800");
            }
            if(((x/pow(10,12)==5)||(x/pow(10,12)==6))&&(x/pow(10,10)%100>12))
            {
                throw new Exception("nu poti introduce persoane ce se vor naste");
            }
            if((x/pow(10,8)%100==0)||(x/pow(10,8)%100>12))
            {
                throw new Exception("luna incorecta");
            }
            if((x/pow(10,6)%100==0)||(x/pow(10,6)%100>31))
            {
                throw new Exception("zi incorecta");
            }
        }
        catch(Throwable e)  {return false;}
        return true;
    }
    public static boolean numeValid(String sir)
    {
        if(letcont(sir))    return true;
        return false;
    }
    Abonat(String n, String p, String c, String tf, String tm) throws Exception 
    {
        if(n.length()==0)
        {
            throw new Exception("Introduceti nume");
        }
        if(p.length()==0)
        {
            throw new Exception("Introduceti prenume");
        }
        if(c.length()==0)
        {
            throw new Exception("Introduceti CNP");
        }
        if((tf.length()==0)&&(tm.length()==0))
        {
            throw new Exception("Introduceti cel putin un numar de telefon");
        }
        if(!numeValid(n))
        {
            throw new Exception("Nume invalid");
        }
        if(!numeValid(p))
        {
            throw new Exception("Prenume invalid");
        }
        if(!cnpValid(c))
        {
            throw new Exception("CNP invalid");
        }
        if((tf.length()!=0)&&(!numarValid(tf)))
        {
            throw new Exception("Numar de telefon fix invalid");
        }
        if((tm.length()!=0)&&(!numarValid(tm)))
        {
            throw new Exception("Numar de telefon mobil invalid");
        }
        for(Object o : Test.carteTelefon.c)
        {
            Abonat a = (Abonat) o;
            if(a.cnp.equals(c))
            {
                throw new Exception("Persoana se afla deja in agenda");
            }
        }
        nume=n; prenume=p; cnp=c; telfix=tf; telmob=tm;
        while(nume.length()<13)
            nume+=' ';
        while(prenume.length()<13)
            prenume+=' ';
        while(cnp.length()<13)
            cnp+=' ';
        while(telfix.length()<13)
            telfix+=' ';
        while(telmob.length()<13)
            telmob+=' ';
    }
    @Override
    public String toString()
    {
        return nume+" | "+prenume+" | "+cnp+" | "+telfix+" | "+telmob+"\n";
    }
}
