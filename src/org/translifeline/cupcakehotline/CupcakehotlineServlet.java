package org.translifeline.cupcakehotline;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.translifeline.cupcakehotline.models.Call;

@SuppressWarnings("serial")
public class CupcakehotlineServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println(req.toString());
		
		// Objectify stuff. Please change this to something more legit.
		Call call =  OfyService.ofy().load().type(Call.class).id(123L).now();
	}
	@Override
	public void init(){
		//Register Objectify entities here
	}
}
