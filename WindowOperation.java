package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class WindowOperation extends JFrame implements ItemListener, ActionListener {
	Jiangjin jiang;
	String job;
	JTextField Number;
	JLabel L1, L2, L3;
	JComboBox<String> choicejob;
	JTextArea textShow;
	JButton button;
	JMenuBar menubar;
	JMenu menu, subMenu;
	JMenuItem item1, item2, item3, item4;
	Box baseBox, boxV1, boxV2, boxV3, boxV4;

	public WindowOperation() {
		setLayout(new java.awt.FlowLayout());
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {

		setLayout(new FlowLayout());
		jiang = new Jiangjin();
		Number = new JTextField(5);
		choicejob = new JComboBox<String>();
		L1 = new JLabel("ְλ");
		L2 = new JLabel("����ʱ��");
		L3 = new JLabel("�����:");
		button = new JButton("ȷ��");
		choicejob.addItem("****�����˴�ѡ��ְλ****");
		String[] a = { "������������ʦ", "�м���������ʦ", "�߼���������ʦ" };
		for (int i = 0; i < a.length; i++) {
			choicejob.addItem(a[i]);
		}
		menubar = new JMenuBar();
		menu = new JMenu("�˵�(alt+F)");
		subMenu = new JMenu("ѡ��ְλ");
		item1 = new JMenuItem("����", new ImageIcon("a.gif"));
		item2 = new JMenuItem("�˳�", new ImageIcon("b.gif"));
		item3 = new JMenuItem("�����๤��ʦ", new ImageIcon("a.gif"));
		item4 = new JMenuItem("�����๤��ʦ", new ImageIcon("a.gif"));
		menu.setMnemonic(KeyEvent.VK_F);
		item1.setAccelerator(KeyStroke.getKeyStroke('a'));
		item2.setAccelerator(KeyStroke.getKeyStroke('b'));
		item3.setAccelerator(KeyStroke.getKeyStroke('1'));
		item4.setAccelerator(KeyStroke.getKeyStroke('2'));
		menu.add(subMenu);
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		subMenu.add(item3);
		subMenu.add(item4);
		menubar.add(menu);
		setJMenuBar(menubar);
		ToolTipManager.sharedInstance().setDismissDelay(2000);
		textShow = new JTextArea(9, 30);
		textShow.setEditable(false);
		boxV1 = Box.createVerticalBox();
		boxV1.add(Box.createVerticalStrut(5));
		boxV1.add(L1);
		boxV1.add(Box.createVerticalStrut(28));
		boxV1.add(L2);
		boxV1.add(Box.createVerticalStrut(15));
		boxV1.add(L3);
		boxV2 = Box.createVerticalBox();
		boxV2.add(choicejob);
		boxV2.add(Box.createVerticalStrut(20));
		boxV2.add(Number);
		boxV2.add(Box.createVerticalStrut(25));
		boxV3 = Box.createHorizontalBox();
		boxV3.add(boxV1);
		boxV3.add(Box.createHorizontalStrut(20));
		boxV3.add(boxV2);
		boxV4 = Box.createHorizontalBox();
		boxV4.add(boxV3);
		boxV4.add(Box.createHorizontalStrut(20));
		boxV4.add(button);
		baseBox = Box.createVerticalBox();
		baseBox.add(boxV4);
		baseBox.add(Box.createVerticalStrut(20));
		baseBox.add(new JScrollPane(textShow));
		add(baseBox);
		Number.setToolTipText("<html><body><font face=���� size=5 color=#06006b>��λ:h");
		textShow.setToolTipText("<html><body><font face=���� size=4 color=#06006b>������ʵ��Ϊ׼");
		choicejob.addItemListener(this);
		button.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
	}
	
	public void itemStateChanged(ItemEvent e) {
		job = choicejob.getSelectedItem().toString();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==item1) {
			JOptionPane.showMessageDialog(null, "��ʾ:��ý�����ʵ��Ϊ׼"+"\n\n           ������:Leo", "����", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==item2){
		        System.exit(0);
		}
		
		if (e.getSource() == item3) {
			remove(baseBox);
			String[] a = { "����������Ա", "�м�������Ա", "�߼�������Ա" };
			String[] b = { "������������ʦ", "�м���������ʦ", "�߼���������ʦ" };
			for (int i = 0; i < a.length; i++) {
				choicejob.removeItem(a[i]);
				choicejob.removeItem(b[i]);
			}
			for (int i = 0; i < b.length; i++) {
				choicejob.addItem(b[i]);
			}
			add(baseBox);
		}
		if (e.getSource() == item4) {

			String[] a = { "������������ʦ", "�м���������ʦ", "�߼���������ʦ" };
			String[] b = { "����������Ա", "�м�������Ա", "�߼�������Ա" };
			for (int i = 0; i < a.length; i++) {
				choicejob.removeItem(a[i]);
				choicejob.removeItem(b[i]);
			}
			for (int i = 0; i < a.length; i++) {
				choicejob.addItem(b[i]);
			}
		}
		if (Number.getText().trim().equals("") || Number.getText().length() == 0) {
		} else {
			try {
				double number = Double.parseDouble(Number.getText());
				double result;
				jiang.set(number);
				jiang.setJTextArea(textShow);
				if (number > 0 && job.equals("������������ʦ")) {
					result = jiang.geta();
					textShow.append("\n" + job + "�Ľ���Ϊ" + result + "\n");
				} else if (number > 0 && job.equals("�м���������ʦ")) {
					result = jiang.getb();
					textShow.append("\n" + job + "�Ľ���Ϊ" + result + "\n");
				} else if (number > 0 && job.equals("�߼���������ʦ")) {
					result = jiang.getc();
					textShow.append("\n" + job + "�Ľ���Ϊ" + result + "\n");
				}
				if (number > 0 && job.equals("����������Ա")) {
					result = jiang.getd();
					textShow.append("\n" + job + "�Ľ���Ϊ" + result + "\n");
				} else if (number > 0 && job.equals("�м�������Ա")) {
					result = jiang.gete();
					textShow.append("\n" + job + "�Ľ���Ϊ" + result + "\n");
				} else if (number > 0 && job.equals("�߼�������Ա")) {
					result = jiang.getf();
					textShow.append("\n" + job + "�Ľ���Ϊ" + result + "\n");
				} else if (job.equals("****�����˴�ѡ��ְλ****")) {
					textShow.append("\n��ѡ��һ��ְλ\n");
				} else if (number <= 0) {
					JOptionPane.showMessageDialog(null, "�����ʱ�䲻��Ϊ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception exp) {
				JOptionPane.showMessageDialog(null, "��������ȷ������(��λ:h)", "��ʾ", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
