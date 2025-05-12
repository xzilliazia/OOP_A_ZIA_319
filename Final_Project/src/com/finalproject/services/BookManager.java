package com.finalproject.services;
import com.finalproject.dataBooks.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private final List<Books> bookList = new ArrayList<>();

    public void loadFromFile(String filePath) {
        bookList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // skip header
            String line;
            while ((line = reader.readLine()) != null) {
                Books book = parseLine(line);
                if (book != null) {
                    bookList.add(book);
                }
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("id,title,genre,stock,writer,contentType\n");
            for (Books book : bookList) {
                writer.write(toLine(book) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Gagal menulis file: " + e.getMessage());
        }
    }

    public void addBook(Books book) {
        bookList.add(book);
    }

    public void displayAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Belum ada buku.");
            return;
        }
        for (Books book : bookList) {
            book.info();
            System.out.println("----------------");
        }
    }

    public Books findByTitle(String title) {
        for (Books book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private Books parseLine(String line) {
        try {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String title = parts[1];
            String genre = parts[2];
            int stock = Integer.parseInt(parts[3]);
            String writer = parts[4];
            String contentType = parts[5];

            return new Books(id, title, genre, stock, writer, contentType);
        } catch (Exception e) {
            System.err.println("Format salah pada line: " + line);
            return null;
        }
    }

    private String toLine(Books book) {
        return book.getId() + "," +
               book.getTitle() + "," +
               book.getGenre() + "," +
               book.getStock() + "," +
               book.getWriter() + "," +
               book.getContenType();
    }

    public List<Books> getAllBooks() {
        return bookList;
    }
}
