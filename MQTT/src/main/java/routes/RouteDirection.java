package routes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.MapboxDirections;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Point;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class RouteDirection {

    public static void simpleMapboxDirectionsRequest() throws IOException {

        MapboxDirections client = MapboxDirections.builder()
                .origin(Point.fromLngLat(-6.989,33.733))
                .destination(Point.fromLngLat(-6,34.733))
                .profile(DirectionsCriteria.PROFILE_DRIVING)
                .accessToken("pk.eyJ1IjoiaW5lc3JhIiwiYSI6ImNqdG9qNDZzMzA0bXY0NHBuYmY3NnEwMjYifQ.-F9lOc44wMnQuiHyFU0zvA")
                .overview(DirectionsCriteria.OVERVIEW_FULL)
                .build();


        Response<DirectionsResponse> response = client.executeCall();
        System.out.println(response.body().routes().get(0).geometry());



    }
}

