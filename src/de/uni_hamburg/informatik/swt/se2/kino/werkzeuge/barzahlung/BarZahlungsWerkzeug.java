package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.BeobachtbaresSubWerkzeug;

/**
 * Mit diesem Werkzeug kann die Bezahlung via Bargeld erfolgen.
 * 
 * Dieses Werkzeug ist ein eingebettetes Subwerkzeug es benachtichtigt sein
 * Kontextwerkzeug wenn die Barzahlung vollzogen ist.
 *
 */
public class BarZahlungsWerkzeug extends BeobachtbaresSubWerkzeug {

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
	
	/**
	 * Fügt die Funktionalität zu Folgenden UI-Elementen hinzu:
	 * - OK-Button
	 * - Abbrechen-Button
	 * - PreisEingabe-TextField
	 */
	private void registriereUIAktionen()
	{
		_ui.getOkButton().addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				//reagiereAufOkButton();
			}
		});
	}
	/* methods
	    
		
		
		reagiereAufAbbrechenButton() : void
		reagiereAufOkButton() : void
		reagiereAufPreisEingabeAenderung() : void
	 */
	
	
}
