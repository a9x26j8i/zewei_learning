package com.how2j.new_feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLearning {
    static final String[] publishers = new String[] {"A", "A", "C", "B", "C"};
    static final String[] authors = new String[] {"zz", "qq", "qq", "rr", "zz"};

    public static void main(String[] args) {
        LambdaLearning l = new LambdaLearning();
        Book[] books = l.makeBook(publishers, authors);
        List<Book> bookList = Arrays.asList(books);

        bookList.get(0).price = 100;
        bookList.get(2).price = 200;

        List<Book> result = l.filter(bookList, book -> book.price > 10);

        l.forEach(result, book -> System.out.println(book));

        System.out.println(l.map(result, book -> book.price));
    }

    //Consumer：执行者
    private <T> void  forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    //Function: 需要返回值
    private <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(f.apply(t));
        }

        return result;
    }

    private List<Book> filter(List<Book> books, Predicate<Book> bookPredicate) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (bookPredicate.test(book)) {
                result.add(book);
            }
        }

        return result;
    }

    private List<Book> filterByPublisher(List<Book> books, String publisher) {
        List<Book> result = new ArrayList<Book>();

        for (Book book : books) {
            if (publisher.equals(book.publisher)) {
                result.add(book);
            }
        }

        return result;
    }
    private Book[] makeBook(String[] publishers, String[] authors) {
        int n = publishers.length;
        int m = authors.length;
        if (n != m) {
            throw new IllegalArgumentException("inconsistent length");
        }
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            books[i] = new Book(publishers[i], authors[i]);
        }
        return books;
    }
}

interface BookPredicate {
    public boolean test(Book book);
}

class Book {
    public String publisher;
    public String author;
    public int price;

    public Book(String publisher, String author) {
        this.publisher = publisher;
        this.author = author;
        this.price = 10;
    }

    @Override
    public String toString() {
        return "publisher:" + publisher + " " + "author:" + author + " price:" + price;
    }
}
