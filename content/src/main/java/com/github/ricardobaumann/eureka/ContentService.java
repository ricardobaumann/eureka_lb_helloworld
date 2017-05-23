package com.github.ricardobaumann.eureka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ricardobaumann on 5/22/17.
 */
@Service
public class ContentService {

    private final Resource[] jsonResourceFiles;
    private final Map<String, JsonNode> nodeMap = new HashMap<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    ContentService(final @Value("classpath*:content.*.json") Resource[] jsonResourceFiles) {
        this.jsonResourceFiles = jsonResourceFiles;
    }

    @PostConstruct
    private void initCache() {
        try {
            for (Resource resource: jsonResourceFiles) {
                final String content = Resources.toString(resource.getURL(), Charset.forName("UTF-8"));
                final String contentName = StringUtils.remove(resource.getFilename(),".json");
                nodeMap.put(contentName,objectMapper.readTree(content));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Content getContent(String name) {
        return new Content(nodeMap.get(name),name);
    }

}
