package bankapp.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import bankapp.server.User;
/**
 * @author BICHRI
 * 
 * @date 05-17-2017
 * 
 * @brief This is the AdminWindow Class
 * 
 * @mainpage Bank application as a project for SOFTWARE PROCESS AND QUALITY 
 * 
 * @warning This code is Just a school project, not for professional use 
 * 
 * @copyright Free license 
 * 
 * @section intro_sec Introduction
 * 
 * this an apllication to help users and managers to do their daily tasks easily 
 * 
 * @section compile_sec Compilation
 * know how to compile the code using maven 
 * 
 */
public class AdminWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.DefaultListModel<User> userList = new DefaultListModel<User>();
	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField passTextField;
	private JTextField emailTextField;
	private JList<User> userJList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * @param bc
	 * Create the frame.
	 */
	public AdminWindow(final BankController bc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		userJList = new JList<User>();
		
		JLabel lblUserAccounts = new JLabel("User Accounts");
		
		JLabel lblCreateUser = new JLabel("Create User");
		
		JLabel lblUsername = new JLabel("Username");
		
		userTextField = new JTextField();
		userTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		passTextField = new JTextField();
		passTextField.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bc.createUser(userTextField.getText(), passTextField.getText(), emailTextField.getText());
				accountList(bc.getUsers());
			}
			
		});
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bc.deleteAccount(userJList.getSelectedValue().getUsername());
				accountList(bc.getUsers());
			}
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserAccounts)
						.addComponent(userJList, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCreateUser)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEmail)
							.addGap(18)
							.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnDeleteUser)
							.addComponent(btnCreateUser)))
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserAccounts)
						.addComponent(lblCreateUser))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userJList, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsername)
									.addGap(20)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPassword)
										.addComponent(passTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEmail)
										.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(userTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addComponent(btnCreateUser)
							.addPreferredGap(ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
							.addComponent(btnDeleteUser)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
		accountList(bc.getUsers());
	}
	/**
	 * Show account list for a user
	 * @param user
	 */
	private void accountList(ArrayList<User> users){
		userList.clear();
		for (User user : users) {
			userList.addElement(user);
		}
		userJList.setModel(userList);
	}

}
