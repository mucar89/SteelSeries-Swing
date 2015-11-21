package org.ulucoder.steelseries.base;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.BackgroundImageFactory;
import eu.hansolo.steelseries.tools.ColorDef;
import eu.hansolo.steelseries.tools.CustomColorDef;
import eu.hansolo.steelseries.tools.ForegroundImageFactory;
import eu.hansolo.steelseries.tools.Shadow;
import eu.hansolo.steelseries.tools.Util;

public class Button extends JComponent {

	private static final long serialVersionUID = 6574695452921742819L;

	private String text;
	private BackgroundColor backgroundColor = BackgroundColor.LINEN;
    private ColorDef onColor = ColorDef.WHITE;
    private CustomColorDef customOnColor = new CustomColorDef(Color.RED);
    private ColorDef offColor = ColorDef.CUSTOM;
    private CustomColorDef customOffColor = new CustomColorDef(Color.LIGHT_GRAY);
    private boolean on = false;
    
    private boolean initialized;
    private BufferedImage biBackground;
    private BufferedImage biForeground;
    private BufferedImage biGlowingText;
    private int textX;
    private int textY;
    private Font font;
    private final FontRenderContext RENDER_CONTEXT = new FontRenderContext(null, true, true);
    private static final int FRAME_SPACE = 18;
    int textHeight;
    int offset;
    
    public Button() {
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
	}
    
    private void init() {
    	if (initialized)
    		return;
    	
    	flushIfNotNull(biBackground);
    	flushIfNotNull(biForeground);
    	
    	biBackground = Util.INSTANCE.createImage(getWidth() + 2 * FRAME_SPACE, getHeight() + 2 * FRAME_SPACE, Transparency.TRANSLUCENT);
    	biForeground = Util.INSTANCE.createImage(getWidth() + 2 * FRAME_SPACE, getHeight() + 2 * FRAME_SPACE, Transparency.TRANSLUCENT);
    	
    	BackgroundImageFactory.INSTANCE.createLinearBackground(
        		biBackground.getWidth(), biBackground.getHeight(), backgroundColor, null, null, biBackground);
        
        ForegroundImageFactory.INSTANCE.createLinearForeground(
        		biForeground.getWidth(), biForeground.getHeight(), false, biForeground);

        font = Util.INSTANCE.getStandardFont().deriveFont(getHeight() * 0.7f);
        TextLayout valueLayout = new TextLayout(text, font, RENDER_CONTEXT); 
        int textWidth = (int)valueLayout.getBounds().getWidth();
        textHeight = (int)new TextLayout("M", font, RENDER_CONTEXT).getBounds().getHeight();
        
        if (text != null && !text.isEmpty()) {
	        textX = (int)(getWidth() - textWidth) / 2;
	        textY = (int)(getHeight() + textHeight) / 2 + 2;
        } else {
        	textX = 0;
        	textY = 0;
        }
        
        BufferedImage softClip = Shadow.INSTANCE.createSoftClipImage(valueLayout.getOutline(new AffineTransform()), onColor.LIGHT);
        offset = 5;
        biGlowingText = Shadow.INSTANCE.createDropShadow(softClip, 0, 0.65f, offset, 315, onColor.LIGHT);
    	initialized = true;
    }
    
    @Override
    protected void processMouseEvent(MouseEvent e) {
    	super.processMouseEvent(e);
    	
    	if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
    		initialized = false;
    		repaint();
    	}
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	init();
    	
    	final Graphics2D G2 = (Graphics2D) g.create();
    	
		G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		G2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		G2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		G2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    	
		G2.drawRect(0, 0, getWidth(), getHeight());
		G2.drawImage(biBackground, -FRAME_SPACE, -FRAME_SPACE, null);
		
		if (text != null && !text.isEmpty() && !on) {
			G2.setFont(font);
			G2.setColor(on 
					? (onColor == ColorDef.CUSTOM ? customOnColor.LIGHT : onColor.LIGHT) 
					: (offColor == ColorDef.CUSTOM ? customOffColor.LIGHT : offColor.LIGHT));
			G2.drawString(text, textX, textY);
		}
		
		if (on)
			G2.drawImage(biGlowingText, 
					(biBackground.getWidth() - biGlowingText.getWidth()) / 2 - 3 * offset, 
					(biBackground.getHeight() - textHeight) / 2 - (int)(4.5 * offset), 
					null);
		
		G2.drawImage(biForeground, -FRAME_SPACE, -FRAME_SPACE, null);
		
    	G2.dispose();
    }
    
    private void flushIfNotNull(BufferedImage bi) {
    	if (bi != null)
    		bi.flush();
    }
    
    public String getText() {
		return text;
	}
    public void setText(String text) {
    	this.initialized = false;
		this.text = text;
	}
    
    public ColorDef getOnColor() {
		return onColor;
	}
    public void setOnColor(ColorDef onColor) {
    	this.initialized = false;
		this.onColor = onColor;
	}
    
    public CustomColorDef getCustomOnColor() {
		return customOnColor;
	}
    public void setCustomOnColor(CustomColorDef customOnColor) {
    	this.initialized = false;
		this.customOnColor = customOnColor;
	}
	
    public ColorDef getOffColor() {
		return offColor;
	}
    public void setOffColor(ColorDef offColor) {
    	this.initialized = false;
		this.offColor = offColor;
	}
    
    public CustomColorDef getCustomOffColor() {
		return customOffColor;
	}
    public void setCustomOffColor(CustomColorDef customOffColor) {
    	this.initialized = false;
		this.customOffColor = customOffColor;
	}
    
    public boolean isOn() {
		return on;
	}
    public void setOn(boolean on) {
    	this.initialized = false;
		this.on = on;
	}
    
    public BackgroundColor getBackgroundColor() {
		return backgroundColor;
	}
    public void setBackgroundColor(BackgroundColor backgroundColor) {
    	this.initialized = false;
		this.backgroundColor = backgroundColor;
	}
}
