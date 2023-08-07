package com.api.library.repository;

import com.api.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, BigInteger> {

    @Query(value="select BK_ID, BK_TITLE, BK_AUTHOR, BK_PUBLISHER, BK_YEAR, BK_GENRE, BK_AMOUNT \n" +
            "from Books where BK_ID =:bookId", nativeQuery=true)
    Optional<BookEntity> findBookById(@Param("bookId") BigInteger bookId);

    @Query(value="select BK_ID, BK_TITLE, BK_AUTHOR, BK_PUBLISHER, BK_YEAR, BK_GENRE, BK_AMOUNT \n" +
            "from Books where BK_TITLE =:bookTitle", nativeQuery=true)
    Optional<BookEntity> findBookByTitle(@Param("bookTitle") String bookTitle);

    @Query(value="select BK_ID, BK_TITLE, BK_AUTHOR, BK_PUBLISHER, BK_YEAR, BK_GENRE, BK_AMOUNT \n" +
            "from Books where BK_AUTHOR =:authorId", nativeQuery=true)
    List<BookEntity> findByAuthorId(BigInteger authorId);

    @Modifying
    @Query(value = "INSERT INTO Books (BK_TITLE, BK_AUTHOR, BK_PUBLISHER, BK_YEAR, BK_GENRE, BK_AMOUNT) " +
            "VALUES (:title, :author, :publisher, :year, :genre, :amount)", nativeQuery = true)
    void insertBook(@Param("title") String title,
                    @Param("author") BigInteger author,
                    @Param("publisher") BigInteger publisher,
                    @Param("year") String year,
                    @Param("genre") String genre,
                    @Param("amount") int amount);

}