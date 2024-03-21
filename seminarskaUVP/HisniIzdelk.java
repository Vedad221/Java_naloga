import java.io.*;
import java.util.*;

public class HisniIzdelk extends Izdelkov {
    private String barva;

    public HisniIzdelk (String imeIzdelkov,int kos, int cena, boolean jeAkcija, int stSklad,String barva) {
        super(imeIzdelkov,kos,cena,jeAkcija,stSklad);
        this.barva=barva;
    }

    public String getBarva() {
        return barva;
    }

    @Override
    public String shraniKoNiz() {
        return super.shraniKoNiz() +
                "\nBarva izdelka: " + barva;
    }
	
	public static HisniIzdelk preberiIzNiza(ArrayList<String> izdelk)
	{
		try
		{
		String ime=izdelk.get(0);
		int kos=Integer.parseInt(izdelk.get(1));
		int cena=Integer.parseInt(izdelk.get(2));
		boolean jeAkcija= Boolean.parseBoolean(izdelk.get(3));
		int stSklad=Integer.parseInt(izdelk.get(4));
		String barva=izdelk.get(5);
		
		HisniIzdelk tel=new HisniIzdelk(ime,kos,cena,jeAkcija,stSklad,barva);
		return tel;
		}
		catch (Exception e)
		{
			System.out.println("Prislo je do napake.");
			throw e;
		}
		
		
	}
}