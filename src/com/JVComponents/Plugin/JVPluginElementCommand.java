package com.JVComponents.Plugin;

import org.dom4j.Element;

import com.JVComponents.core.JVConfigXMLAttribute;
import com.JVComponents.core.JVConfigXMLFile;
import com.JVComponents.core.JVConsts;
import com.JVComponents.core.JVException;

public class JVPluginElementCommand extends JVPluginElement {
	private JVConfigXMLAttribute id;
	/**
	 * id属性
	 * 
	 * @throws JVException 
	 */
	public JVConfigXMLAttribute getId() {
		return id;
	}

	private JVConfigXMLAttribute attr_name;
	/**
	 * 得到name属性
	 * 
	 * @throws JVException 
	 */
	public JVConfigXMLAttribute getAttr_name() {
		return attr_name;
	}
	
	private JVConfigXMLAttribute categoryId;
	/**
	 * 得到categoryId属性
	 * 
	 * @throws JVException 
	 */
	public JVConfigXMLAttribute getCategoryId() {
		return categoryId;
	}

	private JVPluginElementCategory category;
	
	/**
	 * category对象
	 */ 
	public JVPluginElementCategory getCategory() {
		return this.category;
	}

	public void setCategory(JVPluginElementCategory category) {
		this.category = category;
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
		id = getXMLAttribute(JVPluginConsts.JVPluginRoot.id, JVConsts.emptyString);
		attr_name = getXMLAttribute(JVPluginConsts.JVPluginRoot.name, JVConsts.emptyString);
		categoryId = getXMLAttribute(JVPluginConsts.JVPluginCommands.JVPluginCommandCategory.categoryId, JVConsts.emptyString);
	}
	
	public JVPluginElementCommand(JVConfigXMLFile configXMLFile, Element element) throws JVException {
		super(configXMLFile, element);
	}

	@Override
	public void matchPluginElement() throws JVException {
		JVPluginExtensionCommands extension = (JVPluginExtensionCommands)getPluginFile().findExtension(JVPluginExtensionCommands.class);
		//读取categoryId属性后，需要根据该值找到category对象
		this.category = extension.findCategory((String)this.categoryId.getValue().getValue());
		
	}
	
}
