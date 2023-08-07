package com.api.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Book")
public class BookEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BK_ID")
    private BigInteger bookId;
    @Column(name = "BK_TITLE")
    private  String bookTitle;
    @Column(name="BK_AUTHOR")
    private BigInteger bookAuthor;
    @Column(name="BK_PUBLISHER")
    private BigInteger bookPublisher;
    @Column(name="BK_YEAR")
    private String bookYear;
    @Column(name="BK_GENRE")
    private String bookGenre;
    @Column(name="BK_AMOUNT")
    private int bookAmount;
}

