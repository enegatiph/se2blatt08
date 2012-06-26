package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
	int _restBetrag;
	
	public BarZahlungsWerkzeug(int gesamtBetrag) 
	{
		_gesammtBetrag = gesamtBetrag;
		_restBetrag = 0;
		_ui = new BarZahlungsWerkzeugUI(gesamtBetrag);
		registriereUIAktionen();
		_ui.setModal(true);
		_ui.zeigeFenster();
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
		
		_ui.getAbbrechenButton().addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				reagiereAufAbbrechenButton();
			}
		});
		
		_ui.getPreisEingabe().addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//reagiereAufPreisEingabeAenderung();
			}
		});
	}
	
	private void reagiereAufAbbrechenButton()
	{
		_ui.schliesseFenster();
		// informiere darueber dass die bezahlung nicht statgefunden hat
	}
	
	private void reagiereAufOkButton()
	{
		_ui.schliesseFenster();
		// informiere darueber dass die bezahlung stattgefunden hat
	}
	
	/**
	 * SOlang der eingebene Preis kleiner als der Gesamtbetrag ist, ist der 
	 * OK-Button nicht anklickbar
	 * 
	 * Restbetrag neubrechenen (gesamtbetrag - eingegebenerbetrag = restbetrag)
	 * und anzeigen
	 */
	private void reagiereAufPreisEingabeAenderung()
	{
		int eingegebenerBetrag = Integer.parseInt(_ui.getPreisEingabe().getText());
		
		if(istBarZahlungMoeglich(eingegebenerBetrag) == true)
		{
			_ui.setEnabledOkButton(true);
			_ui.setPreisRestLabel(0);
		}
		else
		{
			_restBetrag = _gesammtBetrag - eingegebenerBetrag;
			if(_restBetrag < 0)
			{
				_restBetrag = 0;
			}
			_ui.setPreisRestLabel(_restBetrag);
		}
	}
}
