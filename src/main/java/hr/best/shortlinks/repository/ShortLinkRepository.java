package hr.best.shortlinks.repository;

import hr.best.shortlinks.model.ShortLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkRepository extends JpaRepository<ShortLink, Long> {

}
