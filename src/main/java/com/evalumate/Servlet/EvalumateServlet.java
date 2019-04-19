package com.evalumate.Servlet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsoftvalley.rest.NewSoftValleyResource;
import com.newsoftvalley.rest.NewSoftValleyServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;

public class EvalumateServlet extends NewSoftValleyServlet {
    private ObjectMapper _objectMapper;
    private Map<String, NewSoftValleyResource> _resouceMapping;

    public static void main(String[] args) {
        String a = "poio";
        String b = "poio";
        String c = new String("poio");

        System.out.println((a == b) + ":" + (b == c));

    }

    public EvalumateServlet() {
        _objectMapper = (new ObjectMapper()).setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        _resouceMapping = new HashMap<>();
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        String[] resourceMappings = servletConfig.getInitParameter("resourceMapping").split(";");
        String[] leftAndRight = resourceMappings;
        for (int i = 0; i < leftAndRight.length; i++) {

        }
    }

}
