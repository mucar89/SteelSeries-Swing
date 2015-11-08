package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.BackgroundColor;

public class BackgroundColorDemo {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(3, 2));
		
		for (BackgroundColor bc : BackgroundColor.values()) {
			Radial rd = new Radial();
			rd.setBackgroundColor(bc);
			rd.setTitle(bc.name());
			frame.add(rd);
		}
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
