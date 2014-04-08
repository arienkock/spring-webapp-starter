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
1. _EMail_: generic javamail support and rich email template
1. _Standalone application_: run on embedded container
1. _TLS_: template config for using keystore
1. _Clustering_: config to run N-node cluster with distributed datastore and Java session

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
  
