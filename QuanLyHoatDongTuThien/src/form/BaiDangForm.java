package form;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import utils.KiemTraDinhDang;

public class BaiDangForm extends ActionForm {

	/**
	 * BaiDangForm.java
	 * 
	 * Version 2.0
	 * 
	 * Date: March 12, 2015
	 * 
	 * Copyright
	 * -----------------------------------------------------------------------
	 * March 16, 2015 HieuTM Create
	 */
	private static final long serialVersionUID = 1L;
	private String maBaiDang, tieuDe, noiDung, diaDiem, urlHinhAnh,
			tenDangNhapLeader, tenChuTaiKhoanLeader, stt, submit;

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		try {
			if (this.submit != null
					&& "Đăng bài".equals(new String(this.submit
							.getBytes("8859_1"), "UTF-8"))) {

				if (this.tieuDe == null || tieuDe.trim().equals("")
						|| KiemTraDinhDang.kiemTraPhaHoai(tieuDe)) {
					errors.add("tieuDe", new ActionMessage("errors.template",
							"Tiêu đề không được để trống"));
				}

				if (noiDung == null || noiDung.trim().equals("")
						|| KiemTraDinhDang.kiemTraPhaHoai(noiDung)) {
					errors.add("noiDung", new ActionMessage("errors.template",
							"Nội dung không được để trống"));
				}

				if (ngayDi == null || ngayDi.trim().equals("")) {
					errors.add("ngayDi", new ActionMessage("errors.template",
							"Ngày đi không được để trống"));
				} else {
					try {
						String[] element = this.ngayDi.split("/");
						DateFormat dateFormat = new SimpleDateFormat(
								"MM/dd/yyyy");
						Date date = new Date();
						Date date2 = dateFormat.parse(this.ngayDi);

						if (date.compareTo(date2) >= 0) {
							errors.add("ngayDiBe", new ActionMessage(
									"errors.template",
									"Ngày đi phải lớn hơn ngày hiện tại"));
						} else if (element[0].length() == 2
								&& element[1].length() == 2
								&& element[2].length() == 4) {
						} else {
							errors.add("ngaySinhKhongHopLe", new ActionMessage(
									"errors.template",
									"Ngày đi không hợp lệ (MM/dd/yyyy)"));
						}
					} catch (Exception e) {
						errors.add("ngaySinhKhongHopLe", new ActionMessage(
								"errors.template",
								"Ngày đi không hợp lệ (MM/dd/yyyy)"));
					}
				}

				if (diaDiem == null || diaDiem.trim().equals("")
						|| KiemTraDinhDang.kiemTraPhaHoai(diaDiem)) {
					errors.add("diaDiem", new ActionMessage("errors.template",
							"Địa điểm không được để trống"));
				}

				if (kinhPhiDuKien == null || kinhPhiDuKien.trim().equals("")) {
					errors.add("kinhPhiDuKien", new ActionMessage(
							"errors.template",
							"Kinh phí dự kiến không được để trống"));
				} else if (!isInteger(this.kinhPhiDuKien)) {
					errors.add("dinhDangKinhPhi", new ActionMessage(
							"errors.template", "Kinh phí dự kiến phải là số"));
				} else if (Integer.parseInt(this.kinhPhiDuKien) < 0) {
					errors.add("kinhPhiSoAm", new ActionMessage(
							"errors.template",
							"Kinh phí dự kiến phải là số dương"));
				}
				if (this.soNguoiDuKien == null
						|| this.soNguoiDuKien.trim().equals("")) {
					errors.add("soNguoiDuKien", new ActionMessage(
							"errors.template",
							"Số người dự kiến không được để trống"));
				} else if (!isInteger(this.soNguoiDuKien)) {
					errors.add("dinhDangSoNguoi", new ActionMessage(
							"errors.template", "Số người dự kiến phải là số"));
				} else if (Integer.parseInt(this.soNguoiDuKien) < 0) {
					errors.add("soNguoiSoAm", new ActionMessage(
							"errors.template",
							"Số người dự kiến phải là số dương"));
				}

			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errors;
	}

	public static boolean isInteger(String s) {
		try {
			Long.parseLong(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	private FormFile hinhAnh;

	public FormFile getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(FormFile hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getStt() {
		return stt;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	private String ngayDi, ngayDang;
	private String kinhPhiDuKien;
	private String soNguoiDuKien, trangThai, soLuongBinhLuan;

	public String getMaBaiDang() {
		return maBaiDang;
	}

	public void setMaBaiDang(String maBaiDang) {
		this.maBaiDang = maBaiDang;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getUrlHinhAnh() {
		return urlHinhAnh;
	}

	public void setUrlHinhAnh(String urlHinhAnh) {
		this.urlHinhAnh = urlHinhAnh;
	}

	public String getTenDangNhapLeader() {
		return tenDangNhapLeader;
	}

	public void setTenDangNhapLeader(String tenDangNhapLeader) {
		this.tenDangNhapLeader = tenDangNhapLeader;
	}

	public String getTenChuTaiKhoanLeader() {
		return tenChuTaiKhoanLeader;
	}

	public void setTenChuTaiKhoanLeader(String tenChuTaiKhoanLeader) {
		this.tenChuTaiKhoanLeader = tenChuTaiKhoanLeader;
	}

	public String getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}

	public String getKinhPhiDuKien() {
		return kinhPhiDuKien;
	}

	public void setKinhPhiDuKien(String kinhPhiDuKien) {
		this.kinhPhiDuKien = kinhPhiDuKien;
	}

	public String getSoNguoiDuKien() {
		return soNguoiDuKien;
	}

	public void setSoNguoiDuKien(String soNguoiDuKien) {
		this.soNguoiDuKien = soNguoiDuKien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getSoLuongBinhLuan() {
		return soLuongBinhLuan;
	}

	public void setSoLuongBinhLuan(String soLuongBinhLuan) {
		this.soLuongBinhLuan = soLuongBinhLuan;
	}

}
