package hr.best.shortlinks.controller;

import hr.best.shortlinks.model.ShortLink;
import hr.best.shortlinks.service.ShortLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/link")
public class ShortLinkController {

    @Autowired
    private final ShortLinkService shortLinkService;

    public ShortLinkController(ShortLinkService shortLinkService) {
        this.shortLinkService = shortLinkService;
    }

    @GetMapping
    public List<ShortLink> getLinks() {
        return shortLinkService.getLinks();
    }
}
