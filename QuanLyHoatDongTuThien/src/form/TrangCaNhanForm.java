package form;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 * TrangCaNhanForm.java
 * 
 * Version 1.0
 * 
 * Date: March 12, 2015
 * 
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ----------------------------------------------------------------------- March
 * 12, 2015 HieuTM Create
 */
public class TrangCaNhanForm extends ActionForm {

	private static final long serialVersionUID = 1;
	private String tenDangNhap;
	private String hoTen;
	private String email;
	private FormFile anhDaiDien;
	private String ngaySinh;
	private int gioiTinh, diemNangDong, soLanToChucThanhCong,
			soLanToChucThatBai;
	private String CMND;
	private String diaChi;
	private String noiCongTac;
	private String ngheNghiep;
	private String SDT;
	private String submit;
	private String urlAnhDaiDien;
	private Pattern pattern;
	private Matcher matcher;

	public int getSoLanToChucThatBai() {
		return soLanToChucThatBai;
	}

	public void setSoLanToChucThatBai(int soLanToChucThatBai) {
		this.soLanToChucThatBai = soLanToChucThatBai;
	}

	public FormFile getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(FormFile anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors err = new ActionErrors();

		try {
			if (this.submit == null) {
			} else if (this.submit.trim().startsWith("C")) {
				if (this.CMND.trim().length()>0) {
					if (this.CMND.length() < 8 || this.CMND.length() > 13
							|| !isInteger(CMND)) {
						err.add("CMND", new ActionMessage("errors.template",
								"Số CMND phải có đúng 9 chữ số"));
					}
				}

				if (this.hoTen == null || this.hoTen.trim().equals("")) {
					err.add("hoTen", new ActionMessage("errors.template",
							"Họ tên không được để trống"));
				}

				if (this.email == null || this.email.trim().equals(""))
					err.add("email", new ActionMessage("errors.template",
							"Email không được để trống"));
				else {
					pattern = Pattern.compile(EMAIL_PATTERN);
					matcher = pattern.matcher(this.email.trim());
					if (!matcher.matches())
						err.add("emailKHL", new ActionMessage(
								"errors.template", "Email không hợp lệ"));
				}

				if (this.ngaySinh == null || this.ngaySinh.trim().equals(""))
					err.add("ngaySinh", new ActionMessage("errors.template",
							"Ngày sinh không được để trống"));
				else {
					try {
						String[] element = this.ngaySinh.split("/");
						if (element[0].length() == 2
								&& element[1].length() == 2
								&& element[2].length() == 4) {
						} else {
							err.add("ngaySinhKhongHopLe", new ActionMessage(
									"errors.template",
									"Ngày sinh không hợp lệ (MM/dd/yyyy)"));
						}
					} catch (Exception e) {
						err.add("ngaySinhKhongHopLe", new ActionMessage(
								"errors.template",
								"Ngày sinh không hợp lệ (MM/dd/yyyy)"));
					}
				}
				if(this.SDT.trim().length()>0){
				if (!isInteger(this.SDT.trim()) || this.SDT.length() <= 9) {
					err.add("SDT", new ActionMessage("errors.template",
							"Số điện thoại phải lớn hoặc bằng 9 chữ số"));
				}
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return err;
	}

	public static boolean isInteger(String s) {
		try {
			Long.parseLong(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public String getUrlAnhDaiDien() {
		return urlAnhDaiDien;
	}

	public void setUrlAnhDaiDien(String urlAnhDaiDien) {
		this.urlAnhDaiDien = urlAnhDaiDien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public int getDiemNangDong() {
		return diemNangDong;
	}

	public void setDiemNangDong(int diemNangDong) {
		this.diemNangDong = diemNangDong;
	}

	public int getSoLanToChucThanhCong() {
		return soLanToChucThanhCong;
	}

	public void setSoLanToChucThanhCong(int soLanToChucThanhCong) {
		this.soLanToChucThanhCong = soLanToChucThanhCong;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getNoiCongTac() {
		return noiCongTac;
	}

	public void setNoiCongTac(String noiCongTac) {
		this.noiCongTac = noiCongTac;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
