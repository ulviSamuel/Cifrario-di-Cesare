package it.volta.ts.ulivisamuel.cifrarioCesare.biz;

public class BizCifrario 
{
	public String cifraMessaggio(int chiave, String messaggio)
	{
		String messCifrato = "";
		if(chiave >= 1 && chiave <= 25 && messaggio != null)
		{
			for(int i = 0; i < messaggio.length(); ++i)
			{
				int newAsciiNum;
				int charAsciiNum = (int) messaggio.charAt(i);
				if((charAsciiNum >= 65 && charAsciiNum <= 90))
				{
					newAsciiNum  = charAsciiNum + chiave;
					if(newAsciiNum > 90)
						newAsciiNum = newAsciiNum - (90 - 64);
					messCifrato  = messCifrato + (char)(newAsciiNum);
				}
				else
				{
					if(charAsciiNum >= 97 && charAsciiNum <= 122)
					{
						newAsciiNum  = charAsciiNum + chiave;
						if(newAsciiNum > 122)
							newAsciiNum = newAsciiNum - (122 - 96);
						messCifrato  = messCifrato + (char)(newAsciiNum);
					}
					else
						messCifrato = messCifrato +(char)(charAsciiNum);
				}
			}
		}
		else
			return "IMPOSSIBILE CIFRARE IL MESSAGGIO";
		return messCifrato;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public String decifraMessaggio(int chiave, String messaggio)
	{
		String messDecifrato = "";
		if(chiave >= 1 && chiave <= 25 && messaggio != null)
		{
			for(int i = 0; i < messaggio.length(); ++i)
			{
				int newAsciiNum;
				int charAsciiNum = (int) messaggio.charAt(i);
				if((charAsciiNum >= 65 && charAsciiNum <= 90))
				{
					newAsciiNum  = charAsciiNum - chiave;
					if(newAsciiNum < 65)
						newAsciiNum = newAsciiNum + (90 - 64);
					messDecifrato  = messDecifrato + (char)(newAsciiNum);
				}
				else
				{
					if(charAsciiNum >= 97 && charAsciiNum <= 122)
					{
						newAsciiNum  = charAsciiNum - chiave;
						if(newAsciiNum < 97)
							newAsciiNum = newAsciiNum + (122 - 96);
						messDecifrato  = messDecifrato + (char)(newAsciiNum);
					}
					else
						messDecifrato = messDecifrato +(char)(charAsciiNum);
				}
			}
		}
		else
			return "IMPOSSIBILE CIFRARE IL MESSAGGIO";
		return messDecifrato;
	}
}
