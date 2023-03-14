package com.notetaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.notetaker.entity.Note;
import com.notetaker.utils.HibernateUtils;

public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			int noteid = Integer.parseInt(request.getParameter("id"));
			SessionFactory sfactory = HibernateUtils.getSessionFactory();
			Session session = sfactory.openSession();
			session.beginTransaction();
			
			Note nt = session.get(Note.class, noteid);
			
			
			nt.setID(noteid);
			nt.setContent(content);
			nt.setTitle(title);
			nt.setAddedDate(LocalDate.now());
						
			RequestDispatcher rd = request.getRequestDispatcher("ShowNote.jsp");
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
