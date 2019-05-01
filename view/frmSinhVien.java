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

import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmSinhVien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSinhVien frame = new frmSinhVien();
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
	
	DefaultTableModel dfTab;
	coQuanBO cq = new coQuanBO();
	private JTable table;
	void napBang(ArrayList<Nguoi> ds) {
		dfTab = new DefaultTableModel();
		dfTab.addColumn("Ma sinh vien");
		dfTab.addColumn("Ten sinh vien");
		dfTab.addColumn("Tuoi");
		dfTab.addColumn("Diem TB");
		for(Nguoi t:ds) {
			Object []tam = new Object[4];
			if (t instanceof sinhVien) {
				tam[0]=((sinhVien) t).getMa();
				tam[1]=t.getHoten();
				tam[2]=t.getTuoi();
				tam[3]=((sinhVien) t).getDtb();
				dfTab.addRow(tam);
			}
		}
		table.setModel(dfTab);
	}
	public frmSinhVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				napBang(cq.getDs());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 128, 566, 316);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Sinh Vien", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
