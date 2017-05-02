package de.oss.dockerdui;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.oss.dockerdui.domain.Container;
import de.oss.dockerdui.rest.DockerdRestService;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
/**
 * UI class for running container view.
 * 
 * @author mr
 */
@Theme("mytheme")
public class ContainerStatusUi extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		DockerdRestService dockerdservice = new DockerdRestService();
		List<Container> containers = dockerdservice.getRunningContainer();

		final VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();

		Table table = new Table("Running Container");

		// Define two columns for the built-in container
		table.addContainerProperty("Name", String.class, null);
		table.addContainerProperty("Image", String.class, null);
		table.addContainerProperty("Status", String.class, null);
		table.addContainerProperty("State", String.class, null);

		for (Container container : containers) {
			Object newItemId = table.addItem();
			Item row = table.getItem(newItemId);
			row.getItemProperty("Name").setValue(container.getNames().get(0));
			row.getItemProperty("Image").setValue(container.getImage());
			row.getItemProperty("Status").setValue(container.getStatus());
			row.getItemProperty("State").setValue(container.getState());

		}

		// Show exactly the currently contained rows (items)
		table.setPageLength(table.size());
		layout.addComponent(table);

		layout.setMargin(true);
		layout.setSpacing(true);

		layout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);
		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = ContainerStatusUi.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}
}
