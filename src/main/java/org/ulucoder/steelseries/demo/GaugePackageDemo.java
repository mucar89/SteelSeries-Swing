package org.ulucoder.steelseries.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import eu.hansolo.steelseries.gauges.DigitalRadial;
import eu.hansolo.steelseries.gauges.DisplayCircular;
import eu.hansolo.steelseries.gauges.DisplayMulti;
import eu.hansolo.steelseries.gauges.DisplayRectangular;
import eu.hansolo.steelseries.gauges.DisplaySingle;
import eu.hansolo.steelseries.gauges.Linear;
import eu.hansolo.steelseries.gauges.LinearBargraph;
import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.gauges.Radial1Square;
import eu.hansolo.steelseries.gauges.Radial1Vertical;
import eu.hansolo.steelseries.gauges.Radial2Top;
import eu.hansolo.steelseries.gauges.RadialBargraph;
import eu.hansolo.steelseries.gauges.RadialCounter;
import eu.hansolo.steelseries.gauges.SparkLine;

public class GaugePackageDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new GridLayout(3, 5));
		frame.add(new DigitalRadial());
		frame.add(new DisplayCircular());
		frame.add(new DisplayMulti());
		frame.add(new DisplayRectangular());
		frame.add(new DisplaySingle());
		frame.add(new Linear());
		frame.add(new LinearBargraph());
		frame.add(new Radial());
		frame.add(new Radial1Square());
		frame.add(new Radial1Vertical());
		frame.add(new Radial2Top());
		frame.add(new RadialBargraph());
		frame.add(new RadialCounter());
		frame.add(new SparkLine());
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
