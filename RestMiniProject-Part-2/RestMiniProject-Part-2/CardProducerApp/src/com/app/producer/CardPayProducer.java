package com.app.producer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.app.db.CardPayDao;
import com.app.model.CardInfo;

@Path("/card")
public class CardPayProducer {

	@POST
	@Path("/ctx")
	@Consumes("application/json")
	public String createTx(CardInfo ci) {
		String message=null;
		if(ci.getAmt() <= 0.0) {
			message="Invalid Amt Provided";
		}else {  //Do DB insert
			String id=CardPayDao.createTx(ci);
			message="Created Tx with id="+id;
		}
		return message;
	}

	@Path("/all")
	@GET
	@Produces("application/json")
	public List<CardInfo> viewAllTx() {
		List<CardInfo> al=CardPayDao.viewAllTx();
		return al;
	}

	@GET
	@Produces("application/json")
	@Path("/one")
	public CardInfo getOneTx(
			@QueryParam("txid")String txId) {
		CardInfo ci=CardPayDao.getOneTx(txId);
		return ci;
	}


}
