package com.br.app.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.br.app.controllers.UserController;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);


		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(116, 182, 70, 13);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(196, 179, 166, 19);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(116, 225, 70, 13);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 222, 166, 19);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("DEMO APPLICATION");
		lblNewLabel_2.setBounds(10, 62, 487, 56);
		lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(116, 333, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(277, 333, 85, 21);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(116, 283, 246, 28);
		add(lblNewLabel_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				UserController userController = new UserController();
				String auth = userController.queryForLogin(user, password);
				if(auth.contains("Bem vindo")) {
					lblNewLabel_3.setForeground(Color.GREEN);
				}else {
					lblNewLabel_3.setForeground(Color.RED);
				}
				lblNewLabel_3.setText(auth);
			}
		});

	}
}
