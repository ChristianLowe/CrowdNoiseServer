package com.grognak;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Chris on 12/3/2016.
 */

public class YoutubeQueue {
    Queue<String> queue;

    public YoutubeQueue() {
        queue = new LinkedList<String>();
    }

    public void pushIdentifier(String identifier) {
        if (identifier.length() < 10 || identifier.length() > 12) {
            throw new IllegalArgumentException("Identifier must be between 10-12 characters in length");
        }

        queue.add(identifier);
    }

    public String popIdentifier() {
        return queue.remove();
    }

    public List<String> getAll() {
        ArrayList<String> identifiers = new ArrayList<>(queue.size());

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            identifiers.add((String)iterator.next());
        }

        return identifiers;
    }
}
