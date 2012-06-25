package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Date;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * das UI des {@link BarZahlungsWerkzeugs}
 */
public class BarZahlungsWerkzeugUI 
{

	//dialog & panels
	private JDialog _dialog;
	private JPanel _centerPanel;
	private JPanel _northPanel;
	
	//buttons & co
	private JButton _ok;
	private JButton _abbrechen;
	
	//Preis
	private JLabel _preisGesamt;
	private JTextField _preisEingabe;
	private JLabel _preisRest;


	/**
	 * 
	 * @param gesammtBetrag
	 *        Der zuzahlende Betrag
	 * 
	 * @require gesamtbetrag > 0
	 * @ensure there is a propper window
	 */
	public BarZahlungsWerkzeugUI(int gesammtBetrag) 
	{
		assert gesammtBetrag > 0 : "Vorbedingung verletzt bzgl. gesamtbetrag";
		
		System.out.printf("Running UI Constructor");
		
		//Dialog
		_dialog = new JDialog();
		_dialog.setTitle("Barzahlung");
		_dialog.setLayout( new BorderLayout());
		_dialog.setSize(300, 125);
		
		//GesamtPreis
		_northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		_preisGesamt = new JLabel( "Zu Zahlen: " + Integer.toString(gesammtBetrag) + "Euro");
		_dialog.add( _northPanel, BorderLayout.NORTH);
		_northPanel.add( _preisGesamt);

		//Centerpanel
		_centerPanel = new JPanel( new GridLayout(0,2));
		_dialog.add(_centerPanel, BorderLayout.CENTER);

		//Preis Eingabe + Rest
		_preisEingabe = new JTextField("Gegeben");
		_preisRest = new JLabel("Rest: N/A");
		_dialog.add(_centerPanel, BorderLayout.CENTER);
		_centerPanel.add(_preisEingabe);
		_centerPanel.add(_preisRest);
		
		//Buttons & Co.
		_ok = new JButton("OK");
		_abbrechen = new JButton("Abbrechen");
		_centerPanel.add( _ok);
		_centerPanel.add( _abbrechen);

		_dialog.setModal(true);
		zeigeFenster();
		
	}


	
	public JDialog getDialog() 
	{
		return _dialog;
	}


	public JButton getOkButton() 
	{
		return _ok;
	}


	public JButton getAbbrechenButton() 
	{
		return _abbrechen;
	}


	public JTextField getPreisEingabe() 
	{
		return _preisEingabe;
	}


	public JLabel getPreisGesamtLabel() 
	{
		return _preisGesamt;
	}


	public JLabel getPreisRestLabel() 
	{
		return _preisRest;
	}
	
	public void zeigeFenster() 
	{
		_dialog.setVisible(true);
	}

	private void schliesseFenster()
	{
		_dialog.dispose();
	}
}
