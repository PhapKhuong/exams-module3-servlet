<%@ page import="com.bean.Payment" %>
<%@ page import="com.service.itf.PaymentService" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 24-May-23
  Time: 2:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/asset/bootstrap.min.css">
    <link rel="stylesheet" href="/asset/library_style.css">
</head>
<body>
<div class="container">
    <!--TẠO THANH MENU TRÊN ĐẦU-->
    <div id="menu">
        <div id="position-menu">
            <a href="/exams">Room</a>
        </div>
    </div>
    <!--KẾT THÚC-->

    <!--TẠO THÂN TRANG-->
    <div id="body-page">

        <!--PHẦN NỘI DUNG CỦA ROOM-->
        <div class="content">

            <!--NỘI DUNG CHÍNH CỦA ROOM-->
            <div class="main-content">
                <div class="popup">
                    <c:if test="${error!=null}">
                        <h3>${error}</h3>
                    </c:if>
                </div>

                <!--FORM TÌM KIẾM ROOM-->
                <form class="d-flex" action="/exams" method="post">
                    <input type="hidden" name="action" value="search">
                    <input class="form-control me-2" type="search" placeholder="Search by ID, name or phone"
                           aria-label="Search"
                           name="searchByID">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <form action="/exams" method="post">
                    <input type="hidden" name="action" value="initCreate">
                    <input type="submit" class="btn btn-primary" value="Create">
                </form>

                <!--PHẦN HIỂN THỊ BẢNG ROOM-->
                <h2>Danh sách thuê trọ</h2>
                <form action="/exams" method="post">
                    <input type="hidden" name="action" value="delMany">
                    <table class="table">
                        <thread>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Mã phòng trọ</th>
                                <th scope="col">Tên người thuê trọ</th>
                                <th scope="col">SĐT</th>
                                <th scope="col">Ngày bắt đầu</th>
                                <th scope="col">Ghi chú</th>
                                <th scope="col">Thanh toán</th>
                                <th scope="col">
                                </th>
                            </tr>
                        </thread>
                        <tbody>
                        <c:forEach items="${rooms}" var="room">

                            <tr class="col">
                                <td>
                                    <input type="checkbox" name="choose" value=${room.roomId}>
                                </td>
                                <td>${room.roomId}</td>
                                <td>${room.name}</td>
                                <td>${room.phone}</td>
                                <td>
                                    <fmt:parseDate value="${room.date}" pattern="yyyy-MM-dd" type="date"
                                                   var="parseDate"/>
                                    <fmt:formatDate value="${parseDate}" pattern="dd/MM/yyyy"/>
                                </td>
                                <td>${room.note}</td>
                                <td>${room.payment.getPayName()}</td>
                                <td>
                                    <button
                                            type="button"
                                            class="btn btn-primary"
                                            data-bs-toggle="modal"
                                            data-bs-target="#delRoomModal"
                                            data-bs-roomId="${room.roomId}">
                                        Del
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <input type="submit" class="btn btn-secondary" value="OK">
                </form>
                <div class="modal fade"
                     id="delRoomModal"
                     tabindex="-1"
                     aria-labelledby="delRoomModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="delRoomModalLabel">Xóa phòng cho thuê này</h5>
                                <button type="button"
                                        class="btn-close"
                                        data-bs-dismiss="modal"
                                        aria-label="Close">
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="/exams" method="post">
                                    <input type="hidden" name="action" value="delete">
                                    <div class="mb-3">
                                        <input type="hidden" class="form-control" id="roomId" name="roomId"/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Close
                                        </button>
                                        <input type="submit" class="btn btn-secondary" value="OK">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/asset/bootstrap.bundle.min.js"></script>
<script src="/asset/book.js"></script>
<script src="/asset/room.js"></script>
<script src="/asset/cards.js"></script>
</html>
