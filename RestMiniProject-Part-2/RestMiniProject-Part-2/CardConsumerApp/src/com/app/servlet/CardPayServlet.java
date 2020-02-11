package com.app.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.consumer.CardConsumer;
import com.app.model.CardInfo;
import com.app.util.JsonUtil;

public class CardPayServlet	extends HttpServlet { 

	@Override
	protected void doPost(
			HttpServletRequest req, 
			HttpServletResponse resp)
					throws ServletException, 
					IOException {
		
		//1. Read Form Data
		String cname=req.getParameter("cname");
		String cnum=req.getParameter("cnum");
		String cvvs=req.getParameter("cvv");
		String expDate=req.getParameter("expDate");
		String amts=req.getParameter("amt");
		//2. Parse Data if Required
		int cvv=Integer.parseInt(cvvs);
		double amt=Double.parseDouble(amts);
		
		//3. Convert to Model class object
		CardInfo ci=new CardInfo(cname, cnum, cvv, expDate, amt); 
		
		//4. Convert to JSON Format
		String json=JsonUtil.convertToJson(ci);
		
		//5. Call consumer make HTTP POST call
		     //also get msg back
		String msg=CardConsumer.createTx(json);
		
		//6. Construct Message to send UI
		req.setAttribute("message", msg);
		
		//7. Goto UI back
		RequestDispatcher rd=req.getRequestDispatcher("CardUi.jsp");
		
		//8. call UI Page
		rd.forward(req, resp);
	}
	
	
	
	
}
