package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.KnobStyle;

public class KnobStyleDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(1, 3));
		
		for (KnobStyle ks : KnobStyle.values()) {
			Radial rd = new Radial();
			rd.setKnobStyle(ks);
			rd.setValue(50);
			frame.add(rd);
		}
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
