package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;

import model.dao.BaiDangDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiDangForm;

public class ChiTietDuyetBaiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// request.setCharacterEncoding("UTF-8");
		BaiDangForm baiDangForm = (BaiDangForm) form;
		String maBaiDang = request.getParameter("maBaiDang");
		// System.out.println(maBaiDang);

		// String maBaiDang=baiDangForm.getMaBaiDang();

		BaiDangDAO dangBaiBO = new BaiDangDAO();
		BaiDang baiDang = dangBaiBO.getThongTinBaiDang(maBaiDang);

		baiDangForm.setTenDangNhapLeader(baiDang.getTenDangNhapLeader());
		baiDangForm.setNgayDang(baiDang.getNgayDang());
		baiDangForm.setNgayDi(baiDang.getNgayDi());
		baiDangForm.setDiaDiem(baiDang.getDiaDiem());
		baiDangForm
				.setKinhPhiDuKien(String.valueOf(baiDang.getKinhPhiDuKien()));
		baiDangForm
				.setSoNguoiDuKien(String.valueOf(baiDang.getSoNguoiDuKien()));
		baiDangForm.setNoiDung(baiDang.getNoiDung());
		baiDangForm.setUrlHinhAnh(baiDang.getUrlHinhAnh());
		baiDangForm.setTieuDe(baiDang.getTieuDe());

		// System.out.println(baiDang.getTenChuTaiKhoanLeader());
		// System.out.println(baiDang.getDiaDiem());

		return mapping.findForward("duyetxong");

	}
}
