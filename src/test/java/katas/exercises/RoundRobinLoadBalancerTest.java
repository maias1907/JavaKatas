package katas.exercises;

import katas.exercises.RoundRobinLoadBalancer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RoundRobinLoadBalancerTest {

    @Test
    void testAddServerAndRouteRequest() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        // Add servers
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.2"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.3"));

        // Test round-robin routing
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.2", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.3", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
    }

    @Test
    void testRemoveServer() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        // Add servers
        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");
        RoundRobinLoadBalancer.IP server3 = new RoundRobinLoadBalancer.IP("192.168.0.3");
        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);
        loadBalancer.addServer(server3);

        // Remove a server
        loadBalancer.removeServer(server2);

        // Test round-robin routing after removal
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.3", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
    }

    @Test
    void testRouteRequestNoServers() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        // Test routing when no servers are available
        assertNull(loadBalancer.routeRequest());
    }

    @Test
    void testDuplicateServerAddition() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        // Add the same server twice
        RoundRobinLoadBalancer.IP server = new RoundRobinLoadBalancer.IP("192.168.0.1");
        loadBalancer.addServer(server);
        loadBalancer.addServer(server);

        // Test round-robin routing (only one instance should be present)
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
    }

    @Test
    void testIPValidation() {
        // Valid IPs
        new RoundRobinLoadBalancer.IP("192.168.1.1");
        new RoundRobinLoadBalancer.IP("10.0.0.1");
        new RoundRobinLoadBalancer.IP("255.255.255.255");

        // Invalid IPs (should throw IllegalArgumentException)
        try {
            new RoundRobinLoadBalancer.IP("256.256.256.256");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid IP address: 256.256.256.256", e.getMessage());
        }

        try {
            new RoundRobinLoadBalancer.IP("192.168.1");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid IP address: 192.168.1", e.getMessage());
        }

        try {
            new RoundRobinLoadBalancer.IP("abc.def.ghi.jkl");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid IP address: abc.def.ghi.jkl", e.getMessage());
        }
    }
}
