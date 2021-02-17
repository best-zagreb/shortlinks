package hr.best.shortlinks.service;

import hr.best.shortlinks.model.ShortLink;
import hr.best.shortlinks.repository.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class is part of the Service layer of the Spring
 * application, all the bussiness logic should be written here
 *
 */
@Service
public class ShortLinkService {

    // Repository object
    private final ShortLinkRepository shortLinkRepository;

    /**
     * Spring is injecting repository, (data access layer)
     * by this constructor
     * @param shortLinkRepository - spring will find and
     *                            inject this dependency
     */
    @Autowired
    public ShortLinkService(ShortLinkRepository shortLinkRepository) {
        this.shortLinkRepository = shortLinkRepository;
    }


    /**
     * retrieves all entries from the database
     * @return List<ShortLink>
     */
    public List<ShortLink> getLinks() {
        return shortLinkRepository.findAll();
    }

    /**
     * Writes new entry to the database if
     * that shortened url is not already taken
     * @param shortLink
     */
    public void addNewShortLink(ShortLink shortLink) {
        Optional<ShortLink> shortLinkOptional = shortLinkRepository.findShortLinkByShortenedUrl(shortLink.getShortenedUrl());
        if(shortLinkOptional.isPresent()){
            throw new IllegalStateException("this url is taken");
        }
        shortLinkRepository.save(shortLink);
    }

    /**
     * Deletes entry with given id from the database
     * if it exists
     * @param shortLinkId
     */
    public void deleteShortLink(Long shortLinkId) {
        boolean exists = shortLinkRepository.existsById(shortLinkId);
        if (!exists) {
            throw new IllegalStateException(
                    "url with id " + shortLinkId + " does not exist."
            );
        }
        shortLinkRepository.deleteById(shortLinkId);
    }

    /**
     * Transactional annotation means that this bean is in Hibernate
     * managed state, which means that user doesen't have to query
     * the database to save the canges explicitly.
     *
     * Method will find entry by id if it exists
     * and after that perform various checks on each field
     * before saving them
     *
     * @param shortLinkId
     * @param name
     * @param siteUrl
     * @param shortenedUrl
     */
    @Transactional
    public void updateShortLink(Long shortLinkId, String name, String siteUrl, String shortenedUrl) {
        ShortLink shortLink = shortLinkRepository.findById(shortLinkId)
                .orElseThrow(() -> new IllegalStateException("URL with id " + shortLinkId + " does not exist!"));

        if (name != null &&
            name.length() > 0 &&
            !Objects.equals(shortLink.getName(), name)) {
            shortLink.setName(name);
        }

        if (siteUrl != null &&
            siteUrl.length() > 0 &&
            !Objects.equals(shortLink.getSiteUrl(), siteUrl)) {
            shortLink.setSiteUrl(siteUrl);
        }

        if (shortenedUrl != null &&
            shortenedUrl.length() > 0 &&
            !Objects.equals(shortLink.getShortenedUrl(), shortenedUrl)) {
            Optional<ShortLink> shortLinkOptional = shortLinkRepository.findShortLinkByShortenedUrl(shortenedUrl);
            if(shortLinkOptional.isPresent()){
                throw new IllegalStateException("URI is already taken!");
            }
            shortLink.setShortenedUrl(shortenedUrl);
        }
    }

}
