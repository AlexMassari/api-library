package com.api.library.repository;

import com.api.library.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, BigInteger> {
    @Query(value="select PB_ID, PB_NAME \n" +
            "from Publishers where PB_ID =:publisherId", nativeQuery=true)
    Optional<PublisherEntity> getPublisherIdById(@Param("publisherId") BigInteger publisherId);

    @Query(value="select PB_ID, PB_NAME \n" +
            "from Publishers where REPLACE(LOWER(TRIM(PB_NAME)), ' ', '') =  REPLACE(LOWER(TRIM(:publisherName)), ' ', '')", nativeQuery=true)
    Optional<PublisherEntity> getPublisherByName(@Param("publisherName") String publisherName);

    @Query(value="select PB_ID, PB_NAME \n" +
            "from Publishers", nativeQuery=true)
    List<PublisherEntity> listPublishers();

    @Modifying
    @Query(value = "INSERT INTO Publishers (PB_NAME) " +
            "VALUES (:publisherName)", nativeQuery = true)
    void insertPublisher(@Param("publisherName") String publisherName);

    @Modifying
    @Query(value = "UPDATE Publishers SET PB_NAME=:publisherName WHERE PB_ID=:publisherId", nativeQuery = true)
    void updatePublisher(@Param("publisherName") String publisherName,
                      @Param("publisherId") BigInteger publisherId);

    @Modifying
    @Query(value="DELETE FROM Publishers WHERE PB_ID=:publisherId", nativeQuery=true)
    void deletePublisher(@Param("publisherId") BigInteger publisherId);
}
