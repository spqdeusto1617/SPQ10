package bankapp.client;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import bankapp.server.BankAccount;
import bankapp.server.Report;
import bankapp.server.User;

public class UserWindow extends JFrame {

	/**
	 * 
	 */
	private javax.swing.DefaultListModel<BankAccount> bankAccountList = new DefaultListModel<BankAccount>();
	private static final long serialVersionUID = 1L;
	private User user;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JList<BankAccount> bankAccountJList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public UserWindow(final BankController bc, String name) {
		user = bc.getUser(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Bank Accounts", null, panel, null);
		
		bankAccountJList = new JList<BankAccount>();
		
		JLabel lblAccountList = new JLabel("Account List");
		
		JList<Report> reportList = new JList<Report>();
		
		JLabel lblAccountReports = new JLabel("Account Reports");
		
		JButton btnNewBankAccount = new JButton("New Bank Account");
		
		JLabel lblTransaction = new JLabel("Transaction");
		
		JLabel lblUser = new JLabel("user");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("account number");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblAmount = new JLabel("amount");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnCreateTransaction = new JButton("Create Transaction");
		
		JButton btnDeleteBankAccount = new JButton("Delete Bank Account");
		
		JLabel lblAddFunds = new JLabel("Add Funds");
		
		JLabel lblAmount_1 = new JLabel("amount");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnAddFunds = new JButton("Add Funds");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(bankAccountJList, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAccountList))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAccountReports)
						.addComponent(reportList, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewBankAccount)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteBankAccount))
						.addComponent(lblTransaction)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblUser)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblAccountNumber)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblAddFunds))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCreateTransaction)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAmount)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(39))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAmount_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddFunds)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountList)
						.addComponent(lblAccountReports))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(bankAccountJList, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(reportList, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(lblTransaction)
							.addGap(8)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUser)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAccountNumber)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAmount)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(13)
									.addComponent(btnCreateTransaction))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(33)
									.addComponent(lblAddFunds)))
							.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAmount_1)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddFunds))
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewBankAccount)
								.addComponent(btnDeleteBankAccount))))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Reports", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JList list_2 = new JList();
		panel_1.add(list_2, BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
		accountList();
		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {


		           BankAccount bankaccount = (BankAccount) bankAccountJList.getSelectedValue();
		           
		           // add selectedItem to your second list.
		           DefaultListModel<Report> model = (DefaultListModel<Report>) reportList.getModel();
		           if(model == null)
		           {
		                 model = new DefaultListModel<Report>();
		                 reportList.setModel(model);
		           }
		           model.addElement(null);

		         }
		    }
		};
	}
	
	private void accountList(){
		bankAccountList.clear();
		for (BankAccount bankAccount : user.getAccounts().values()) {
			bankAccountList.addElement(bankAccount);
		}
		bankAccountJList.setModel(bankAccountList);
	}

}
