package it.volta.ts.ulivisamuel.cifrarioCesare;

import java.util.Scanner;

import it.volta.ts.ulivisamuel.cifrarioCesare.biz.BizCifrario;
import it.volta.ts.ulivisamuel.cifrarioCesare.util.Util;

public class Console 
{
	private Scanner     scanner;
	private BizCifrario bizCifrario;
	
	//---------------------------------------------------------------------------------------------
	
	public Console()
	{
		bizCifrario = new BizCifrario();
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void esegui()
	{
		scanner = new Scanner(System.in);
		titolo();
		menu();
		scanner.close();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void titolo()
	{
		System.out.println("CIFRARIO DI CESARE - Ulivi Samuel");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void menu()
	{
		String  mess     = "\nMenu\n   1.Cifra un messaggio\n   2.Decifra un messaggio\n   0.Esci";
		boolean continua = true;
		while(continua)
		{
			int scelta = Util.leggiInt(scanner, mess, 0, 2, true, 0);
			switch(scelta)
			{
			case 0:
				continua = false;
				break;
			case 1:
				cifra();
				break;
			case 2:
				decifra();
				break;
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void cifra()
	{
		String mess1 = "\nInserisci un numero da 1 a 25 corrispondente alla chiave di cifratura."
				     + "\nOppure premi invio per annullare l'operazione.";
		int chiave   = Util.leggiInt(scanner, mess1, 1, 25, false, -1);
		if(chiave != -1)
		{
			String mess2 = "\nInserisci il messaggio da cifrare.\nOppure premi invio per "
					     + "annullare l'operazione.";
			String messNoCifr = Util.leggiString(scanner, mess2, false, null);
			if(messNoCifr != null)
				System.out.println("\nMessaggio cifrato: " + bizCifrario.cifraMessaggio(chiave, messNoCifr));
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void decifra()
	{
		String mess1 = "\nInserisci un numero da 1 a 25 corrispondente alla chiave di cifratura."
				     + "\nOppure premi invio per annullare l'operazione.";
		int chiave   = Util.leggiInt(scanner, mess1, 1, 25, false, -1);
		if(chiave != -1)
		{
			String mess2 = "\nInserisci il messaggio da decifrare.\nOppure premi invio per "
					     + "annullare l'operazione.";
			String messNoCifr = Util.leggiString(scanner, mess2, false, null);
			if(messNoCifr != null)
				System.out.println("\nMessaggio decifrato: " + bizCifrario.decifraMessaggio(chiave, messNoCifr));
		}
	}
}
