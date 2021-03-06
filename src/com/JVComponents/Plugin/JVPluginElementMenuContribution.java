package com.JVComponents.Plugin;


import org.dom4j.Element;

import com.JVComponents.core.JVConfigXMLAttribute;
import com.JVComponents.core.JVConfigXMLFile;
import com.JVComponents.core.JVException;

public class JVPluginElementMenuContribution extends JVPluginElement {
	
	private JVConfigXMLAttribute locationURI;
	/**
	 * 得到locationURI属性
	 * 
	 * @throws JVException 
	 */
	public JVConfigXMLAttribute getLocationURI() {
		return locationURI;
	}

	public JVPluginElementMenuContribution(JVConfigXMLFile configXMLFile, Element element) throws JVException {
		super(configXMLFile, element);
	}
	
	/**
	 * 针对节点读取属性对象，子类继承读取指定的属性
	 * 
	 * @param element
	 * @throws JVException
	 */
	@Override
	protected void readAttributes(Element element) throws JVException {
		//忽略基类
		//super.readAttributes(element);
		//特殊属性
		locationURI = getXMLAttribute(JVPluginConsts.JVPluginMenus.JVPluginMenuContribution.locationURI,
				JVPluginConsts.JVPluginMenus.JVPluginMenuContribution.locationURI_MainMemu +
				JVPluginConsts.JVPluginMenus.JVPluginMenuContribution.locationURI_Value);
	}
	
	@Override
	public void matchPluginElement() throws JVException {
		//无需要匹配的对象				
	}

}
