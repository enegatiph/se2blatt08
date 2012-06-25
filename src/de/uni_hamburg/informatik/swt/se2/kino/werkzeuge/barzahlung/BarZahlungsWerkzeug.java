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
	
	public BarZahlungsWerkzeug(int gesammtBetrag) {
		_gesammtBetrag = gesammtBetrag;
		_ui = new BarZahlungsWerkzeugUI(gesammtBetrag);
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
