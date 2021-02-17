package hr.best.shortlinks.controller;

import hr.best.shortlinks.model.ShortLink;
import hr.best.shortlinks.service.ShortLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is part of API Layer of the application
 * It serves as a REST Controller for the ShortLink entity
 * It enables frontend to use HTTP GET, POST, PUT and DELETE requests
 * to alter the database
 */
@RestController
@RequestMapping(path = "api/v1/link")
public class ShortLinkController {

    @Autowired
    private final ShortLinkService shortLinkService;

    /**
     * Constructor injected dependency
     * @param shortLinkService
     */
    public ShortLinkController(ShortLinkService shortLinkService) {
        // note: shortLinkService is injected by spring, we do not need to make
        // new ShortLinkService() (and shouldn't) do it explicitly
        this.shortLinkService = shortLinkService;
    }

    /**
     * GET endpoint
     * Used by frontend for fetching data from the backend
     * @return ShortLink list - contains all the entries from the database
     */
    @GetMapping
    public List<ShortLink> getLinks() {
        return shortLinkService.getLinks();
    }

    /**
     * POST endpoint
     * Used by frontend for sending new entry to the backend
     * @param shortLink - entry to be saved, sent in the body
     *                  of the http request in JSON format
     */
    @PostMapping
    public void registerNewShortLink(@RequestBody ShortLink shortLink) {
        shortLinkService.addNewShortLink(shortLink);
    }

    /**
     * DELETE endpoint
     * Used by frontend to delete entry by id
     * @param shortLinkId - integer sent in the URI
     *                    of DELETE request
     */
    @DeleteMapping(path = "{shortLinkId}")
    public void deleteShortLink(@PathVariable("shortLinkId") Long shortLinkId) {
        shortLinkService.deleteShortLink(shortLinkId);
    }

    /**
     * PUT endpoint
     * Used for updating existing entry in the database
     * @param shortLinkId - integer id - sent in the path
     *                    this is onlt required parameter to send
     * @param name
     * @param siteUrl
     * @param shortenedUrl
     */
    @PutMapping(path = "{shortLinkId}")
    public void updateShortLink(
            @PathVariable("shortLinkId") Long shortLinkId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String siteUrl,
            @RequestParam(required = false) String shortenedUrl) {
        shortLinkService.updateShortLink(shortLinkId, name, siteUrl, shortenedUrl);
    }
}
