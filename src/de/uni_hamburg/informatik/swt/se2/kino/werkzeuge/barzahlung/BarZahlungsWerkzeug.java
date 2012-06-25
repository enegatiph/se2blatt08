package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.BeobachtbaresSubWerkzeug;

/**
 * Mit diesem Werkzeug kann die Bezahlung via Bargeld erfolgen.
 * 
 * Dieses Werkzeug ist ein eingebettetes Subwerkzeug es benachtichtigt sein
 * Kontextwerkzeug wenn die Barzahlung vollzogen ist.
 *
 */
public class BarZahlungsWerkzeug  extends BeobachtbaresSubWerkzeug{

 	BarZahlungsWerkzeugUI _ui;
	int _gesammtBetrag;
	
	public BarZahlungsWerkzeug(int gesammtBetrag) 
	{
		_gesammtBetrag = gesammtBetrag;
		_ui = new BarZahlungsWerkzeugUI(gesammtBetrag);
	}
	
	/**
	 * 
	 * @param betragVomKunden
	 *        Der Kunde muss mind. den gesamtBetrag Bezahlen
	 * @return
	 *        true: wenn der Kunde zahlen kann
	 *        false: andererseits
	 */
	public boolean istBarZahlungMoeglich(int betragVomKunden)
	{
		if(betragVomKunden >= _gesammtBetrag)
		{	
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/* methods
	    
		
		registriereUIAktionen(): void
		reagiereAufAbbrechenButton() : void
		reagiereAufOkButton() : void
		reagiereAufPreisEingabeAenderung() : void
	 */
	
	
}
