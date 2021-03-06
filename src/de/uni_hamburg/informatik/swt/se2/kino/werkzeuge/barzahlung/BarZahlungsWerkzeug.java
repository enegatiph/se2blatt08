package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
	boolean _istBarzahlungErfolgt;
	
	public BarZahlungsWerkzeug(int gesamtBetrag) 
	{
		_gesammtBetrag = gesamtBetrag;
		_restBetrag = 0;
		_istBarzahlungErfolgt = false;
		_ui = new BarZahlungsWerkzeugUI(gesamtBetrag);
		registriereUIAktionen();
		_ui.setModal(true);
		//_ui.zeigeFenster();
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
	
	public boolean istBarZahlungErfolgt()
	{
		return _istBarzahlungErfolgt;
	}
	
	public void zeigeFenster()
	{
		_ui.zeigeFenster();
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
				reagiereAufOkButton();
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
		
		_ui.getPreisEingabe().getDocument().addDocumentListener(new DocumentListener() 
		{
			
			@Override
			public void removeUpdate(DocumentEvent arg0) 
			{
				reagiereAufPreisEingabeAenderung();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) 
			{
				reagiereAufPreisEingabeAenderung();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				reagiereAufPreisEingabeAenderung();
			}
		});
	}
	
	private void reagiereAufAbbrechenButton()
	{
		_ui.schliesseFenster();
		informiereAlleBeobachter();
	}
	
	private void reagiereAufOkButton()
	{
		_ui.schliesseFenster();
		_istBarzahlungErfolgt = true;
		informiereAlleBeobachter();
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
		// exception abfangen, button unsichtbar lassen wenn buchstabe
		int eingegebenerBetrag = Integer.parseInt(_ui.getPreisEingabe().getText());
		
		if(istBarZahlungMoeglich(eingegebenerBetrag) == true)
		{
			_ui.setEnabledOkButton(true);
			_ui.setPreisRestLabel(0);
		}
			_restBetrag =  eingegebenerBetrag - _gesammtBetrag;
			_restBetrag = ( _restBetrag < 0) ? 0 : _restBetrag;
			_ui.setPreisRestLabel(_restBetrag);
	}
}
