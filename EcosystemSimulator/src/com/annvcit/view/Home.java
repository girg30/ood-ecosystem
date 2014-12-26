/*
 * Created by JFormDesigner on Fri Dec 26 22:41:31 ICT 2014
 */

package com.annvcit.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.annvcit.controller.HomeEvent;

/**
 * @author Chuc An Nguyen Van
 */
public class Home extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private HomeEvent homeEvent;
	public Home() {
		initComponents();
		// lập group cho radio button
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnAfrican);
		group.add(rbtnFinnish);
		this.setTitle("Ecosystem Simulator");
		
		// add event cho jframe
		homeEvent = new HomeEvent(this);
	}

	public static void main(String[] args) {
		Home home = new Home();
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.setVisible(true);
		
	}
	
	private void rbtnAfricanActionPerformed(ActionEvent e) {
		//System.out.println("rbtnAfrican is selected");
		homeEvent.actionPerformed(e);
	}

	private void rbtnFinnishActionPerformed(ActionEvent e) {
		//System.out.println("rbtnFinnish is selected");
		homeEvent.actionPerformed(e);
	}

	
	
	public JRadioButton getRbtnAfrican() {
		return rbtnAfrican;
	}

	public void setRbtnAfrican(JRadioButton rbtnAfrican) {
		this.rbtnAfrican = rbtnAfrican;
	}

	public JRadioButton getRbtnFinnish() {
		return rbtnFinnish;
	}

	public void setRbtnFinnish(JRadioButton rbtnFinnish) {
		this.rbtnFinnish = rbtnFinnish;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Chuc An Nguyen Van
		rbtnAfrican = new JRadioButton();
		rbtnFinnish = new JRadioButton();

		//======== this ========
		Container contentPane = getContentPane();

		//---- rbtnAfrican ----
		rbtnAfrican.setText("African");
		rbtnAfrican.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rbtnAfricanActionPerformed(e);
			}
		});

		//---- rbtnFinnish ----
		rbtnFinnish.setText("Finnish");
		rbtnFinnish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rbtnFinnishActionPerformed(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(113, 113, 113)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(rbtnAfrican)
						.addComponent(rbtnFinnish))
					.addContainerGap(212, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(59, 59, 59)
					.addComponent(rbtnAfrican)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(rbtnFinnish)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Chuc An Nguyen Van
	private JRadioButton rbtnAfrican;
	private JRadioButton rbtnFinnish;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
