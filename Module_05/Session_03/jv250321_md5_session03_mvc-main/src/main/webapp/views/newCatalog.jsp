<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/1/2025
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Catalog</title>
</head>
<body>
<h3>Create new catalog</h3>
<form action="<%=request.getContextPath()%>/CategoryController?action=Create" method="post">
    <label for="catalogName">Catalog Name</label>
    <input type="text" id="catalogName" name="catalogName"/><br>
    <label for="description">Description</label>
    <input type="text" id="description" name="description"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" checked/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">InActive</label><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
