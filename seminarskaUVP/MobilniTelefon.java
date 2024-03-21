import java.io.*;
import java.util.*;

public class MobilniTelefon extends Izdelkov {
    private String konek;

    public MobilniTelefon (String imeIzdelkov,int kos, int cena, boolean jeAkcija, int stSklad,String konek) {
        super(imeIzdelkov,kos,cena,jeAkcija,stSklad);
        this.konek = konek;
    }

    public String getKonek() {
        return konek;
    }

    @Override
    public String shraniKoNiz() {
        return super.shraniKoNiz() +
                "\nVrsta Konekcije: " + konek;
    }
	
	public static MobilniTelefon preberiIzNiza(ArrayList<String> izdelk)
	{
		try
		{
		String ime=izdelk.get(0);
		int kos=Integer.parseInt(izdelk.get(1));
		int cena=Integer.parseInt(izdelk.get(2));
		boolean jeAkcija= Boolean.parseBoolean(izdelk.get(3));
		int stSklad=Integer.parseInt(izdelk.get(4));
		String konek=izdelk.get(5);
		
		MobilniTelefon tel=new MobilniTelefon(ime,kos,cena,jeAkcija,stSklad,konek);
		return tel;
		}
		catch (Exception e)
		{
			System.out.println("Prislo je do napake.");
			throw e;
		}
		
		
	}
}