package com.controller;

import com.bean.Payment;
import com.bean.Room;
import com.exception.ValidateException;
import com.regex.MyRegex;
import com.service.impl.PaymentServiceImpl;
import com.service.impl.RoomServiceImpl;
import com.service.itf.PaymentService;
import com.service.itf.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "libraryServlet", value = "/exams")
public class RoomServlet extends HttpServlet {
    RoomService roomService = new RoomServiceImpl();
    PaymentService paymentService = new PaymentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showList(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> rooms = roomService.display();
        req.setAttribute("rooms", rooms);
        req.getRequestDispatcher("WEB-INF/view/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "search":
                doSearch(req, resp);
                break;
            case "initCreate":
                doInitCreate(req, resp);
                break;
            case "create":
                doCreate(req, resp);
                break;
            case "delete":
                doDel(req, resp);
                break;
            case "delMany":
                doDelMany(req, resp);
                break;
            default:
                break;
        }
    }

    private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("searchByID");
        List<Room> rooms = roomService.search(str);
        req.setAttribute("rooms", rooms);
        req.getRequestDispatcher("WEB-INF/view/home.jsp").forward(req, resp);
    }

    private void doInitCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Payment> payments = paymentService.display();
        req.setAttribute("payments", payments);
        req.getRequestDispatcher("WEB-INF/view/create.jsp").forward(req, resp);
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            if (!name.matches(MyRegex.REGEX_NAME)) {
                throw new ValidateException();
            }

            String phone = req.getParameter("phone");
            if (!phone.matches(MyRegex.REGEX_PHONE_NUMBER)) {
                throw new ValidateException();
            }

            LocalDate date = LocalDate.parse(req.getParameter("date"));

            int payId = Integer.parseInt(req.getParameter("payment"));
            Payment payment = paymentService.search(payId);

            String note = req.getParameter("note");

            Room room = new Room(name, phone, date, payment, note);
            roomService.create(room);
            resp.sendRedirect("/exams");
        } catch (ValidateException e) {
            String errorMsg = "Dữ liệu chưa đúng định dạng";
            req.setAttribute("error", errorMsg);
            req.getRequestDispatcher("WEB-INF/view/create.jsp").forward(req, resp);
        }
    }

    private void doDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        roomService.delete(roomId);
        resp.sendRedirect("/exams");
    }

    private void doDelMany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] roomIdAsString = req.getParameterValues("choose");
        for (String str : roomIdAsString) {
            roomService.delete(Integer.parseInt(str));
        }
        resp.sendRedirect("/exams");
    }
}
