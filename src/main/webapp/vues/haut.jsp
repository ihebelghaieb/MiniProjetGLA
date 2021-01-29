   <%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">          
            <a class="navbar-brand" href="#">E-Boutique ESSAT</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="">Home</a></li>
                <li><a href='#'>Promotions</a></li>
                <li><a href='#'>Ventes Flash</a></li>
            </ul>
			 <ul class="nav navbar-nav navbar-right">                
                <li>
					<a href="${cxt}/panier"> Mon Panier 
						<span class="badge"> ${fn:length(sessionScope.monpanier.lignes) } </span>
					</a>   
				</li>     
				<c:if test="${sessionScope.clt !=null}">      
                <li>
	                 <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                     ${sessionScope.clt.prenom}${sessionScope.clt.nom}  <span class="caret"></span></a>
	                     
			          <ul class="dropdown-menu">
			            <li><a href="">Mes Commandes</a></li>
			            <li><a href="${cxt }/dec">Déconnexion</a></li>		            
			          </ul>
	            </li>
	            </c:if>
              
            </ul>
        </div>
    </div>
</nav>
