package com.example.mcpserverwebmvc.config;

import com.example.mcpserverwebmvc.tool.OrderTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolConfiguration {
    @Bean
    ToolCallbackProvider orderToolCallBack(OrderTool orderTool) {
        return MethodToolCallbackProvider
                .builder()
                .toolObjects(orderTool)
                .build();
    }
}
