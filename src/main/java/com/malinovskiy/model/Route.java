package com.malinovskiy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 27.11.2014.
 */
class Route implements Comparable<Route> {
    private double distance;
    private List<ClientOrder> clientOrders = new ArrayList<>();

    public Route(double distance, List<ClientOrder> clientOrders) {
        this.distance = distance;
        this.clientOrders = clientOrders;
    }

    public Route(){
        super();
    }

    @Override
    public int compareTo(Route o) {
        if (getDistance() == getDistance()) {
            return 0;
        } else if (getDistance() > o.getDistance()) {
            return 1;
        } else {
            return -1;
        }

    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<ClientOrder> getClientOrders() {
        return clientOrders;
    }

    public void setClientOrders(List<ClientOrder> clientOrders) {
        this.clientOrders = clientOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (Double.compare(route.distance, distance) != 0) return false;
        if (clientOrders != null ? !clientOrders.equals(route.clientOrders) : route.clientOrders != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(distance);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (clientOrders != null ? clientOrders.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "distance=" + distance +
                ", clientOrders=" + clientOrders +
                '}';
    }
}
