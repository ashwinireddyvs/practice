<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!--  using JSTL core libraries -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<meta charset="UTF-8">
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
 <title>Add Todo Page</title>
</head>
<body>
	<div class="container">
		<h1>Enter Todo Details</h1>
		<form:form method="post" modelAttribute="todo">
			<!-- Description: <input type="text" name="description" required="required"/> -->
			<fieldset class="mb-3">
				<form:label path="description" >Description:</form:label>
				<form:input type="text" path="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="mb-3">
				<form:label path="targetDate" >TargetDate:</form:label>
				<form:input type="text" id="targetDate" path="targetDate" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/>
			</fieldset>
			<form:input type="hidden" path="id"/>
			<form:input type="hidden" path="done"/> 
			<input type="submit" class="btn btn-success" />
		</form:form>
		
		
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
	    	format: 'yyyy-mm-dd',
	 	});
	</script>
</body>
</html>