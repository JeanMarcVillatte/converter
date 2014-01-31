package com.converter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class converter extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JLabel lblNewLabel;
	private JLabel resultLabel;
	private final JComboBox comboBox;
	private final JComboBox comboBox_1;
	private JPanel panel;
	private JButton btnCalcul;
	private JPanel panel_1;
	private JLabel errorLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					converter frame = new converter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public converter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setSize(new Dimension(50, 50));
		panel.setMaximumSize(new Dimension(50, 50));
		final float conversion[][] = new float[][] {
				{ 1, 1000, 1000000, 0.6213711f, 1094, 3280.8399166f },
				{ 0.001f, 1, 1000, 0.0006213f, 1.0938712f, 3.2804478f },
				{ 0.000001f, 0.001f, 1, 0.0000006213f,  0.0010938712f, 0.0032804478f },
				{ 1.6093442f, 1609.3442f, 1609000.3442f, 1, 1760.6225973f, 5280.0007769f },
				{ 0.000914f, 0.914f, 914, 0.0005679f, 1, 2.9933802f },
				{ 0.0003047f, 0.3047f, 304.7f, 0.0001893f, 0.3331342f, 1 }
				};

		final String modelJComboBox[] = new String[] { "km", "m", "mm",
				"miles", "yards", "feet" };
		
		btnCalcul = new JButton("calcul");
		btnCalcul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				int idUnite1=0;
				int idUnite2=0;
				if (input.getText().isEmpty()) {
					errorLabel.setText("erreur");
				} else {
					for (int i=0; i<modelJComboBox.length;i++) {
						if (comboBox.getSelectedItem().toString().equals(modelJComboBox[i])){
							idUnite1=i;
						}
						if (comboBox_1.getSelectedItem().toString().equals(modelJComboBox[i])){
							idUnite2=i;
						}
					}
					resultLabel.setText(String.valueOf(Float.parseFloat(input.getText())*conversion[idUnite1][idUnite2]));

				}

			}
		});
		panel.add(btnCalcul);

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		panel.add(errorLabel);

		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		input = new JTextField();
		panel_1.add(input);
		input.setColumns(10);



		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object itemSel = comboBox_1.getSelectedItem();
				comboBox_1.setModel(new DefaultComboBoxModel(modelJComboBox));
				comboBox_1.removeItem(comboBox.getSelectedItem());
				comboBox_1.setSelectedItem(itemSel);

			}
		});
		panel_1.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(modelJComboBox));

		lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		lblNewLabel
				.setIcon(new ImageIcon("D:\\workspace\\Converter\\index.jpg"));

		resultLabel = new JLabel("");
		panel_1.add(resultLabel);

		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object itemSel = comboBox.getSelectedItem();
				comboBox.setModel(new DefaultComboBoxModel(modelJComboBox));
				comboBox.removeItem(comboBox_1.getSelectedItem());
				comboBox.setSelectedItem(itemSel);
			}
		});
		panel_1.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(modelJComboBox));
		comboBox_1.removeItem(comboBox.getSelectedItem());

		
	}

}
