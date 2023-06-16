package com.event.feedbackservice.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString

public class ApiResponse<T> {
    int statusCode;
    String statusDescription;
    T result;
}
