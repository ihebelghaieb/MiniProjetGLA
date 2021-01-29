 <div class="col-md-3">
            <div class="list-group">
                <a href="#" class="list-group-item active"> Tous les Produits </a>
               <c:forEach items="${cats}" var="c" >
                <a href="${cxt }/produits/${c.id}" class="list-group-item">${c.description}</a>
                </c:forEach>
            </div>
        </div>
		