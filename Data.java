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
		if(tweetCollection.isEmpty()) {
			tweetCollection=tweetCollectionClimat;
		}
		cpt=0;
		for(int i=0 ; i < tweetCollection.size() ; i++) {
			if(tweetCollection.get(i).getStrDate().substring(0,10).equals(Label2)) {
				cpt=cpt+1;
			}
		}
		System.out.println("Il y a eu "+ cpt +" tweets au " + Label2);
		return cpt;
	}
	
	public ArrayList<String> UserPopulaire(String Label2) {
		ArrayList<String> User = new ArrayList<String>();
		ArrayList<String> resultat = new ArrayList<String>();
		ArrayList<Integer> occurence = new ArrayList<Integer>();
		ArrayList<String> resultat2 = new ArrayList<String>();
		
		if(tweetCollection.isEmpty()) {
			tweetCollection=tweetCollectionClimat;
		}
		
		for(int i=0 ; i < tweetCollection.size() ; i++) {
			if(tweetCollection.get(i).getStrDate().substring(0,10).equals(Label2)) {
				User.add(tweetCollection.get(i).getStrUser());
			}
		}
		
		Set<String> set = new HashSet<String>();
		set.addAll(User);
		ArrayList<String> distinctList = new ArrayList<String>(set) ;
		
		
		for(int i=0 ; i < distinctList.size() ; i++) {
			int frequence = Collections.frequency(User, distinctList.get(i));
			if(frequence >= 1) {
				resultat.add(distinctList.get(i));
				occurence.add(frequence);
			}
		}
		
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
		
		//récupère dans une collection tous les tweets
		for(int i=0 ; i < tweetCollection.size() ; i++) {
			content.add(tweetCollection.get(i).getStrContent());
		}
		
		//récupère dans une collection tous les hashtag présent dans les tweets
		for(int i=0 ; i < tweetCollection.size() ; i++) {
			if(tweetCollection.get(i).getStrContent().contains("#")) {
				
				String hashtag = tweetCollection.get(i).getStrContent();
				
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
				
		arrHash2 =arrHash;
		Set<String> set = new HashSet<String>();
		set.addAll(arrHash2);
		ArrayList<String> distinctList = new ArrayList<String>(set) ;
		
		
			for(int i=0 ; i < distinctList.size() ; i++) {
				int frequence = Collections.frequency(arrHash, distinctList.get(i));
				if(frequence >= 1000) {
					resultat1.add(distinctList.get(i));
					occurence.add(frequence);
				}
			}
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
