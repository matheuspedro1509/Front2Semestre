<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:template titulo="Sucesso">
	<h1>Cadastrado com sucesso</h1>
	<label>Modelo: </label> <h3>${v.modelo }</h3>
	<label>Marca: </label> <h3>${v.marca }</h3>
	<label>Ano: </label> <h3>${v.ano }</h3>
	<label>Cor: </label> <h3>${v.cor }</h3>
	<label>Placa: </label> <h3>${v.placa }</h3>
 </tags:template>