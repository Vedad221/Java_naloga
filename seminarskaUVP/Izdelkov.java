import java.io.*;
import java.util.*;

public class Izdelkov {
    private String imeIzdelkov;
	private int kos;
    private int cena;
    private boolean jeAkcija;
    private int stSklad;
	private int stKupljenih;
   

    public Izdelkov(String imeIzdelkov,int kos, int cena, boolean jeAkcija, int stSklad) {
        this.imeIzdelkov=imeIzdelkov;
        this.kos=kos;
        this.cena=cena;
        this.jeAkcija=jeAkcija;
        this.stSklad=stSklad;
		this.stKupljenih=0;
    }

    public String getIme() {
        return imeIzdelkov;
    }

    public int getKos() {
        return kos;
    }

    public int getCena() {
        return cena;
    }

    public boolean getjeAkcija() {
        return jeAkcija;
    }
	
	public int getstKupljenih()
	{
		return stKupljenih;
	}
    
	public void setstKupljenih(int stKupljenih)
	{
		this.stKupljenih=stKupljenih;
	}
    public int getstSklad() {
        return stSklad;
    }

    public void setKos(int kos) {
        this.kos=kos;
    }

    public void setstSklad(int stSklad) {
        this.stSklad=stSklad;
    }

    public String shraniKoNiz() {
        String niz= "Ime izdelka je: " + this.imeIzdelkov +"\n";
		niz+="Stevilo kos v radnji je:"+this.kos+ "\n";
		niz+="Cena izdelka je: "+this.cena+"\n";
		if(this.jeAkcija)
			niz+="Izdelk je na akciji.";
		else
			niz+="Izdelk ni na akciji";
		niz+="Stevilo izdelka na skladiscu je: "+this.stSklad;
		
        return niz;
    }


	



}
