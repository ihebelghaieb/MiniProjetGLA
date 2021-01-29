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
	
       
		
       
     
        <div class="col-md-6">
            <div class="panel panel-info">
                <div class="panel-body">
					
					
				<form class="form-horizontal" method="get" action="${cxt }/verif" >
				 <h4 align="center">Vous Avez Déjà Un Compte E-Boutique ?<br>
  				 Connectez-Vous !
				 </h4>
				 <br>
				  <div class="form-group">
					<label class="col-md-4 control-label">Email</label>
					<div class="col-md-8">
					  <input type="email" class="form-control" placeholder="Email" name="email">
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-md-4 control-label">Mot de passe</label>
					<div class="col-md-8">
					  <input type="password" class="form-control" placeholder="Password" name="password">
					</div>
				  </div>
				  
				  <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					  <button type="submit" class="btn btn-info">Se Connecter</button>
					</div>
				  </div>
				</form>
					
                </div>
            </div>
        </div>
		<div class="col-md-6" style="margin-left:-20px;">
            <div class="panel panel-info">
              <div class="panel-body">
				<form:form class="form-horizontal" method="POST" action="${cxt }/saveClient" modelAttribute="clt">
				  <h4 align="center">Je Suis Un Nouveau Client </h4>
				  <br />
				  <h5>Créer un nouveau compte client</h5>
				  <br />				
				  <div class="form-group">
					<label class="col-md-4 control-label">Nom</label>
					<div class="col-md-8">
					  <form:input type="text" class="form-control" placeholder="Nom" path="nom" />
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-md-4 control-label">Prénom</label>
					<div class="col-md-8">
					  <form:input type="text" class="form-control" placeholder="Prenom" path="prenom" />
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-md-4 control-label">Adresse</label>
					<div class="col-md-8">
					  <form:input type="text" class="form-control" placeholder="Adresse" path="adresse" />
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-md-4 control-label">Email</label>
					<div class="col-md-8">
					  <form:input type="email" class="form-control" placeholder="Email" path="email" />
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-md-4 control-label">Mot de passe</label>
					<div class="col-md-8">
					  <form:input type="password" class="form-control" placeholder="Password" path="password" />
					</div>
				  </div>
				  <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					  <button type="submit" class="btn btn-info">S'inscrire</button>
					</div>
				  </div>
				</form:form>
					
                </div>
            </div>
        </div>
		

    </div>

</div>

</body>
</html>