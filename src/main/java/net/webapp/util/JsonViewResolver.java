package net.webapp.util;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class JsonViewResolver extends AbstractCachingViewResolver {

	@Override
	protected View loadView(String viewName, Locale locale) throws Exception {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;
	}
}