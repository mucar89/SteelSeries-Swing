package org.ulucoder.steelseries.demo;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.Radial;

public class TrackDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(1, 2));
		
		Radial rd = new Radial();
		rd.setTrackSection(27);
		rd.setTrackSectionColor(Color.YELLOW);
		rd.setTrackStart(5);
		rd.setTrackStartColor(Color.BLUE);
		rd.setTrackStop(35);
		rd.setTrackStopColor(Color.RED);
		rd.setTrackVisible(true);
		frame.add(rd);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
