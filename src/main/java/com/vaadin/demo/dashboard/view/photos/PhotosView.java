package com.vaadin.demo.dashboard.view.photos;

import com.vaadin.demo.dashboard.data.http.HttpRequestService;
import com.vaadin.demo.dashboard.domain.HttpRequest;
import com.vaadin.demo.dashboard.domain.Result;
import com.vaadin.demo.dashboard.event.DashboardEventBus;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.virkki.carousel.HorizontalCarousel;
import org.vaadin.virkki.carousel.client.widget.gwt.ArrowKeysMode;
import org.vaadin.virkki.carousel.client.widget.gwt.CarouselLoadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Peter on 2016-07-30.
 */
public class PhotosView extends VerticalLayout implements View {

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

        getImageUrls().stream().forEach(url -> {
            Image image = new Image();
            image.setSource(new ExternalResource(url));
            carousel.addComponent(image);
        });

        carousel.setSizeFull();

        return carousel;
    }

    private List<String> getImageUrls() {
        List<String> imageUrls = new ArrayList<String>();

        //tester locations
        imageUrls.add("http://i.imgur.com/Z29NdOs.jpg");
        imageUrls.add("https://i.redd.it/3lv1qcqgvdcx.jpg");
        imageUrls.add("http://i.imgur.com/HfrGp2C.jpg");


        return imageUrls;
    }

    private static Result getPhotosData() {
        String url = "https://www.apple.com";
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        HttpRequest request = new HttpRequest(HttpRequest.TYPE.GET, headers, url);
        Result result = HttpRequestService.request(request);

        return result;

    }

    public static void main(String args[]){
        Result result = getPhotosData();
        System.out.println(result.getResponse());
    }
}

