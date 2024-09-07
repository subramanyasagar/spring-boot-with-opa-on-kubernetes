from diagrams import Cluster, Diagram, Edge
from diagrams.aws.compute import ECS
from diagrams.aws.database import ElasticacheForRedis, RDS
from diagrams.aws.network import ELB
from diagrams.aws.network import Route53
from diagrams.custom import Custom

with Diagram("Business Service", show=False) as diag:
    actor = Custom("Client", "actor.png")
    lb = ELB("lb")

    with Cluster("Cache Group"):
        redis = ElasticacheForRedis("Redis Cache")
    with Cluster("POD Group", direction="TB"):
        node1 = ECS("node1")
        opa = Custom("OPA", "opa_sidecar.png")
        node1 >> Edge(color="darkgreen") << opa
    with Cluster("POD Group", direction="TB"):
        node2 = ECS("node2")
        opa = Custom("OPA", "opa_sidecar.png")
        node2 >> Edge(color="darkgreen") << opa
    with Cluster("POD Group", direction="TB"):
        node3 = ECS("node3")
        opa = Custom("OPA", "opa_sidecar.png")
        node3 >> Edge(color="darkgreen") << opa
    with Cluster("DB Cluster", direction="LR"):
        db_primary = RDS("serviceDB")
        db_primary >> RDS("serviceDB ro")

    nodes = [node1 , node2, node3]


    actor >> lb
    lb >> nodes
    nodes >> Edge(color="blue") >> redis
    nodes >> Edge(color="darkgreen") >> db_primary


diag