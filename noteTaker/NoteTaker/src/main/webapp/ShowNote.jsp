<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.notetaker.utils.HibernateUtils"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.notetaker.entity.Note"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes</title>
    <link rel="icon" href="image/pencil.png" sizes="32x32" type="image/png">
<%@include file="all_js_css.jsp" %>
</head>
<body>
	<div class="container">
    	<%@include file="Navbar.jsp" %>
    	<br>
    	<%
    	SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session sess = sfactory.openSession();
		String hql = "from com.notetaker.entity.Note";
		Query <Note> q = sess.createQuery(hql, Note.class);
		List<Note> note = q.getResultList();
		out.println("<div class=\"row\">");
		for(Note no:note){
    	%>
    	<div class="col-sm-6 mt-3">
    		<div class="card">
     			 <div class="card-body">
		       	 	<h5 class="card-title"><%=no.getTitle() %></h5>
		        	<p class="card-text"><%=no.getContent()%></p>
		        	<br>
		        	<br>
		        	<p class="text-primary"><%=no.getAddedDate()%></p>
		        	<div class="container text-center mt-2" >
		        	<a href="delete?noteId=<%=no.getID() %>" class="btn btn-danger">Delete</a>
		        	<a href="UpdateNote.jsp?noteId=<%=no.getID() %>" class="btn  btn-primary">Update</a>
		        	</div>
				</div>
    		</div>
  		</div>
    	<%}
		out.println("</div>");
		sfactory.close();
		sess.close();
		%>
    </div>
</body>
</html>