package hr.best.shortlinks.service;

import hr.best.shortlinks.model.ShortLink;
import hr.best.shortlinks.repository.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShortLinkService {

    private final ShortLinkRepository shortLinkRepository;

    @Autowired
    public ShortLinkService(ShortLinkRepository shortLinkRepository) {
        this.shortLinkRepository = shortLinkRepository;
    }


    public List<ShortLink> getLinks() {
        return shortLinkRepository.findAll();
    }

    public void addNewShortLink(ShortLink shortLink) {
        Optional<ShortLink> shortLinkOptional = shortLinkRepository.findShortLinkByShortenedUrl(shortLink.getShortenedUrl());
        if(shortLinkOptional.isPresent()){
            throw new IllegalStateException("this url is taken");
        }
        shortLinkRepository.save(shortLink);
    }

    public void deleteShortLink(Long shortLinkId) {
        boolean exists = shortLinkRepository.existsById(shortLinkId);
        if (!exists) {
            throw new IllegalStateException(
                    "url with id " + shortLinkId + " does not exist."
            );
        }
        shortLinkRepository.deleteById(shortLinkId);
    }

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
