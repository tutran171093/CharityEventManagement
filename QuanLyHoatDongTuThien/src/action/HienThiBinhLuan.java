package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BinhLuanBaiDang;
import model.bo.BinhLuanBaiDangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HienThiBinhLuan extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String trang = request.getParameter("trang");
		String maBaiDang = request.getParameter("maBaiDang");

		ArrayList<BinhLuanBaiDang> danhSachBinhLuanBaiDang = new BinhLuanBaiDangBO()
				.getBinhLuanBaiDang(maBaiDang);

		ArrayList<BinhLuanBaiDang> danhSachBinhLuanBaiDangTrang = new ArrayList<BinhLuanBaiDang>();

		int tongSoBinhLuan = danhSachBinhLuanBaiDang.size();
		int soTrang;
		if (tongSoBinhLuan % 6 == 0)
			soTrang = tongSoBinhLuan / 6;
		else
			soTrang = tongSoBinhLuan / 6 + 1;

		int batDau = (Integer.parseInt(trang) - 1) * 6;
		int ketThuc;
		if (tongSoBinhLuan >= batDau + 6)
			ketThuc = batDau + 6;
		else
			ketThuc = batDau + tongSoBinhLuan % 6;

		for (int i = batDau; i < ketThuc; i++) {
			danhSachBinhLuanBaiDangTrang.add(danhSachBinhLuanBaiDang.get(i));
		}

		String result = "";

		result = "<ul class='comments'>";
		for (int i = 0; i < danhSachBinhLuanBaiDangTrang.size(); i++) {
			BinhLuanBaiDang binhLuan = danhSachBinhLuanBaiDangTrang.get(i);
			result += "<li class='level1'><div class='insec'><div class='thumb'><a href='xemThanhVien.do?maLeader="
					+ binhLuan.getTenDangNhap()
					+ "'><img src='"
					+ binhLuan.getUrlHinhAnh()
					+ "' width='45px' height='45px'></img></a></div><div class='desc'><div class='author_date'><h5><a class='bold' href='xemThanhVien.do?tenDangNhap="
					+ binhLuan.getTenDangNhap()
					+ "'>"
					+ binhLuan.getTenDangNhap()
					+ "</a></h5><p class='date'>"
					+ binhLuan.getNgayBinhLuan()
					+ "</p></div><div class='clear'></div><p class='txt'>"
					+ binhLuan.getNoiDung() + "</p></div></div></li>";

		}
		result += "</ul>";

		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter PW = response.getWriter();
		PW.print(result);
		PW.flush();

		return null;
	}
}
