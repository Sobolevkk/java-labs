package org.example.model;

import org.example.exception.InvalidMagazineDataException;
import org.example.exception.SubscriptionException;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Magazine {
    private String title;
    private String publisher;
    private int issueNumber;
    private int pages;
    private double price;
    private final Set<String> subscribers = new LinkedHashSet<>();


    public Magazine(String title, String publisher, int issueNumber,
                                  int pages, double price) throws InvalidMagazineDataException {
        setTitle(title);
        setPublisher(publisher);
        setIssueNumber(issueNumber);
        setPages(pages);
        setPrice(price);
    }

    public String getTitle() { return title; }
    public String getPublisher() { return publisher; }
    public int getIssueNumber() { return issueNumber; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }
    public Set<String> getSubscribers() { return Collections.unmodifiableSet(subscribers); }

    public void setTitle(String title) throws InvalidMagazineDataException {
        if (title == null || title.isBlank()) {
            throw new InvalidMagazineDataException(
                    "Название журнала не может быть пустым", "title", title);
        }
        this.title = title;
    }

    public void setPublisher(String publisher) throws InvalidMagazineDataException {
        if (publisher == null || publisher.isBlank()) {
            throw new InvalidMagazineDataException(
                    "Издатель не может быть пустым", "publisher", publisher);
        }
        this.publisher = publisher;
    }

    public void setIssueNumber(int issueNumber) throws InvalidMagazineDataException {
        if (issueNumber <= 0) {
            throw new InvalidMagazineDataException(
                    "Номер выпуска должен быть > 0", "issueNumber", issueNumber);
        }
        this.issueNumber = issueNumber;
    }

    public void setPages(int pages) throws InvalidMagazineDataException {
        if (pages <= 0) {
            throw new InvalidMagazineDataException(
                    "Количество страниц должно быть > 0", "pages", pages);
        }
        this.pages = pages;
    }

    public void setPrice(double price) throws InvalidMagazineDataException {
        if (price < 0) {
            throw new InvalidMagazineDataException(
                    "Цена не может быть отрицательной", "price", price);
        }
        this.price = price;
    }

    public void subscribe(String subscriber) {
        if (subscriber == null || subscriber.isBlank()) {
            throw new SubscriptionException(
                    "Имя подписчика не может быть пустым", subscriber, "SUBSCRIBE");
        }
        if (subscribers.contains(subscriber)) {
            throw new SubscriptionException(
                    "Подписчик уже подписан на журнал '" + title + "'", subscriber, "SUBSCRIBE");
        }
        subscribers.add(subscriber);
    }

    public void unsubscribe(String subscriber) {
        if (subscriber == null || subscriber.isBlank()) {
            throw new SubscriptionException(
                    "Имя подписчика не может быть пустым", subscriber, "UNSUBSCRIBE");
        }
        if (!subscribers.contains(subscriber)) {
            throw new SubscriptionException(
                    "Подписчик не найден в списке подписчиков журнала '" + title + "'",
                    subscriber, "UNSUBSCRIBE");
        }
        subscribers.remove(subscriber);
    }

    @Override
    public String toString() {
        return String.format(
                "Magazine{title='%s', publisher='%s', issue=%d, pages=%d, price=%.2f, subscribers=%d}",
                title, publisher, issueNumber, pages, price, subscribers.size());
    }
}