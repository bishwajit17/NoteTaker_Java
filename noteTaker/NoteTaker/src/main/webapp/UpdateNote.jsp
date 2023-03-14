<%@page import="com.notetaker.entity.Note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.notetaker.utils.HibernateUtils"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@include file="all_js_css.jsp" %>
   
    <title>Edit Note</title>
    <link rel="icon" href="image/pencil.png" sizes="32x32" type="image/png">
  </head>
  <body>
    <div class="container">
    	<%@include file="Navbar.jsp" %>
    	<br>
    	<% 
    	int noteid = Integer.parseInt(request.getParameter("noteId").trim());
    	SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session s = sfactory.openSession();
		
		Note note = s.get(Note.class, noteid);
    	
    	%>
    	<form action="update" method="post">
    	<input value="<%= note.getID()%>" name="id" type="hidden">
		  <div class="form-group">
		    <label for="title">Note Title :- </label>
		    <input type="text" class="form-control" id="title" name="title" value="<%= note.getTitle() %>" required>
		  </div>
		  <div class="form-group">
		    <label for="noteArea">Note Area :- </label>
		    <textarea class="form-control" id="noteArea" name="content"  ><%= note.getContent()%></textarea>
		  </div>
		  <br>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    	
    </div>

    
    

    </body>
</html>