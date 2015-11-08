package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.ForegroundType;

public class ForegroundTypeDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new GridLayout(2, 3));
		for (ForegroundType ft : ForegroundType.values()) {
			Radial rd = new Radial();
			rd.setForegroundType(ft);
			frame.add(rd);
		}
		
		Radial rd = new Radial();
		rd.setForegroundVisible(false);
		frame.add(rd);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
