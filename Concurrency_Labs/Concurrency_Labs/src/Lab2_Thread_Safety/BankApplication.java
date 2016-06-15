package Lab2_Thread_Safety;


@SuppressWarnings("serial")
public class BankApplication extends javax.swing.JFrame implements BankUpdater {

	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
	private Bank bank;


    public BankApplication() {
        initComponents();
		bank = new Bank(this);
    }
    
	@Override
	public void refreshAccount(int accountNumber, Account account) {
		switch (accountNumber) {
			case 1:
				this.jTextField1.setText(Account.moneyToString(account.getBalance())); break;
			case 2:
				this.jTextField2.setText(Account.moneyToString(account.getBalance())); break;
		}
	}

	@Override
	public void output(String message) {
		this.jTextArea1.append(message + "\n");		
	}

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bank Application");
        jPanel1.add(jLabel1);

        jTextField1.setMinimumSize(new java.awt.Dimension(100, 25));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 25));
 
        jPanel2.add(jTextField1);

        jTextField2.setMinimumSize(new java.awt.Dimension(100, 25));
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel2.add(jTextField2);

        jPanel1.add(jPanel2);

        jButton1.setText("START");
        jButton1.setMaximumSize(new java.awt.Dimension(75, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(75, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(75, 23));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("STOP");
        jButton2.setMaximumSize(new java.awt.Dimension(75, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(75, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jPanel1.add(jPanel3);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	bank.startThreads();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	bank.stopThreads();
    }

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	BankApplication ba = new BankApplication();
            	ba.setLocation(200, 200);
                ba.setVisible(true);
            }
        });
    }


}
