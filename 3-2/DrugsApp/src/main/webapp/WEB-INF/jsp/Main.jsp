<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Контроль лекарств</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover{
            color: white;
            text-decoration: none;
        }

		body {
			/*background: #717370;*/

		}

		#content {
			/*border: 1px solid rgba(0, 83, 249, 0.5);*/
			padding: 0.8em 1em;
			/*max-width: 98vw;*/
			max-height: 80vh;
			/*max-width: 100%;*/
			padding-bottom: 744px;
			position: relative;
			background: var(--content-background);
			color: var(--font-color);
		}

		th{
			color: var(--font-color);
		}

		td{
			color: var(--font-color);
		}

		p {
			font-size: 80%;
		}


		#content strong {
			box-shadow: var(--Bshadow-box-shadow);
			padding: 0.8em 1em;
		}

		:root {
			--content-background: #ffffff;
			--font-color: #000000;
			--Bshadow-box-shadow: 0rem 0rem 0.3rem rgba(97, 97, 97, 0.41);
		}

		[data-theme="dark"] {
			--content-background: #363636;
			--font-color: #ecefef;
			--Bshadow-box-shadow: 0rem 0rem 0.3rem rgba(201, 201, 201, 0.41);
			--font-color: #fff;
			--font-color: #fff;

		}

		/* переключатель темы  start */
		.toggle-box:after {
			content: "\25cf "" \2601";
		}
		.toggle-box:before {
			content: "\263c "" \25cb";
		}
		.toggle-box {
			display: inline-block;
			position: relative;
			margin: 1em;
		}
		.toggle-box input {
			display: none;
		}
		.toggle-box label {
			display: inline-block;
			position: relative;
			padding: 0;
			font-size: 14px;
			line-height: 16px;
			cursor: pointer;
			color: hsla(0, 0%, 58.4%, 0.51);
		}
		.toggle-box input[type="checkbox"]:checked + .toggle-box-label-left {
			color: hsla(0, 0%, 58.4%, 0.51);
		}
		.toggle-box input[type="checkbox"] + .toggle-box-label-left {
			color: hsla(0, 0%, 98%, 0.51);
		}
		.toggle-box input[type="checkbox"]:checked + .toggle-box-label-left:before {
			right: 17px;
			box-shadow: 5px 5px 0 0 #eee;
			background: transparent;
		}
		.toggle-box-label-left:before {
			content: "";
			display: block;
			position: absolute;
			z-index: 1;
			line-height: 34px;
			text-indent: 40px;
			height: 16px;
			width: 16px;
			margin: 4px;
			border-radius: 100%;
			right: 26px;
			bottom: 0;
			background: #383838;
			-webkit-transform: rotate(-45deg);
			transform: rotate(-45deg);
		}
		.toggle-box-label-left:after,
		.toggle-box-label-left:before {
			box-sizing: border-box;
			padding: 0;
			-webkit-transition: 0.25s ease-in-out;
			transition: 0.25s ease-in-out;
			outline: none;
		}
		.toggle-box input[type="checkbox"]:checked + .toggle-box-label-left:after {
			background: rgba(0, 0, 0, 0.15);
			border: 2px solid #ddd;
		}
		.toggle-box-label-left:after {
			content: "";
			display: inline-block;
			width: 40px;
			height: 24px;
			border-radius: 16px;
			background: hsla(0, 0%, 100%, 0.15);
			vertical-align: middle;
			margin: 0 10px;
			border: 2px solid #383838;
		}
		.toggle-box-label-left:after,
		.toggle-box-label-left:before {
			box-sizing: border-box;
			padding: 0;
			-webkit-transition: 0.25s ease-in-out;
			transition: 0.25s ease-in-out;
			outline: none;
		}
		/*  переключатель темы   end*/

	</style>
	<link rel="stylesheet" href="../src/webapp/WEB_INF/jsp/css/style.css">
</head>

<body >

