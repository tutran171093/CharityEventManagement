package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ThongBao;
import model.bo.ThongBaoBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HienThiThongBaoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String trang = request.getParameter("trang");
		HttpSession session = request.getSession();
		String tenDangNhap = session.getAttribute("tenDangNhap").toString();

		String result = "";

		ArrayList<ThongBao> danhSachThongBao = new ThongBaoBO()
				.getDanhSachThongBao(tenDangNhap);

		System.out.print("Tong so: " + danhSachThongBao.size());

		int tongSoBinhLuan = danhSachThongBao.size();
		int soTrang;
		if (tongSoBinhLuan % 5 == 0)
			soTrang = tongSoBinhLuan / 5;
		else
			soTrang = tongSoBinhLuan / 5 + 1;

		int batDau = (Integer.parseInt(trang) - 1) * 5;
		int ketThuc;
		if (tongSoBinhLuan >= batDau + 5)
			ketThuc = batDau + 5;
		else
			ketThuc = batDau + tongSoBinhLuan % 5;

		batDau = 0;

		for (int i = batDau; i < ketThuc; i++) {
			ThongBao tb = danhSachThongBao.get(i);
			result += "<div class='notif_blue'><div class='alertin'><h5>"
					+ tb.getNgay()
					+ "<br/>"
					+ tb.getNoiDung()
					+ "&nbsp<a href='xoaThongBao.do?maThongBao="
					+ tb.getMaThongBao()
					+ "'><img src='.\\Wisdom of Life_files\\images\\comments.png' /></a></h5></div></div><br/><hr/><br/>";
		}

		int trangMoi = Integer.parseInt(trang) + 1;

		if (Integer.parseInt(trang) < soTrang) {
			result += "<br/><input type='button' value='Hiển thị thêm' class='button medium' onclick='hienThiThongBao("
					+ trangMoi + ")' />";
		}

		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter PW = response.getWriter();
		PW.print(result);

		System.out.print(result);
		PW.flush();

		return null;
	}
}
