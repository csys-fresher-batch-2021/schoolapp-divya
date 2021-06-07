<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Individual Fees</title>
</head>
<style>
#feesTable {
	background-color: #AAB7B8;
	font-weight: bold;
	border: none;
}

p {
	background-color: pink;
	font-weight: bolder;
	padding: 5px;
	text-align: center;
	font-size: 15px;
}
</style>
</head>
<body onload="onLoadGetId()">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="AllStudentInformationDisplay.jsp">Previous page</a><br /> <br />
		<!-- Display Student Fess -->
		<figure>
			<figcaption>
				<p>FEES INFORMATION</p>
			</figcaption>
			<br />
			<table border="1" id="feesTable" class="table">
			</table>
		</figure>
	</main>

	<script>
		/**
		 *This method fetches the fees data for a specifice student from the servlet 
		 *and gets a json data from the servlet, and writes those json data to the html. 
		 */
		function getFeesFromServlet(studentRollNumber){
			let params = 'studentRollNumber='+studentRollNumber;
			let url = "StudentFeesDisplayServlet?"+params;
			fetch(url,{method:'get'}).then(res=> res.json()).then(res=>{
				let data = res;
				console.log(data);
				var tableData = '<thead class="thead-dark"><tr><th>S.no</th><th scope="col">ROLL NUMBER</th><th scope="col">MONTH</th><th scope="col">FEES AMOUNT (Rs)</th><th scope="col">RECEIVE DATE</th></tr></thead>'
					tableData+= '<tbody>'
				    for(i = 0;i < data.length; i++){
				    	tableData+= '<tr>';
				    	tableData+= '<td>' + (parseInt(i)+1) + '</td>';
				    	tableData+= '<td>' + data[i].studentRollNumber + '</td>';
				    	tableData+= '<td>' + data[i].month+ '</td>';
				    	tableData+= '<td>' + data[i].studentFees + '</td>';
				    	tableData+= '<td>' + data[i].date + '</td>';
				    	tableData+= '</tr>';
				    }
					tableData+='</tbody>';
				    document.getElementById("feesTable").innerHTML = tableData;				
			})
		}
		/**
		 * This method gets the parameter from the url and calls the fetch function as parameter.
		 */
		function onLoadGetId(){
			let params = new URLSearchParams(window.location.search);
			let studentRollNumber = params.get('allInfo');
			getFeesFromServlet(studentRollNumber);
			}
	</script>
</body>
</html>

