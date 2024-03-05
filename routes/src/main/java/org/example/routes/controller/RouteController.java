package org.example.routes.controller;

import org.example.routes.model.Route;
import org.example.routes.model.RouteObj;
import org.example.routes.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/transportroutes/*")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/route/{start}/{end}/{transportType}")
    public RouteObj getRoute(@PathVariable String start, @PathVariable String end, @PathVariable String transportType) {
        List<Route> routes = routeService.getRoute(start, end, transportType);
        RouteObj obj = new RouteObj();
        obj.setRoutes(routes);
        return obj;
    }

    /*@GetMapping("/route/{transportType}")
    public RouteObj getRoutesByTransportType(@PathVariable String transportType) {
        List<Route> routes = routeService.getRoutesByTransportType(transportType);
        RouteObj obj = new RouteObj();
        obj.setRoutes(routes);
        return obj;
    }*/



}
