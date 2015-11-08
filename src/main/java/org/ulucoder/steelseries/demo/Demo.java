package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.DisplaySingle;
import eu.hansolo.steelseries.tools.LcdColor;

public class Demo {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(8, 1));
		
		for (LcdColor lc : LcdColor.values()) {
			DisplaySingle ds = new DisplaySingle();
			ds.setLcdColor(lc);
			ds.setLcdUnitString(lc.name());
			frame.add(ds);
		}
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
