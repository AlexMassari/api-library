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
            "from Books where REPLACE(LOWER(TRIM(BK_TITLE)), ' ', '') =  REPLACE(LOWER(TRIM(:bookTitle)), ' ', '')", nativeQuery=true)
    Optional<BookEntity> findBookByTitle(@Param("bookTitle") String bookTitle);

    @Query(value="select BK_ID, BK_TITLE, BK_AUTHOR, BK_PUBLISHER, BK_YEAR, BK_GENRE, BK_AMOUNT \n" +
            "from Books where BK_AUTHOR =:authorId", nativeQuery=true)
    List<BookEntity> findByAuthorId(BigInteger authorId);

    @Query(value="select BK_ID, BK_TITLE, BK_AUTHOR, BK_PUBLISHER, BK_YEAR, BK_GENRE, BK_AMOUNT \n" +
            "from Books where BK_PUBLISHER =:publisherId", nativeQuery=true)
    List<BookEntity> findByPublisherId(BigInteger publisherId);

    @Query(value="select BK_ID, BK_TITLE, BK_AUTHOR, BK_PUBLISHER, BK_YEAR, BK_GENRE, BK_AMOUNT \n" +
            "from Books", nativeQuery=true)
    List<BookEntity> listBooks();

    @Modifying
    @Query(value = "INSERT INTO Books (BK_TITLE, BK_AUTHOR, BK_PUBLISHER, BK_YEAR, BK_GENRE, BK_AMOUNT) " +
            "VALUES (:title, :authorId, :publisherId, :year, :genre, :amount)", nativeQuery = true)
    void insertBook(@Param("title") String title,
                    @Param("authorId") BigInteger authorId,
                    @Param("publisherId") BigInteger publisherId,
                    @Param("year") String year,
                    @Param("genre") String genre,
                    @Param("amount") int amount);

    @Modifying
    @Query(value = "UPDATE Books SET BK_TITLE=:title, BK_AUTHOR=:authorId, BK_PUBLISHER=:publisherId, BK_YEAR=:year, " +
            "BK_GENRE=:genre, BK_AMOUNT=:amount WHERE BK_ID=:id", nativeQuery = true)
    void updateBook(@Param("title") String title,
                    @Param("authorId") BigInteger authorId,
                    @Param("publisherId") BigInteger publisherId,
                    @Param("year") String year,
                    @Param("genre") String genre,
                    @Param("amount") int amount,
                    @Param("id") BigInteger id);

    @Modifying
    @Query(value="DELETE FROM Books WHERE BK_ID=:bookId", nativeQuery = true)
    void deleteBook(@Param("bookId") BigInteger bookId);

}
