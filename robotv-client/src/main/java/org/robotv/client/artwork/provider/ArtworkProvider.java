package org.robotv.client.artwork.provider;

import org.robotv.client.artwork.ArtworkHolder;
import org.robotv.client.model.Event;

import java.io.IOException;

public abstract class ArtworkProvider {

    protected abstract ArtworkHolder searchMovie(Event event) throws IOException;

    protected abstract ArtworkHolder searchTv(Event event) throws IOException;

    public ArtworkHolder search(Event event) throws IOException {
        // search tv series
        if(event.getContentId() == 0x17 || event.getGenre() == 0x40 || event.getContentId() == 0x24) {
            return searchTv(event);
        }
        // search movies
        else if(event.getGenre() == 0x10 || event.getGenre() == 0x70) {
            return searchMovie(event);
        }

        return null;
    }

}
