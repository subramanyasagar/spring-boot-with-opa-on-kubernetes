package com.springboot.opa.interceptor;

import com.springboot.opa.dto.OPARequest;
import com.springboot.opa.dto.OPAResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${opa.server.url}")
    private String opaUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // This method is called before the actual handler method is invoked
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        var path = request.getRequestURI().split("/");
        var roles = request.getHeader("USER_ROLES").split(",");

        OPARequest opaRequest = new OPARequest(Map.of("path",path, "roles", roles, "method", request.getMethod()));
        HttpEntity<Object> httpEntity = new HttpEntity<>(opaRequest, headers);



        log.info("Items Sent to OPA: {}, {}", path, roles);
        log.info("OPA URL: {}", opaUrl);

       ResponseEntity<OPAResponse> responseEntity =
                restTemplate.exchange(opaUrl , HttpMethod.POST, httpEntity, OPAResponse.class);
        log.info(responseEntity.getBody().toString());

        var isAllowed = responseEntity.getBody().getResult().isAllow();

        log.info("OPA Decision: {}", isAllowed);


        if(!isAllowed){
           throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
        // Your preHandle logic goes here

        // Return true to continue with the execution chain
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // This method is called after the handler method is invoked but before the view is rendered

        // Your postHandle logic goes here
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // This method is called after the view has been rendered

        // Your afterCompletion logic goes here
    }
}
