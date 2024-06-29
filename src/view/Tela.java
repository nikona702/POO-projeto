package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() throws FontFormatException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 575);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		PanelSuperior panelSuperior = new PanelSuperior();
		PanelMeio panelMeio = new PanelMeio();
		panelMeio.setBackground(new Color(60, 25, 3));
		panelMeio.setBounds(10, 215, 925, 310 );
		panelSuperior.setBounds(0, 0, 964, 200);
		contentPane.add(panelSuperior);
		contentPane.add(panelMeio);
		panelMeio.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECIONE UMA OPÇÃO:");
		lblNewLabel.setBounds(10, 11, 216, 14);
		panelMeio.add(lblNewLabel);
		setContentPane(contentPane);
	}
}