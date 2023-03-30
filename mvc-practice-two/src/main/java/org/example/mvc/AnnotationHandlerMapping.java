package org.example.mvc;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.controller.HandlerKey;
import org.example.mvc.controller.RequestMethod;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationHandlerMapping implements HandlerMapping{
    private final Object[] basePackge;
    private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<>();

    public AnnotationHandlerMapping(Object... basePackge) {
        this.basePackge = basePackge;
    }

    public void initialize() {
        Reflections reflections = new Reflections(basePackge);

        Set<Class<?>> clazzesWithControllerAnnotation = reflections.getTypesAnnotatedWith(Controller.class);

        clazzesWithControllerAnnotation.forEach(clazz ->
                Arrays.stream(clazz.getDeclaredMethods()).forEach(decleredMethod -> {
                    RequestMapping requestMapping = decleredMethod.getDeclaredAnnotation(RequestMapping.class);

                    Arrays.stream(getRequestMethods(requestMapping))
                            .forEach(requestMethod -> handlers.put(
                                    new HandlerKey(requestMethod, requestMapping.value()),
                                    new AnnotationHandler(clazz, decleredMethod)
                            ));
                })
        );
    }

    private RequestMethod[] getRequestMethods(RequestMapping requestMapping) {
        return requestMapping.method();
    }

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }
}
