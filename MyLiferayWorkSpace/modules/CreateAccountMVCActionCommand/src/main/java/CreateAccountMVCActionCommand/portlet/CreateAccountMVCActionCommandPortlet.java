package CreateAccountMVCActionCommand.portlet;


import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author EbooSM
 */
@Component(
property = { 
		"javax.portlet.name="+LoginPortletKeys.LOGIN, 
		"mvc.command.name=/login/create_account",
		"service.ranking:Integer=100" 
}, 
service = MVCActionCommand.class)
public class CreateAccountMVCActionCommandPortlet extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		System.out.println("inside MVC action Command");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		System.out.println("First name is " + firstName);
		//actionResponse.sendRedirect("/web/guest/home");
		mvcActionCommand.processAction(actionRequest, actionResponse);
	}
	
	@Reference(target = 
		      "(component.name=com.liferay.login.web.internal.portlet.action.CreateAccountMVCActionCommand)")
		  protected MVCActionCommand mvcActionCommand;	
}