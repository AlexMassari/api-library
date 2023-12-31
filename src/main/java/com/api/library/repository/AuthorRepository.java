package com.api.library.repository;

import com.api.library.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, BigInteger> {

    @Query(value="select AU_ID, AU_NAME \n" +
            "from Authors where AU_ID =:authorId", nativeQuery=true)
    Optional<AuthorEntity> getAuthorById(@Param("authorId") BigInteger authorId);

    @Query(value="select AU_ID, AU_NAME \n" +
            "from Authors where REPLACE(LOWER(TRIM(AU_NAME)), ' ', '') =  REPLACE(LOWER(TRIM(:authorName)), ' ', '')", nativeQuery=true)
    Optional<AuthorEntity> getAuthorByName(@Param("authorName") String authorName);

    @Query(value="select AU_ID, AU_NAME \n" +
            "from Authors", nativeQuery=true)
    List<AuthorEntity> listAuthors();

    @Modifying
    @Query(value = "INSERT INTO Authors (AU_NAME) " +
            "VALUES (:authorName)", nativeQuery = true)
    void insertAuthor(@Param("authorName") String authorName);

    @Modifying
    @Query(value = "UPDATE Authors SET AU_NAME=:authorName WHERE AU_ID=:authorId", nativeQuery = true)
    void updateAuthor(@Param("authorName") String authorName,
                      @Param("authorId") BigInteger authorId);

    @Modifying
    @Query(value="DELETE FROM Authors WHERE AU_ID=:authorId", nativeQuery=true)
    void deleteAuthor(@Param("authorId") BigInteger authorId);
}
