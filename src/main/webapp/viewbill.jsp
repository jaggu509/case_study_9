<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<form method="post">

<table border=2>
   <tr>
        <td>user ID</td>
        <td>Name</td>
        <td>Salary</td>
        <td>Location</td>
   </tr>
   <%
   try
   {
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       String url="jdbc:derby://localhost:1527/firstdb";

       String query="select * from employee";
       Connection conn=DriverManager.getConnection(url);
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
   %>
           <tr><td><%rs.getInt("ID"); %></td></tr>
           <tr><td><%rs.getString("NAME"); %></td></tr>
           <tr><td><%rs.getInt("SALARY"); %></td></tr>
           <tr><td><%rs.getString("LOCATION"); %></td></tr>

   <%
       }
   %>
   </table>
   <%
        rs.close();
        stmt.close();
        conn.close();
   }
   catch(Exception e){
        e.printStackTrace();
   }
   %>
</form>`