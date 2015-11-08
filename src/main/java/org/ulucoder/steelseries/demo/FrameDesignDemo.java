package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.FrameDesign;

public class FrameDesignDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new GridLayout(3, 4));
		for (FrameDesign fd : FrameDesign.values()) {
			Radial rd = new Radial();
			rd.setFrameDesign(fd);
			frame.add(rd);
		}
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
