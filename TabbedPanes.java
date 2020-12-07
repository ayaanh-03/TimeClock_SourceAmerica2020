import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class TabbedPanes {
	public static int clicks1 = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = new ImageIcon();

		Panel panel1 = new Panel();
		tabbedPane.addTab("Buttons", icon, panel1, "Does nothing");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		JTextField text1 = new JTextField(26);

		JButton button1 = new JButton("click");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clicks1++;
				text1.setText(clicks1 + "");
				clicks1 = 0;
			}
		});
		panel1.add(button1);
		
		panel1.add(text1);
		
		JButton clear1 = new JButton("clear");
		clear1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text1.setText("");
			}
		});
		panel1.add(clear1);
		

		Panel panel2 = new Panel();
		tabbedPane.addTab("Type and Print", icon, panel2, "Does twice as much nothing");
		
		JTextField type = new JTextField(26);
		JTextField print = new JTextField(26);
		JButton enter = new JButton("enter");
		enter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				print.setText(type.getText());
			}
		});
		
		panel2.add(type);
		panel2.add(enter);
		panel2.add(print);

		Panel panel3 = new Panel();
		tabbedPane.addTab("Tab 3", icon, panel3, "Still does nothing");

		Panel panel4 = new Panel();
		panel4.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Tab 4", icon, panel4, "Does nothing at all");
		
		JFrame frame = new JFrame("Testing Tabs");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.add(tabbedPane);
		frame.setVisible(true);
	}

}
