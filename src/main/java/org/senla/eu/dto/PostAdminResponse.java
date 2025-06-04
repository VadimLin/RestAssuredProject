package org.senla.eu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAdminResponse {
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<PostAdminResponseData> data;
    private String requestId;
}
