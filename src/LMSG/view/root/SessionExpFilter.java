package LMSG.view.root;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionExpFilter implements Filter {
    public SessionExpFilter() {
        super();
    }
    public void init(FilterConfig filterConfig) {
      }
        public void doFilter(ServletRequest servletRequest,
                             ServletResponse servletResponse,
                             FilterChain filterChain)throws IOException,ServletException {
            
            HttpServletRequest hreq = (HttpServletRequest)
            servletRequest;
            HttpServletResponse hres = (HttpServletResponse)
            servletResponse;
            hres.setHeader("Cache-Control", "no-cache");
            hres.setHeader("Cache-Control", "no-store");
            hres.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
            hres.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility 
            HttpSession session = hreq.getSession();
            String url = hreq.getPathTranslated(); 
            boolean loginPage = url.endsWith("index.jspx");
            if (!loginPage) {
            if(session.getAttribute("Username") == null) {
            String context=hreq.getContextPath();
            hres.sendRedirect(context+"/index.html");
            return;
            }
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }

        public void destroy() {
        }
}
