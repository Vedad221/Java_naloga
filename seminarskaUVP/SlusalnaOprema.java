import java.io.*;
import java.util.*;

public class SlusalnaOprema extends Izdelkov {
    private int snaga;

    public SlusalnaOprema (String imeIzdelkov,int kos, int cena, boolean jeAkcija, int stSklad,int snaga) {
        super(imeIzdelkov,kos,cena,jeAkcija,stSklad);
        this.snaga=snaga;
    }

    public int getSnaga() {
        return snaga;
    }

    @Override
    public String shraniKoNiz() {
        return super.shraniKoNiz() +
                "\nSnaga (v vatima):  " + snaga;
    }
	
	public static SlusalnaOprema preberiIzNiza(ArrayList<String> izdelk)
	{
		try
		{
		String ime=izdelk.get(0);
		int kos=Integer.parseInt(izdelk.get(1));
		int cena=Integer.parseInt(izdelk.get(2));
		boolean jeAkcija= Boolean.parseBoolean(izdelk.get(3));
		int stSklad=Integer.parseInt(izdelk.get(4));
		int snaga=Integer.parseInt(izdelk.get(5));
		
		SlusalnaOprema tel=new SlusalnaOprema(ime,kos,cena,jeAkcija,stSklad,snaga);
		return tel;
		}
		catch (Exception e)
		{
			System.out.println("Prislo je do napake.");
			throw e;
		}
		
		
	}
}