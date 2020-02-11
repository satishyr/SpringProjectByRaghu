<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO CARD PAYMENT SERVICE</h3>
<form action="pay" method="post">
<pre>
 NAME  :  <input type="text" name="cname"/>
 NUMBER:  <input type="text" name="cnum"/>
 CVV   :  <input type="text" name="cvv" size="2"/> DATE  :  <input type="text" name="expDate" size="3"/>
  AMOUNT:  <input type="text" name="amt" size="4"/>  <input type="submit" value="PAY AMOUNT"/>
</pre>
</form>
${message}
</body>
</html>





