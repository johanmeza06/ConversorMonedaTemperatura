package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InterfazConversor extends JFrame {

	private JPanel contentPane;
	ConversorMonedas interfazMoneda = new ConversorMonedas();
	ConversorTemperatura interfazTemperatura = new ConversorTemperatura();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazConversor frame = new InterfazConversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazConversor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(17, 63, 103));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// configuraciones de mi Jframe
	    setTitle("Menu Principal");
	    setResizable(false);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Selecciona una opcion para continuar");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 24, 434, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox jComboMenu = new JComboBox();
		jComboMenu.setBackground(new Color(255, 255, 255));
		jComboMenu.setForeground(new Color(17, 63, 103));
		jComboMenu.setFont(new Font("Roboto Slab", Font.PLAIN, 15));
		jComboMenu.setMaximumRowCount(2);
		jComboMenu.setToolTipText("");
		jComboMenu.setModel(new DefaultComboBoxModel(new String[] {"Conversor de Monedas", "Conversor de Temperatura"}));
		jComboMenu.setBounds(77, 80, 276, 33);
		contentPane.add(jComboMenu);
		
		JButton btnMenu = new JButton("Ir");
		btnMenu.setForeground(new Color(255, 255, 255));
		btnMenu.setBackground(new Color(52, 105, 154));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String item;
				item = jComboMenu.getSelectedItem().toString();
			
				if(item.equalsIgnoreCase("Conversor de Monedas")){
					interfazMoneda.setVisible(true);
					setVisible(false);
				}else {
					interfazTemperatura.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnMenu.setFont(new Font("Roboto Slab", Font.BOLD, 14));
		btnMenu.setBounds(77, 145, 109, 33);
		contentPane.add(btnMenu);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(52, 105, 154));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro que deseas Salir del programa? ", "Salir",JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				System.exit(0);
			}
			}
		});
		btnSalir.setFont(new Font("Roboto Slab", Font.BOLD, 14));
		btnSalir.setBounds(244, 145, 109, 33);
		contentPane.add(btnSalir);
	}
}
