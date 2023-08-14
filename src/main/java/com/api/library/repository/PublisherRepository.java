package com.api.library.repository;

import com.api.library.entity.AuthorEntity;
import com.api.library.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, BigInteger> {
    @Query(value="select PB_ID, PB_NAME \n" +
            "from Publishers where PB_ID =:publisherId", nativeQuery=true)
    Optional<PublisherEntity> getPublisherIdById(@Param("publisherId") BigInteger publisherId);

    @Query(value="select PB_ID, PB_NAME \n" +
            "from Publishers where REPLACE(LOWER(TRIM(PB_NAME)), ' ', '') =  REPLACE(LOWER(TRIM(:publisherName)), ' ', '')", nativeQuery=true)
    Optional<PublisherEntity> getPublisherByName(@Param("publisherName") String authorId);

    @Modifying
    @Query(value = "INSERT INTO Publishers (PB_NAME) " +
            "VALUES (:publisherName)", nativeQuery = true)
    void insertPublisher(@Param("publisherName") String name);

    @Modifying
    @Query(value = "UPDATE Publishers SET PB_NAME=:publisherName WHERE PB_ID=:id", nativeQuery = true)
    void updatePublisher(@Param("publisherName") String name,
                      @Param("id") BigInteger id);

    @Modifying
    @Query(value="DELETE FROM Publishers WHERE PB_NAME=:id", nativeQuery=true)
    void deletePublisher(@Param("id") BigInteger id);
}
