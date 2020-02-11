<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<%@include file="MenuBar.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>Welcome to Item Data Page!!</h2>
			</div>
			<br> <br> <br>
			<div class="card-body">
				<c:choose>
					<c:when test="${empty item}">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table-hover table-bordered">

							<tr class="thead-light">
								<th>ID</th>
								<th>CODE</th>
								<th>DIMENSIONS</th>
								<th>PRICE</th>
								<th>CURRENCY</th>
								<th>NOTE</th>
								<th>UOM MODE</th>
								<th>ORDER METHOD MODE</th>
								
								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${item}" var="it">
								<tr>
									<td><c:out value="${it.itemId}"></c:out></td>
									<td><c:out value="${it.itemCode}"></c:out></td>
									<td><c:out value="${it.itemLength}"></c:out>
									<c:out value="(L),"></c:out>
									<c:out value="${it.itemWidth}"></c:out>
									<c:out value="(W),"></c:out>
									<c:out value="${it.itemHeight}"></c:out>
									<c:out value="(H)"></c:out>
									</td>
									<td><c:out value="${it.itemBaseCost}"></c:out></td>
									<td><c:out value="${it.itemCurrentCurrency}"></c:out></td>
									<td><c:out value="${it.itemDesc}"></c:out></td>
									<td>
									<c:out value="${it.uom.uomModel}"></c:out>-
									<c:out value="${it.uom.uomType}"></c:out>
									
									</td>
									<td><c:out value="${it.orderMethod.orderMode}"></c:out></td>
									<td><a href="view?itemId=${it.itemId}"> <img
											src="../resources/images/view.png" height="40" width="40">
									</a></td>
									<td><a href="edit?itemId=${it.itemId}"> <img
											src="../resources/images/edit.png" height="40" width="40">
									</a></td>
									<td><a href="delete?itemId=${it.itemId}"> <img
											src="../resources/images/delete.png" height="40" width="40">
									</a></td>
									<td><a href="excelExport?itemId=${it.itemId }">
											<img src="../resources/images/excel.png" height="40"
											width="40" />
									</a></td>
									<td><a href="pdfExport?itemId=${it.itemId}"> <img
											src="../resources/images/pdf.png" height="40" width="40" />
									</a></td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<h6>
							<a href="excelExport"><img src="../resources/images/BulkExcel.png" height="80" width="180" /></a> 
							<a href="pdfExport"><img src="../resources/images/BulkPdf.png" height="80" width="180" /></a>
							<a href="report"><img src="../resources/images/charts.png" height="80" width="180" /></a>
						</h6>
					</c:otherwise>
				</c:choose>
			</div>

			<c:if test="${message !=null}">
				<div class="card-footer">${message}</div>
			</c:if>
		</div>
	</div>
	<br>
</body>
</html>