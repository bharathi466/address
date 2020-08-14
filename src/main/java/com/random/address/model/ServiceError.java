package com.random.address.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(description = "Service error")
@Builder
@Data
public class ServiceError {
    @ApiModelProperty(required = true, value = "error code equal to http status code")
    private String errorCode;
    @ApiModelProperty(required = true, value = "error message")
    private String errorMessage;
}
