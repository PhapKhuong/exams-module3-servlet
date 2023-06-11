package com.database;

public class MyQuery {

    private MyQuery() {
    }

    public static final String SELECT_ALL_BOOK =
            "SELECT * FROM book";
    public static final String UPDATE_BOOK =
            "UPDATE book SET bookName = ?, author = ?, description = ?, quantity = ? WHERE bookId = ?";
    public static final String DELETE_ROOM =
            "DELETE FROM room WHERE roomId = ?";
    public static final String SEARCH_ROOM =
            "SELECT * FROM room INNER JOIN payment ON room.payId=payment.payId WHERE roomId LIKE ? OR name LIKE ? OR phone LIKE ?";
    public static final String SEARCH_PAYMENT =
            "SELECT * FROM payment WHERE payId = ?";
    public static final String SELECT_ALL_STUDENT =
            "SELECT * FROM student";
    public static final String CREATE_ROOM =
            "INSERT INTO room (name, phone, date, note, payId) VALUE (?, ?, ?, ?, ?)";
    public static final String SEARCH_STUDENT_BY_NAME =
            "SELECT * FROM student WHERE stuName LIKE ?";
    public static final String UPDATE_STUDENT =
            "UPDATE student SET stuName = ?, grade = ? WHERE stuId = ?";

    public static final String SELECT_ROOM =
            "SELECT * FROM room INNER JOIN payment ON room.payId=payment.payId ORDER BY roomId";
    public static final String SELECT_PAYMENT =
            "SELECT * FROM payment";
    public static final String INSERT_NEW_CARD =
            "INSERT INTO card (cardId, bookId, stuId, status, loanDate,returnDAte) VALUE (?,?,?,?,?,?)";
    public static final String UPDATE_CARD =
            "UPDATE card SET status = 0 WHERE cardId = ?";
    public static final String SEARCH_CARD =
            "SELECT * FROM (card INNER JOIN book ON card.bookId=book.bookId) INNER JOIN student ON card.stuId = student.stuId WHERE book.bookName LIKE ? AND student.stuName LIKE ?";
    public static final String DELETE_CARD =
            "DELETE FROM card WHERE cardId = ?";
    public static final String SELECT_BORROWED_BOOK =
            "SELECT book.bookId, book.bookName, book.author, book.description, count(book.bookId)\n" +
                    "FROM card INNER JOIN book ON card.bookId = book.bookId\n" +
                    "WHERE status = 1\n" +
                    "GROUP BY book.bookId\n" +
                    "ORDER BY book.bookId;";
}
