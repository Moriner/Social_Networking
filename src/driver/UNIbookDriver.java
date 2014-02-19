package driver;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Model;
import model.ModelFactory;
import view.MainView;


public class UNIbookDriver {

	public static void main(String argv[]) {

		// init the model once it is implemented
		final Model model = new ModelFactory().getModelHandlerChain();
		
        //final Model model = new ModelImpl();

		// create view - i.e. the main Frame class
		final MainView mainView = new MainView(model);	
		mainView.setSize(320, 480);
		mainView.validate();
		mainView.show();

		mainView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				mainView.dispose();
				System.exit(0);
			}
		});
	}
}
