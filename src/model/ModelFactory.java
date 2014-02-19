package model;

import model.handler.*;

/**
 * @author Chen Chao
 *
 */
public class ModelFactory {
	
	private WSModelHandler wsModel = new WSModelHandler();
	private DBModelHandler dbModel = new DBModelHandler();
	private MemoryModelHandler memModel = new MemoryModelHandler();
	private DefaultModelHandler defaultModel = new DefaultModelHandler();
	
	public Model getModelHandlerChain(){
		
		//forward chain
		defaultModel.setNextHandler(memModel);
		memModel.setNextHandler(dbModel);
		dbModel.setNextHandler(wsModel);
		
		//backward chain
		memModel.setPreviousHandler(defaultModel);
		dbModel.setPreviousHandler(memModel);
		wsModel.setPreviousHandler(dbModel);
		
		return defaultModel;
	}
}
