import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TimeClock_2027 {
	
	public static ArrayList<String> names;
	public static ArrayList<Panel> panels;
	public static ArrayList<int[]> times;
	public static Color[] colors;
	public static File theDir;
	public static File file;
	public static FileWriter writer;

	public static void main(String[] args) throws IOException {
		names = new ArrayList<String>();
		panels = new ArrayList<Panel>();
		times = new ArrayList<int[]>();
		colors = new Color[2];
		colors[0] = new Color(255, 255, 0);
		colors[1] = new Color(75, 5, 105);
		theDir = new File("C:\\/TimeClock");
		if (!theDir.exists()){
		    theDir.mkdirs();
		}
		file = new File("C:\\TimeClock\\Timings.txt\\");
		file.createNewFile();
		writer = new FileWriter(file, true);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = new ImageIcon();

		Panel addPerson = new Panel();
		Panel Listing = new Panel();
		
		Listing.setLayout(new BoxLayout(Listing, BoxLayout.Y_AXIS));
		
		tabbedPane.setBackground(colors[1]);
		tabbedPane.setForeground(colors[0]);
		tabbedPane.addTab("ADD PERSON", icon, addPerson, "");
		tabbedPane.addTab("LIST + START/STOP", icon, Listing, "");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		TextField format = new TextField();
		format.setBackground(colors[1]);
		format.setForeground(colors[0]);
		format.setText("Format is [name],[job],[pay rate($/hr)] no spaces");
		
		JTextField name = new JTextField(26);
		name.setBackground(colors[1]);
		name.setForeground(colors[0]);

		JButton button1 = new JButton("Submit");
		button1.setBackground(colors[1]);
		button1.setForeground(colors[0]);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newName = name.getText();
				if(!names.contains(newName)) {
					names.add(newName);
					addName(newName, Listing);
					name.setText("");
				}
			}
		});
		
//		JButton deleteTXT = new JButton("Clear Time Recordings");
//		deleteTXT.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				file.delete();
//				try {
//					file.createNewFile();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//			
//		});
		
		addPerson.add(format);
		addPerson.add(name);
		addPerson.add(button1);
//		addPerson.add(deleteTXT);
		addPerson.setBackground(colors[0]);
		addPerson.setForeground(colors[1]);
		Listing.setBackground(colors[0]);
		Listing.setForeground(colors[1]);

		Panel settings = new Panel();
		settings.setBackground(colors[0]);
		tabbedPane.addTab("COLOR SETTINGS", icon, settings, "");
		
		JButton deuter = new JButton("Deuteranopia");
		JButton trita = new JButton("Tritanopia");
		JButton prota = new JButton("Protanopia");
		JButton defa = new JButton("Default");
		
		deuter.setBackground(colors[1]);
		deuter.setForeground(colors[0]);
		trita.setBackground(colors[1]);
		trita.setForeground(colors[0]);
		prota.setBackground(colors[1]);
		prota.setForeground(colors[0]);
		defa.setBackground(colors[1]);
		defa.setForeground(colors[0]);
		
		settings.add(defa);
		settings.add(deuter);
		settings.add(trita);
		settings.add(prota);
		
		defa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				colors[0] = new Color(255, 255, 0);
				colors[1] = new Color(75, 5, 105);
				recolor(addPerson, Listing, settings);
				tabbedPane.setBackground(colors[1]);
				tabbedPane.setForeground(colors[0]);
//				Component[] adds = addPerson.getComponents();
//				for(int i = 0; i < adds.length-1; i++) {
//					adds[i].setBackground(colors[1]);
//				}
				
			}
			
		});
		
		deuter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				colors[0] = new Color (255, 231, 92);
				colors[1] = new Color (131, 164, 255);
//				addPerson.setBackground(colors[0]);
//				Listing.setBackground(colors[0]);
//				settings.setBackground(colors[0]);
				recolor(addPerson, Listing, settings);
				tabbedPane.setBackground(colors[1]);
				tabbedPane.setForeground(colors[0]);
//				Component[] adds = addPerson.getComponents();
//				for(int i = 0; i < adds.length-1; i++) {
//					adds[i].setBackground(colors[1]);
//				}
				
			}
			
		});
		
		prota.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				colors[0] = new Color (255, 229, 50);
				colors[1] = new Color (67, 135, 255);
//				addPerson.setBackground(colors[0]);
//				Listing.setBackground(colors[0]);
//				settings.setBackground(colors[0]);
				recolor(addPerson, Listing, settings);
				tabbedPane.setBackground(colors[1]);
				tabbedPane.setForeground(colors[0]);
