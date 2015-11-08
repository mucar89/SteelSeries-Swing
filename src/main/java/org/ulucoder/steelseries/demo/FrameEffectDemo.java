package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.FrameEffect;
import eu.hansolo.steelseries.tools.FrameType;

public class FrameEffectDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new GridLayout(2, 2));
		for (FrameEffect fe : FrameEffect.values()) {
			Radial rd = new Radial();
			rd.setFrameEffect(fe);
			rd.setBackgroundColor(BackgroundColor.LINEN);
			rd.setFrameType(FrameType.SQUARE);
			rd.setTitle(fe.name());
			frame.add(rd);
		}
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
