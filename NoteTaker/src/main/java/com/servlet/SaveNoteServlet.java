package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class SaveNoteServlet
 */
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveNoteServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String title=request.getParameter("title");
			String content = request.getParameter("content");
			
			Note note = new Note(title, content, new Date());
			
			Session session =FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(note);			
			tx.commit();
			session.close(); 
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h2 style='text-align:center;'> This note is added</h2>");
			out.println("<h2 style='text-align:center;'> <a href='all_notes.jsp'>View all Notes</a></h2>");
			
		}catch(Exception e) {
			
		}		
	}

}
