<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
   <%@include file="all_js_css.jsp" %>
   
    <title>Add Note</title>
    <link rel="icon" href="image/pencil.png" sizes="32x32" type="image/png">
  </head>
  <body>
    <div class="container">
    	<%@include file="Navbar.jsp" %>
    	<br>
    	<h3>This is Add Note Page.</h3>
    	
    	<!-- form -->
    	<form action="save" method="post">
		  <div class="form-group">
		    <label for="title">Note Title :- </label>
		    <input type="text" class="form-control" id="title" name="Title" aria-describedby="emailHelp" placeholder="Note Titel">
		  </div>
		  <div class="form-group">
		    <label for="noteArea">Note Area :- </label>
		    <textarea class="form-control" id="noteArea" name="Content" placeholder="Text Area"></textarea>
		  </div>
		  <br>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </div>
    

    
    

    </body>
</html>