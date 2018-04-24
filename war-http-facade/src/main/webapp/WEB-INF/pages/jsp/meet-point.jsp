<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ru.aparfenov.meetplace.model.MeetPoint" %>
<%--<%@ page import="getman.ejb3.jpa.relations.AuthorEntity" %>
<%@ page import="getman.ejb3.jpa.relations.BookReviewEntity" %>
<%@ page import="getman.ejb3.jpa.relations.BookSpoiler" %>
<%@ page import="getman.ejb3.jpa.relations.ISBN" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pocket</title>
</head>
<body>
Pocket list
<% Object meetPointList = request.getAttribute("meet-point-list");%>
<% if ((meetPointList != null) && (!((List<MeetPoint>) meetPointList).isEmpty())) { %>
<table border="3">
    <tr>
        <td>id</td>
        <td>x</td>
        <td>y</td>
    </tr>
    <% for (MeetPoint nextMP : (List<MeetPoint>) meetPointList) { %>
    <tr>
        <%--id--%>
        <td><%= nextMP.getId() %></td>
        <%--x coord--%>
        <td><%= nextMP.getX() %></td>
        <%--x coord--%>
        <td><%= nextMP.getY() %></td>
    </tr>
    <% } %>
</table>
<% } else { %>
no pockets
<% } %>
<form method="POST" action="http-facade">
    <p>
        <label for="item">Add new meet point, id:</label>
        <input id="new-meet-point-id" type="text" name="new-meet-point-id"/>

        <label for="item">x:</label>
        <input id="new-meet-point-x" type="text" name="new-meet-point-x"/>

        <label for="item">y:</label>
        <input id="new-meet-point-y" type="text" name="new-meet-point-y"/>

        <input type="hidden" name="action" value="add"/>
        <input type="submit" value="add"/>
    </p>

</form>

</body>
</html>

