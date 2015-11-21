package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import eu.hansolo.steelseries.extras.Indicator;
import eu.hansolo.steelseries.tools.SymbolType;

public class SymbolDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new GridLayout(4, 6));
		for (SymbolType st : SymbolType.values()) {
			final Indicator indi = new Indicator();
			indi.setSymbolType(st);
			indi.setGlow(true);
			indi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					indi.setOn(!indi.isOn());
				}
			});
			
			frame.add(indi);
		}
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
