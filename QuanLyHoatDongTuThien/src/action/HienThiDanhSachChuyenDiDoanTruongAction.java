package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bo.BaiDangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HienThiDanhSachChuyenDiDoanTruongAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String trang = request.getParameter("trang");
		String maLeader = request.getParameter("maLeader");

		System.out.print(trang + " - " + maLeader);
		
		ArrayList<BaiDang> danhSachChuyenDi = new BaiDangBO()
				.getDanhSachBaiDangDoanTruong(maLeader);
		ArrayList<BaiDang> danhSachChuyenDiTrang = new ArrayList<BaiDang>();

		int tongSoBinhLuan = danhSachChuyenDi.size();
		int soTrang;
		if (tongSoBinhLuan % 3 == 0)
			soTrang = tongSoBinhLuan / 3;
		else
			soTrang = tongSoBinhLuan / 3 + 1;

		int batDau = (Integer.parseInt(trang) - 1) * 3;
		int ketThuc;
		if (tongSoBinhLuan >= batDau + 3)
			ketThuc = batDau + 3;
		else
			ketThuc = batDau + tongSoBinhLuan % 3;

		for (int i = batDau; i < ketThuc; i++) {
			danhSachChuyenDiTrang.add(danhSachChuyenDi.get(i));
		}

		String result = "";

		for (int i = 0; i < danhSachChuyenDiTrang.size(); i++) {
			BaiDang baiDang = danhSachChuyenDiTrang.get(i);

			result += "<div class='post'><h5 class='title'><a href='chiTietBaiDangR.do?maChuyenDi="
					+ baiDang.getMaBaiDang()
					+ "&trangSo=1' class='bold txthover'>"
					+ baiDang.getTieuDe()
					+ "</a></h5><div class='thumb'><a href='chiTietBaiDangR.do?maChuyenDi="
					+ baiDang.getMaBaiDang()
					+ "&trangSo=1'><img src='"
					+ baiDang.getUrlHinhAnh()
					+ "' alt='' width='703px' height='200px' />"

					+ "</a></div><div class='postoptions'><ul><li class='author'><a href='xemThanhVien.do?tenDangNhap="
					+ baiDang.getTenDangNhapLeader()
					+ "' class='txthover'>"
					+ baiDang.getTenChuTaiKhoanLeader()
					+ "</a>"
					+ "</li><li class='date'>"
					+ baiDang.getNgayDang()
					+ "</li><li class='coments'>"
					+ baiDang.getSoLuongBinhLuan()
					+ "</li></ul></div><div class='postdesc'><p>"
					+ baiDang.getNoiDungVanTat()
					+ "</p><a href='chiTietBaiDangR.do?maChuyenDi="
					+ baiDang.getMaBaiDang()
					+ "&trangSo=1' class='readmore txthover'>Đọc tiếp</a></div></div>";

		}

		result += "";

		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter PW = response.getWriter();
		PW.print(result);
		PW.flush();

		return null;
	}

}
