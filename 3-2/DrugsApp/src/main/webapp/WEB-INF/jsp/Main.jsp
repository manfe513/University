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


	<link rel="stylesheet" href="../css/style.css">
</head>

<body >

<header class="p-3 text-bg-dark">
	<div class="container-xxl">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
				<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
			</a>

			<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
				<li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
				<li><a href="#" class="nav-link px-2 text-white">Features</a></li>
				<li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
				<li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
				<li><a href="#" class="nav-link px-2 text-white">About</a></li>
			</ul>

			<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
				<input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
			</form>

			<div class="text-end">
				<button type="button" class="btn btn-outline-light me-2">Login</button>
				<button type="button" class="btn btn-warning">Sign-up</button>
			</div>
		</div>
	</div>
</header>

<%--<section id="content">--%>

<%--    <div class="container">--%>
<%--		<header class="p-3 text-bg-dark">--%>
<%--			<div class="container" >--%>
<%--				<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">--%>
<%--					<a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">--%>
<%--						<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>--%>
<%--					</a>--%>

<%--					<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">--%>
<%--						<li><a href="#" class="nav-link px-2 text-secondary">Главная</a></li>--%>
<%--						<li><a href="#" class="nav-link px-2 text-white">Справка</a></li>--%>
<%--					</ul>--%>

<%--					<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">--%>
<%--						<input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">--%>
<%--					</form>--%>

<%--					<div class="text-end">--%>
<%--						<button type="button" class="btn btn-outline-light me-2">Login</button>--%>
<%--						<button type="button" class="btn btn-warning">Sign-up</button>--%>
<%--					</div>--%>
<%--				</div>--%>
<%--			</div>--%>
<%--		</header>--%>

<%--        <h1 class="p-3">Курсы лекарств</h1>--%>
<%--        <div>--%>

<%--			<c:if test="${empty user}">--%>
<%--				   <button type="button" class="btn btn-outline-primary">--%>
<%--					   <a href="/auth" style="color: black; font-weight: bold">Авторизация</a>--%>
<%--				   </button>--%>
<%--			</c:if>--%>
<%--			<c:if test="${not empty user}">--%>
<%--				<jsp:useBean id="user" scope="request" type="com.example.drugs.model.User"/>--%>
<%--				<div>Пользователь: ${user.fullName}</div>--%>
<%--			</c:if>--%>

<%--&lt;%&ndash;            <c:choose>&ndash;%&gt;--%>
<%--&lt;%&ndash;               <c:when test="${empty user}">&ndash;%&gt;--%>
<%--&lt;%&ndash;				   <button type="button" class="btn btn-outline-primary">&ndash;%&gt;--%>
<%--&lt;%&ndash;					   <a href="/auth" style="color: black; font-weight: bold">Авторизация</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;				   </button>&ndash;%&gt;--%>
<%--&lt;%&ndash;			   </c:when> <!-- if condition -->&ndash;%&gt;--%>
<%--&lt;%&ndash;               <c:otherwise>Вы вошли, как </c:otherwise>    <!-- else condition -->&ndash;%&gt;--%>
<%--&lt;%&ndash;            </c:choose>&ndash;%&gt;--%>
<%--        </div>--%>

<%--		<div class="toggle-box">--%>
<%--		    <input type="checkbox" name="checkbox1" id="toggle-box-checkbox">--%>
<%--		    <label for="toggle-box-checkbox" class="toggle-box-label-left"></label>--%>
<%--		    <label for="toggle-box-checkbox" class="toggle-box-label"></label>--%>
<%--		</div>--%>

<%--        <form:form>--%>

<%--            <table class="table table-bordered">--%>
<%--            	<tr>--%>
<%--&lt;%&ndash;            		<th>Id</th>&ndash;%&gt;--%>
<%--            		<th>Название</th>--%>
<%--            		<th>Год</th>--%>
<%--            		<th>Редактировать</th>--%>
<%--            		<th>Удалить</th>--%>
<%--					<th>Где посмотреть</th>--%>
<%--					<th>Отзыв</th>--%>
<%--            	</tr>--%>

<%--            	<c:forEach var="anime" items="${animeList}">--%>
<%--&lt;%&ndash;--%>
<%--&lt;%&ndash;                		<td>${anime.id}</td>&ndash;%&gt;--%>
<%--                		<td style="font-weight: bold">${anime.name}</td>--%>
<%--                		<td style="font-weight: bold">${anime.year}</td>--%>
<%--                		<td><button type="button" class="btn btn-success">--%>
<%--                		    <a href="/editAnime/${anime.id} " style="color: black; font-weight: bold">Редактировать</a>--%>
<%--                		</button></td>--%>
<%--                		<td><button type="button" class="btn btn-danger">--%>
<%--                			<a href="/deleteAnime/${anime.id}" style="color: black; font-weight: bold">Удалить</a>--%>
<%--                		</button></td>--%>
<%--						<td><button type="button" class="btn btn-warning">--%>
<%--							<a href="https://yummyanime.org" target="_blank" style="color: black; font-weight: bold">Посмотреть на сайте</a>--%>
<%--						</button></td>--%>
<%--						<td><button type="button" class="btn btn-primary ">--%>
<%--							<a href="/reviewAnime/" style="color: black; font-weight: bold">Оставить отзыв</a>--%>
<%--						</button></td>--%>
<%--                	</tr>--%>

<%--            	</c:forEach>--%>

<%--            </table>--%>

<%--        </form:form>--%>

<%--        <button type="button" class="btn btn-info btn-block">--%>
<%--        	<a href="/addAnime" style="color: black; font-weight: bold">Добавить новое Аниме</a>--%>
<%--        </button>--%>

<%--    </div>--%>
<%--</section>--%>

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