package controllers;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
    private static final String CHARACTER_ENCODING_ATTRIBUTE = "characterEncoding";
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) {
        encoding = filterConfig.getInitParameter(CHARACTER_ENCODING_ATTRIBUTE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
