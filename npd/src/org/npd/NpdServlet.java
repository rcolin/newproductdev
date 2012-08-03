package org.npd;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class NpdServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		EntityManager em = EMF.get().createEntityManager();
		try {
			Requirement r = new Requirement();
			r.setName("toto");
			r.setUpdateDate(new Date());
			r.setVersion(1);
			r.setCreationDate(new Date());
			r.setJustification("Blabla");
			r.setDescription("Blabla");
			
			em.persist(r);

		} finally {
			em.close();
		}

		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
