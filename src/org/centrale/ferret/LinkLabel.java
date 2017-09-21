package org.centrale.ferret;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class LinkLabel extends JTextField implements MouseListener, FocusListener, ActionListener {
		private URI target;

		public Color standardColor = new Color(0,0,255);
		public Color hoverColor = new Color(255,0,0);
		public Color activeColor = new Color(128,0,128);
		public Color transparent = new Color(0,0,0,0);
		public Color backgroundColor;

		private Border activeBorder;
		private Border hoverBorder;
		private Border standardBorder;

		public LinkLabel(URI target, String text){
			super(text);
			this.target = target;
		}

		public void setBackgroundColor(Color bgColor){
			this.backgroundColor = bgColor;
		}

		public void init() {
			this.addMouseListener(this);
			this.addFocusListener(this);
			this.addActionListener(this);
			setToolTipText(target.toString());

			activeBorder = new MatteBorder(0,0,1,0,activeColor);
			hoverBorder = new MatteBorder(0,0,1,0,hoverColor);
			standardBorder = new MatteBorder(0,0,1,0,transparent);

			setEditable(false);
			setForeground(standardColor);
			setBorder(standardBorder);
			setBackground(backgroundColor);
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void browse() {
			setForeground(activeColor);
			setBorder(activeBorder);
			try {
				Desktop.getDesktop().browse(target);
			} catch(Exception e) {
				e.printStackTrace();
			}
			setForeground(standardColor);
			setBorder(standardBorder);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			browse();	
		}

		@Override
		public void focusGained(FocusEvent e) {
			setForeground(hoverColor);
			setBorder(hoverBorder);
		}

		@Override
		public void focusLost(FocusEvent e) {
			setForeground(standardColor);
			setBorder(standardBorder);
		}

		public void mouseClicked(MouseEvent e) {
			browse();
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {
			setForeground(hoverColor);
			setBorder(hoverBorder);
		}

		public void mouseExited(MouseEvent e) {
			setForeground(standardColor);
			setBorder(standardBorder);
		}

	}