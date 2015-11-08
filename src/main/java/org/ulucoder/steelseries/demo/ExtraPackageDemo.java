package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.extras.AirCompass;
import eu.hansolo.steelseries.extras.Altimeter;
import eu.hansolo.steelseries.extras.Battery;
import eu.hansolo.steelseries.extras.Clock;
import eu.hansolo.steelseries.extras.Compass;
import eu.hansolo.steelseries.extras.Horizon;
import eu.hansolo.steelseries.extras.Indicator;
import eu.hansolo.steelseries.extras.Led;
import eu.hansolo.steelseries.extras.Level;
import eu.hansolo.steelseries.extras.LightBulb;
import eu.hansolo.steelseries.extras.Radar;
import eu.hansolo.steelseries.extras.StopWatch;
import eu.hansolo.steelseries.extras.TrafficLight;
import eu.hansolo.steelseries.extras.TrafficLight2;
import eu.hansolo.steelseries.extras.WindDirection;

public class ExtraPackageDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new GridLayout(3, 5));
		frame.add(new AirCompass());
		frame.add(new Altimeter());
		frame.add(new Battery());
		frame.add(new Clock());
		frame.add(new Compass());
		frame.add(new Horizon());
		frame.add(new Indicator());
		frame.add(new Led());
		frame.add(new Level());
		frame.add(new LightBulb());
		frame.add(new Radar());
		frame.add(new StopWatch());
		frame.add(new TrafficLight());
		frame.add(new TrafficLight2());
		frame.add(new WindDirection());
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
