package hr.best.shortlinks.service;

import hr.best.shortlinks.model.ShortLink;
import hr.best.shortlinks.repository.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
