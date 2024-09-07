## Tracking Number Generator

The Tracking Number Generator exposed a RESTful API that generates unique tracking number for parcels. This
API is efficient, ease to scale and capable of handling high concurrency.

### Technology Used

- java11
- apache-maven3.6.3
- spring-boot2.7.3
- postgres13.1-alpine
- jacoco-plugin0.8.5
- docker
- testcontainers1.16.2

### Go to the project root directory and follow the instructions below to build & run the application

- Run the below command to build the application & generate jacoco report (which includes code-coverage details). The Path for the jacoco report is: `reports/jacoco/index.html`
  > mvn clean install -U
- Install or Setup docker on your machine & verify the same using below command
  > docker --version
- Make sure docker-deamon is running-up prior
  - ###### Window:
    > wsl -l -v
  - ###### Linux/Mac:
    > sudo service docker status
- Run the below commands in the terminal to build, start & stop all the services
    - ###### Build:
      > docker build -t tracking-number-generator .
    - ###### Run:
      > docker-compose up
    - ###### Stop:
      > docker-compose down

### Please use the below APIs details to test the application once services are up & running
- Generates unique tracking number 
  - URI: http://localhost:8080/api/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2018-11-20T19:29:32%2B08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox Logistics&customer_slug=redbox-logistics
  - HTTP-Method: GET
  - Response:
    - {
      "id": 1,
      "customerId": "de619854-b59b-425e-9db4-943979e1bd49",
      "trackingNumber": "23095919D6444705",
      "createdAt": "2024-09-07T19:33:15.068585Z"
      }
