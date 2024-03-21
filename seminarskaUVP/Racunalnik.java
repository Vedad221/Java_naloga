import java.io.*;
import java.util.*;

public class Racunalnik extends Izdelkov {
    private String procesor;

    public Racunalnik (String imeIzdelkov,int kos, int cena, boolean jeAkcija, int stSklad,String procesor) {
        super(imeIzdelkov,kos,cena,jeAkcija,stSklad);
        this.procesor=procesor;
    }

    public String getProcesor() {
        return procesor;
    }

    @Override
    public String shraniKoNiz() {
        return super.shraniKoNiz() +
                "\nProcesor: " + procesor;
    }
	public static Racunalnik preberiIzNiza(ArrayList<String> izdelk)
	{
		try
		{
		String ime=izdelk.get(0);
		int kos=Integer.parseInt(izdelk.get(1));
		int cena=Integer.parseInt(izdelk.get(2));
		boolean jeAkcija= Boolean.parseBoolean(izdelk.get(3));
		int stSklad=Integer.parseInt(izdelk.get(4));
		String procesor=izdelk.get(5);
		
		Racunalnik tel=new Racunalnik(ime,kos,cena,jeAkcija,stSklad,procesor);
		return tel;
		}
		catch (Exception e)
		{
			System.out.println("Prislo je do napake.");
			throw e;
		}
		
		
	}
	
}