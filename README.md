# eureka_lb_helloworld
A micro-services hello world application, combining load balancer,reverse-proxy, authentication, authorization and service discovery

## Installation
1. Clone repo
2. Run the main class of each one of the services, starting on registry

## Architecture
1. auth: Authentication and authorization microservice
2. content: Main microservice, because we need to access some something :)
3. registry: Eureka registration microservice
4. proxy: Reverse proxy to enable access to both content and auth through the same url

## Usage
1. Authenticate

`curl -XPOST -k foo:foosecret@localhost:4444/auth/hascode/oauth/token    -d grant_type=password -d client_id=foo -d client_secret=abc123    -d redirect_uri=http://www.hascode.com -d username=bar -d password=barsecret`

2. Use content service

`curl -H "Authorization: Bearer 7545f727-5f4a-4633-9275-542f07ddf881" -H "Content-type: application/json" http://localhost:4444/content/resource/content`
