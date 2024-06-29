package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSuperior extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelSuperior() throws FontFormatException, IOException {
		setBackground(new Color(60, 25, 3));
		setLayout(null);
		Font fonte = Font.createFont(Font.TRUETYPE_FONT, new File("src/view/fontes/Gliker-Regular.ttf"));
		fonte = fonte.deriveFont(Font.PLAIN, 50);
		JLabel lblNewLabel = new JLabel("MAX");
		lblNewLabel.setForeground(new Color(159, 15, 15));
		lblNewLabel.setFont(fonte);
		lblNewLabel.setBounds(445, 27, 408, 47);
		add(lblNewLabel);
		JLabel lblGlobal = new JLabel("GLOBAL");
		lblGlobal.setForeground(new Color(159, 15, 15));
		lblGlobal.setFont(fonte);
		lblGlobal.setBounds(445, 68, 408, 47);
		add(lblGlobal);
		JLabel lblSports = new JLabel("SPORTS");
		lblSports.setForeground(new Color(159, 15, 15));
		lblSports.setFont(fonte);
		lblSports.setBounds(445, 109, 408, 47);
		add(lblSports);

		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("D:\\Nikol\\Documents\\editar video s\\bola.png"));
		lblNewLabel_1.setBounds(354, 11, 157, 157);
		add(lblNewLabel_1);

	}
}