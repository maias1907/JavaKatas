package katas.exercises;


import java.util.ArrayList;
import java.util.List;


public class RoundRobinLoadBalancer {
  /*
     * In distributed systems, a load balancer is responsible for distributing incoming requests to multiple server instances.
     * A round-robin load balancer assigns requests to server instances in a circular order.
     *
     * You need to implement a RoundRobinLoadBalancer class that:
     *
     *  - Adds a server instance to the pool of available instances.
     *  - Removes a server instance from the pool of available instances.
     *  - Routes incoming requests to server instances in a round-robin manner.
     *  - Return null when no servers are available.*/


    private  List<IP> servers;
    private int currentIndex;

    /*V
     * Constructor to initialize the load balancer.

     */

    public RoundRobinLoadBalancer() {
        this.servers=new ArrayList<>();
        this.currentIndex=0;

    }

    /**
     * Adds a server instance to the load balancer.V
     *
     * @param server the IP object representing the server to add
     */

    public void addServer(IP server) {
        if (!servers.contains(server)) {
            servers.add(server);
        }

    }

    /**
     * Removes a server instance from the load balancer.
     *
     * @param server the IP object representing the server to remove
     *               */

    public void removeServer(IP server) {
        if(this.servers.contains(server))
        {
            this.servers.remove(server);
        }

    }

    /**
     * Routes a request to the next server in round-robin order.
     *
     * @return the IP object of the server handling the request
     */

    public IP routeRequest() {
        if(servers.isEmpty())
        {
            return null;
        }
        IP retServer=servers.get(currentIndex);
        currentIndex=(currentIndex+1)% servers.size();
        return retServer;

    }

    public static void main(String[] args) {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        loadBalancer.addServer(new IP("192.168.0.1"));
        loadBalancer.addServer(new IP("192.168.0.2"));
        loadBalancer.addServer(new IP("192.168.0.3"));

        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());

        loadBalancer.removeServer(new IP("192.168.0.2"));

        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
    }

    /**
     * Represents an IP address.
     */

    static class IP {
        private final String address;

        /**
         * Constructor to initialize an IP address.
         *
         * @param address the IP address as a string
         */

        public IP(String address) {
            if (!isValidIP(address)) {
                throw new IllegalArgumentException("Invalid IP address: " + address);
            }
            this.address=address;
        }

        /*
         * Validates an IPv4 address.
         *
         * @param address the IP address to validate
         * @return true if the address is valid, false otherwise
     */


        private static boolean isValidIP(String address) {
            String ipv4Regex =
                    "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}" +
                            "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
            return address.matches(ipv4Regex);

        }

        @Override
        public String toString() {
            return address;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            IP ip = (IP) obj;
            return address.equals(ip.address);
        }

        @Override
        public int hashCode() {
          return   address.hashCode();

        }
    }

}


