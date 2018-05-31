package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BinhLuanBaiDang;
import model.bo.BinhLuanBaiDangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CapNhatBinhLuanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		String maBaiDang = request.getParameter("maBaiDang");
		String noiDung = request.getParameter("noiDung");
		String tenDangNhap = session.getAttribute("tenDangNhap").toString();

		if (noiDung != null && !noiDung.trim().equals("")) {
			new BinhLuanBaiDangBO().themBinhLuan(maBaiDang, tenDangNhap,
					noiDung);
		}

		ArrayList<BinhLuanBaiDang> danhSachBinhLuanBaiDang = new BinhLuanBaiDangBO()
				.getBinhLuanBaiDang(maBaiDang);

		int tongSoBinhLuan = danhSachBinhLuanBaiDang.size();
		int soTrang;
		if (tongSoBinhLuan % 6 == 0)
			soTrang = tongSoBinhLuan / 6;
		else
			soTrang = tongSoBinhLuan / 6 + 1;

		String result = "" + soTrang;

		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter PW = response.getWriter();
		
		
		
		PW.print(result);
		PW.flush();

		return null;
	}
}
