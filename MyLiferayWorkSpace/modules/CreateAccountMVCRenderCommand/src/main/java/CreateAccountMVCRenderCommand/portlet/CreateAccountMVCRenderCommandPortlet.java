package CreateAccountMVCRenderCommand.portlet;

import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author hp-pc
 */
@Component(
property = { 
		"javax.portlet.name="+LoginPortletKeys.LOGIN, 
		"mvc.command.name=/login/create_account",
		"service.ranking:Integer=100" 
}, 
service = MVCRenderCommand.class)
public class CreateAccountMVCRenderCommandPortlet implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, 
	                    RenderResponse renderResponse) throws PortletException {

	   System.out.println("inside custom create account render");
	   renderRequest.setAttribute("name", "sami mohamed basyoni");
	    return mvcRenderCommand.render(renderRequest, renderResponse);
	}

@Reference(target = 
		      "(component.name=com.liferay.login.web.internal.portlet.action.CreateAccountMVCRenderCommand)")
		  protected MVCRenderCommand mvcRenderCommand;	

}