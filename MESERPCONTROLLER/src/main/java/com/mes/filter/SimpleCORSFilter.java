package com.mes.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.stereotype.Component;


@Component
public class SimpleCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE ,PUT");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}
/*public class SimpleCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse)res;
		MyHttpServletResponseWrapper wrapper = 
				  new MyHttpServletResponseWrapper(response);
		//PrintWriter writer;
		//ServletOutputStream
//		res.get
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
		//res.getOutputStream();
		response.setContentType("text/plain");
		writer = response.getWriter();
		System.out.println(writer.toString());
		writer.write("kevin");
		writer.close();
		chain.doFilter(req, response);
		//String content = wrapper.toString();
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}
	
	static class MyHttpServletResponseWrapper 
	  extends HttpServletResponseWrapper {

	  private StringWriter sw = new StringWriter(1024);

	  public MyHttpServletResponseWrapper(HttpServletResponse response) {
	    super(response);
	  }

	  public PrintWriter getWriter() throws IOException {
	    return new PrintWriter(sw);
	  }

	  public ServletOutputStream getOutputStream() throws IOException {
	    throw new UnsupportedOperationException();
	  }

	  public String toString() {
	    return sw.toString();
	  }
	}

}
*/