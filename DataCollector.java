package model;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import model.Tweet;
import view.Launcher;
import view.GetActionFileFoot;

public class DataCollector{
	static ArrayList<Tweet> tweetCollection = new ArrayList<Tweet>();
	String Fichier;
	
		public DataCollector()
		{
			Fichier = GetActionFileFoot.getChoix();
			LoadFichier("Foot.txt");
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
					//System.out.println(tweetCollection.size());
					//System.out.println(arr[3]);
	
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
		
		
		public static ArrayList<Tweet> getTweetCollection(){
			return tweetCollection;
		}
		
		public static void setTweetCollection(ArrayList<Tweet> tTweetCollection){
			tweetCollection = tTweetCollection;
		}
	}