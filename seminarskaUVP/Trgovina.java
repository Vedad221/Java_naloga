import java.io.*;
import java.util.*;

public class Trgovina
{
	private ArrayList<Izdelkov> izdelki;
	private int totalDenar;
	
	public Trgovina()
	{
		izdelki= new ArrayList<Izdelkov>();
		totalDenar=0;
	}
	
	public void dodajIzdelk(Izdelkov izdelkov)
	{
		izdelki.add(izdelkov);
		System.out.println("*****Uspesno je dodan izdelk!*****");
	}
	
	public void skloniIzdelk(Izdelkov izdelk)
	{
		izdelki.remove(izdelk);
		System.out.println("*****Uspesno ste sklonili izdelk!*****");
		
	}
	public ArrayList<Izdelkov> vrniVse()
	{
		return this.izdelki;
		
	}
	public int vrniDenar(){
	return this.totalDenar;
	}
	
	public void nakupIzdelk(Izdelkov izdelk, int stevil)
	{
		if (izdelk.getKos() >= stevil) {
		izdelk.setstKupljenih(izdelk.getstKupljenih()+stevil);
		izdelk.setKos(izdelk.getKos() - stevil);
		totalDenar += izdelk.getCena() * stevil;
		}
		else 
			System.out.println("Nima dovoljno kos v radnji!");
		
		
	}
	
	public void vrniIzdelk(Izdelkov izdelk, int stevil)
	{
		if (izdelk.getstKupljenih()>=stevil)
		{
			izdelk.setstKupljenih(izdelk.getstKupljenih()-stevil);
			izdelk.setKos(izdelk.getKos()+stevil);
			
			for(int i=0;i<stevil;i++)
			{
				totalDenar-=izdelk.getCena();
				
			}
			
		}
		else System.out.println("Ni mogoce vratit vec stevil od kupljenih izdelkov!");
	}
	
	public void izdelkovNaAkciji(ArrayList<Izdelkov> izdelki) {
		
    boolean imaAkcija = true;
    
    for (Izdelkov izdelk : izdelki) {
        if (izdelk.getjeAkcija()) {
            System.out.println("Ime izdelka na akciji je: "+izdelk.getIme());
            imaAkcija = false;
			}
		}
    
		if (imaAkcija) {
        System.out.println("Nima izdelka na akciji.");
		}
	}
	
	public void izdelkovMedCena(ArrayList<Izdelkov> izdelki,int minCena, int maxCena)
	{
		boolean imaIzdelk=true;
		
		for(int i=0;i<izdelki.size();i++)
		{
			if (izdelki.get(i).getCena()>minCena && izdelki.get(i).getCena()<maxCena)
			{
				imaIzdelk=false;
				System.out.println("Izdelki kiji su med cenama ki jo ste dali so: "+izdelki.get(i).getIme());
			}
		}
		
		if (imaIzdelk)
			System.out.println("Nima izdelkov med tim cenama.");
	}
	public void kupljeniIzdelci(ArrayList<Izdelkov> izdelki)
	{
		for (Izdelkov izdelk : izdelki)
		{
			if (izdelk.getKos()>0)
			{
				System.out.println("Izdelki kiji ste kupili je: "+izdelk.getIme());
				
			}
		}
	}
	public void shraniVDatoteku(String imeDatoteke,ArrayList<Izdelkov> vsi)
	{
		try{
			FileWriter fw = new FileWriter(imeDatoteke);
			PrintWriter pw = new PrintWriter(fw);
			
			
			for (Izdelkov izdelk : vsi) {
				if (izdelk instanceof MobilniTelefon)
				{
					MobilniTelefon mobilni = (MobilniTelefon) izdelk;
					pw.print(mobilni.shraniKoNiz());
				}
				else if (izdelk instanceof VideoOprema)
				{
					VideoOprema video = (VideoOprema) izdelk;
					pw.print(video.shraniKoNiz());
				}
				else if (izdelk instanceof SlusalnaOprema)
				{
					SlusalnaOprema slus = (SlusalnaOprema) izdelk;
					pw.print(slus.shraniKoNiz());
				}
				else if (izdelk instanceof Racunalnik)
				{
					Racunalnik rac = (Racunalnik) izdelk;
					pw.print(rac.shraniKoNiz());
				}
				else if (izdelk instanceof HisniIzdelk)
				{
					HisniIzdelk hisa = (HisniIzdelk) izdelk;
					pw.print(hisa.shraniKoNiz());
					
				}
				else if (izdelk instanceof Laptop)
				{
					Laptop lap = (Laptop) izdelk;
					pw.print(lap.shraniKoNiz());
					
				}
			pw.println();
			
			}
			
        pw.flush();
        pw.close(); 
        fw.close();
			
		}
		catch(Exception e)
		{
			
			System.out.println("Prislo je do napake.");
		}
		
		
	}
	