//				Component[] adds = addPerson.getComponents();
//				for(int i = 0; i < adds.length-1; i++) {
//					adds[i].setBackground(colors[1]);
//				}
				
			}
			
			
		});
		
		trita.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				colors[0] = new Color (255, 190, 202);
				colors[1] = new Color (062, 169, 182);
//				addPerson.setBackground(colors[0]);
//				Listing.setBackground(colors[0]);
//				settings.setBackground(colors[0]);
				recolor(addPerson, Listing, settings);
				tabbedPane.setBackground(colors[1]);
				tabbedPane.setForeground(colors[0]);
//				Component[] adds = addPerson.getComponents();
//				for(int i = 0; i < adds.length-1; i++) {
//					adds[i].setBackground(colors[1]);
//				}
				
			}
			
		});
		
		JFrame frame = new JFrame("TimeClock");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.add(tabbedPane);
		frame.setVisible(true);
	}
	
	public static void addName(String newName, Panel main){
		Panel newSub = new Panel();
		newSub.setBackground(colors[0]);
		newSub.setForeground(colors[1]);
		TextField name = new TextField();
		name.setText(newName);
		name.setForeground(colors[0]);
		name.setBackground(colors[1]);
		name.setEditable(false);
		
		JButton start = new JButton("Start");
		start.setBackground(colors[1]);
		start.setForeground(colors[0]);
		Timer clock = new Timer(true);
		JButton stop = new JButton("Stop");
		stop.setBackground(colors[1]);
		stop.setForeground(colors[0]);
		JButton delete = new JButton("Delete User");
		delete.setBackground(colors[1]);
		delete.setForeground(colors[0]);
		TextField elapsed = new TextField(26);
		elapsed.setBackground(colors[1]);
		elapsed.setForeground(colors[0]);
		JButton clear = new JButton("Clear Time");
		clear.setBackground(colors[1]);
		clear.setForeground(colors[0]);
		int[] newTime = {0, 0, 0};
		times.add(newTime);
		final int index = times.size()-1;
		
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.scheduleAtFixedRate(new TimerTask() {

					@Override
					public void run() {
						times.get(index)[0]++;
						if(times.get(index)[0] >= 60) {
							times.get(index)[0] -= 60;
							times.get(index)[1]++;
						}
						if(times.get(index)[1] >= 60) {
							times.get(index)[1] -= 60;
							times.get(index)[2]++;
						}
						elapsed.setText(times.get(index)[2] + ":" + times.get(index)[1] + ":" + times.get(index)[0]);
						
					}
					
				}, 0, 1000);
			}
		});
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.cancel();
				String finalTime = elapsed.getText();
				addName(newName, main, finalTime, newSub);
				String[] temp = name.getText().split(",");
				String[] newLine = new String[4];
				newLine[0] = temp[0];
				newLine[1] = temp[1];
				newLine[2] = temp[2];
				newLine[3] = finalTime;
				try {
					saveToFile(newLine);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < panels.size(); i++) {
					Panel p = panels.get(i);
					if(p.isAncestorOf(delete)) {
						panels.remove(i);
					}
				}
				main.removeAll();
				for(int i = 0; i < panels.size(); i ++) {
					main.add(panels.get(i));
				}
			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] arr = {0, 0, 0};
				times.set(index,  arr);
				elapsed.setText("");
			}
			
		});
		
		elapsed.setEditable(false);
		
		newSub.add(delete);
		newSub.add(name);
		newSub.add(start);
		newSub.add(stop);
		newSub.add(elapsed);
		newSub.add(clear);
		main.add(newSub);
		panels.add(newSub);
	 
	}
	
	public static void addName(String newName, Panel main, String finalTime, Panel old) {
		main.remove(old);
		panels.remove(old);
		
		Panel newSub = new Panel();
		newSub.setBackground(colors[0]);
		newSub.setForeground(colors[1]);
		TextField name = new TextField();
		name.setBackground(colors[1]);
		name.setForeground(colors[0]);
		name.setText(newName);
		name.setEditable(false);
		
		JButton start = new JButton("Start");
		start.setBackground(colors[1]);
		start.setForeground(colors[0]);
		Timer clock = new Timer(true);
		JButton stop = new JButton("Stop");
		stop.setBackground(colors[1]);
		stop.setForeground(colors[0]);
		JButton delete = new JButton("Delete User");
		delete.setBackground(colors[1]);
		delete.setForeground(colors[0]);
		TextField elapsed = new TextField(26);
		elapsed.setBackground(colors[1]);
		elapsed.setForeground(colors[0]);
		JButton clear = new JButton("Clear Time");
		clear.setBackground(colors[1]);
		clear.setForeground(colors[0]);
		elapsed.setText(finalTime);
		int[] newTime = {0, 0, 0};
		times.add(newTime);
		final int index = times.size()-1;
		
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.scheduleAtFixedRate(new TimerTask() {

					@Override
					public void run() {
						times.get(index)[0]++;
						if(times.get(index)[0] >= 60) {
							times.get(index)[0] -= 60;
							times.get(index)[1]++;
						}
						if(times.get(index)[1] >= 60) {
							times.get(index)[1] -= 60;
							times.get(index)[2]++;
						}
						elapsed.setText(times.get(index)[2] + ":" + times.get(index)[1] + ":" + times.get(index)[0]);
						
					}
					
				}, 0, 1000);
			}
		});
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.cancel();
				String finalTime = elapsed.getText();
				addName(newName, main, finalTime, newSub);
				String[] temp = name.getText().split(",");
				String[] newLine = new String[4];
				newLine[0] = temp[0];
				newLine[1] = temp[1];
				newLine[2] = temp[2];
				newLine[3] = finalTime;
				try {
					saveToFile(newLine);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < panels.size(); i++) {
					Panel p = panels.get(i);
					if(p.isAncestorOf(delete)) {
						panels.remove(i);
					}
				}
				main.removeAll();
				for(int i = 0; i < panels.size(); i ++) {
					main.add(panels.get(i));
				}
			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] arr = {0, 0, 0};
				times.set(index,  arr);
				elapsed.setText("");
			}
			
		});
		
		elapsed.setEditable(false);
		
		newSub.add(delete);
		newSub.add(name);
		newSub.add(start);
		newSub.add(stop);
		newSub.add(elapsed);
		newSub.add(clear);
		panels.add(newSub);
		
		main.removeAll();
		for(int i = 0; i < panels.size(); i ++) {
			main.add(panels.get(i));
		}
		main.validate();
	}
	
	public static int[] msToHMS(long time) {
		int[] diff = new int[3];
		int hours = (int) (time % 3600000);
		time = time - hours * 3600000;
		int minutes = (int) (time % 60000);
		time = time - minutes * 60000;
		int seconds = (int) (time % 1000);
		diff[0] = hours;
		diff[1] = minutes;
		diff[2] = seconds;
		return diff;
	}
	
	public static void recolor(Panel p1, Panel p2, Panel p3) {
		p1.setBackground(colors[0]);
		p1.setForeground(colors[1]);
		p2.setBackground(colors[0]);
		p2.setForeground(colors[1]);
		p3.setBackground(colors[0]);
		p3.setForeground(colors[1]);
		Component[] c1 = p1.getComponents();
		Component[] c2 = p2.getComponents();
		Component[] c3 = p3.getComponents();
		for(int i = 0; i < c1.length; i++) {
			c1[i].setBackground(colors[1]);
			c1[i].setForeground(colors[0]);
		}
		for(int i = 0; i < c2.length; i++) {
			c2[i].setBackground(colors[1]);
			c2[i].setForeground(colors[0]);
		}
		for(int i = 0; i < c3.length; i++) {
			c3[i].setBackground(colors[1]);
			c3[i].setForeground(colors[0]);
		}
		for(int i = 0; i < panels.size(); i++) {
			Component[] c = panels.get(i).getComponents();
			panels.get(i).setBackground(colors[0]);
			for(int j = 0; j < c.length; j++) {
				c[j].setBackground(colors[1]);
				c[j].setForeground(colors[0]);
			}
		}
	}
	
	public static void saveToFile(String[] newLine) throws IOException {
		double rate = Double.parseDouble(newLine[2]);
		int hours = Integer.parseInt(newLine[3].split(":")[0]);
		double pay = rate * hours;
		LocalDate d = LocalDate.now();
		String date = d.getMonthValue() + "/" + d.getDayOfMonth() + "/" + d.getYear();
		String toBeAdded = "(" + date + ")  " + "name: " + newLine[0] + "\tjob: " + newLine[1] + "\telapsed time: " + newLine[3] + "\t pay: $" + pay + "\n";
		writer.write(toBeAdded);
		writer.close();
		writer = new FileWriter(file, true);
	}
}
