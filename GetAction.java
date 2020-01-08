package view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;


import javax.swing.AbstractAction;

import model.*;

public class GetAction extends AbstractAction {
	private Launcher fenetre;
	static String texteUtilisateur;
	long nombreTweet;
	Data Compteur = new Data();
	ArrayList<String> Utilisateur;
	ArrayList<String> Hashtag;
	
	public GetAction(Launcher fenetre, String texte){
		super(texte);
 
		this.fenetre = fenetre;
	}
 
	public void actionPerformed(ActionEvent e) { 
		texteUtilisateur = fenetre.getTextField().getText();
		
		nombreTweet=Compteur.CompteTweet(texteUtilisateur);
		Utilisateur = Compteur.UserPopulaire(texteUtilisateur);
		Hashtag = Compteur.FrequenceHashtag(texteUtilisateur);
		
		fenetre.getLabel().setText("Il y a eu "+ Long.toString(nombreTweet) +" tweets au " + texteUtilisateur);
		
		String list2 = String.join(" : ", Utilisateur);
		fenetre.getLabelUserPopu().setText(list2);
		
		String list3 = String.join(" : ", Hashtag);
		fenetre.getLabelHashtag().setText(list3);
		
	} 
	
	public static String getTextUtilisateur() {
		return texteUtilisateur;
	}
}