	public void vzmiIzDatoteke(String imeDatoteke) throws Exception
	{
		FileReader fr = new FileReader(imeDatoteke);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<String> izdelkPodatki;
		while(br.ready())
		{
			String vrstica = br.readLine().trim();
			
			
			izdelkPodatki=new ArrayList<String>();
			
				System.out.println(vrstica);
				if (vrstica.equalsIgnoreCase("MobilniTelefon")){
					while(br.ready() && !vrstica.equalsIgnoreCase("*Z"))
					{
					vrstica = br.readLine().trim();
					izdelkPodatki.add(vrstica);
					
					}
					MobilniTelefon tel=MobilniTelefon.preberiIzNiza(izdelkPodatki);
					dodajIzdelk(tel);
				}
				else if(vrstica.equalsIgnoreCase("VideoOprema"))
				{
					while(br.ready() && !vrstica.equalsIgnoreCase("*Z"))
					{
					vrstica = br.readLine().trim();
					izdelkPodatki.add(vrstica);
					}
					VideoOprema video=VideoOprema.preberiIzNiza(izdelkPodatki);
					dodajIzdelk(video);
					
				}
				else if(vrstica.equalsIgnoreCase("SlusalnaOprema"))
				{
					while(br.ready() && !vrstica.equalsIgnoreCase("*Z"))
					{
					vrstica = br.readLine().trim();
					izdelkPodatki.add(vrstica);
					}
					SlusalnaOprema slus=SlusalnaOprema.preberiIzNiza(izdelkPodatki);
					dodajIzdelk(slus);
				}
				else if(vrstica.equalsIgnoreCase("Racunalnik"))
				{
					
					while(br.ready() && !vrstica.equalsIgnoreCase("*Z"))
					{
					vrstica = br.readLine().trim();
					izdelkPodatki.add(vrstica);
					}
					Racunalnik rac=Racunalnik.preberiIzNiza(izdelkPodatki);
					dodajIzdelk(rac);
				}
				else if(vrstica.equalsIgnoreCase("HisniIzdelk"))
				{
					while(br.ready() && !vrstica.equalsIgnoreCase("*Z"))
					{
					vrstica = br.readLine().trim();
					izdelkPodatki.add(vrstica);
					}
					HisniIzdelk hisa=HisniIzdelk.preberiIzNiza(izdelkPodatki);
					dodajIzdelk(hisa);
					
				}
				else if (vrstica.equalsIgnoreCase("Laptop"))
				{
					while (br.ready() && !vrstica.equalsIgnoreCase("*Z"))
					{
						vrstica = br.readLine().trim();
						izdelkPodatki.add(vrstica);
						
					}
					Laptop lap = Laptop.preberiIzNiza(izdelkPodatki);
					dodajIzdelk(lap);
					
				}
				
				
				
			
			
		
		}
		
	}
	
	
	public static void main(String args[])
	{
		Trgovina trg=new Trgovina();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
		
		while(true)
		{
				System.out.println("Vnesi (0) za prekinitev programa.");
				System.out.println("Vnesi (1) za dodajanje izdelka");
				System.out.println("Vnesi (2) za uklanjanje izdelka");
				System.out.println("Vnesi (3) za nakup izdelka");
				System.out.println("Vnesi (4) za vracanje izdelka");
				System.out.println("Vnesi (5) za filtriranje izdelkov po ceni");
				System.out.println("Vnesi (6) za filtriranje izdelkov po kupnji");
				System.out.println("Vnesi (7) za filtriranje izdelkov po akciji");
				System.out.println("Vnesi (8) za prikaz totalnog prihoda");
				System.out.println("Vnesi (9) za shranjevanje v datoteko.");
				System.out.println("Vnesi (10) za dodajanje iz datoteke.");
				
				int vnos=Integer.parseInt(br.readLine());
				
				switch(vnos)
				{
					case 0:
					return;
					case 1:
					System.out.println("Vnesi tip izdelka ki ga zelite dodati");
					String tip;
					tip=br.readLine().trim();
					switch (tip)
					{
						case "MobilniTelefon":
						
						System.out.println("Vnesite ime telefona.");
						String ime = br.readLine();
						System.out.println("Vnesite koliko kosov zelite");
						int kos=Integer.parseInt(br.readLine());
						System.out.println("Vnesite cenu telefona");
						int cena=Integer.parseInt(br.readLine());
						System.out.println("Vnesite ali je telefon na akciji(true ali false)");
						boolean jeAkcija=Boolean.parseBoolean(br.readLine());
						System.out.println("Vnesite koliko kosov je v skladiscu");
						int stSklad=Integer.parseInt(br.readLine());
						System.out.println("Vnesite vrstu konekcije telefona (3g ali 4g ali 5g)");
						String konek=br.readLine();
						
						MobilniTelefon mob=new MobilniTelefon(ime,kos,cena,jeAkcija,stSklad,konek);
						trg.dodajIzdelk(mob);
						break;
						
						case "VideoOprema":
						System.out.println("Vnesite ime video opreme");
						String ime2 = br.readLine();
						System.out.println("Vnesite koliko kosov zelite");
						int kos2=Integer.parseInt(br.readLine());
						System.out.println("Vnesite cenu video opreme");
						int cena2=Integer.parseInt(br.readLine());
						System.out.println("Vnesite ali je oprema na akciji(true ali false)");
						boolean jeAkcija2=Boolean.parseBoolean(br.readLine());
						System.out.println("Vnesite koliko kosov je v skladiscu");
						int stSklad2=Integer.parseInt(br.readLine());
						System.out.println("Vnesite leto proizvodnje");
						int godProiz = Integer.parseInt(br.readLine());
						
						VideoOprema video=new VideoOprema(ime2,kos2,cena2,jeAkcija2,stSklad2,godProiz);
						trg.dodajIzdelk(video);
						break;
						
						case "SlusalnaOprema":
						System.out.println("Vnesite ime slusalne opreme");
						String ime3 = br.readLine();
						System.out.println("Vnesite koliko kosov zelite");
						int kos3=Integer.parseInt(br.readLine());
						System.out.println("Vnesite cenu opreme");
						int cena3=Integer.parseInt(br.readLine());
						System.out.println("Vnesite ali je oprema na akciji(true ali false)");
						boolean jeAkcija3=Boolean.parseBoolean(br.readLine());
						System.out.println("Vnesite koliko kosov je v skladiscu");
						int stSklad3=Integer.parseInt(br.readLine());
						System.out.println("Vnesite snagu slusalne opreme");
						int snaga = Integer.parseInt(br.readLine());
						
						SlusalnaOprema slus = new SlusalnaOprema(ime3,kos3,cena3,jeAkcija3,stSklad3,snaga);
						trg.dodajIzdelk(slus);
						break;
						
						case "Racunalnik":
						System.out.println("Vnesite ime racunalnika");
						String ime4 = br.readLine();
						System.out.println("Vnesite koliko kosov zelite");
						int kos4=Integer.parseInt(br.readLine());
						System.out.println("Vnesite cenu racunalnika");
						int cena4=Integer.parseInt(br.readLine());
						System.out.println("Vnesite ali je racunalnik na akciji(true ali false)");
						boolean jeAkcija4=Boolean.parseBoolean(br.readLine());
						System.out.println("Vnesite koliko kosov je v skladiscu");
						int stSklad4=Integer.parseInt(br.readLine());
						System.out.println("Vnesite procesor racunalnika");
						String procesor=br.readLine();
						
						Racunalnik rac=new Racunalnik(ime4,kos4,cena4,jeAkcija4,stSklad4,procesor);
						trg.dodajIzdelk(rac);
						break;
						
						case "HisniIzdelk":
						System.out.println("Vnesite ime hisnog izdelka");
						String ime5 = br.readLine();
						System.out.println("Vnesite koliko kosov zelite");
						int kos5=Integer.parseInt(br.readLine());
						System.out.println("Vnesite cenu izdelka");
						int cena5=Integer.parseInt(br.readLine());
						System.out.println("Vnesite ali je izdelk na akciji(true ali false)");
						boolean jeAkcija5=Boolean.parseBoolean(br.readLine());
						System.out.println("Vnesite koliko kosov je v skladiscu");
						int stSklad5=Integer.parseInt(br.readLine());
						System.out.println("Vnesite barvu izdelka");
						String barva=br.readLine();
						
						HisniIzdelk hisa=new HisniIzdelk(ime5,kos5,cena5,jeAkcija5,stSklad5,barva);
						trg.dodajIzdelk(hisa);
						break;
						case "Laptop":
						System.out.println("Vnesite ime racunalnika");
						String ime6 = br.readLine();
						System.out.println("Vnesite koliko kosov zelite");
						int kos6=Integer.parseInt(br.readLine());
						System.out.println("Vnesite cenu racunalnika");
						int cena6=Integer.parseInt(br.readLine());
						System.out.println("Vnesite ali je racunalnik na akciji(true ali false)");
						boolean jeAkcija6=Boolean.parseBoolean(br.readLine());
						System.out.println("Vnesite koliko kosov je v skladiscu");
						int stSklad6=Integer.parseInt(br.readLine());
						System.out.println("Vnesite procesor racunalnika");
						String procesor2=br.readLine();
						System.out.println("Vnesite velikost ekrana");
						int velEkrana = Integer.parseInt(br.readLine());
						
						Laptop lap = new Laptop(ime6,kos6,cena6,jeAkcija6,stSklad6,procesor2,velEkrana);
						trg.dodajIzdelk(lap);
						
					}
					break;
					case 2:
					System.out.println("Vnesite ime izdelka kiji zelite ukloniti");
					String imeSkloni = br.readLine();
					boolean ima=false;
					ArrayList<Izdelkov> vsi=trg.vrniVse();
					for (Izdelkov izdelk: vsi)
					{
						if (izdelk.getIme().equalsIgnoreCase(imeSkloni))
						{
							trg.skloniIzdelk(izdelk);
							ima=true;
							break;
						}
						
					}
					if(!ima)
					{
						System.out.println("Nima izdelka sa tim imenom");
						
					}
					break;
					case 3:
					System.out.println("Vnesite ime izdelka koji zelite kupiti.");
					String ime = br.readLine();
					System.out.println("Vnesite stevilo koji zelite kupiti");
					int kos=Integer.parseInt(br.readLine());
					boolean izvrseno=false;
					ArrayList<Izdelkov> vsiNakup = trg.vrniVse();
					
					for (Izdelkov izdelk:vsiNakup)
					{
						if(izdelk.getIme().equalsIgnoreCase(ime))
						{
							trg.nakupIzdelk(izdelk,kos);
						}
						
					}
					if(izvrseno)
					{
						System.out.println("Nima izdelka koji zelite kupiti");
						
					}
					break;
					case 4:
					System.out.println("Vnesite ime izdelka koji zelite vrnuti");
					String imeIzdelk = br.readLine();
					System.out.println("Vnesite stevilo kos koji zelite vrnuti");
					int kosVrni = Integer.parseInt(br.readLine());
					boolean vrnjeno = false;
					ArrayList<Izdelkov> vsiVrnjeni = trg.vrniVse();
					
					for (Izdelkov izdelk:vsiVrnjeni)
					{
						if (izdelk.getIme().equalsIgnoreCase(imeIzdelk))
						{
							
							trg.vrniIzdelk(izdelk,kosVrni);
						}
						
					}
					if (!vrnjeno)
					{
						System.out.println("Nima izdelka koji zelite vrnuti");
						
					}
					break;
					case 5:
					System.out.println("Vnesite minimanu cenu");
					int minCena=Integer.parseInt(br.readLine());
					System.out.println("Vnesite maksimalnu cenu");
					int maxCena=Integer.parseInt(br.readLine());
					
					ArrayList<Izdelkov> izdelkiMedCenu=trg.vrniVse();
					trg.izdelkovMedCena(izdelkiMedCenu,minCena,maxCena);
					break;
					
					case 6:
					ArrayList<Izdelkov> vsiKupljeni = trg.vrniVse();
					trg.kupljeniIzdelci(vsiKupljeni);
					break;
					
					case 7:
					ArrayList<Izdelkov> izdelkinaAkciji=trg.vrniVse();
					trg.izdelkovNaAkciji(izdelkinaAkciji);
					break;
					
					case 8:
					int totalPrihod=trg.vrniDenar();
					System.out.println("Totalni prihodi koji ste ostvarili je:"+totalPrihod);
					break;
					case 9:
					System.out.println("Vnesite ime datoteke(s koncnico)");
					String imeIzDat =br.readLine();
					ArrayList<Izdelkov> shrani = trg.vrniVse();
					trg.shraniVDatoteku(imeIzDat,shrani);
					break;
					case 10:
					System.out.println("Vnesite ime datoteke (s koncnico)");
					String imeVDat = br.readLine();
					trg.vzmiIzDatoteke(imeVDat);
					break;
					
				}
	
			}
		}
		catch (Exception e)
		{
			System.out.println("Prislo je do napake!");
		}
		
		
		
		
		
	}
	
	
	
	
	
	
}