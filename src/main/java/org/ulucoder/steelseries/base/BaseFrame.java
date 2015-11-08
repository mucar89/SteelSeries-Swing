package org.ulucoder.steelseries.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.BackgroundImageFactory;
import eu.hansolo.steelseries.tools.ForegroundImageFactory;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.FrameEffect;
import eu.hansolo.steelseries.tools.FrameImageFactory;

public class BaseFrame extends JComponent {

	private static final long serialVersionUID = -389611091884603191L;

	private FrameDesign frameDesign = FrameDesign.METAL;
	private Paint customFrameDesign = Color.BLACK;
	private FrameEffect frameEffect = FrameEffect.EFFECT_CONE;
	private BackgroundColor backgroundColor = BackgroundColor.LINEN;
	
	private BufferedImage frameImage;
	private BufferedImage backgroundImage;
	private BufferedImage foregroundImage;
	private boolean initialized;
	
	protected void init() {
		if (initialized)
			return;
		
		if (frameImage != null) {
			frameImage.flush();
		}
		frameImage = FrameImageFactory.INSTANCE.createLinearFrame(getWidth(), getHeight(), frameDesign, customFrameDesign, frameEffect);

		if (backgroundImage != null) {
			backgroundImage.flush();
		}
		backgroundImage = BackgroundImageFactory.INSTANCE.createLinearBackground(getWidth(), getHeight(), backgroundColor);
	
		if (foregroundImage != null) {
			foregroundImage.flush();
		}
		foregroundImage = ForegroundImageFactory.INSTANCE.createLinearForeground(getWidth(), getHeight());
		
		initialized = true;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		init();
		
		final Graphics2D G2 = (Graphics2D) g.create();

		G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		G2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		G2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		G2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		G2.drawImage(backgroundImage, 0, 0, null);
		G2.drawImage(foregroundImage, 0, 0, null);
		G2.drawImage(frameImage, 0, 0, null);

		G2.dispose();
	}
	
	public FrameDesign getFrameDesign() {
		return frameDesign;
	}
	public void setFrameDesign(FrameDesign frameDesign) {
		initialized = false;
		this.frameDesign = frameDesign;
	}
	
	public Paint getCustomFrameDesign() {
		return customFrameDesign;
	}
	public void setCustomFrameDesign(Paint customFrameDesign) {
		this.initialized = false;
		this.customFrameDesign = customFrameDesign;
	}
	
	public FrameEffect getFrameEffect() {
		return frameEffect;
	}
	public void setFrameEffect(FrameEffect frameEffect) {
		this.initialized = false;
		this.frameEffect = frameEffect;
	}
	
	public BackgroundColor getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(BackgroundColor backgroundColor) {
		this.initialized = false;
		this.backgroundColor = backgroundColor;
	}
}
