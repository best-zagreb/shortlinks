package hr.best.shortlinks.repository;

import hr.best.shortlinks.model.ShortLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is the data access layer of the application
 * It extends JpaRepository which provides basic operations
 * on the database table (no need to write baseic SQL queries)
 */
@Repository
public interface ShortLinkRepository extends JpaRepository<ShortLink, Long> {

    //@Query("SELECT s FROM shortlink s WHERE s.outcomingUrl = ?1 ")
    Optional<ShortLink> findShortLinkByShortenedUrl(String outcomingUrl);
}