<section id="content">

    <div class="container">

        <h1 class="p-3">Курсы лекарств</h1>
        <div>

			<c:if test="${empty user}">
				   <button type="button" class="btn btn-outline-primary">
					   <a href="/auth" style="color: black; font-weight: bold">Авторизация</a>
				   </button>
			</c:if>
			<c:if test="${not empty user}">
				<jsp:useBean id="user" scope="request" type="com.example.drugs.model.User"/>
				<div>Пользователь: ${user.fullName}</div>
			</c:if>

<%--            <c:choose>--%>
<%--               <c:when test="${empty user}">--%>
<%--				   <button type="button" class="btn btn-outline-primary">--%>
<%--					   <a href="/auth" style="color: black; font-weight: bold">Авторизация</a>--%>
<%--				   </button>--%>
<%--			   </c:when> <!-- if condition -->--%>
<%--               <c:otherwise>Вы вошли, как </c:otherwise>    <!-- else condition -->--%>
<%--            </c:choose>--%>
        </div>

		<div class="toggle-box">
		    <input type="checkbox" name="checkbox1" id="toggle-box-checkbox">
		    <label for="toggle-box-checkbox" class="toggle-box-label-left"></label>
		    <label for="toggle-box-checkbox" class="toggle-box-label"></label>
		</div>

        <form:form>

            <table class="table table-bordered">
            	<tr>
<%--            		<th>Id</th>--%>
            		<th>Название</th>
            		<th>Год</th>
            		<th>Редактировать</th>
            		<th>Удалить</th>
					<th>Где посмотреть</th>
					<th>Отзыв</th>
            	</tr>

            	<c:forEach var="anime" items="${animeList}">
<%--
<%--                		<td>${anime.id}</td>--%>
                		<td style="font-weight: bold">${anime.name}</td>
                		<td style="font-weight: bold">${anime.year}</td>
                		<td><button type="button" class="btn btn-success">
                		    <a href="/editAnime/${anime.id} " style="color: black; font-weight: bold">Редактировать</a>
                		</button></td>
                		<td><button type="button" class="btn btn-danger">
                			<a href="/deleteAnime/${anime.id}" style="color: black; font-weight: bold">Удалить</a>
                		</button></td>
						<td><button type="button" class="btn btn-warning">
							<a href="https://yummyanime.org" target="_blank" style="color: black; font-weight: bold">Посмотреть на сайте</a>
						</button></td>
						<td><button type="button" class="btn btn-primary ">
							<a href="/reviewAnime/" style="color: black; font-weight: bold">Оставить отзыв</a>
						</button></td>
                	</tr>

            	</c:forEach>

            </table>

        </form:form>

        <button type="button" class="btn btn-info btn-block">
        	<a href="/addAnime" style="color: black; font-weight: bold">Добавить новое Аниме</a>
        </button>

    </div>
</section>

    <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    console.log(msg);
                    if (msg == "Save Success") {
        				Command: toastr["success"]("Аниме успешно добавлено!!")
        			} else if (msg == "Delete Success") {
        				Command: toastr["success"]("Аниме успешно удалено!!")
        			} else if (msg == "Delete Failure") {
        			    Command: toastr["error"]("Ошибка!!!")
        			} else if (msg == "Edit Success") {
        				Command: toastr["success"]("Аниме успешно изменено!!")
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

			<script>
				/* переключение темы */
				const toggleSwitch = document.querySelector(
						'.toggle-box input[type="checkbox"]'
				);
				const currentTheme = localStorage.getItem("theme");

				if (currentTheme) {
					document.documentElement.setAttribute("data-theme", currentTheme);

					if (currentTheme === "dark") {
						toggleSwitch.checked = true;
					}
				}

				function switchTheme(e) {
					if (e.target.checked) {
						document.documentElement.setAttribute("data-theme", "dark");
						localStorage.setItem("theme", "dark");
					} else {
						document.documentElement.setAttribute("data-theme", "light");
						localStorage.setItem("theme", "light");
					}
				}

				toggleSwitch.addEventListener("change", switchTheme, false);
				/* переключение темы */
			</script>
</body>

</html>