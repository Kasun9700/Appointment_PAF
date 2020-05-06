<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.Appointment"%>
<%@ page import="com.AppointmentsAPI"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HealthCare System</title>
</head>
<style>
body {
    font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
    font-size: 26px;
    line-height: 3;
    color: #333;
    background-color: #fff;
}

/*Contact sectiom*/
.content-header{
  font-family: 'Oleo Script', cursive;
  color:#fcc500;
  font-size: 45px;
}

.section-content{
  text-align: center; 

}
#contact{
    
  font-family: 'Teko', sans-serif;
  padding-top: 60px;
  width: 100%;
  width: 100vw;
  height: 1200px;
  background: #3a6186; /* fallback for old browsers */
  background: -webkit-linear-gradient(to left, #3a6186 , #89253e); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to left, #3a6186 , #89253e); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
    color : #fff;    
}
.contact-section{
  padding-top: 40px;
}
.contact-section .col-md-6{
  width: 50%;
}

.form-line{
  border-right: 1px solid #B29999;
}

.form-group{
  margin-top: 10px;
}
label{
  font-size: 1.3em;
  line-height: 1em;
  font-weight: normal;
}
.form-control{
  font-size: 7px;
  color: #080808;
}
textarea.form-control {
    height: 135px;
    font-size: 4px;
   /* margin-top: px;*/
}

.submit{
  font-size: 2em;
  float: right;
  width: 150px;
  background-color: transparent;
  color: #fff;

}

</style>
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.2.1.min.js"></script>
	<script src="Components/appointments.js"></script>
	<meta charset="ISO-8859-1">
	<meta charset="ISO-8859-1">
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

    <link href="https://fonts.googleapis.com/css?family=Oleo+Script:400,700" rel="stylesheet">
   	<link href="https://fonts.googleapis.com/css?family=Teko:400,700" rel="stylesheet">
   	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
   	
	<title>Appointment management</title>
</head>
<body>
<section id="contact">
			<div class="section-content">
				<h1 class="section-header">Hospital <span class="content-header wow fadeIn " data-wow-delay="0.2s" data-wow-duration="2s"> Appointment Management</span></h1>
				<br>
			</div>
			
			    <div class="col-6">
				<form id="formAppointment" name="formAppointment" method="post" action="appointment.jsp" style="
                padding-left: 550px;
                height: 332px;
                width: 1300px; 
                font-family: 'Oleo Script', cursive;
                color:#fcc500;
                font-size: 19px;">
					Appointment number: 
					<input id="appointmentNo" name="appointmentNo" type="text"class="form-control form-control-sm" style="font-size: 1.1em;  font-family: Alef Regular;">
					 <br> Appointment name:
					<input id="appointmentName" name="appointmentName" type="text"class="form-control form-control-sm" style="font-size: 1.1em;  font-family: Alef Regular;"> 
					<br> Appointment time: 
					<input id="appointmentTime" name="appointmentTime" type="text"class="form-control form-control-sm" style="font-size: 1.1em;  font-family: Alef Regular;"> 
					<br> Appointment date: 
					<input id="appointmentDate" name="appointmentDate" type="text"class="form-control form-control-sm" style="font-size: 1.1em;  font-family: Alef Regular;">
					 <br> 
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary" onclick="location.reload()" style="
                    width: 94px;
                    height: 40px;
                    font-size: 19px;">
		            <input type="hidden" id="hidAppointmentIDSave" name="hidAppointmentIDSave" value="">
				</form>

                    <br><br><br><br>
				<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
  
   <br>
   <div id="divAppointmentsGrid" style="
    padding-left: 550px;
    width: 1300px;
    font-size: 20px;
    font-family: Alef Regular;">
   
   <%
                        Appointment appointmentObj = new Appointment();
                        out.print(appointmentObj.readAppointments());
                        %>
   </div>

			</div>
		</div>
	</div>




</body>
</html>