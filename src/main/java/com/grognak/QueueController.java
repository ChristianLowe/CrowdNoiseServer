package com.grognak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by Chris on 12/3/2016.
 */

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/queue")
public class QueueController {
    YoutubeQueue youtubeQueue;

    public QueueController() {
        youtubeQueue = new YoutubeQueue();
    }

    @RequestMapping(method = RequestMethod.GET)
    List<String> getAll() {
        return youtubeQueue.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="next")
    String getNext(HttpServletResponse response) {
        try {
            return youtubeQueue.popIdentifier();
        } catch (NoSuchElementException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void postId(@RequestParam String id) {
        youtubeQueue.pushIdentifier(id);
    }

}
