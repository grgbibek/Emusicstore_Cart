<%--
  Created by IntelliJ IDEA.
  User: grgbibek22
  Date: 6/27/2017
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administration Page</h1>
            <p class="lead">Here is the list of all Products!!</p>

        </div>

        <h3>
        <a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
        </h3>
        <p> Here you can check all the products</p>
        <%@include file="/WEB-INF/views/template/footer.jsp"%>
