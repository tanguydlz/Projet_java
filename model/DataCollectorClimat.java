package model;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import model.Tweet;
import view.Launcher;
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

				File path = new File(Fichier);
				InputStream flux=new FileInputStream(path); 
				InputStreamReader lecture=new InputStreamReader(flux, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(lecture);
				
				String line;
				tweetCollection.clear();
				while((line = br.readLine()) != null)
				{
					line = br.readLine();
					String arr[] = line.split("\t");
	
					if(arr.length == 5) {
						Tweet t = new Tweet(arr[0], arr[1], arr[2], arr[3], arr[4]);
						tweetCollection.add(t);
						//System.out.println(arr[0]+ arr[1]+ arr[2]+ arr[3]+ arr[4]);
						//System.out.println(tweetCollection.size());
	
					}
					else if(arr.length == 4) {
						Tweet t = new Tweet(arr[0], arr[1], arr[2], arr[3], "0");
						tweetCollection.add(t);
						//System.out.println(tweetCollection.size());
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
