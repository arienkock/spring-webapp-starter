# Starter Project
The goal of this project is to serve as a base for "modern" Java web-applications with a Spring4 founcation. It contains example views, controllers and a data layer and attempts to address the following concerns by default:


1. Web-tier security (authn, authz and user-content filtering/whitelisting)
1. Localization (message bundles, automatic and manual locale resolution)
1. Caching (conditional GET in example controllers)
1. Forms (example views+forms, partial updates, server-side validation)
1. Frontend workflow (JS/CSS/HTML [Gulp.js](http://gulpjs.com/) build integrated into Maven lifecycle where prototype == templates thanks to valid HTML [Thymeleaf](http://www.thymeleaf.org/) views)
1. Search (example embedded search engine using [Spring-Data-Solr](https://github.com/spring-projects/spring-data-solr))
1. Expose API (service methods as oauth content provider, JSON views)
1. Social integration ([Spring-Social](http://projects.spring.io/spring-social/))
1. Datastore ([Spring-Data-JPA](http://projects.spring.io/spring-data-jpa/))
1. EMail 

__TODO:__

* Social Auth
* thymeleaf, jsp or mustache view resolvers
* simple independent error pages
* CRUD example + forms
* multipart example
* solr example
* data layer example (jpa?, tinkerpop?)
* message resolver
* account creation/email validation (?)
* email support
* JSoup user content cleanup
* change static content url location to avoid caching problems during version changes/releases
* payment provider integration
* setup for clustered environment (distributed sessions)
* Add partial-update example handler method
* integrate frontend build process (gulp)

__Done__:

* content negotiation view resolution (html+json)
* multipart support
* basic security setup, csrf, placeholder authn
* locale resolving
* dev and prod slf4j logging setup with config reloading
* externalized config through environment and props file
  
