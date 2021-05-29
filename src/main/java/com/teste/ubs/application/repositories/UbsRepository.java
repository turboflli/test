package com.teste.ubs.application.repositories;

import com.teste.ubs.application.model.UbsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;

public interface UbsRepository  extends PagingAndSortingRepository<UbsEntity, Long> {

    @Query(value = "SELECT u.* FROM ubs u order by sqrt( ( abs(u.lon - :lon) * abs(u.lon - :lon) ) + ( abs(u.lat - :lat) * abs(u.lat - :lat) ) ) ", nativeQuery=true) //distance(u.lon, u.lat, :lon, :lat)
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    Page<UbsEntity> findByDistance(@Param("lon") double lon, @Param("lat") double lat, Pageable pageable);

}
