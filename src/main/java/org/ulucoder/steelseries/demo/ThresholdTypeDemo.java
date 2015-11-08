package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.ThresholdType;

public class ThresholdTypeDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(1, 2));
		
		for (ThresholdType tt : ThresholdType.values()) {
			Radial rd = new Radial();
			rd.setThreshold(25d);
			rd.setThresholdVisible(true);
			rd.setThresholdType(tt);
			rd.setValue(50);
			frame.add(rd);
		}
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
