import java.io.*;
import java.util.*;

public class Laptop extends Racunalnik {
    private int velEkrana;

    public Laptop(String imeIzdelkov,int kos, int cena, boolean jeAkcija, int stSklad,String procesor,int velEkrana) {
        super(imeIzdelkov,kos, cena, jeAkcija, stSklad, procesor);
        this.velEkrana = velEkrana;
    }

    public int getVelEkrana() {
        return velEkrana;
    }

    @Override
    public String shraniKoNiz() {
        return super.shraniKoNiz() +
                "\nVelicina ekrana: " + velEkrana;
    }
	
		public static Laptop preberiIzNiza(ArrayList<String> izdelk)
	{
		try
		{
		String ime=izdelk.get(0);
		int kos=Integer.parseInt(izdelk.get(1));
		int cena=Integer.parseInt(izdelk.get(2));
		boolean jeAkcija= Boolean.parseBoolean(izdelk.get(3));
		int stSklad=Integer.parseInt(izdelk.get(4));
		String procesor=izdelk.get(5);
		int velEkrana=Integer.parseInt(izdelk.get(6));
		
		Laptop lap=new Laptop(ime,kos,cena,jeAkcija,stSklad,procesor,velEkrana);
		return lap;
		}
		catch (Exception e)
		{
			System.out.println("Prislo je do napake.");
			throw e;
		}
		
		
	}
}