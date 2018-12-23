package CreateAccountMVCResourceCommand;

import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author EbooSM
 */
@Component(
		immediate = true,
property = { 
		"javax.portlet.name=" + LoginPortletKeys.FAST_LOGIN,
	    "javax.portlet.name=" + LoginPortletKeys.LOGIN, 
		"mvc.command.name=/login/create_account",
		"service.ranking:Integer=100" 
}, 
service = MVCResourceCommand.class)
public class CreateAccountMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		System.out.println("inside serve resource base");
		String cancelOTPActionParam =resourceRequest.getParameter("cancelOTPAction");
		String createOTPActionParam =resourceRequest.getParameter("createOTPAction");
		System.out.println("inside serve resource end base");
		JSONObject jsonObject= JSONFactoryUtil.createJSONObject();
		jsonObject.put("success", true);
		PrintWriter writer;
		try {
			writer = resourceResponse.getWriter();
			writer.write(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	

}
