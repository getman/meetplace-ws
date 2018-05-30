<%@ page import="java.util.List" %>
<%@ page import="ru.aparfenov.meetplace.model.MeetPoint" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pocket</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="https://api-maps.yandex.ru/1.1/index.xml" type="text/javascript"></script>
    <script type="text/javascript">
        // Создает обработчик события window.onLoad
        YMaps.jQuery(function () {
            // Создает экземпляр карты и привязывает его к созданному контейнеру
            var map = new YMaps.Map(YMaps.jQuery("#YMapsID")[0]);

            // Устанавливает начальные параметры отображения карты: центр карты и коэффициент масштабирования
            map.setCenter(new YMaps.GeoPoint(37.64, 55.76), 10);
        })
    </script>
</head>
<body>
Meet point full list
<% Object meetPointList = request.getAttribute("meet-point-list");%>
<% if ((meetPointList != null) && (!((List<MeetPoint>) meetPointList).isEmpty())) { %>
<%--<form method="POST" action="http-facade">
    <p>--%>
        <table border="3">
            <tr>
                <td>id</td>
                <td>x</td>
                <td>y</td>
                <%--<td>-</td>--%>
            </tr>
            <% for (MeetPoint nextMP : (List<MeetPoint>) meetPointList) { %>
            <tr>
                <%--id--%>
                <td><%= nextMP.getId() %></td>
                <%--x coord--%>
                <td><%= nextMP.getX() %></td>
                <%--x coord--%>
                <td><%= nextMP.getY() %></td>
                <%--delete button--%>
                <%--<td><input type="hidden" name="delete-by-mp-id" value="<%= nextMP.getId() %>"/>
                    <input type="submit" value="delete"/></td>--%>
            </tr>
            <% } %>
        </table>
<%--    </p>
</form>--%>
<% } else { %>
no meet points
<% } %>

<%--deletes the meet point from the database--%>
<%--<form method="POST" action="http-facade">
    <p>
        <input type="hidden" name="action" value="delete"/>
        <input type="submit" value="delete"/>
    </p>
</form>--%>

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

<%--Deleting meet point--%>
<form method="POST" action="http-facade">
    <p>
        <%--<label for="item">Add new meet point, id:</label>
        <input id="new-meet-point-id" type="text" name="new-meet-point-id"/>

        <label for="item">x:</label>
        <input id="new-meet-point-x" type="text" name="new-meet-point-x"/>--%>

        <label for="item">Delete item by id:</label>
        <input id="delete-by-mp-id" type="text" name="delete-by-mp-id"/>

        <input type="hidden" name="action" value="delete"/>
        <input type="submit" value="delete"/>
    </p>
</form>

Search meet points by params
<<form method="POST" action="http-facade">
    <p>
        <label for="item">id:</label>
        <input id="search-param-mp-id" type="text" name="search-param-mp-id"/>

        <label for="item">x:</label>
        <input id="search-param-mp-x" type="text" name="search-param-mp-x"/>

        <label for="item">y:</label>
        <input id="search-param-mp-y" type="text" name="search-param-mp-y"/>

        <input type="hidden" name="action" value="search"/>
        <input type="submit" value="search"/>
    </p>
</form>

<% Object meetPointFoundList = request.getAttribute("meet-point-found-list");%>
<% if ((meetPointFoundList != null) && (!((List<MeetPoint>) meetPointFoundList).isEmpty())) { %>
Meet point found list
<table border="3">
    <tr>
        <td>id</td>
        <td>x</td>
        <td>y</td>
    </tr>
    <% for (MeetPoint nextMP : (List<MeetPoint>) meetPointFoundList) { %>
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
no meet points found
<% } %>

    Карта
    <div id="YMapsID" style="width:600px;height:400px"></div>

</body>
</html>

