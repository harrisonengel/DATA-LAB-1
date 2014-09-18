package GUI;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon; 
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ShipGUI extends javax.swing.JFrame{
	
	public ShipGUI(){
		getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(81, 0, 81, 40);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(162, 0, 81, 40);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(355, 0, 81, 40);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(324, 0, 81, 40);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(405, 0, 81, 40);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(486, 0, 81, 40);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(0, 40, 81, 40);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(81, 40, 81, 40);
		getContentPane().add(label_8);
		
		JButton btnAddShip = new JButton("Add Ship");
		btnAddShip.setBounds(212, 11, 112, 40);
		getContentPane().add(btnAddShip);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(243, 40, 81, 40);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(324, 40, 81, 40);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(405, 40, 81, 40);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(486, 40, 81, 40);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(0, 80, 81, 40);
		getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(81, 80, 81, 40);
		getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(162, 80, 81, 40);
		getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(243, 80, 81, 40);
		getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(324, 80, 81, 40);
		getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(405, 80, 81, 40);
		getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setBounds(486, 80, 81, 40);
		getContentPane().add(label_19);
		
		JButton btnDisplayByAge = new JButton("Display by Age");
		btnDisplayByAge.setBounds(47, 120, 119, 40);
		getContentPane().add(btnDisplayByAge);
		
		JLabel label_20 = new JLabel("");
		label_20.setBounds(81, 120, 81, 40);
		getContentPane().add(label_20);
		
		JButton btnDisplayByGender = new JButton("Display by Gender");
		btnDisplayByGender.setBounds(212, 120, 119, 40);
		getContentPane().add(btnDisplayByGender);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(243, 120, 81, 40);
		getContentPane().add(label_21);
		
		JButton btnDisplayAll = new JButton("Display All");
		btnDisplayAll.setBounds(398, 120, 119, 40);
		getContentPane().add(btnDisplayAll);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(405, 120, 81, 40);
		getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setBounds(486, 120, 81, 40);
		getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setBounds(0, 160, 81, 40);
		getContentPane().add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setBounds(81, 160, 81, 40);
		getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setBounds(162, 160, 81, 40);
		getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setBounds(243, 160, 81, 40);
		getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(324, 160, 81, 40);
		getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setBounds(405, 160, 81, 40);
		getContentPane().add(label_29);
		
		JLabel label_30 = new JLabel("");
		label_30.setBounds(486, 160, 81, 40);
		getContentPane().add(label_30);
		
		JButton btnAddConvict = new JButton("Add Convict");
		btnAddConvict.setBounds(47, 240, 119, 40);
		getContentPane().add(btnAddConvict);
		
		JLabel label_31 = new JLabel("");
		label_31.setBounds(81, 200, 81, 40);
		getContentPane().add(label_31);
		
		JButton btnRemoveConvict = new JButton("Remove Convict");
		btnRemoveConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemoveConvict.setBounds(212, 240, 119, 40);
		getContentPane().add(btnRemoveConvict);
		
		JLabel label_32 = new JLabel("");
		label_32.setBounds(243, 200, 81, 40);
		getContentPane().add(label_32);
		
		JButton btnSaveShips = new JButton("Save Ships");
		btnSaveShips.setBounds(405, 240, 119, 40);
		getContentPane().add(btnSaveShips);
		
		JLabel label_33 = new JLabel("");
		label_33.setBounds(405, 200, 81, 40);
		getContentPane().add(label_33);
		
		JLabel label_34 = new JLabel("");
		label_34.setBounds(486, 200, 81, 40);
		getContentPane().add(label_34);
		
		JLabel label_35 = new JLabel("");
		label_35.setBounds(0, 240, 81, 40);
		getContentPane().add(label_35);
		
		JLabel label_36 = new JLabel("");
		label_36.setBounds(81, 240, 81, 40);
		getContentPane().add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setBounds(162, 240, 81, 40);
		getContentPane().add(label_37);
		
		JLabel label_38 = new JLabel("");
		label_38.setBounds(243, 240, 81, 40);
		getContentPane().add(label_38);
		
		JLabel label_39 = new JLabel("");
		label_39.setBounds(324, 240, 81, 40);
		getContentPane().add(label_39);
		
		JLabel label_40 = new JLabel("");
		label_40.setBounds(405, 240, 81, 40);
		getContentPane().add(label_40);
		
		JLabel label_41 = new JLabel("");
		label_41.setBounds(486, 240, 81, 40);
		getContentPane().add(label_41);
		
		JLabel label_42 = new JLabel("");
		label_42.setBounds(0, 280, 81, 40);
		getContentPane().add(label_42);
		
		JLabel label_43 = new JLabel("");
		label_43.setBounds(81, 280, 81, 40);
		getContentPane().add(label_43);
		
		JLabel label_44 = new JLabel("");
		label_44.setBounds(162, 280, 81, 40);
		getContentPane().add(label_44);
		
		JLabel label_45 = new JLabel("");
		label_45.setBounds(243, 280, 81, 40);
		getContentPane().add(label_45);
		
		JLabel label_46 = new JLabel("");
		label_46.setBounds(324, 280, 81, 40);
		getContentPane().add(label_46);
		
		JLabel label_47 = new JLabel("");
		label_47.setBounds(405, 280, 81, 40);
		getContentPane().add(label_47);
		
		JLabel label_48 = new JLabel("");
		label_48.setBounds(486, 280, 81, 40);
		getContentPane().add(label_48);
		
		JLabel label_49 = new JLabel("");
		label_49.setBounds(0, 320, 81, 40);
		getContentPane().add(label_49);
		
		JLabel label_50 = new JLabel("");
		label_50.setBounds(81, 320, 81, 40);
		getContentPane().add(label_50);
		
		JLabel label_51 = new JLabel("");
		label_51.setBounds(162, 320, 81, 40);
		getContentPane().add(label_51);
		
		JLabel label_52 = new JLabel("");
		label_52.setBounds(243, 320, 81, 40);
		getContentPane().add(label_52);
		
		JLabel label_53 = new JLabel("");
		label_53.setBounds(324, 320, 81, 40);
		getContentPane().add(label_53);
		initGUI();
	}
	
	
	public void initGUI(){
		this.setVisible(true);
	}
	
}

