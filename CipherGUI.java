package com.phs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class CipherGUI implements ActionListener{
	Caesar c = new Caesar();
	Substitution s = new Substitution();
	Vigenère v = new Vigenère();
	JTextField outputText = null;
	JTextField userText = null;
	JTextField keyText = null;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Cipher GUI Varun Khilnani");
		frame.setSize(800, 400);


		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//panel.setLayout(new GridLayout(0, 2));
		frame.add(panel);

		CipherGUI gui = new CipherGUI();
		gui.placeUIPieces(panel);

		frame.setVisible(true);
	}


	private void placeUIPieces(JPanel panel) {
		JLabel prompt = new JLabel("Enter message to be encoded/decoded (only enter letters)");
		prompt.setBounds(0,0,0,10);
		panel.add(prompt);
		
		userText = new JTextField(26);
		userText.setBounds(0, 0, 10, 10);
		panel.add(userText);
		
		JLabel key = new JLabel("Enter key to be used (optional) (for Caesar enter an integer, for Substitution enter a 26 letter key and, for Vigenère enter letters");
		key.setBounds(10,10,0,25);
		panel.add(key);
		
		keyText = new JTextField(26);
		keyText.setBounds(10, 10, 165, 40);
		panel.add(keyText);


		JButton encodeCaesar = new JButton("encodeCaesar");
		encodeCaesar.setBounds(200, 200, 165, 25);
		panel.add(encodeCaesar);
		encodeCaesar.addActionListener(this);

		JButton decodeCaesar = new JButton("decodeCaesar");
		decodeCaesar.setBounds(100, 100, 100, 0);
		panel.add(decodeCaesar);
		decodeCaesar.addActionListener(this);

		JButton encodeSubstitution = new JButton("encodeSubstitution");
		encodeSubstitution.setBounds(100, 100, 100, 0);
		panel.add(encodeSubstitution);
		encodeSubstitution.addActionListener(this);

		JButton decodeSubstitution = new JButton("decodeSubstitution");
		decodeSubstitution.setBounds(100, 100, 100, 0);
		panel.add(decodeSubstitution);
		decodeSubstitution.addActionListener(this);

		JButton encodeVigenère = new JButton("encodeVigenère");
		encodeVigenère.setBounds(100, 100, 100, 0);
		panel.add(encodeVigenère);
		encodeVigenère.addActionListener(this);

		JButton decodeVigenère = new JButton("decodeVigenère");
		decodeVigenère.setBounds(100, 100, 100, 0);
		panel.add(decodeVigenère);
		decodeVigenère.addActionListener(this);

		JLabel output = new JLabel("Output");
		output.setBounds(700,300,0,25);
		panel.add(output);

		outputText = new JTextField(26);
		outputText.setBounds(700, 300, 300, 40);
		panel.add(outputText);




	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getActionCommand().equalsIgnoreCase("encodeCaesar")) {
			if (!keyText.getText().isBlank())
			{
				c = new Caesar(Integer.parseInt(keyText.getText()));
			}
			String encodedMessage = c.encode(userText.getText());
			outputText.setText(encodedMessage);

		}

		else if(e.getActionCommand().equalsIgnoreCase("decodeCaesar")) {
			if (!keyText.getText().isBlank())
			{
				c = new Caesar(Integer.parseInt(keyText.getText()));
			}


			String decodeCaesar = c.decode(userText.getText());
			outputText.setText(decodeCaesar);
		}

		else if(e.getActionCommand().equalsIgnoreCase("encodeSubstitution")) {
			if (!keyText.getText().isBlank())
			{
				s = new Substitution(keyText.getText());
			}

			String encodeSubstitution = s.encode(userText.getText());
			outputText.setText(encodeSubstitution);
		}

		else if(e.getActionCommand().equalsIgnoreCase("decodeSubstitution")) {
			if (!keyText.getText().isBlank())
			{
				s = new Substitution(keyText.getText());
			}


			String decodeSubstitution = s.decode(userText.getText());
			outputText.setText(decodeSubstitution);
		}

		else if(e.getActionCommand().equalsIgnoreCase("encodeVigenère")) {
			if (!keyText.getText().isBlank())
			{
				v = new Vigenère(keyText.getText());
			}


			String encodeVigenère = v.encode(userText.getText());
			outputText.setText(encodeVigenère);
		}

		else if(e.getActionCommand().equalsIgnoreCase("decodeVigenère")) {
			if (!keyText.getText().isBlank())
			{
				v = new Vigenère(keyText.getText());
			}

			String decodeVigenère = v.decode(userText.getText());
			outputText.setText(decodeVigenère);
		}

	}


}
