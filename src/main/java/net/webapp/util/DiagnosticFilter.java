package net.webapp.util;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DiagnosticFilter implements Filter {
	private static Logger logger = LoggerFactory
			.getLogger(DiagnosticFilter.class);
	private WebApplicationContext appCtx;

	public void init(FilterConfig filterConfig) throws ServletException {
		appCtx = WebApplicationContextUtils
				.getWebApplicationContext(filterConfig.getServletContext());
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			long startTime = System.nanoTime();
			long startSystemTimeNano = getSystemTime();
			long startUserTimeNano = getUserTime();
			chain.doFilter(request, response);
			long duration = System.nanoTime() - startTime;
			long durationUserTimeNano = getUserTime() - startUserTimeNano;
			long durationSystemTimeNano = getSystemTime() - startSystemTimeNano;

		} catch (Throwable t) {
			// protect against uncaught errors
		}
	}

	public void destroy() {
	}

	/** Get CPU time in nanoseconds. */
	public long getCpuTime() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ? bean
				.getCurrentThreadCpuTime() : 0L;
	}

	/** Get user time in nanoseconds. */
	public long getUserTime() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ? bean
				.getCurrentThreadUserTime() : 0L;
	}

	/** Get system time in nanoseconds. */
	public long getSystemTime() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ? (bean
				.getCurrentThreadCpuTime() - bean.getCurrentThreadUserTime())
				: 0L;
	}

}
