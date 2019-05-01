package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bean.Nguoi;
import bean.nhanVien;
import bean.sinhVien;

public class coQuanDAO {
	public ArrayList<Nguoi> getDs() {
		ArrayList<Nguoi> ds = new ArrayList<Nguoi>();
		try {
			
			FileReader f = new FileReader("input.txt");
			BufferedReader in= new BufferedReader(f);
			while(true) {
				String st= in.readLine();
				if(st==""||st==null) {
					break;
				}
				//Tach du lieu
				String []tam = st.split("[;]");
				if(tam[0].toUpperCase().startsWith("SV")) {
					sinhVien sv = new sinhVien(tam[0],tam[1],Integer.parseInt(tam[2]),Double.parseDouble(tam[3]));
					ds.add(sv);
				}
				else {
					nhanVien nv = new nhanVien(tam[0],tam[1],Integer.parseInt(tam[2]),tam[3]);
					ds.add(nv);
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
