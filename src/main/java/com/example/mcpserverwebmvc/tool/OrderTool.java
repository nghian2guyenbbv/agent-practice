package com.example.mcpserverwebmvc.tool;

import com.example.mcpserverwebmvc.model.Order;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class OrderTool {

    private final RestClient restClient;

    public OrderTool(@Value("${order.api.base-url:http://localhost:${server.port:8080}}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    @Tool(name = "searchOrder", description = "search the exiting order by its numeric order ID")
    public OrderSearchResult searchOrder(@ToolParam(description = "Numeric order ID, e.g. 123") long orderId) {
        return restClient.get()
                .uri("/api/orders/{id}", orderId)
                .exchange((req, res)
                        -> res.getStatusCode().is2xxSuccessful()
                        ? new OrderSearchResult(true, res.bodyTo(Order.class), "Order found")
                        : new OrderSearchResult(false, null, "Order " + orderId + " not found"));
    }

    public record OrderSearchResult(boolean found, Order order, String message) {
    }
}
