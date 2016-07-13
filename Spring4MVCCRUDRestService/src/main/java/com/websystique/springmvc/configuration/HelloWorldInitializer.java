package com.websystique.springmvc.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HelloWorldConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
    /*
     * 
     * below getServletFilters is for
     * Adding CORS support to your REST API
     * 
    https://en.wikipedia.org/wiki/Same-origin_policy
    http://www.html5rocks.com/en/tutorials/cors/
    
    	While accessing the REST API, you might face issues concerning Same Origin Policy.

    	Errors like :
    	"No 'Access-Control-Allow-Origin' header is present on the requested resource. Origin 'http://127.0.0.1:8080' is therefore not allowed access." OR
    	" XMLHttpRequest cannot load http://abc.com/bla. Origin http://localhost:12345 is not allowed by Access-Control-Allow-Origin." are common in such case.

    	Solution is Cross-Origin Resource Sharing. Basically, on server side, we can return additional CORS access control headers with response, which will eventually allow further inter-domain communication.

    	With Spring, we can write a simple filter which adds those CORS specific headers in each response.
    	*/
    	
    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CORSFilter()};
        return singleton;
    }
    
}