package com.toanngo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.toanngo.app.models.Artist;

@Repository
@Component
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
