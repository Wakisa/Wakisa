import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public class Gui extends JFrame {
	
	//("The title");
	private JLabel inputLabel, outputLabel;
	private JButton findButton, clearButton;
	private JTextField dipField, result;
	
	
	
	
	
	public Gui() {
		super("Dip Calculator");
		JFrame mainFrame = new JFrame();
				
		mainFrame.setLayout(new BorderLayout());
		
		
		JPanel thePanel = new JPanel();
		thePanel.setLayout(new FlowLayout());
		
		inputLabel = new JLabel("Enter Dip:");
		
		dipField = new JTextField(6);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout());
		outputLabel = new JLabel("LITRES:");
		result = new JTextField("00000", 10);
		result.setEditable(false);
		clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ClearButtonListener());
		
		outputPanel.add(outputLabel);
		outputPanel.add(result);
		outputPanel.add(clearButton);
		
		JButton findButton = new JButton("Find dip");
		findButton.addActionListener(new FindButtonListener());
		
		thePanel.add(inputLabel);
		thePanel.add(dipField);
		thePanel.add(findButton);
		
		add(thePanel, BorderLayout.NORTH);
		add(outputPanel, BorderLayout.CENTER);
	}

	public class ClearButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			result.setText("00000");
			dipField.setText(null);
		}
		
	}
	
	public class FindButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String userInput = dipField.getText();
			Scanner in = new Scanner(userInput);
			int input;
			
			
			// Create files and locate files
			File dip = new File("C:\\Users\\Wakisa\\eclipse-workspace\\DipCalculator\\src\\litres.txt");
			
			//check input
			if(!in.hasNextInt()) {
				
				result.setText("Invalid input");
				
			}else {
				input = in.nextInt();
				
				//check if input is within range
				if(input > 2175) {
					result.setText("out of chat");
				
				}
				
			   
			   if(input >=0 && input <= dip.length()) {
				   
				   try {
						Scanner dipScan = new Scanner(dip);
						
						List<Integer> dipList = new ArrayList<Integer>();
						
						while(dipScan.hasNext()){
						       int a1 = dipScan.nextInt();
						       dipList.add(a1);

						       
						    }
						
						result.setText(dipList.get(input).toString());
						
					} catch (FileNotFoundException e) {
						
						result.setText("Dip not in the chart");
						//e.printStackTrace();
					}
						
						
							
				    
				   
				   
			   }else {
				   
				   result.setText("Dip not in the chart");
				   
			   }
				
			}
			
		    
							
						
		}
	}
	
	
}
















