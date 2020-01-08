package view;



import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.event.ActionEvent;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.util.Properties;

import model.DataCollector;
import model.Data;
import view.GetAction;
import view.GetActionFileFoot;
import view.DateLabelFormatter;

public class Launcher extends JFrame  {

	private JLabel labelNbTweet;
	private JLabel NbTweet;
	private JTextField textFieldNbTweet;
	private String dDate;
	private JLabel labelUserPopu;
	private JLabel UserPopu;
	private JLabel Hashtag;
	private JLabel labelHashtag;
	private JDatePickerImpl datePicker;
	
	public Launcher(){
		super();
		build();
	}
	
	private void build(){
		setTitle("Tweet"); 
		setSize(400,400); 
		setLocationRelativeTo(null); 
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
		
	}
	

	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
	//--------------------------------------------------------------	
		
		JButton boutonFoot = new JButton(new GetActionFileFoot(this, "Foot"));
		panel.add(boutonFoot);
		JButton boutonClimat = new JButton(new GetActionFileClimat(this, "Climat"));
		panel.add(boutonClimat);
		
	//--------------------------------------------------------------
		
		JLabel titre = new JLabel("Ajouter une date");
		panel.add(titre);
		
		UtilDateModel model = new UtilDateModel();
		model.setDate(2019, 5, 21);
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panel.add(datePicker);
		dDate = datePicker.getJFormattedTextField().getText();
		
	//--------------------------------------------------------------
		
		textFieldNbTweet = new JTextField();
		textFieldNbTweet.setColumns(10);
		panel.add(textFieldNbTweet);
		textFieldNbTweet.setText(dDate);
		JButton boutonTweet = new JButton(new GetAction(this, "Recherche"));
		panel.add(boutonTweet);
		
	//--------------------------------------------------------------
		NbTweet = new JLabel("Nombre de Tweets");
		NbTweet.setBounds(10,10,50,20);
		panel.add(NbTweet);
				
		labelNbTweet = new JLabel("");
		
		panel.add(labelNbTweet);

	//--------------------------------------------------------------
		
		UserPopu = new JLabel("Utilisateurs Populaires (Top 10)");
		panel.add(UserPopu);
		
		
		labelUserPopu = new JLabel("");
		
		panel.add(labelUserPopu);

	//--------------------------------------------------------------
		
		Hashtag = new JLabel("Hashtag Populaires - Frequence (Top 10)");
		panel.add(Hashtag);
				
				
		labelHashtag = new JLabel("");
				
		panel.add(labelHashtag);
		
		return panel;
	}
	

	public JTextField getTextField(){
		return textFieldNbTweet;
	}
 
	public JLabel getLabel(){
		return labelNbTweet;
	}
	
 
	public JLabel getLabelUserPopu(){
		return labelUserPopu;
	}
	
	public JLabel getLabelHashtag(){
		return labelHashtag;
	}
	
	public static void main(String[] args) throws IOException {
		Launcher fenetre = new Launcher();
		fenetre.setVisible(true);
	}

	
}
