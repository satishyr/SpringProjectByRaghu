package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.SaleOrder;

public class SaleOrderExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=SaleOrder.xlsx");

		
		List<SaleOrder> saleOrder=(List<SaleOrder>) model.get("saleOrder");
	
		Sheet sheet=workbook.createSheet("Purchases");
		
		setHead(sheet);
		setBody(sheet,saleOrder);
		
	}

	private void setHead(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("REF NUM");
		row.createCell(3).setCellValue("STOCK MODE");
		row.createCell(4).setCellValue("STOCK SOURCE");
		row.createCell(5).setCellValue("STATUS");
		row.createCell(6).setCellValue("CUSTOMER");
		row.createCell(6).setCellValue("SHIPMENT CODE");
		row.createCell(7).setCellValue("NOTE");
	}
	
	private void setBody(Sheet sheet, List<SaleOrder> saleOrder) {

		int rowNumber=1;
		for(SaleOrder p:saleOrder) {
			Row row=sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(p.getSaleOrderId().toString());
			row.createCell(1).setCellValue(p.getSaleOrderCode());
		    row.createCell(2).setCellValue(p.getRefNum());
			row.createCell(3).setCellValue(p.getStockMode());
			row.createCell(4).setCellValue(p.getStockSource());
			row.createCell(5).setCellValue(p.getOrderStatus());
			row.createCell(6).setCellValue(p.getWhUserType().getUserCode());
			row.createCell(6).setCellValue(p.getShipmentType().getShipmentCode());
			row.createCell(7).setCellValue(p.getOrderDesc());
		}
		
	}

	}
