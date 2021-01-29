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
	<%@ include file="gauche.jsp" %>
       
		
        <div class="col-md-9">
  <c:forEach items="${prods}" var="p">
            <div class="col-md-4">
                <div class="thumbnail">
                    <img src="${cxt }/${rs }/files/images/${p.id}.jpg" >
                    <div class="caption">
                        <h3>${p.description}</h3>
                        <p><a href="${cxt }/addPanier/${p.id}" class="btn btn-primary" >Ajouter Panier</a>
                            <a href="#" class="btn btn-danger" >${p.prix }DT</a>
                        </p>
                    </div>
                </div>
            </div>       
           </c:forEach>
        </div>

    </div>

</div>

</body>
</html>