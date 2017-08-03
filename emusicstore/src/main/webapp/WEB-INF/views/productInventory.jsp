<%--
  Created by IntelliJ IDEA.
  User: grgbibek22
  Date: 6/27/2017
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">Checkout all the products available now!</p>

        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>

            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png" />" alt="image" style="width:100%"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} NPR</td>
                    <td>
                        <a href="<spring:url value="/productList/viewProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-info-sign"></span>
                        </a>
                    </td>
                    <td>
                        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-remove"></span>
                        </a>

                        <a href="<spring:url value="/admin/productInventory/editProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>

                    </td>
                </tr>
            </c:forEach>

        </table>
        <a href="<spring:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary">Add Products</a>
<%@include file="/WEB-INF/views/template/footer.jsp"%>