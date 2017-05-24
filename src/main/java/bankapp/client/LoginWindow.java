package bankapp.client;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;


public class LoginWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPassword;
	private JLabel lblUsernameOrPassword = new JLabel();
	private static BankController bc;
	private static LoginWindow frame = new LoginWindow(bc);
	private int counter = 0;
	private long timeBlock = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					bc = new BankController(args[0], args[1], args[2]);
					LoginWindow frame = new LoginWindow(bc);
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
	public LoginWindow(final BankController bc) {
		setTitle("EasyBank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 0));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 102));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblSignInWindow = new JLabel("Sign in window");
		lblSignInWindow.setBackground(new Color(204, 255, 102));
		panel.add(lblSignInWindow, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 102));
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 102));
		panel_1.add(panel_3, BorderLayout.EAST);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(102, 153, 255));
		btnLogin.setForeground(new Color(0, 0, 255));
		panel_3.add(btnLogin);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 102));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(166, 55, 180, 20);
		panel_2.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(30, 55, 126, 20);
		panel_2.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 92, 126, 20);
		panel_2.add(lblPassword);

		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(166, 92, 180, 20);
		panel_2.add(passwordFieldPassword);

		JLabel lblEasyBooking = new JLabel("Easy Bank");
		lblEasyBooking.setFont(new Font("Monotype Corsiva", Font.PLAIN, 29));
		lblEasyBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblEasyBooking.setBounds(76, 11, 270, 33);
		panel_2.add(lblEasyBooking);


		lblUsernameOrPassword.setForeground(Color.RED);
		lblUsernameOrPassword.setBounds(166, 123, 237, 14);
		lblUsernameOrPassword.setVisible(false);
		panel_2.add(lblUsernameOrPassword);

		btnLogin.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				counter++;
				String name=textFieldUsername.getText(), pass=passwordFieldPassword.getText();
				//if(eb.login(name,pass)==true){
				if(counter < 4){
				char login = bc.login(name,pass);
				if(login=='u'){
						UserWindow bank=new UserWindow(bc, name);
						bank.setVisible(true);
						setVisible(false);
				}else if(login=='a'){
						AdminWindow bank=new AdminWindow(bc);
						bank.setVisible(true);
						setVisible(false);
				}else if(login == 'e'){
					lblUsernameOrPassword.setText("Username or Password incorrect. Try again.");
					lblUsernameOrPassword.setVisible(true);
				}
				}else if(counter == 4){
					lblUsernameOrPassword.setText("Too many login tries. Try again in 20 seconds");
					timeBlock = System.currentTimeMillis();
				}
				else{
					if(System.currentTimeMillis() - timeBlock > 20000)
						counter = 0;
					else lblUsernameOrPassword.setText("Too many login tries Try again in " + (20 - ((System.currentTimeMillis() - timeBlock)/1000)) + " seconds");    	
				}
				frame.repaint();
			}
		});
	}
}
