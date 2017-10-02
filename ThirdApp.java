package reaktor;
import javax.swing.*;
import java.awt.Choice;
import java.awt.event.*;

public class ThirdApp {
	
	static String spr(boolean x) {
		String A = null;
		if (x == true) {
			A = "tak";
		} else A = "nie";
		return A;
	}
	
	public static boolean notEmpty(String s) {
		 return (s != null && s.length() > 0);
		}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame("ThirdApp");	
		JFrame warning = new JFrame("Uwaga!");
		
		// labels
		JLabel lbl_imie = new JLabel("Imiê");
		JLabel lbl_nazwisko = new JLabel("Nazwisko");
		JLabel lbl_stanowisko = new JLabel("Stanowisko");
		JLabel lbl_email = new JLabel("e-mail");
		JLabel lbl_planguages = new JLabel("Jakie znasz jêzyki programowania?");
		JLabel lbl_english = new JLabel("Wybierz poziom jêzyka angielskiego.");
		JLabel lbl_choose = new JLabel("Wybierz kurs programowania:");
		JLabel lbl_warning = new JLabel("Nie wszystkie pola zosta³y uzupe³nione!");
		
		//Choices
		Choice kurs = new Choice();
		kurs.add("Kurs Back-End Developer");
		kurs.add("Kurs Front-End Developer");	
		
		// txtareas
		JTextArea ta = new JTextArea(); 
		ta.setBounds(500, 40, 350, 350); 
		ta.setEditable(false);
		
		
		// buttons
		JButton btn1 = new JButton("Wypisz");
		JButton btn2 = new JButton("Wyjdz");
		JButton btn3 = new JButton("OK");
		
		//txtfields
		
		JTextField tf_imie = new JTextField();
		JTextField tf_nazwisko = new JTextField();
		JTextField tf_stanowisko = new JTextField();
		JTextField tf_email = new JTextField();
		
		// RadioButtons
		JRadioButton rbtn1 = new JRadioButton("podstawowy"); rbtn1.setSelected(true);
		JRadioButton rbtn2 = new JRadioButton("œrednio zaawansowany");
		JRadioButton rbtn3 = new JRadioButton("zaawansowany");
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rbtn1); 
		bg1.add(rbtn2);
		bg1.add(rbtn3);
		
		// CheckBoxes
		JCheckBox cb_Java = new JCheckBox("Java");
		JCheckBox cb_Python = new JCheckBox("Python");
		JCheckBox cb_oth = new JCheckBox("inne");
				
		// layout
		f.setVisible(true);
		f.setSize(1000, 600);
		f.setLayout(null);
		
		warning.setVisible(false);
		warning.setSize(300, 150);
		warning.setLayout(null);
		
		lbl_imie.setBounds(20, 20, 100, 20);
		lbl_planguages.setBounds(250, 20, 250, 20);
		lbl_nazwisko.setBounds(20, 100, 100, 20);
		lbl_stanowisko.setBounds(20, 180, 100, 20);
		lbl_email.setBounds(20, 260, 100, 20);
		lbl_english.setBounds(250, 160, 250, 20);
		lbl_choose.setBounds(250, 280, 200, 20);
		lbl_warning.setBounds(20, 20, 300, 20);
		tf_imie.setBounds(20, 60, 100, 20);
		tf_nazwisko.setBounds(20, 140, 100, 20);
		tf_stanowisko.setBounds(20, 220, 100, 20);
		tf_email.setBounds(20, 300, 100, 20);
		cb_Java.setBounds(250, 60, 100, 20);
		cb_Python.setBounds(250, 80, 100, 20);
		cb_oth.setBounds(250, 100, 100, 20);
		rbtn1.setBounds(250, 200, 200, 20);
		rbtn2.setBounds(250, 220, 200, 20);
		rbtn3.setBounds(250, 240, 200, 20);
		btn1.setBounds(20, 380, 100, 20);
		btn2.setBounds(150, 380, 100, 20);
		btn3.setBounds(100, 50, 100, 20);
		kurs.setBounds(250, 320, 200, 20 );
			
		f.add(tf_email);
		f.add(tf_stanowisko);
		f.add(tf_nazwisko);
		f.add(tf_imie);
		f.add(tf_email);
		f.add(btn2);
		f.add(btn1);
		f.add(lbl_email);
		f.add(lbl_stanowisko);
		f.add(lbl_nazwisko);
		f.add(lbl_imie);
		f.add(lbl_planguages);
		f.add(lbl_english);
		f.add(lbl_choose);
		f.add(cb_Java);
		f.add(cb_Python);
		f.add(cb_oth);
		f.add(rbtn1);
		f.add(rbtn2);
		f.add(rbtn3);
		f.add(ta);
		f.add(kurs);
		warning.add(btn3);
		warning.add(lbl_warning);
		

		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String imie = tf_imie.getText();
				String nazwisko = tf_nazwisko.getText();
				String stanowisko = tf_stanowisko.getText();
				String email = tf_email.getText();
				String englishtxt = null;
				String sKurs = kurs.getSelectedItem();
				
				if(rbtn1.isSelected()) englishtxt = rbtn1.getText();
				if(rbtn2.isSelected()) englishtxt = rbtn2.getText();
				if(rbtn3.isSelected()) englishtxt = rbtn3.getText();
				
				
				if (notEmpty(imie) == false || notEmpty(nazwisko) == false || notEmpty(stanowisko) == false || notEmpty(email) == false ) {
					warning.setVisible(true);
					
					btn3.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							warning.setVisible(false);
					}
				});
					
				}
				
				ta.setText("Dane kontaktowe: \n" + 
							imie + " " + nazwisko + " ("+ stanowisko + ") " + email + "\n \n" + 
							"Informacje zawodowe: \n" + 
							cb_Java.getText() + ": " + spr(cb_Java.isSelected()) + "\n" +
							cb_Python.getText() + ": "+ spr(cb_Python.isSelected()) + "\n" +
							cb_oth.getText() + ": " + spr(cb_oth.isSelected()) + "\n" +
							"Angielski: " + englishtxt + "\n \n" +
							"Wybrany kurs: \n" + sKurs);
			}});
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
		}
	});
		
	}
}


