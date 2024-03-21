import java.io.*;
import java.util.*;

public class VideoOprema extends Izdelkov {
    private int godProiz;

    public VideoOprema (String imeIzdelkov,int kos, int cena, boolean jeAkcija, int stSklad,int godProiz) {
        super(imeIzdelkov,kos,cena,jeAkcija,stSklad);
        this.godProiz=godProiz;
    }

    public int getGodProiz() {
        return godProiz;
    }

    @Override
    public String shraniKoNiz() {
        return super.shraniKoNiz() +
                "\nGodina proizvodnje: " + godProiz;
    }
	
	public static VideoOprema preberiIzNiza(ArrayList<String> izdelk)
	{
		try
		{
		String ime=izdelk.get(0);
		int kos=Integer.parseInt(izdelk.get(1));
		int cena=Integer.parseInt(izdelk.get(2));
		boolean jeAkcija= Boolean.parseBoolean(izdelk.get(3));
		int stSklad=Integer.parseInt(izdelk.get(4));
		int godProiz=Integer.parseInt(izdelk.get(5));
		
		VideoOprema tel=new VideoOprema(ime,kos,cena,jeAkcija,stSklad,godProiz);
		return tel;
		}
		catch (Exception e)
		{
			System.out.println("Prislo je do napake.");
			throw e;
		}
		
		
	}
}