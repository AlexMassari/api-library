package com.api.library.repository;

import com.api.library.entity.AuthorEntity;
import com.api.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, BigInteger> {

    @Query(value="select AU_ID, AU_NAME \n" +
            "from Authors where AU_ID =:authorId", nativeQuery=true)
    Optional<AuthorEntity> getAuthorById(@Param("authorId") BigInteger authorId);

    @Modifying
    @Query(value = "INSERT INTO Authors (AU_NAME) " +
            "VALUES (:authorName)", nativeQuery = true)
    void insertAuthor(@Param("authorName") String name);

    @Modifying
    @Query(value = "UPDATE Authors SET AU_NAME=:authorName WHERE AU_ID=:id", nativeQuery = true)
    void updateAuthor(@Param("authorName") String name,
                      @Param("id") BigInteger id);

    @Modifying
    @Query(value="DELETE FROM Authors WHERE AU_ID=:id", nativeQuery=true)
    void deleteAuthor(@Param("id") BigInteger id);
}
