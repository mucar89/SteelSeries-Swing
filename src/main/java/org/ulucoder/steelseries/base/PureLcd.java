package org.ulucoder.steelseries.base;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import eu.hansolo.steelseries.tools.LcdColor;
import eu.hansolo.steelseries.tools.LcdImageFactory;
import eu.hansolo.steelseries.tools.Util;

public class PureLcd extends JComponent {
	
	private static final long serialVersionUID = -8734694411359992129L;
	
	public enum ValueAlignment { LEFT, CENTER, RIGHT }
	
	private LcdColor lcdColor = LcdColor.GRAY_LCD;
	private Paint customLcdBackground = null;
	private String value;
	private ValueAlignment valueAlignment = ValueAlignment.CENTER;
	
	private final FontRenderContext RENDER_CONTEXT = new FontRenderContext(null, true, true);
	
	private boolean init = false;
	private BufferedImage imBackground;
	private int digitsWidth;
	private int digitsHeight;
	
	protected void init() {
		if (init)
			return;
		
		if (imBackground != null) {
			imBackground.flush();
		}

		imBackground = LcdImageFactory.INSTANCE.create_LCD_Image(new Rectangle2D.Double(
				0d, 0d, (double)getWidth(), (double)getHeight()), lcdColor, customLcdBackground, null);
		
		Font font = Util.INSTANCE.getDigitalFont().deriveFont(getHeight() * 0.9f);
		
		if (value == null || value.length() == 0) {
			TextLayout valueLayout = new TextLayout("8", font, RENDER_CONTEXT);
			
			digitsWidth = 0;
			digitsHeight = (int)valueLayout.getBounds().getHeight();
		} else {
			String s = "";
			for (int i = 0; i < value.length(); i++)
				s += "8";
			
			TextLayout valueLayout = new TextLayout(s, font, RENDER_CONTEXT);
			
			digitsWidth = (int)valueLayout.getBounds().getWidth();
			digitsHeight = (int)valueLayout.getBounds().getHeight();
		}
		
		init = true;
	}
	
	protected int getDigitsWidth() {
		return digitsWidth;
	}
	
	protected int getDigitsHeight() {
		return digitsHeight;
	} 
	
	@Override
	protected void paintComponent(Graphics g) {
		init();
		
		final Graphics2D G2 = (Graphics2D) g.create();

		G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		G2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		G2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		G2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		G2.drawImage(imBackground, 0, 0, null);
		
		if (value != null && value.length() > 0) {
			G2.setColor(lcdColor.TEXT_COLOR);
			G2.setFont(Util.INSTANCE.getDigitalFont().deriveFont(getHeight() * 0.9f));
			
			int x;
			switch (valueAlignment) {
				case LEFT:
					x = (getHeight() - digitsHeight) / 2;
					break;
				case RIGHT:
					x = getWidth() - ((getHeight() - digitsHeight) / 2) - digitsWidth;
					break;
				case CENTER:
				default:
					x = (getWidth() - digitsWidth) / 2;
					break;
			}
			
			G2.drawString(value, 
					(int) x, 
					(int)((getHeight() + digitsHeight) / 2));
		}
		
		G2.dispose();
	}
	
	public LcdColor getLcdColor() {
		return lcdColor;
	}
	public void setLcdColor(LcdColor lcdColor) {
		init = false;
		this.lcdColor = lcdColor;
	}
	
	public Paint getCustomLcdBackground() {
		return customLcdBackground;
	}
	public void setCustomLcdBackground(Paint customLcdBackground) {
		init = false;
		this.customLcdBackground = customLcdBackground;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		init = false;
		this.value = value;
		repaint();
	}
	
	public ValueAlignment getValueAlignment() {
		return valueAlignment;
	}
	public void setValueAlignment(ValueAlignment valueAlignment) {
		init = false;
		this.valueAlignment = valueAlignment;
	}
	
}
