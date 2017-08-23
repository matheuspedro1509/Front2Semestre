<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:template titulo="Listagem de veiculos">

	<h1>Listagem de veiculos</h1>
	<table class="table">
		<tr>
			<th>Modelo</th>
			<th>Marca</th>
		</tr>
		<c:forEach items="${veiculos }" var="v">
		<tr>
			<td>${v.modelo }</td>
			<td>${v.marca }</td>
		</tr>
		</c:forEach>
	</table>
</tags:template>