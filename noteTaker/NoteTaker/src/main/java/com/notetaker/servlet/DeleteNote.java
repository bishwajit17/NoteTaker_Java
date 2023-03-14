package com.notetaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;

import com.notetaker.entity.Note;
import com.notetaker.utils.HibernateUtils;


public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int noteid = Integer.parseInt(request.getParameter("noteId"));
			SessionFactory sfactory = HibernateUtils.getSessionFactory();
			Session session = sfactory.openSession();
			session.beginTransaction();
			
			Note note = session.get(Note.class, noteid);
			session.delete(note);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
			
			session.getTransaction().commit();
			sfactory.close();
			session.close();
			
			PrintWriter out = response.getWriter();
			out.println("<p style=text-align:center;font-size:30px>Successfullly to save your Note</p>");
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
