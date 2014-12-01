package org.translifeline.cupcakehotline;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.translifeline.cupcakehotline.annotations.RestrictToAdmins;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class CupcakehotlineServlet extends HttpServlet {
	
	public enum ResponseStatus {
		ERROR, OK, WARNING
	}
	
	protected void respondWithMessage(ResponseStatus status, String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.getWriter().println(String.format("{'status':'%s','message':'%s'}", status, message));
	}
	
	protected void respondWithData(ResponseStatus status, String data, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.getWriter().println(String.format("{'status':'%s','data':'%s'}", status, data));
	}
	
	protected void respondWithData(ResponseStatus status, Object data, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		Gson gson = new Gson();
		String dataJson = gson.toJson(data);
		resp.getWriter().println(String.format("{'status':'%s','data':'%s'}", status, dataJson));
	}
	
	protected boolean authenticatedUserIsAdmin(HttpServletRequest req) {
		// TODO: Change this to something more legit.
		return true;
	}
	
	protected Gson getGson(HttpServletRequest req) {
		if (authenticatedUserIsAdmin(req)) {
			// No exclusion strategy.
			return new Gson();
		}
		return new GsonBuilder().serializeNulls().setExclusionStrategies(new RestrictToAdminsExclusionStrategy()).create();
	}
	
	// Excludes any field (or class) that is tagged with an "@RestrictToAdmins"
	 private static class RestrictToAdminsExclusionStrategy implements ExclusionStrategy {
	   public boolean shouldSkipClass(Class<?> clazz) {
	     return clazz.getAnnotation(RestrictToAdmins.class) != null;
	   }

	   public boolean shouldSkipField(FieldAttributes f) {
	     return f.getAnnotation(RestrictToAdmins.class) != null;
	   }
	 }
}
