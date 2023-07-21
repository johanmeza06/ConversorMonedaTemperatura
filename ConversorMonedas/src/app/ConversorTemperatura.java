package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Metodos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConversorTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	JLabel lblResultado = new JLabel("");
	
	Metodos metodos = new Metodos();
	double cantidad = 0;
	double conversion = 0;
	String de = "°C";
	String a = "°C";

	/**
	 * Create the frame.
	 */
	public ConversorTemperatura() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		inicarInterfaz();
		// configuraciones de mi Jframe
	    setTitle("Conversor de Temperatura");
	    setResizable(false);
		this.setLocationRelativeTo(null);
		
		
	}

	private void inicarInterfaz() {

		setBounds(100, 100, 451, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(17, 63, 103));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnInformacionc = new JTextPane();
		txtpnInformacionc.setForeground(new Color(255, 255, 255));
		txtpnInformacionc.setToolTipText("\r\n");
		txtpnInformacionc.setText("°C = Grados Celsius\r\n°F = Grados Farenheit");
		txtpnInformacionc.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		txtpnInformacionc.setEditable(false);
		txtpnInformacionc.setBackground(new Color(17, 63, 103));
		txtpnInformacionc.setBounds(153, 87, 148, 49);
		contentPane.add(txtpnInformacionc);
		
		JLabel lblConversorDeTemperatura = new JLabel("Conversor de Temperatura");
		lblConversorDeTemperatura.setForeground(new Color(255, 255, 255));
		lblConversorDeTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDeTemperatura.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		lblConversorDeTemperatura.setBounds(0, 11, 434, 29);
		contentPane.add(lblConversorDeTemperatura);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese la temperatura");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto Slab", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 162, 434, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantidad = new JTextField("1");
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setFont(new Font("Roboto Slab", Font.PLAIN, 15));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(153, 187, 138, 35);
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				String texto = txtCantidad.getText();
				boolean isNumeric = Character.isDigit(key) || key == '.'; // Permitir puntos

				if (!isNumeric || (key == '.' && (texto.contains(".") || texto.startsWith("0")))
						|| texto.replaceAll("\\.", "").length() == 7) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				cantidad = Double.parseDouble(txtCantidad.getText());
				metodos.convertirTemperatura(de, a, conversion, cantidad, lblResultado);
			}
		});
		contentPane.add(txtCantidad);
		
		JComboBox cboDe = new JComboBox();
		cboDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de = cboDe.getSelectedItem().toString();
				metodos.convertirTemperatura(de, a, conversion, cantidad, lblResultado);
			}
		});
		cboDe.setModel(new DefaultComboBoxModel(new String[] {"°C", "°F"}));
		cboDe.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		cboDe.setBounds(74, 258, 121, 29);
		contentPane.add(cboDe);
		
		JLabel lblDe = new JLabel("DE:");
		lblDe.setForeground(new Color(255, 255, 255));
		lblDe.setFont(new Font("Roboto Slab", Font.BOLD, 15));
		lblDe.setBounds(74, 233, 107, 14);
		contentPane.add(lblDe);
		
		JComboBox cboA = new JComboBox();
		cboA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = cboA.getSelectedItem().toString();
				metodos.convertirTemperatura(de, a, conversion, cantidad, lblResultado);
			}
		});
		cboA.setModel(new DefaultComboBoxModel(new String[] {"°C", "°F"}));
		cboA.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		cboA.setBounds(255, 258, 121, 29);
		contentPane.add(cboA);
		
		JLabel lblA = new JLabel("A:");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setFont(new Font("Roboto Slab", Font.BOLD, 15));
		lblA.setBounds(255, 233, 107, 14);
		contentPane.add(lblA);
		
		JButton btnMenuPrincipal = new JButton("Ir al menu principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazConversor interfazPrincipal = new InterfazConversor();
				interfazPrincipal.setVisible(true);
				setVisible(false);
			}
		});
		btnMenuPrincipal.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		btnMenuPrincipal.setBounds(135, 409, 179, 32);
		contentPane.add(btnMenuPrincipal);
		lblResultado.setForeground(new Color(255, 255, 255));
		
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		lblResultado.setBounds(0, 298, 434, 77);
		contentPane.add(lblResultado);
		
		JLabel lblNewLabel = new JLabel("Informacion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Slab", Font.PLAIN, 15));
		lblNewLabel.setBounds(135, 51, 179, 35);
		contentPane.add(lblNewLabel);
	}
}
