package org.example.service;

import org.example.exception.InvalidMagazineDataException;
import org.example.exception.MagazineNotFoundException;
import org.example.model.Magazine;

import java.util.ArrayList;
import java.util.List;

public class MagazineService {
    private final List<Magazine> magazines = new ArrayList<>();

    public void addMagazine(Magazine magazine) throws InvalidMagazineDataException {
        if (magazine == null) {
            throw new InvalidMagazineDataException(
                    "Журнал не может быть null", "magazine", null);
        }
        boolean exists = magazines.stream().anyMatch(m ->
                m.getTitle().equalsIgnoreCase(magazine.getTitle())
                        && m.getIssueNumber() == magazine.getIssueNumber());
        if (exists) {
            throw new InvalidMagazineDataException(
                    "Журнал с таким названием и номером выпуска уже существует",
                    "title+issueNumber",
                    magazine.getTitle() + "#" + magazine.getIssueNumber());
        }
        magazines.add(magazine);
    }

    public Magazine findByTitleAndIssue(String title, int issueNumber)
            throws MagazineNotFoundException {
        if (title == null || title.isBlank()) {
            throw new MagazineNotFoundException("Название не задано", title);
        }
        return magazines.stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title)
                        && m.getIssueNumber() == issueNumber)
                .findFirst()
                .orElseThrow(() -> new MagazineNotFoundException(
                        "Журнал '" + title + "' выпуск #" + issueNumber + " не найден",
                        title));
    }

    public void subscribe(String title, int issueNumber, String subscriber)
            throws MagazineNotFoundException {
        Magazine m = findByTitleAndIssue(title, issueNumber);
        m.subscribe(subscriber);
    }

    public void unsubscribe(String title, int issueNumber, String subscriber)
            throws MagazineNotFoundException {
        Magazine m = findByTitleAndIssue(title, issueNumber);
        m.unsubscribe(subscriber);
    }

    public List<Magazine> getAll() { return new ArrayList<>(magazines); }
    public int size() { return magazines.size(); }
}