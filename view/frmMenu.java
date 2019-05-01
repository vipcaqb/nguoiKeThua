package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Nguoi;
import bean.nhanVien;
import bean.sinhVien;
import bo.coQuanBO;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenu frame = new frmMenu();
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
//	DefaultTableModel dfTab;
//	coQuanBO cq = new coQuanBO();
//	private JTable table2;
//	void napBang(ArrayList<Nguoi> ds) {
//		dfTab = new DefaultTableModel();
//		dfTab.addColumn("Ma sinh vien");
//		dfTab.addColumn("Ten sinh vien");
//		dfTab.addColumn("Tuoi");
//		dfTab.addColumn("Diem TB");
//		for(Nguoi t:ds) {
//			Object []tam = new Object[4];
//			if (t instanceof sinhVien) {
//				tam[0]=((sinhVien) t).getMa();
//				tam[1]=t.getHoten();
//				tam[2]=t.getTuoi();
//				tam[3]=((sinhVien) t).getDtb();
//				dfTab.addRow(tam);
//			}
//			else {
//				tam[0]=((nhanVien) t).getMa();
//				tam[1]=t.getHoten();
//				tam[2]=t.getTuoi();
//				tam[3]=((nhanVien) t).getTenDv();
//				dfTab.addRow(tam);
//			}
//		}
//		table2.setModel(dfTab);
//	}
	public frmMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 414);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnQuanly = new JMenu("QuanLy");
		menuBar.add(mnQuanly);
		
		JMenuItem mntmQuanly = new JMenuItem("SinhVien");
		mntmQuanly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new frmSinhVien().setVisible(true);
			}
		});
		mnQuanly.add(mntmQuanly);
		
		JMenuItem mntmNhanvien = new JMenuItem("NhanVien");
		mntmNhanvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new frmNhanVien().setVisible(true);
			}
		});
		mnQuanly.add(mntmNhanvien);
		
		JMenuItem mntmThoat = new JMenuItem("Thoat");
		mntmThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		mnQuanly.add(mntmThoat);
		
		JMenu mnThongKe = new JMenu("Thong Ke");
		menuBar.add(mnThongKe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
