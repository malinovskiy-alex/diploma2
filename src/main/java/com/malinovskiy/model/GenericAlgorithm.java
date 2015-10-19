package com.malinovskiy.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.*;

/**
 * Created by Александр on 10.11.2014.
 */
class GenericAlgorithm {
    private static final double EARTH_RADIUS = 6371; // Радиус Земли
    // public static final String GOOGLE_API = "http://maps.googleapis.com"
    public static final int POPULATION_SIZE = 800;
    public static final double ELITE_RATE = 0.1;
    public static final double SURVIVE_RATE = 0.5;
    public static final double MUTATION_RATE = 0.8;
    private static final int MAX_ITER = 1000;


    void generatePopulation(List<Route> result, List<ClientOrder> start, List<ClientOrder> end) {
        if (end.size() <= 1) {
            start.addAll(end);
            result.add(new Route(getDistByPoints(start), start));
        } else {
            if (result.size() < POPULATION_SIZE) {
                for (int i = 0; i < end.size(); i++) {
                    List<ClientOrder> newArray = new ArrayList<>(end.size() - 1);
                    List<ClientOrder> begin = new ArrayList<>(end.size() + 1);
                    begin.addAll(start);
                    begin.add(end.get(i));
                    newArray.addAll(end);
                    newArray.remove(end.get(i));
                    generatePopulation(result, begin, newArray);
                }
            }
        }
    }

    List<Route> mate(List<Route> population) {
        int esize = (int) (POPULATION_SIZE * ELITE_RATE);
        List<Route> children = new ArrayList<Route>();

        selectElite(population, children, esize);

        for (int i = esize; i < POPULATION_SIZE; i++) {
            int i1 = (int) (Math.random() * POPULATION_SIZE * SURVIVE_RATE);
            int i2 = (int) (Math.random() * POPULATION_SIZE * SURVIVE_RATE);

            Route child = generateChild(population.get(i1), population.get(i2));
            mutate(child);
            children.add(child);
        }
        return children;
    }


    Route generateChild(Route r1, Route r2) {
        List<ClientOrder> addresses = new ArrayList<>(r1.getClientOrders().size());
        for (int i = 0; i<addresses.size();i++){
            ClientOrder o = addresses.get(i);
            if (r2.getClientOrders().contains(o)) {
                addresses.add(o);
            } else if (i+1 % 2 == 0) {
                addresses.add(o);
            } else if (i+1 % 2 != 0) {
                addresses.add(r2.getClientOrders().get(i));
            } else {
                addresses.add(o);
            }
        }
        return new Route(getDistByPoints(addresses), addresses);
    }

    public List<Route> calculate(List<ClientOrder> addresses) {
        List<Route> population = new ArrayList<Route>();
        generatePopulation(population, new ArrayList<ClientOrder>(), addresses);

        for (int i = 0; i < MAX_ITER; i++) {
            Collections.sort(population);
            System.out.println(i + " > " + population.get(0));
            population = mate(population);
        }
        return population;
    }

    void mutate(Route input) {
        List<ClientOrder> addrs = input.getClientOrders();
        int ipos = (int) (Math.random() * addrs.size()-1);
        ClientOrder temp = addrs.get(ipos);
        //println("move from pos" + ipos)
        addrs.remove(ipos);
        addrs.add(temp);
    }

    ClientOrder getCenter(List<ClientOrder> addr){
        ClientOrder center = new ClientOrder();
        double latSum = 0;
        double lngSum = 0;
        for(ClientOrder o:addr){
            latSum+= o.getLat();
            lngSum+=o.getLng();
        }
        center.setLat(latSum/addr.size());
        center.setLng(lngSum / addr.size());
        return center;
    }

    private void selectElite(List<Route> population, List<Route> children, int esize) {
        for (int i = 0; i < esize; i++) {
            children.add(population.get(i));
        }
    }

    double getDistByPoints(List<ClientOrder> result) {
        double resultDist = 0;
        for (int i = 0; i < result.size() - 1; i++) {
            resultDist += getDistanceByLatAndLng(result.get(i).getLat(), result.get(i).getLng(), result.get(i + 1).getLat(), result.get(i + 1).getLng());
        }
        return resultDist;
    }

    /* def generateDistance(String origin, String destination) {
         def http = new HTTPBuilder(GOOGLE_API)
         double result = 0
         http.request(GET, JSON) {
             uri.path = '/maps/api/distancematrix/json'
             uri.query = [sensor: false, origins: origin, destinations: destination, mode: 'driving']

             // response handler for a success response code:
             response.success = { resp, json ->
                 assert resp.statusLine.statusCode == 200
                 String dist = json.rows.elements['distance'].text[0][0]
                 //result = Double.parseDouble(dist.replaceAll("( km)|( m)", ""))
                 return dist
             }

             // handler for any failure status code:
             response.failure = { resp ->
                 println("Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}")
             }
             return result
         }
     }*/


    double getDistanceByLatAndLng(double originLat, double originLng, double destLat, double destLng) {
        final double dlng = deg2rad(originLng - destLng);
        final double dlat = deg2rad(originLat - destLat);
        final double a = sin(dlat / 2) * sin(dlat / 2) + cos(deg2rad(destLat)) * cos(deg2rad(originLat)) * sin(dlng / 2) * sin(dlng / 2);
        return BigDecimal.valueOf(2 * atan2(sqrt(a), sqrt(1 - a)) * EARTH_RADIUS).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    private static double deg2rad(final double degree) {
        return degree * (Math.PI / 180);
    }

}
