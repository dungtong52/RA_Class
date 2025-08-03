<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/1/2025
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Catalog</title>
</head>
<body>
<h3>Update Catalog</h3>
<form action="<%=request.getContextPath()%>/CategoryController?action=Update" method="post">
    <label for="catalogId">Catalog ID</label>
    <input type="text" id="catalogId" name="catalogId" value="${catalog.catalogId}" readonly/><br>
    <label for="catalogName">Catalog Name</label>
    <input type="text" id="catalogName" name="catalogName" value="${catalog.catalogName}"/><br>
    <label for="description">Description</label>
    <input type="text" id="description" name="description" value="${catalog.description}"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" ${catalog.status?"checked":""}/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false" ${catalog.status?"":"checked"}/><label for="inActive">InActive</label><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
