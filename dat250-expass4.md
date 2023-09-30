# DAT250: Assignment 4
By 587900 (Kjetil Berg)

### Description
The instructions of https://github.com/selabhvl/dat250public/blob/master/expassignments/expass4.md was followed to create a
spring test application with some rudimentary requests. Everything went according to the instructions
besides what is mentioned under the 'Trials and tribulations' section (problems and noteworthy moments).

### Experiment 1 - Postman proof
Here is a picture of me doing GET (getting nothing), PUT (data in instructions) and GET again (getting the expected value).
See the 'history' tab for my requests (not detailed).\
![postman requests](https://raw.githubusercontent.com/587900/dat250-spring-counters-todos/master/img/postman.png)


### Experiment 2 - REST API implemented
The test cases run, as you can see by the 'TodosController test suite - passing' in the readme.md in this repository.

### Trials and tribulations
1. Experiment 1: In order to send a body with PUT in Postman, I selected the 'body' tab and chose 'raw' then 'json'. The GET requests acted as expected.
2. Experiment 2: I struggled getting Spring to work properly due to missing annotations. I knew to add @PathVariable and quickly found that @RestController was needed.
For the PUT request, however, it took me a moment to discover that I needed @RequestBody. The reason was that a tutorial I was following online
did not include it (for some reason?). I found out when I asked a classmate.
3. Experiment 2: Some methods required us to return 404 if a resource was not found. To solve this I threw a "RequestStatusException", where I could
specify a custom code and reason.
4. When I was going to start experiment 3 and 4, suddenly "This project is not a gradle project" started popping up when trying to run gradle build.
I tried fixing this for about 30 minutes before I gave up. I have worked with IntelliJ for a long time, but not with gradle. I blame gradle :).
Because experiments 3 and 4 are optional, I did not do them. Still, I provided some info below regarding their theoretics.

### Experiment 3 - Swagger
I have worked with Swagger before and it is very easy to define. It should be noted, however, that one could put almost an
infinite amount of detail into the documentation (that is the main reason I skipped this experiment).
There are also some differences between the OpenAPI definition and Swagger implementation.
As for providing the documentation to the end user, there are a few options.
1. You could download some OpenAPI renderer and host it on a web server to provide the documentation.
This is, in my opinion, the most elegant way of doing it.
2. When starting out with Swagger, I tended to just provide a swagger.yaml file that the user could upload to another OpenAPI-rendering site.
For development I tended to use https://editor.swagger.io. Very cool.

### Experiment 4 - XML Representation
You can easily allow Spring to render your object using XML instead of JSON by simply adding a XML-Marshaller to the dependencies of your project.
Spring should notice it automatically and use it if an 'Accept' header specifies XML. This is easily managed by Spring since we just return an object
in our implementation. Spring also handles JSON-Marshalling the same way, however some default implementation for this is included in Spring (at least this project).
Again, I could not do this because the project refused to run after gradle got ill.