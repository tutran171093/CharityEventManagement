package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.BaiDangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.GuiPhanHoiForm;

public class GuiPhanHoiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String maUser = session.getAttribute("tenDangNhap").toString();
		
		
		
		GuiPhanHoiForm guiPhanHoiForm = (GuiPhanHoiForm) form;
		
		String tinNhan = guiPhanHoiForm.getTinNhan();
		String tenDangNhap = guiPhanHoiForm.getHidden();

		BaiDangBO baiDangBO = new BaiDangBO();
		baiDangBO.guiTinPhanHoi(maUser, tinNhan, tenDangNhap);
		return mapping.findForward("guiPhanHoiXong");
	}
}
