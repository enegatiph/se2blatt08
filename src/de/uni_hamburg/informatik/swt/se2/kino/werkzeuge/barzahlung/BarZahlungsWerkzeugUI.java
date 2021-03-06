package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * das UI des {@link BarZahlungsWerkzeugs}
 */
//TODO fenster zentrieren
public class BarZahlungsWerkzeugUI 
{
	
	int _frame_heigth = 125;
	int _frame_width = 300;

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
		
		//Dialog
		_dialog = new JDialog();
		_dialog.setTitle("Barzahlung");
		_dialog.setLayout( new BorderLayout());
		_dialog.setSize(_frame_width, _frame_heigth);
		_dialog.setResizable(false);
		
		//Zentrieren
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
         int top = (screenSize.height - _frame_heigth) / 2; 
         int left = (screenSize.width - _frame_width) / 2; 
	     _dialog.setLocation(left, top);
		
		
		//GesamtPreis
		_northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		_preisGesamt = new JLabel( "Zu Zahlen: " + Integer.toString(gesammtBetrag) + "Eurocent");
		_dialog.add( _northPanel, BorderLayout.NORTH);
		_northPanel.add( _preisGesamt);

		//Centerpanel
		_centerPanel = new JPanel( new GridLayout(0,2));
		_dialog.add(_centerPanel, BorderLayout.CENTER);

		//Preis Eingabe + Rest
		_preisEingabe = new JTextField("");
		_preisRest = new JLabel("Rest: N/A");
		_dialog.add(_centerPanel, BorderLayout.CENTER);
		_centerPanel.add(_preisEingabe);
		_centerPanel.add(_preisRest);
		
		//Buttons & Co.
		_ok = new JButton("OK");
		_abbrechen = new JButton("Abbrechen");
		_centerPanel.add( _ok);
		_centerPanel.add( _abbrechen);
		_ok.setEnabled(false);
		
	}


	
	public JDialog getDialog() 
	{
		return _dialog;
	}


	public JButton getOkButton() 
	{
		return _ok;
	}
	
	public void setEnabledOkButton(boolean status)
	{
		_ok.setEnabled(status);
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
	
	public void setPreisRestLabel(int restBetrag)
	{
		if ( restBetrag > 0)
		_preisRest.setText("Rest: " + restBetrag + " Eurocent");
		else
		_preisRest.setText("Rest: N/A");
	}
	
	public void zeigeFenster() 
	{
		_dialog.setVisible(true);
	}

	public void schliesseFenster()
	{
		_dialog.dispose();
	}
	
	public void setModal(boolean arg)
	{
		_dialog.setModal(arg);
	}
}
