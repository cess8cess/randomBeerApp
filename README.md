## SPRING BOOT + RESTFUL API + JAVA 8 + MONGODB + JUNIT + REACT.JS + DOCKER + KUBERNETES
 
# randomBeerApp

Clone the project

cd randomBeerApp

# LOCAL RUN

# To start the rest api

cd RandomBeerAppApplication

mvn clean install

java -jar target/beer-nrc-0.0.1-SNAPSHOT.jar

# To start the frontend 

cd random-beer

npm install

npm start


# RUNNING ON MINIKUBE
kubectl apply -f services.yaml
kubectl apply -f pods.yaml
minikube ip 
http://<minikube ip>:30000
