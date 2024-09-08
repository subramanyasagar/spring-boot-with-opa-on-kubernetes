1. If using minikube docker then first start a docker container.
2. Run command and see the docker desktop you can see minikube up and running.
    **minikube start**
4. Start a tunnel
   **minikube tunner**
5. Deploy the cluster
_kubectl apply -f service.yml
kubectl apply -f cm.yml
kubectl apply -f deployment.yml_

6. Use Postman or curl to see the results for a GET endpoint:

   <img width="1093" alt="image" src="https://github.com/user-attachments/assets/64a8762d-cf04-4510-bbd0-8810cd688f8f">

7. For Post endpoint without right roles:

<img width="1093" alt="image" src="https://github.com/user-attachments/assets/d561c94f-5312-4512-ad62-7ef20f60eaa9">

8. With Right roles:

   <img width="1093" alt="image" src="https://github.com/user-attachments/assets/2dfc079a-97b0-4478-a13c-6bbd246ed008">

   
