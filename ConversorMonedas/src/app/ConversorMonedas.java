package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeListener;

import clases.Metodos;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.SystemColor;

public class ConversorMonedas extends JFrame {

	private JPanel panelPrincipal;
	JLabel lblResultado = new JLabel("");

	Metodos metodos = new Metodos();
	double cantidad = 1;
	double conversion = 0;
	String de = "CLP";
	String a = "CLP";
	private JTextField txtCantidad;

	/**
	 * Create the frame.
	 */
	public ConversorMonedas() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		iniciarInterfaz();
		// configuraciones de mi Jframe
		setTitle("Conversor de Monedas");
		setResizable(false);
		this.setLocationRelativeTo(null);
		

	}

	private void iniciarInterfaz() {
		setBounds(100, 100, 451, 490);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(17, 63, 103));
		
		
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblConversorMoneda = new JLabel("Conversor de Monedas");
		lblConversorMoneda.setForeground(new Color(255, 255, 255));
		lblConversorMoneda.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorMoneda.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		lblConversorMoneda.setBounds(0, 11, 434, 24);
		panelPrincipal.add(lblConversorMoneda);

		JLabel lblNewLabel_1 = new JLabel("Ingrese la cantidad");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto Slab", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 171, 434, 24);
		panelPrincipal.add(lblNewLabel_1);

		JLabel lblDe = new JLabel("DE:");
		lblDe.setForeground(new Color(255, 255, 255));
		lblDe.setFont(new Font("Roboto Slab", Font.BOLD, 15));
		lblDe.setBounds(70, 253, 107, 14);
		panelPrincipal.add(lblDe);

		JLabel lblA = new JLabel("A:");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setFont(new Font("Roboto Slab", Font.BOLD, 15));
		lblA.setBounds(251, 253, 107, 14);
		panelPrincipal.add(lblA);

		JComboBox cboDe = new JComboBox();
		cboDe.setForeground(new Color(0, 0, 0));
		lblDe.setLabelFor(cboDe);
		cboDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de = cboDe.getSelectedItem().toString();
				metodos.convertirMoneda(de, a, conversion, cantidad, lblResultado);
			}
		});
		cboDe.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		cboDe.setModel(new DefaultComboBoxModel(new String[] { "CLP", "USD", "EUR", "GBP", "JPY", "KRW" }));
		cboDe.setBounds(70, 278, 121, 29);
		panelPrincipal.add(cboDe);

		JComboBox cboA = new JComboBox();
		cboA.setForeground(new Color(0, 0, 0));
		lblA.setLabelFor(cboA);
		cboA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = cboA.getSelectedItem().toString();
				metodos.convertirMoneda(de, a, conversion, cantidad, lblResultado);
			}
		});
		cboA.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		cboA.setModel(new DefaultComboBoxModel(new String[] { "CLP", "USD", "EUR", "GBP", "JPY", "KRW" }));
		cboA.setBounds(251, 278, 121, 29);
		panelPrincipal.add(cboA);
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);

		lblResultado.setFont(new Font("Roboto Slab", Font.BOLD, 18));
		lblResultado.setBounds(0, 318, 434, 77);
		panelPrincipal.add(lblResultado);

		txtCantidad = new JTextField("1");
		txtCantidad.requestFocus();
		lblNewLabel_1.setLabelFor(txtCantidad);
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
				metodos.convertirMoneda(de, a, conversion, cantidad, lblResultado);
			}
		});
		txtCantidad.setFont(new Font("Roboto Slab", Font.PLAIN, 15));
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setBounds(146, 207, 138, 35);
		panelPrincipal.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnMenuPrincipal = new JButton("Ir al menu principal");
		btnMenuPrincipal.setBackground(new Color(52, 105, 154));
		btnMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazConversor interfazPrincipal = new InterfazConversor();
				interfazPrincipal.setVisible(true);
				setVisible(false);
			}
		});
		btnMenuPrincipal.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		btnMenuPrincipal.setBounds(123, 406, 179, 32);
		panelPrincipal.add(btnMenuPrincipal);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setForeground(new Color(255, 255, 255));
		txtpnInfo.setToolTipText("\r\n");
		txtpnInfo.setBackground(new Color(17, 63, 103));
		txtpnInfo.setEditable(false);
		txtpnInfo.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		txtpnInfo.setText("CLP = Peso Chileno\r\nUSD = Dolar\r\nEUR = Euro");
		txtpnInfo.setBounds(70, 92, 138, 68);
		panelPrincipal.add(txtpnInfo);
		
		JTextPane txtpnGbpLibras = new JTextPane();
		txtpnGbpLibras.setToolTipText("\r\n");
		txtpnGbpLibras.setText("GBP = Libras Esterlinas\r\nJPY = Yen Japones\r\nKRW = Won Sul-Coreano");
		txtpnGbpLibras.setForeground(Color.WHITE);
		txtpnGbpLibras.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		txtpnGbpLibras.setEditable(false);
		txtpnGbpLibras.setBackground(new Color(17, 63, 103));
		txtpnGbpLibras.setBounds(218, 92, 185, 68);
		panelPrincipal.add(txtpnGbpLibras);
		
		JLabel lblNewLabel = new JLabel("Informacion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Slab", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(123, 46, 179, 35);
		panelPrincipal.add(lblNewLabel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
