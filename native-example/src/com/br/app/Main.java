package com.br.app;

import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.br.app.views.Login;

public class Main {
	public static void main(String[]args) throws SQLException {
	    SwingUtilities.invokeLater(new Runnable(){
	        @Override
	        public void run(){
	            JFrame frame = new JFrame();
	            Insets insets = frame.getInsets();
	            frame.setSize(550 + insets.left + insets.right,
	                          500 + insets.top + insets.bottom);
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setResizable(false);
	            frame.setLocationRelativeTo(null);
	            frame.getContentPane().add(new Login());
	            frame.setVisible(true);
	        }
	    });
//	    TestConnection test = new TestConnection();
//	    test.testConnection();
	}
}
