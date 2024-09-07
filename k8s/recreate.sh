cd ..
kubectl delete configmap example-policy
kubectl create configmap example-policy --from-file=admin.rego
docker build -t app:v1 .
cd k8s
kubectl delete deployment app
kubectl apply -f deployment.yml
sleep 10s
kubectl get pods
