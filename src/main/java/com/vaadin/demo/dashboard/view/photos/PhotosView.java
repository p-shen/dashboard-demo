package com.vaadin.demo.dashboard.view.photos;

import com.google.gson.Gson;
import com.vaadin.demo.dashboard.data.http.HttpRequestService;
import com.vaadin.demo.dashboard.domain.Flickr.Flickr;
import com.vaadin.demo.dashboard.domain.HttpRequest;
import com.vaadin.demo.dashboard.domain.Result;
import com.vaadin.demo.dashboard.event.DashboardEventBus;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.virkki.carousel.AbstractCarousel;
import org.vaadin.virkki.carousel.HorizontalCarousel;
import org.vaadin.virkki.carousel.client.widget.gwt.ArrowKeysMode;
import org.vaadin.virkki.carousel.client.widget.gwt.CarouselLoadMode;

import java.util.HashMap;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Peter on 2016-07-30.
 *
 * Display Flickr images in a carousel
 */
public class PhotosView extends VerticalLayout implements View {

    private final String source = "https://api.flickr.com/services/feeds/photos_public.gne?format=json";

    public PhotosView() {
        setSizeFull();
        addStyleName("photos");
        DashboardEventBus.register(this);

        Component carousel = buildCarousel();
        addComponent(carousel);
        setExpandRatio(carousel, 1);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }

    @Override
    public void forEach(Consumer<? super Component> action) {
    }

    @Override
    public Spliterator<Component> spliterator() {
        return null;
    }

    private Component buildCarousel() {
        final HorizontalCarousel carousel = new HorizontalCarousel();

        // Only react to arrow keys when focused
        carousel.setArrowKeysMode(ArrowKeysMode.FOCUS);
        // Fetch children lazily
        carousel.setLoadMode(CarouselLoadMode.LAZY);
        // Transition animations between the children run 500 milliseconds
        carousel.setTransitionDuration(500);

        addImagesToCarousel(carousel);

        carousel.setSizeFull();

        return carousel;
    }

    private boolean addImagesToCarousel(AbstractCarousel carousel) {

        try {
            Result result = getPhotosData();
            //remove "jsonFlickrFeed(" at the beginning
            //also remove ")" at the end
            String json = result.getResponse().substring(15, result.getResponse().length()-1);
            Flickr flickr = new Gson().fromJson(json, Flickr.class);

            flickr.getItems().stream().forEach(item -> {
                Image image = new Image();
                image.setSource(new ExternalResource(item.getMedia().getM()));
                image.setCaption(item.getTitle());
                image.setDescription(item.getDescription());
                image.setSizeFull();
                carousel.addComponent(image);
            });


        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            return true;
        }
    }

    private Result getPhotosData() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        HttpRequest request = new HttpRequest(HttpRequest.TYPE.GET, headers, source);
        Result result = HttpRequestService.request(request);

        return result;

    }
}

