/*
 * Created by JFormDesigner on Fri Dec 26 22:41:31 ICT 2014
 */

package com.annvcit.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Chuc An Nguyen Van
 */
public class Home extends JFrame {
	public Home() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Chuc An Nguyen Van
		radioButton1 = new JRadioButton();
		radioButton2 = new JRadioButton();

		//======== this ========
		Container contentPane = getContentPane();

		//---- radioButton1 ----
		radioButton1.setText("African");

		//---- radioButton2 ----
		radioButton2.setText("Finnish");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(113, 113, 113)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(radioButton1)
						.addComponent(radioButton2))
					.addContainerGap(212, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(59, 59, 59)
					.addComponent(radioButton1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(radioButton2)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Chuc An Nguyen Van
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
