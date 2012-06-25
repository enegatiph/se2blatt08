package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

	//dialog
	private JDialog _dialog;
	//buttons & co
	private JPanel _buttonPanel;
	private JButton _ok;
	private JButton _abbrechen;
	
	//todo
	private JTextField _preisEingabe;
	private JLabel _preisGesamt;
	private JLabel _preisRest;


	/**
	 * 
	 * @param gesammtBetrag
	 *        Der zuzahlende Betrag
	 * 
	 * @require gesamtbetrag > 0
	 * @ensure ?
	 */
	public BarZahlungsWerkzeugUI(int gesammtBetrag) 
	{
		assert gesammtBetrag > 0 : "Vorbedingung verletzt bzgl. gesamtbetrag";
		
		//TODO layout
		//Anderes Layout?
		
		System.out.printf("Running UI Constructor");
		
		//Dialog
		_dialog = new JDialog();
		_dialog.setLayout( new BorderLayout());
		_dialog.setSize(300, 200);//?
		_dialog.setTitle("Barzahlung");
		
		//Buttons & Co.
		_buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		_ok = new JButton("OK");
		_abbrechen = new JButton("Abbrechen");
		_dialog.add(_buttonPanel, BorderLayout.SOUTH);
		_buttonPanel.add( _ok, BorderLayout.SOUTH);
		_buttonPanel.add( _abbrechen, BorderLayout.SOUTH);

		
		//TODO
		
		/*_preisEingabe = new JTextField("0");
		_preisGesamt = new JLabel();
		_preisRest = new JLabel();*/


		
		
		_dialog.setModal(true);
		_dialog.setVisible(true);
		
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
	
	//ist bereits im konstruktor => entfernen?
	// nein...
	public void zeigeFenster() 
	{
		_dialog.setVisible(true);
	}

	/* methods
		schliesseFenster()
	 */
}
