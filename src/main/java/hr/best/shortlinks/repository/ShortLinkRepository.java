package hr.best.shortlinks.repository;

import hr.best.shortlinks.model.ShortLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortLinkRepository extends JpaRepository<ShortLink, Long> {

    //@Query("SELECT s FROM shortlink s WHERE s.outcomingUrl = ?1 ")
    Optional<ShortLink> findShortLinkByShortenedUrl(String outcomingUrl);
}
