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

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class frmNhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNhanVien frame = new frmNhanVien();
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
	private JTable table1;
	void napBang(ArrayList<Nguoi> ds) {
		dfTab = new DefaultTableModel();
		dfTab.addColumn("Ma sinh vien");
		dfTab.addColumn("Ten sinh vien");
		dfTab.addColumn("Tuoi");
		dfTab.addColumn("Diem TB");
		for(Nguoi t:ds) {
			Object []tam = new Object[4];
			if (t instanceof nhanVien) {
				tam[0]=((nhanVien) t).getMa();
				tam[1]=t.getHoten();
				tam[2]=t.getTuoi();
				tam[3]=((nhanVien) t).getTenDv();
				dfTab.addRow(tam);
			}
		}
		table1.setModel(dfTab);
	}
	public frmNhanVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				napBang(cq.getDs());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 181, 630, 258);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Nhan Vien", null, scrollPane, null);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
	}
}
