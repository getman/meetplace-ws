<%@page import="ru.aparfenov.meetplace.rest.MPRestfulService"%>
<html>
<body>>
<h1>***Meet point***</h1>
<jsp:useBean id="srv" class="ru.aparfenov.meetplace.rest.MPRestfulService" scope="session"/>
<jsp:setProperty name="srv" property="*" />
<%
    out.print(34+23);
    srv.getDecsription();
    out.print("cube of 5 is "+m);
%>
</body>
</html>