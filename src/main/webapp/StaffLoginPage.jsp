<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Login Page</title>
<style type = "text/css">
	  
         body {
            font-family:Arial, Helvetica, sans-serif;
            font-size:14px;
         }
		 .head{
			 font-weight:bold;
			 font-size:25px;
			 text-align:center;
		 }
         label {
            font-weight:bold;
            width:100px;
            font-size:14px;
         }
         .box {
            border:#666666 solid 1px;
         }
		 h1 {
			color: blank;
		}
      </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	
	<div class="head"><h1><marquee>DIVVLEARN HIGHER SECONDARY SCHOOL</marquee></h1></div><br>
	
	<div align = "center">
         <div style = "width:400px;height:350px; border: solid 1px #333333; " align = "left">
            <div style = "background-color:#333333; color:#FFFFFF; padding:3px;">
				<h2>STAFF LOGIN PORTAL</h2>
			</div>
            <div style = "margin:30px">
            <!-- Staff Login Page -->
            	<form action="StaffLoginActionServlet" method="post">
					<label>NAME : </label><br/>
					<input type="text" name="staffName" id="stafftName" placeholder="Enter Your Name" required><br/><br/>
					<label>PASSWORD : </label><br/>
					<input type="password" name="staffPassword" id="staffPassword" placeholder="Enter Your Password" required><br/><br/>
					<button class="btn btn-primary">LOGIN</button>
				</form>
              	<div style = "font-size:11px; color:#cc0000; margin-top:10px"></div>
                <%
					String errorMessage = request.getParameter("errorMessage");
					if(errorMessage!=null)
					{
						out.println("<font color='blue'>"+errorMessage+"</font>");
					}
				%>
            </div>
        </div>
     </div>
</main>
</body>
</html>