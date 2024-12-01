package com.ahnsugyeong.dugout.global.config;

import com.ahnsugyeong.dugout.global.annotation.ApiErrorCodeExample;
import com.ahnsugyeong.dugout.global.dto.ExampleHolder;
import com.ahnsugyeong.dugout.global.response.ResponseDto;
import com.ahnsugyeong.dugout.global.response.status.ErrorStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Dugout API Document")
                .version("v0.0.1")
                .description("""
                        ## Dugout API 명세서입니다. ⚾️️
                                                
                        ---
                                                
                        ### 🔑 테스트 사용자 인증 토큰
                        """);

        Server server = new Server().url("/");

        return new OpenAPI()
                .info(info)
                .addServersItem(server);
    }

    @Bean
    public OperationCustomizer customize() {
        return (Operation operation, HandlerMethod handlerMethod) -> {
            // ApiErrorCodeExample 어노테이션 처리
            ApiErrorCodeExample apiErrorCodeExample = handlerMethod.getMethodAnnotation(ApiErrorCodeExample.class);
            if (apiErrorCodeExample != null) {
                // 오류 코드와 함께 응답 예제 생성
                generateErrorCodeResponseExample(operation, apiErrorCodeExample.value());
            }
            return operation;
        };
    }

    private void generateErrorCodeResponseExample(Operation operation, ErrorStatus[] errorStatuses) {
        ApiResponses responses = operation.getResponses();

        // 상태 코드별로 ExampleHolder를 그룹화
        Map<Integer, List<ExampleHolder>> statusWithExampleHolders = Arrays.stream(errorStatuses)
                .map(errorStatus -> ExampleHolder.builder()
                        .holder(getSwaggerExample(errorStatus))
                        .code(errorStatus.getCode())
                        .name(String.valueOf(errorStatus.getCode()))
                        .build())
                .collect(groupingBy(ExampleHolder::getCode));

        // 응답 예제를 추가
        addExamplesToResponses(responses, statusWithExampleHolders);
    }

    private Example getSwaggerExample(ErrorStatus status) {
        ResponseDto<Object> responseDto = new ResponseDto<>(false, status.getCode(), status.getMessage(), null);
        Example example = new Example();
        example.setDescription(status.getMessage());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonResponseDto = objectMapper.writeValueAsString(responseDto);
            example.setValue(jsonResponseDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return example;
    }

    private void addExamplesToResponses(ApiResponses responses, Map<Integer, List<ExampleHolder>> statusWithExampleHolders) {
        statusWithExampleHolders.forEach((status, exampleHolders) -> {
            Content content = new Content();
            MediaType mediaType = new MediaType();
            ApiResponse apiResponse = new ApiResponse();

            exampleHolders.forEach(exampleHolder ->
                    mediaType.addExamples(exampleHolder.getName(), exampleHolder.getHolder()));

            content.addMediaType("application/json", mediaType);
            apiResponse.setContent(content);
            responses.addApiResponse(String.valueOf(status), apiResponse);
        });
    }
}
