<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: uknow
  Date: 2023/04/18
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.write("    <tr>");
            out.write("       <td>" + member.getId() + "</td>");
            out.write("       <td>" + member.getUsername() + "</td>");
            out.write("       <td>" + member.getAge() + "</td>");
            out.write("    </td>");
        }
    %>
    </tbody>
</table>

</body>
</html>