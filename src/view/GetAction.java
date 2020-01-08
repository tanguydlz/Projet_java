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
 
	//Gère le bouton rechercher
	public void actionPerformed(ActionEvent e) { 
		
		//Récupère la date choisie
		texteUtilisateur = fenetre.getTextField().getText();
		
		//Fait appel aux 3 fonctions pour pour déterminer hashtag, tweet et utilisateur
		nombreTweet=Compteur.CompteTweet(texteUtilisateur);
		Utilisateur = Compteur.UserPopulaire(texteUtilisateur);
		Hashtag = Compteur.FrequenceHashtag(texteUtilisateur);
		
		//Affichage du nombre de tweet
		fenetre.getLabel().setText("Il y a eu "+ Long.toString(nombreTweet) +" tweets au " + texteUtilisateur);
		
		//Affichage utilisateur
		String list2 = String.join(" : ", Utilisateur);
		fenetre.getLabelUserPopu().setText(list2);
		
		//affichage hashtag
		String list3 = String.join(" : ", Hashtag);
		fenetre.getLabelHashtag().setText(list3);
		
	} 
	
	//getter
	public static String getTextUtilisateur() {
		return texteUtilisateur;
	}
}
