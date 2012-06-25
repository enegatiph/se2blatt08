package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BarZahlungsWerkzeugUI{

	private JDialog _dialog;
	private JButton _ok;
	private JButton _abbrechen;
	private JTextField _preisEingabe;
	private JLabel _preisGesamt;
	private JLabel _preisRest;

	
	public BarZahlungsWerkzeugUI( int gesammtBetrag) {
		//TODO layout
		_dialog = new JDialog();
		_ok = new JButton("OK");
		_abbrechen = new JButton("Abbrechen");
		_preisEingabe = new JTextField();
		_preisGesamt = new JLabel();
		_preisRest = new JLabel();
	
	}


	public JDialog getDialog() {
		return _dialog;
	}


	public JButton getOkButton() {
		return _ok;
	}


	public JButton getAbbrechenButton() {
		return _abbrechen;
	}


	public JTextField getPreisEingabe() {
		return _preisEingabe;
	}


	public JLabel getPreisGesamtLabel() {
		return _preisGesamt;
	}


	public JLabel getPreisRestLabel() {
		return _preisRest;
	}

	/* methods
		schliesseFenster()
	 */
}
