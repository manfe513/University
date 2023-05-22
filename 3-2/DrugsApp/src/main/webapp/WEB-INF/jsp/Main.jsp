<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
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
                    <th>Начало курса</th>
                    <th>Окончание курса</th>
                    <th>Редактировать</th>
                    <th>Удалить</th>
                </tr>

                <tr>
<%--                    <jsp:useBean id="courseInfos" scope="session" type="java.util.ArrayList<com.example.drugs.model.CourseInfo>"/>--%>
                    <c:forEach var="courseInfo" items="${courseInfos}">
                    <td>${courseInfo.drug.name}</td>
                    <td>${courseInfo.useType.name}</td>
                    <td>${courseInfo.course.time}</td>
                    <td>${courseInfo.course.date_start}</td>
                    <td>${courseInfo.course.date_end}</td>
                    <td>
                        <button type="button" class="btn btn-success">
                            <a href="/editCourse/${courseInfo.course.id} " style="color: black; font-weight: bold">Редактировать</a>
                        </button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger">
                            <a href="/deleteCourse/${courseInfo.course.id}" style="color: black; font-weight: bold">Удалить</a>
                        </button>
                    </td>
                </tr>

                </c:forEach>

            </table>

        </form:form>

        <button type="button" class="btn btn-info btn-block">
            <a href="/addCourse" style="color: black; font-weight: bold">Добавить новый курс</a>
        </button>

    </div>
</section>

<script th:inline="javascript">
    window.onload = function () {

        const msg = "${message}";
        console.log(msg);
        if (msg === "save_success") {
            toastr["success"]("Успешно добавлено")

        } else if (msg === "delete_success") {
            toastr["success"]("Успешно удалено")

        } else if (msg === "delete_error") {
            toastr["error"]("Ошибка удаления")

        } else if (msg === "edit_success") {
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