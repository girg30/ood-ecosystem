/*
 * Created by JFormDesigner on Fri Dec 26 22:41:31 ICT 2014
 */

package com.annvcit.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

import com.annvcit.controller.HomeEvent;

public class Home extends JFrame{

	
	private static final long serialVersionUID = 1L;
	private HomeEvent homeEvent;
	public Home() {
		initComponents();
		// lập group cho radio button
		ButtonGroup group = new ButtonGroup();
		this.rbtnAfrican.setSelected(true);
		group.add(rbtnAfrican);
		group.add(rbtnFinnish);
		this.setTitle("Home");
		
		// add event cho jframe
		homeEvent = new HomeEvent(this);
		button1.addActionListener(homeEvent);
	}
	
	public JButton getStartButton(){
		return this.button1;
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
		button1 = new JButton();

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

		//---- button1 ----
		button1.setText("Start Simulator");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(42, 42, 42)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(rbtnFinnish)
							.addContainerGap(178, Short.MAX_VALUE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(rbtnAfrican)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addComponent(button1)
							.addGap(26, 26, 26))))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(44, 44, 44)
							.addComponent(rbtnAfrican))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(59, 59, 59)
							.addComponent(button1)))
					.addGap(18, 18, 18)
					.addComponent(rbtnFinnish)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Chuc An Nguyen Van
	private JRadioButton rbtnAfrican;
	private JRadioButton rbtnFinnish;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

}
