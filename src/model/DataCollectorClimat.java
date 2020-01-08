package model;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import model.Tweet;
import view.GetActionFileClimat;

public class DataCollectorClimat {
	static ArrayList<Tweet> tweetCollection = new ArrayList<Tweet>();
	String Fichier;

		public DataCollectorClimat()
		{
			Fichier = GetActionFileClimat.getChoix();
		}
		
		public void LoadFichier(String Fichier) {
			try {
				
				//Récupère le bon fichier et l'importe
				File path = new File(Fichier);
				InputStream flux=new FileInputStream(path); 
				InputStreamReader lecture=new InputStreamReader(flux, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(lecture);
				
				String line;
				tweetCollection.clear();
				
				//lecture du fichier
				while((line = br.readLine()) != null)
				{
					line = br.readLine();
					String arr[] = line.split("\t");
					//On stocke dans notre classe Tweet les lignes du fichier
					if(arr.length == 5) {
						Tweet t = new Tweet(arr[0], arr[1], arr[2], arr[3], arr[4]);
						tweetCollection.add(t);
	
					}
					else if(arr.length == 4) {
						Tweet t = new Tweet(arr[0], arr[1], arr[2], arr[3], "0");
						tweetCollection.add(t);
					}
				}
				br.close();
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}
		
		public static ArrayList<Tweet> getTweetCollectionClimat(){
			return tweetCollection;
		}
		
}
