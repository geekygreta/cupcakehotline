package org.translifeline.cupcakehotline.controller;

import static org.translifeline.cupcakehotline.objectify.OfyService.ofy;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.translifeline.cupcakehotline.CupcakehotlineServlet;
import org.translifeline.cupcakehotline.models.Operator;
import org.translifeline.cupcakehotline.objectify.OfyService;

import com.google.gson.Gson;

public class OperatorServlet extends CupcakehotlineServlet {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2002574891514820851L;
	
	private static final Logger logger = Logger.getLogger(Operator.class.getName());

	private static final String idParameter = "id"; 
	private static final String dataParameter = "data"; 
		
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String idParam = req.getParameter(idParameter);
		if (idParam == null) {
			logger.severe("Id parameter not defined");
			respondWithMessage(ResponseStatus.ERROR, "Please pass an id parameter", resp);
		}
		Long id = Long.parseLong(idParam);
		
		Operator value =  ofy().load().type(Operator.class).id(id).now();
		respondWithData(ResponseStatus.OK, value, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("application/json");
		String dataJson = req.getParameter(dataParameter);
		if (dataJson == null) {
			logger.severe("Data parameter not defined");
			respondWithMessage(ResponseStatus.ERROR, "Please pass a data parameter containing an Operator object.", resp);
		}
		
		Operator operator = getGson(req).fromJson(dataJson, Operator.class);

		ofy().save().entity(operator).now();  
		
    	respondWithData(ResponseStatus.OK, String.format("{'id' : '%d'}", operator.getId()), resp);
	}
}
