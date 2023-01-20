<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="com.entities.Note"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
 <%@include file="all_js_css.jsp" %>

</head>
<body>
<div class="container">
			<%@include file="navbar.jsp" %>
			<br>
			 <h2>This is Edit Page</h2>
			 <%
			 int noteId=Integer.parseInt(request.getParameter("note_id"));
			 Session s =FactoryProvider.getFactory().openSession();
			
			 Note note=(Note)s.get(Note.class, noteId); 
			 %>
			 
			 <form action="SaveNoteServlet" method="post">
			 
			 <input value="<%=note.getId() %>" name="noteId" type="hidden"/>
			 
			  <div class="form-group">
			    <label for="title">Note title</label>
			    <input name="title" required type="text"
			     type="text" class="form-control" 
			     id="title" aria-describedby="emailHelp" 
			     placeholder="Enter here"
			     value=<%=note.getTitle() %>
			     />
				  
			  </div>
			  
			  <div class="form-group">
			    <label for="content">Note Content</label>
			 	<textarea name="content"
			 		required
			 	 id="content" 
			 	placeholder="Enter your content here"
			 	class="form-control"
			 	style="height:300px">
			 	<%=note.getContent() %>
			 	
			 	</textarea>
			  </div>
			  	<div class="container text-center">
			  
			    <button type="submit" class="btn btn-primary">Save</button>
			  </div>
			</form>		
					</div>					
			</div>
</body>
</html>