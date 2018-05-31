package form;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import utils.KiemTraDinhDang;

public class DangKyForm extends ActionForm {

	private String taiKhoan, matKhau, matKhauXN, hoTen, ngaySinh, email;

	private ArrayList<String> soTrang;
	private String trangSo;

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String TaiKhoan_PATTERN = "[A-Za-z0-9]+";

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (this.taiKhoan == null || this.taiKhoan.trim().equals("")
				|| KiemTraDinhDang.kiemTraPhaHoai(taiKhoan))
			errors.add("taiKhoan", new ActionMessage("errors.template",
					"Tài khoản không được để trống"));
		else {
			pattern = Pattern.compile(TaiKhoan_PATTERN);
			matcher = pattern.matcher(this.taiKhoan.trim());
			if (!matcher.matches())
				errors.add("taiKhoanKhongHopLe", new ActionMessage(
						"errors.template", "Tài khoản chỉ chứa chữ và số"));
		}

		if (this.matKhau == null || this.matKhau.trim().equals(""))
			errors.add("matKhau", new ActionMessage("errors.template",
					"Mật khẩu không được để trống"));
		else {
			pattern = Pattern.compile(TaiKhoan_PATTERN);
			matcher = pattern.matcher(this.matKhau.trim());
			if (!matcher.matches()) {
				errors.add("matKhauKhongHopLe", new ActionMessage(
						"errors.template", "Mật khẩu chỉ chứa chữ và số"));
			} else if (this.matKhauXN == null
					|| !matKhau.trim().equals(matKhauXN.trim())) {
				errors.add("matKhauXacNhan", new ActionMessage(
						"errors.template", "Mật khẩu xác nhận không đúng"));
			}
		}

		if (this.hoTen == null || this.hoTen.trim().equals("")
				|| KiemTraDinhDang.kiemTraPhaHoai(hoTen))
			errors.add("hoTen", new ActionMessage("errors.template", "Họ tên không được để trống"));

		if (this.ngaySinh == null || this.ngaySinh.trim().equals(""))
			errors.add("ngaySinh", new ActionMessage("errors.template", "Ngày sinh không được để trống"));
		else {
			try {
				String[] element = this.ngaySinh.split("/");
				if (element[0].length() == 2 && element[1].length() == 2
						&& element[2].length() == 4) {
				} else {
					errors.add("ngaySinhKhongHopLe", new ActionMessage(
							"errors.template", "Ngày sinh không hợp lệ (MM/dd/yyyy)"));
				}
			} catch (Exception e) {
				errors.add("ngaySinhKhongHopLe", new ActionMessage(
						"errors.template", "Ngày sinh không hợp lệ (MM/dd/yyyy)"));
			}
		}

		if (this.email == null || this.email.trim().equals("")
				|| KiemTraDinhDang.kiemTraPhaHoai(email))
			errors.add("email", new ActionMessage("errors.template", "Email không được để trống"));
		else {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(this.email.trim());
			if (!matcher.matches())
				errors.add("emailKhongHopLe", new ActionMessage(
						"errors.template", "Email không hợp lệ"));
		}

		return errors;
	}

	public ArrayList<String> getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(ArrayList<String> soTrang) {
		this.soTrang = soTrang;
	}

	public String getTrangSo() {
		return trangSo;
	}

	public void setTrangSo(String trangSo) {
		this.trangSo = trangSo;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getMatKhauXN() {
		return matKhauXN;
	}

	public void setMatKhauXN(String matKhauXN) {
		this.matKhauXN = matKhauXN;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
