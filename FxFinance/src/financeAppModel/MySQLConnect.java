package financeAppModel;
  
public class MySQLConnect{  

	public boolean GirisKontrol(String girisKullaniciAdi, String girisSifre)
	{
		boolean kontrol = false;
		String a= new String("recep");
		String b="1234";
		if(girisKullaniciAdi.contentEquals("recep") && girisSifre.contentEquals("1234"))
		{
			kontrol=true;
		}
		else
		{
			kontrol = false;
		}
		
		return kontrol;
	}
	
}