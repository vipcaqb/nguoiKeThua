package view;

import java.util.ArrayList;

import bean.Nguoi;
import bean.nhanVien;
import bean.sinhVien;
import bo.coQuanBO;

public class mainNguoi {

	public static void main(String[] args) {
			coQuanBO cq = new coQuanBO();
			System.out.println("Ds sv : ");
			ArrayList<Nguoi> ds = cq.getDs();
			
			for(Nguoi n : ds) {
				if(n instanceof sinhVien)
					n.hienThi();
			}
			System.out.println("Ds ns :");
			for(Nguoi n : ds) {
				if(n instanceof nhanVien)
					n.hienThi();
			}
			System.out.println("Ds chung:");
			for(Nguoi n : ds) {
				n.hienThi();
			}
	}

}
