package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import model.DataCollector;

public class GetActionFileFoot extends AbstractAction {
	
	private Launcher fenetre;
	static String choix;
	DataCollector dc = new DataCollector();
	
	public GetActionFileFoot(Launcher fenetre, String texte){
		super(texte);
 
		this.fenetre = fenetre;
	}
	//Charge fichier foot quand bouton foot est appuyé
	public void actionPerformed(ActionEvent e) {
		choix = "Foot.txt";
		dc.LoadFichier(choix);
	}
	
	public static String getChoix() {
		return choix;
	}
}
