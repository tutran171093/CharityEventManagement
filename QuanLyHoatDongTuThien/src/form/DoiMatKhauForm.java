package form;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DoiMatKhauForm extends ActionForm {

	private String matKhauCu, matKhauMoi, matKhauXacNhan;
	private String nutLuu, nutQuayLai;
	private String thongBao;
	
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String TaiKhoan_PATTERN = "[A-Za-z0-9]+";
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		
		if (this.matKhauCu == null || this.matKhauCu.trim().equals(""))
			errors.add("matKhauCu", new ActionMessage("errors.template",
					"Mật khẩu cũ không được để trống"));
		
		if (this.matKhauMoi == null || this.matKhauMoi.trim().equals(""))
			errors.add("matKhau", new ActionMessage("errors.template",
					"Mật khẩu mới không được để trống"));
		else {
			pattern = Pattern.compile(TaiKhoan_PATTERN);
			matcher = pattern.matcher(this.matKhauMoi.trim());
			if (!matcher.matches()) {
				errors.add("matKhauKhongHopLe", new ActionMessage(
						"errors.template", "Mật khẩu mới chỉ chứa chữ và số"));
			} else if (this.matKhauMoi == null
					|| !matKhauMoi.trim().equals(matKhauXacNhan.trim())) {
				errors.add("matKhauXacNhan", new ActionMessage(
						"errors.template", "Mật khẩu xác nhận không đúng"));
			}
		}

		return errors;
	}

	public String getMatKhauCu() {
		return matKhauCu;
	}

	public void setMatKhauCu(String matKhauCu) {
		this.matKhauCu = matKhauCu;
	}

	public String getMatKhauMoi() {
		return matKhauMoi;
	}

	public void setMatKhauMoi(String matKhauMoi) {
		this.matKhauMoi = matKhauMoi;
	}

	public String getMatKhauXacNhan() {
		return matKhauXacNhan;
	}

	public void setMatKhauXacNhan(String matKhauXacNhan) {
		this.matKhauXacNhan = matKhauXacNhan;
	}

	public String getNutLuu() {
		return nutLuu;
	}

	public void setNutLuu(String nutLuu) {
		this.nutLuu = nutLuu;
	}

	public String getNutQuayLai() {
		return nutQuayLai;
	}

	public void setNutQuayLai(String nutQuayLai) {
		this.nutQuayLai = nutQuayLai;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}

}
