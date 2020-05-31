//package com.gongj.noproblem.commonsutils.handler;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.gongj.noproblem.commonsutils.ApiException;
//import com.gongj.noproblem.commonsutils.ResultVo;
//import lombok.SneakyThrows;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//@RestControllerAdvice(basePackages = {"com.gongj.eduservice.controller"})
//public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return !returnType.getGenericParameterType().equals(ResultVo.class);
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//       if(returnType.getGenericParameterType().equals(String.class)){
//           ObjectMapper objectMapper = new ObjectMapper();
//           try {
//              return objectMapper.writeValueAsString(ResultVo.ok().data("list",body));
//           } catch (JsonProcessingException e) {
//               throw new ApiException(1001,"返回Stirng类型失败");
//           }
//       }
//        return ResultVo.ok().data("list",body);
//    }
//
//}
