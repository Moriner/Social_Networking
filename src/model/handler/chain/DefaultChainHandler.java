package model.handler.chain;

import model.handler.DefaultModelHandler;

/**
 * @author Chen Chao
 *
 */
public interface DefaultChainHandler {
	
	public DefaultModelHandler nextHandler();
	public void setNextHandler(DefaultModelHandler handler);
	
	public DefaultModelHandler previousHandler();
	public void setPreviousHandler(DefaultModelHandler handler);
}
