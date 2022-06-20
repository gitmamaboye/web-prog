package rest;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.awt.*;

public class PersonContextListner implements ServletContextListener {
    @Override
    public void contextInitialized
            (ServletContextEvent contextEvent) { ServletContext context =
            contextEvent.getServletContext();
        /* handling context parameters for CounterInit02 */
        String fileName01 = context.getInitParameter("counterFileName02");

       // counterInit02.setFileName(counterFileName02);
    }
}

