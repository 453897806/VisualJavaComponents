package com.JVComponents.core;

/**
 * 所有菜单集合的基类
 * 
 * @author bob
 *
 */
public class JVMenus extends JVirtualList {

	public JVMenus(JVContainer container) throws JVException {
		super(container);
	}

	@Override
	public Class<?> getItemClass() {
		return JVMenuItem.class;
	}

}
