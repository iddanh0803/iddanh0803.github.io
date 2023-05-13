package entity;

import java.time.LocalDate;
import java.util.Date;

public class Ticket {
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate payDate;

    public Ticket(User user, Book book, LocalDate loanDate, LocalDate payDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.payDate = payDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user +
                ", book=" + book +
                ", loanDate=" + loanDate +
                ", payDate=" + payDate +
                '}';
    }
}
