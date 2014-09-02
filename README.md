# Starter Project
The goal of this project is to serve as a base for "modern" Java web-applications with a Spring4 founcation. It contains example views, controllers and a data layer and attempts to address the following concerns by default:


1. _Forms_: example views+forms, partial updates, server-side validation
1. _Web-tier security_: authn, authz, csrf protection and user-content filtering/whitelisting to prevent xss
1. _Localization_: message bundles, automatic and manual locale resolution
1. _Application-level caching_: conditional GET in example controllers
1. _Expose API_: expose service methods as OAuth content provider, content-negotiated JSON views
1. _Frontend workflow_: JS/CSS/HTML [Gulp.js](http://gulpjs.com/) build integrated into Maven lifecycle where prototype == templates due to valid HTML [Thymeleaf](http://www.thymeleaf.org/) views
1. _Search_: example embedded search engine using [Spring-Data-Solr](https://github.com/spring-projects/spring-data-solr)
1. _Social integration_: [Spring-Social](http://projects.spring.io/spring-social/)
1. _Datastore_: [Spring-Data-JPA](http://projects.spring.io/spring-data-jpa/)
1. _Easy Deployment_: Standalone application running on embedded container
1. _TLS_: template config for using keystore
1. _Clustering_:
    1. HAProxy sticky session config
    2. Distributed datastore
    3. Distributed session store
1. _Development lifecycle support_: Spring profiles, tasks for hot code/asset replacing
1. _Testing_: unit and integration testing setup
1. _Logging_: pluggable logging SLF4J
1. _Common webapp utilities_:
    1. IP to Country mapping. Geolocation
    1. URL building/manipulation
    1. EMail: generic javamail support and rich email template

__TODO:__

* Social Auth
* thymeleaf, jsp or mustache view resolvers
* [transparent HEAD support](http://axelfontaine.com/blog/http-head.html)
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
  
