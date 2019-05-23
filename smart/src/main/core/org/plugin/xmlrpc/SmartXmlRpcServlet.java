package org.plugin.xmlrpc;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcHandlerMapping;
import org.apache.xmlrpc.webserver.XmlRpcServlet;
import org.smart.framework.core.ClassHelper;
import org.smart.framework.util.CollectionUtil;

@WebServlet(urlPatterns = XmlRpcConstant.SERVLET_URL, loadOnStartup = 0)
public class SmartXmlRpcServlet extends XmlRpcServlet {

    /**
	 * create by ty on TY 2017年11月10日 下午2:16:41
	 */
	private static final long serialVersionUID = 3336174559669671500L;

	@Override
    protected XmlRpcHandlerMapping newXmlRpcHandlerMapping() throws XmlRpcException {
        try {
            return newPropertyHandlerMapping(null);
        } catch (IOException e) {
            throw new XmlRpcException("", e);
        }
    }

    @Override
    protected PropertyHandlerMapping newPropertyHandlerMapping(URL url) throws IOException, XmlRpcException {
        PropertyHandlerMapping propertyHandlerMapping = new PropertyHandlerMapping();
        List<Class<?>> xmlrpcClassList = ClassHelper.getClassListByAnnotation(XmlRpc.class);
        if (CollectionUtil.isNotEmpty(xmlrpcClassList)) {
            for (Class<?> xmlrpcClass : xmlrpcClassList) {
                propertyHandlerMapping.addHandler(xmlrpcClass.getSimpleName(), xmlrpcClass);
            }
        }
        return propertyHandlerMapping;
    }
}
