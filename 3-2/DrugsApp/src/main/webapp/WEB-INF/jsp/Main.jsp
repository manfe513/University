<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<%@include file="../template/head.jsp" %>

<body>

<section id="content">

    <div class="container">

        <h1 class="p-3">Курсы лекарств</h1>

        <form:form>

            <table class="table table-bordered">
                <tr>

                    <th>Препарат</th>
                    <th>Способ приёма</th>
                    <th>Время приёма</th>
                    <th>Удалить</th>
                    <th>Начало курса</th>
                    <th>Окончание курса</th>
                </tr>

                <jsp:useBean id="courses" scope="application" type="com.example.drugs.model.Course"/>
                <c:forEach var="course" items="${courses}">
                                    		<td style="font-weight: bold">${course.}</td>
                    <%--                		<td style="font-weight: bold">${anime.year}</td>--%>
<%--                    <td>--%>
<%--                        <button type="button" class="btn btn-success">--%>
<%--                            <a href="/editAnime/${anime.id} " style="color: black; font-weight: bold">Редактировать</a>--%>
<%--                        </button>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <button type="button" class="btn btn-danger">--%>
<%--                            <a href="/deleteAnime/${anime.id}" style="color: black; font-weight: bold">Удалить</a>--%>
<%--                        </button>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <button type="button" class="btn btn-warning">--%>
<%--                            <a href="https://yummyanime.org" target="_blank" style="color: black; font-weight: bold">Посмотреть--%>
<%--                                на сайте</a>--%>
<%--                        </button>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <button type="button" class="btn btn-primary ">--%>
<%--                            <a href="/reviewAnime/" style="color: black; font-weight: bold">Оставить отзыв</a>--%>
<%--                        </button>--%>
<%--                    </td>--%>
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
    window.onload = function () {

        const msg = "${message}";
        console.log(msg);
        if (msg === "save_success") {
            toastr["success"]("Успешно добавлено!!")
        } else if (msg == "delete_success") {
            toastr["success"]("Успешно удалено!!")
        } else if (msg == "delete_error") {
            toastr["error"]("Ошибка!!!")
        } else if (msg == "edit_success") {
            toastr["success"]("Успешно изменено!!")
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