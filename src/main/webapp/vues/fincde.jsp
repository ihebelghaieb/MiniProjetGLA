<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Boutique</title>
<c:set var="rs" value="resources" />
<c:set var="cxt" value="${pageContext.request.contextPath }" />
<link  href="${cxt}/${rs}/files/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${cxt}/${rs}/files/bootstrap/js/jquery.min.js"></script>
<script src="${cxt}/${rs}/files/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<%@ include file="haut.jsp" %>

<div class="container">
 
    <div class="row" style="margin-top: 80px;">
	 <div class="col-md-12">
           
		    <div class="alert alert-success" role="alert">
				Votre commande a bien été prise en compte. <br />
				Nous vous remercions de votre confiance. <br />
				Numéro de votre commande : <br />
				Vous recevrez votre commande dans un délai de 10 jours maximum.
			</div>
		   
		   
		</div>   
    </div>

</div>

</body>
</html>