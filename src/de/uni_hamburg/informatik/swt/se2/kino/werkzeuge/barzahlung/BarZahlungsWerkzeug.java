package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.BeobachtbaresSubWerkzeug;

public class BarZahlungsWerkzeug  extends BeobachtbaresSubWerkzeug{

 	BarZahlungsWerkzeugUI _ui;
	int _preis;
	
	public BarZahlungsWerkzeug(int preis) {
		_preis = preis;
		_ui = new BarZahlungsWerkzeugUI();
	}
	
	
	/* methods
	    BarZahlungsWerkzeug( int gesamtBetrag)
		istBarZahlungMoeglich( int betragVomKunden) : boolean
		registriereUIAktionen(): void
		reagiereAufAbbrechenButton() : void
		reagiereAufOkButton() : void
		reagiereAufPreisEingabeAenderung() : void
	 */
	
	
}
