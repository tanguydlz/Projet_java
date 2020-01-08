package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import model.DataCollectorClimat;

public class GetActionFileClimat extends AbstractAction {
	private Launcher fenetre;
	static String choix;
	DataCollectorClimat dc = new DataCollectorClimat();
	
	public GetActionFileClimat(Launcher fenetre, String texte){
		super(texte);
 
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) {
		choix = "climat.txt";
		dc.LoadFichier(choix);
	}
	
	public static String getChoix() {
		return choix;
	}
}
