package im.spent.core.conf.listener;

import im.spent.core.decorator.HttpResponseBodyMethodDecorator;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Configuration
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private final RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    public ApplicationContextListener(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        this.requestMappingHandlerAdapter = requestMappingHandlerAdapter;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(Objects.requireNonNull(this.requestMappingHandlerAdapter.getReturnValueHandlers()));
        for (int i = 0; i < Objects.requireNonNull(handlers).size(); i ++) {
            HandlerMethodReturnValueHandler handler = handlers.get(i);
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                handlers.set(i, new HttpResponseBodyMethodDecorator(handler));
            }
        }
        requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
    }
}
