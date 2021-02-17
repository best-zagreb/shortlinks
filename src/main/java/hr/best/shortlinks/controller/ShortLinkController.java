package hr.best.shortlinks.controller;

import hr.best.shortlinks.model.ShortLink;
import hr.best.shortlinks.service.ShortLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewShortLink(@RequestBody ShortLink shortLink) {
        shortLinkService.addNewShortLink(shortLink);
    }

    @DeleteMapping(path = "{shortLinkId}")
    public void deleteShortLink(@PathVariable("shortLinkId") Long shortLinkId) {
        shortLinkService.deleteShortLink(shortLinkId);
    }

    @PutMapping(path = "{shortLinkId}")
    public void updateShortLink(
            @PathVariable("shortLinkId") Long shortLinkId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String siteUrl,
            @RequestParam(required = false) String shortenedUrl) {
        shortLinkService.updateShortLink(shortLinkId, name, siteUrl, shortenedUrl);
    }
}
