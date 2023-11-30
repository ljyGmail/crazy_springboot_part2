package org.crazyit.app;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InterceptorCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        // 向restTemplate中添加自定义的拦截器
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            System.out.println("---添加拦截器---");
            // 获取请求地址
            String checkTokenUrl = request.getURI().getPath();
            // 计算Token的有效时间
            int ttTime = (int) (System.currentTimeMillis() / 1000 + 1800);
            // 获取请求方法名POST, GET等
            String methodName = request.getMethod().name();
            // 获取请求体
            var requestBody = new String(body);
            // 根据请求内容来生成Token
            String token = generateToken(checkTokenUrl, ttTime, methodName, requestBody);
            // 将Token放入请求头
            request.getHeaders().add("X-Auth-Token", token);
            return execution.execute(request, body);
        }));
    }

    private String generateToken(String checkTokenUrl, int ttTime, String methodName, String requestBody) {
        return "fkjava";
    }
}
