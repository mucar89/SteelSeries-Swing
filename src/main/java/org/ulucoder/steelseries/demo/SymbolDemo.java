package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.extras.Indicator;
import eu.hansolo.steelseries.tools.SymbolType;

public class SymbolDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new GridLayout(4, 6));
		for (SymbolType st : SymbolType.values()) {
			Indicator indi = new Indicator();
			indi.setSymbolType(st);
			frame.add(indi);
		}
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
