package network.step2;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class SocketScanEx extends JFrame implements ActionListener, Runnable {
	private JButton jbtn_scan;
	private JTextField jtf_ip;
	private JList jlist_result;
	private JLabel jlabel_ip;
	private DefaultListModel listmodel;
	private int index;
	private String ip;

	public SocketScanEx(String message) {
		super(message);
		jbtn_scan = new JButton("스캔");
		jlabel_ip = new JLabel("IP Address : ");
		jtf_ip = new JTextField(10);
		listmodel = new DefaultListModel();
		jlist_result = new JList(listmodel);
		jlist_result.setVisibleRowCount(10);

		JPanel jpanel_south = new JPanel();
		jpanel_south.add(jlabel_ip);
		jpanel_south.add(jtf_ip);
		jpanel_south.add(jbtn_scan);

		jbtn_scan.addActionListener(this);
		JScrollPane jsp = new JScrollPane(jlist_result);
		add(jsp, BorderLayout.CENTER);
		add(jpanel_south, BorderLayout.SOUTH);

		pack();

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj == jbtn_scan) {
			ip = jtf_ip.getText();
			if (ip == null || ip.trim().length() == 0) {
				jtf_ip.requestFocusInWindow();
				jtf_ip.setText("");
				return;
			} else {
				listmodel.insertElementAt(ip, index);
				jlist_result.setSelectedIndex(index);
				index++;
				Thread t = new Thread(this);
				t.start();
			}
		}
	}

	public void run() {
		Socket s = null;
		for (int i = 1; i < 65536; i++) {
			try {
				s = new Socket(ip, i);
				listmodel.insertElementAt(i + "번 포트가 사용중입니다", index);
				jlist_result.setSelectedIndex(index);
			} catch (IOException e) {
				listmodel.insertElementAt(i + "번 포트를 사용하지 않습니다.", index);
				jlist_result.setSelectedIndex(index);
			}
		}

	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new SocketScanEx("Port Sanner");
	}
}
