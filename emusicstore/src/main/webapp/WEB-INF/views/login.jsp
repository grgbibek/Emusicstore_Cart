<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grgbibek22
  Date: 7/26/2017
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Login with username and pasword</h2>
            <%--displaying login error--%>
            <c:if test="${not empty msg}" >
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
                <%--displaying login error--%>
                <c:if test="${not empty error}">
                    <div class="error" style="color:#ff0000">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username" >Username</label>
                    <input type="text"  id="username" name="username" class="form-control" />
                </div>

                <div class="form-group">
                    <label for="password" >Password</label>
                    <input type="password"  id="password" name="password" class="form-control" />
                </div>
                <input type="submit" value="Login" class="btn btn-default" />
                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>