package com.example.ai.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;

@Configuration
public class CommonConfiguration {

    @Bean
    public ChatClient chatClient(@Qualifier("dashscopeChatModel") ChatModel chatModel) {
        return ChatClient.builder(chatModel)
                // 可选：设置一个默认的系统提示词
                .defaultSystem("You are a helpful assistant.")
                .build();
    }


}
