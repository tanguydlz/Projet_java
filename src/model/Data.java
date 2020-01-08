package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import view.*;
import model.*;

public class Data {
	String Label;
	long cpt;
	ArrayList<Tweet> tweetCollection = DataCollector.getTweetCollection();
	ArrayList<Tweet> tweetCollectionClimat = DataCollectorClimat.getTweetCollectionClimat();
	
	public Data() {
		Label = GetAction.getTextUtilisateur();
	}
	
	public long CompteTweet(String Label2) {
		//Prend la bonne collection de tweet en fonction du fichier choisi
		if(tweetCollection.isEmpty()) {
			tweetCollection=tweetCollectionClimat;
		}
		
		cpt=0;
		//On compte le nombre de tweet équivalent à la date choisie par l'utilisateur
		for(int i=0 ; i < tweetCollection.size() ; i++) {
			if(tweetCollection.get(i).getStrDate().substring(0,10).equals(Label2)) {
				cpt=cpt+1;
			}
		}
		return cpt;
	}
	
	public ArrayList<String> UserPopulaire(String Label2) {
		ArrayList<String> User = new ArrayList<String>();
		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<Integer> occurence = new ArrayList<Integer>();
		ArrayList<String> resultat2 = new ArrayList<String>();
		
		//Prend la bonne collection de tweet en fonction du fichier choisi
		if(tweetCollection.isEmpty()) {
			tweetCollection=tweetCollectionClimat;
		}
		
		//On stocke dans une collection les tweets contenant la date choisie pa l'utilisateur
		for(int i=0 ; i < tweetCollection.size() ; i++) {
			if(tweetCollection.get(i).getStrDate().substring(0,10).equals(Label2)) {
				User.add(tweetCollection.get(i).getStrUser());
			}
		}
		
		//Création d'un HashSet pour enlever les doublons
		Set<String> set = new HashSet<String>();
		set.addAll(User);
		ArrayList<String> distinctList = new ArrayList<String>(set) ;
		
		//On compte le nombre d'occurence de chaque pseudo dans la liste entière
		for(int i=0 ; i < distinctList.size() ; i++) {
			int frequence = Collections.frequency(User, distinctList.get(i));
			if(frequence >= 1) {
				resultat.add(distinctList.get(i));
				occurence.add(frequence);
			}
		}
		
		//On fait un classement pour avoir les 10 premiers ayant le plus tweet
		String nomUser = null;
		for(int j=0 ; j<9 ; j++) {
			Integer max = getMax(occurence);
			int pos = occurence.indexOf(max);
			if(pos >0) {
				 nomUser = resultat.get(pos);
			}
			resultat.remove(nomUser);
			occurence.remove(max);
			resultat2.add(nomUser);
			resultat2.add(Integer.toString(max));
		}
		return resultat2;
	}
	
	//fonction prenant la valeur max d'une liste
	public int getMax(ArrayList<Integer> list){
	    int max = Integer.MIN_VALUE;
	    for(int i=0; i<list.size(); i++){
	        if(list.get(i) > max){
	            max = list.get(i);
	        }
	    }
	    return max;
	}
	
	public ArrayList<String> FrequenceHashtag(String Label2) {
		ArrayList<String> content = new ArrayList<String>();
		ArrayList<String> arrHash = new ArrayList<String>();
		ArrayList<String> arrHash2 = new ArrayList<String>();
		ArrayList<Integer> occurence = new ArrayList<Integer>();
		ArrayList<String> resultat1 = new ArrayList<String>();
		ArrayList<String> resultat2 = new ArrayList<String>();
		
		//Prend la bonne collection de tweet en fonction du fichier choisi
		if(tweetCollection.isEmpty()) {
			tweetCollection=tweetCollectionClimat;
		}
		
		//récupère dans une collection tous les tweets en fonction de la date choisi
		for(int i=0 ; i < tweetCollection.size() ; i++) {
			if(tweetCollection.get(i).getStrDate().substring(0,10).equals(Label2)) {
				content.add(tweetCollection.get(i).getStrContent());
			}
		}
		
		//récupère dans une collection tous les hashtag présent dans les tweets
		for(int i=0 ; i < content.size() ; i++) {
			if(content.get(i).contains("#")) {
				
				String hashtag = content.get(i);
				
				int pos = hashtag.indexOf("#");
				
				hashtag = hashtag.substring(pos);

				int pos2 = hashtag.indexOf(" ");

				if(pos2  != -1) {
					 pos2 = hashtag.indexOf(" ");
					 hashtag = hashtag.substring(0,pos2);
				}
				
				arrHash.add(hashtag);
			}
		}
			
		//Création d'un HashSet pour enlever les doublons
		arrHash2 =arrHash;
		Set<String> set = new HashSet<String>();
		set.addAll(arrHash2);
		ArrayList<String> distinctList = new ArrayList<String>(set) ;
		
		//On compte le nombre d'occurence de chaque hashtag dans la liste entière
			for(int i=0 ; i < distinctList.size() ; i++) {
				int frequence = Collections.frequency(arrHash, distinctList.get(i));
				if(frequence >= 10) {
					resultat1.add(distinctList.get(i));
					occurence.add(frequence);
				}
			}
			
		//On fait un classement des 10 premiers hashtag les plus fréquent
			String hash = null;
			for(int j=0 ; j<9 ; j++) {
				Integer max = getMax(occurence);
				int pos = occurence.indexOf(max);
				if(pos >0) {
					 hash = resultat1.get(pos);
				}
				resultat1.remove(hash);
				occurence.remove(max);
				resultat2.add(hash);
				resultat2.add(Integer.toString(max));
			}
		
		return resultat2;
	}

}
