<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<%@include file="../template/head.jsp" %>

<body>

    <div class="container">

        <h1 class="p-3"> Добавить новое Аниме </h1>

        <form:form action="/saveCourse" method="post" modelAttribute="addCourseModel">

            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="drugId">Препарат</label>
            		<div class="col-md-6">
						<form:select  path="drugId" id="drugId" class="form-control input-sm" required="required">
							<c:forEach items="${drugs}" var="drug">
								<option value="${drug.id}">${drug.name}</option>
							</c:forEach>
						</form:select>
            		</div>
            	</div>
            </div>

            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="useTypeId">Способ приёма</label>
            		<div class="col-md-6">
						<form:select  path="useTypeId" id="useTypeId" class="form-control input-sm" required="required">
							<c:forEach items="${useTypes}" var="useType">
								<option value="${useType.id}">${useType.name}</option>
							</c:forEach>
						</form:select>
            		</div>
            	</div>
            </div>

            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="datepicker1">Дата начала</label>
            		<div class="col-md-6">
            		    <form:input type="text" path="dateStart" id="datepicker1"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>

            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="datepicker2">Дата начала</label>
            		<div class="col-md-6">
            		    <form:input type="text" path="dateEnd" id="datepicker2"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>

<%--            <div class="row">--%>
<%--            	<div class="form-group col-md-12">--%>
<%--            		<label class="col-md-3" for="year">Год</label>--%>
<%--            		<div class="col-md-6">--%>
<%--            			<form:input type="number" path="year" id="year"--%>
<%--            				class="form-control input-sm" required="required" />--%>
<%--            		</div>--%>
<%--            	</div>--%>
<%--            </div>--%>

            <div class="row p-2">
            	<div class="col-md-2">
            		<button type="submit" value="Save" class="btn btn-success">Сохранить</button>
            	</div>
            </div>

        </form:form>

    </div>

	<script>
		$(function() {
			$("#datepicker1").datepicker();
			$("#datepicker2").datepicker();
		});
	</script>

    <script th:inline="javascript">
            window.onload = function() {

                var msg = "${message}";
                console.log(msg);
                if (msg == "save_error") {
    				Command: toastr["error"]("Что-то пошло не так.")
    			}

    			toastr.options = {
                      "closeButton": true,
                      "debug": false,
                      "newestOnTop": false,
                      "progressBar": true,
                      "positionClass": "toast-top-right",
                      "preventDuplicates": false,
                      "showDuration": "300",
                      "hideDuration": "1000",
                      "timeOut": "5000",
                      "extendedTimeOut": "1000",
                      "showEasing": "swing",
                      "hideEasing": "linear",
                      "showMethod": "fadeIn",
                      "hideMethod": "fadeOut"
                    }
    	    }
        </script>

</body>

</html>