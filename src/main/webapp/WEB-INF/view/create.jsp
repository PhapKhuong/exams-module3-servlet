<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 25-May-23
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrow</title>
    <link rel="stylesheet" href="/asset/library_style.css">
    <link rel="stylesheet" href="/asset/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Thêm phòng cho thuê</h2>
    <c:if test="${error!=null}">
        <h3 id="popup">${error}</h3>
    </c:if>

    <c:if test="${error==null}">
        <form action="/exams" method="post">
            <table class="table">
                <tbody>
                <input type="hidden" name="action" value="create">
                <tr class="col">
                    <td>Tên người thuê:</td>
                    <td><input type="text" name="name" required/></td>
                </tr>
                <tr class="col">
                    <td>Số điện thoại:</td>
                    <td><input type="text" name="phone" required/></td>
                </tr>
                <tr class="col">
                    <td>Ngày bắt đầu thuê:</td>
                    <td><input type="date" name="date" required></td>
                </tr>
                <tr class="col">
                    <td>Kiểu thanh toán</td>
                    <td>
                        <select class="form-control" name="payment">
                            <c:forEach items="${payments}" var="payment">
                                <option value="${payment.payId}">${payment.payName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="col">
                    <td>Ghi chú:</td>
                    <td><input type="text" name="note"/></td>
                </tr>
                </tbody>
            </table>
            <div>
                <a href="/library" class="btn btn-secondary">Cancel</a>
                <input type="submit" class="btn btn-secondary" value="OK">
            </div>
        </form>
    </c:if>


</div>
</body>
<script src="/asset/bootstrap.bundle.min.js"></script>
<script src="/asset/book.js"></script>
<script src="/asset/cards.js"></script>
<script src="/asset/room.js"></script>
</html>
