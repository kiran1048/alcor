/*
 *
 * Copyright 2019 The Alcor Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *         you may not use this file except in compliance with the License.
 *         You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *         See the License for the specific language governing permissions and
 *         limitations under the License.
 * /
 */

package com.futurewei.alcor.web.entity.topic;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.futurewei.alcor.web.entity.node.NodeInfo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class VpcTopicInfo implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(NodeInfo.class);

    @JsonProperty("topic_name")
    private String topicName;

    @JsonProperty("subscribe_mapping")
//    Mapping of <Subscribed NodeId, key for Pulsar>
    private Map<String, String> subscribeMapping;

    public VpcTopicInfo(String topicName) {
        this.topicName = topicName;
        this.subscribeMapping = new HashMap<>();
    }

    public VpcTopicInfo(String topicName, HashMap<String, String> subscribeMapping) {
        this.topicName = topicName;
        this.subscribeMapping = subscribeMapping;
    }

    public VpcTopicInfo(VpcTopicInfo vpcTopicInfo, HashMap<String, String> subscribeMapping) {
        this.topicName = vpcTopicInfo.topicName;
        this.subscribeMapping = vpcTopicInfo.subscribeMapping;
        this.subscribeMapping.putAll(subscribeMapping);
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Map<String, String> getSubscribeMapping() {
        return subscribeMapping;
    }

    public void setSubscribeMapping(HashMap<String, String> subscribeMapping) {
        this.subscribeMapping = subscribeMapping;
    }
}
