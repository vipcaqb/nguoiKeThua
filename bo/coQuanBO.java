package bo;

import java.util.ArrayList;

import bean.Nguoi;
import dao.coQuanDAO;

public class coQuanBO {
	coQuanDAO cq= new coQuanDAO();
	public ArrayList<Nguoi> getDs() {
		
		return cq.getDs();
	}
}
