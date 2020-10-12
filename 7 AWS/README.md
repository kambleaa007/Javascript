# AWS

[AWS] Important Notes

## [Just AWS] 07. AWS Fundamentals

### AWS

On Demand, Pay as You Go, Delivered Over Internet,
to elimainated heavy lifted tasks
common areas-> storage, calculations, secure, automation, DB as service, DevOPs, ML, IoT, Identity Management, etc.

### What Is Cloud Computing?
Cloud computing is the on-demand delivery of compute power, database storage, applications, and other IT resources through a cloud services platform via the internet with pay-as-you-go pricing.

### AWS Infrastructure 
-> location by Latency (Speed) -> where your customers are
-> Cost varies with region
-> Compliance (govt laws)
-> Services (frequent brand new updates varies with locations)

collections of availabilites

### Sample app

loads -> Elastic Load Balancer -> distribute traffic -> elastic compute class (EC2 instances) 
EC2
-> Amazon simple store service (S3)
-> DynamoDB
-> RDS relational db server

### Compute Services on AWS
to power your business-> need compute capacity
flexibility you can run virtually any app in cloud 
container services 
-> Amazon Elastic Compute EC2


-> docker (elastic container serice) ECS
Amazon Elastic Container Service (Amazon ECS) is a highly scalable, high-performance container orchestration service that supports Docker containers. It allows you to run and scale containerized applications on AWS.
-> kubernetes () EKS
Amazon Elastic Container Service for Kubernetes (Amazon EKS) makes it straightforward to deploy, manage, and scale containerized applications that use Kubernetes on AWS

AWS Fargate is a compute engine for Amazon ECS and Amazon EKS that allows you to run containers without having to manage servers or clusters

-> pure serverless solutions (AWS Lambda)
AWS Lambda lets you run code without provisioning or managing servers. You pay only for the compute time you consume there is no charge when your code isn't running

### Amazon Elastic Compute Cloud (EC2)
Amazon Elastic Compute Cloud (Amazon EC2) is a web service that provides secure and resizable compute capacity in the cloud. It's designed to make web-scale cloud computing easier for developers.

Amazon EC2 presents a true virtual computing environment, and it allows you to use web service interfaces to launch instances with a variety of operating systems, load them with your custom application environment, manage your network’s access permissions, and run your image by using as many or few systems as you want.

Amazon EC2 instance types->
Amazon EC2 provides a wide selection of instance types that are optimized to fit different use cases. Instance types comprise varying combinations of CPU, memory, storage, and networking capacity. They give you the flexibility to choose the appropriate mix of resources for your applications. Each instance type includes one or more instance sizes, which allows you to scale your resources to the requirements of your target workload

### Creating a (Web Server) Using Amazon EC2

### Amazon Lightsail
Amazon Lightsail is the easiest way to get started with AWS for developers, small businesses, students, and other users who need a simple virtual private server (VPS) solution. Lightsail provides developers compute, storage, and networking capacity, and it also provides capabilities to deploy and manage websites and web applications in the cloud. Lightsail includes everything you need to launch your project quickly--a virtual machine, solid state drive (SSD)-based storage, data transfer, Domain Name System (DNS) management, and a static IP--for a low, predictable monthly price.

### Networking and Storage

### Amazon Virtual Private Cloud (VPC) Part 1
VPC -> A Box (isolate)-> divide sub nets -> inside it launch EC2 instance
Multi Availability Zones
VPC -> stops all traffic In/Out -> security -> to communicate need gateway (Internet Gate Way) -> IGW

1) Build VPC -> Region and IP range -> 10.10.0.0/16
2) Build Sub Net -> subset of IP range VPC itself -> 10.10.1.0/24
3) Build Internet Gateway -> Attach to VPC
4) Route Tables -> select VPC -> edit routes Public (0.0.0.0/0) -> Target to gateway
5) Build EC2 instance in subnet
6) Build Private (Without IGW) Sub Net for DB -> 10.10.2.0/24
7) Inside launch RDS DB
8) Build Sub Net in another availability zone same VPC
10.10.3.0/24 public2
10.10.4.0/24 private2
9) edit Route table add public2
10) ELB Load Balancers

Amazon Virtual Private Cloud
Amazon Virtual Private Cloud (Amazon VPC) lets you provision a logically isolated section of the AWS Cloud where you can launch AWS resources in a virtual network that you define. You have complete control over your virtual networking environment, including the selection of your own IP address range, the creation of subnets, and the configuration of route tables and network gateways. You can use both IPv4 and IPv6 in your VPC for secure and easy access to resources and applications. You could create up to five non-default VPCs per AWS account per Region

Subnets
A VPC spans all the Availability Zones in the Region. After creating a VPC, you can add one or more subnets in each Availability Zone. When you create a subnet, you specify the CIDR block for the subnet, which is a subset of the VPC CIDR block. Each subnet must reside entirely within one Availability Zone, and it can't span Availability Zones.

### Storage on AWS
S3 (Object level storage) -> update whole file for every change
RDS (Block level storage) -> update block only

### Amazon Elastic Block Store (Amazon EBS)

when you launch EC2 instance
EC2 instance -> start/stop
EBS Volume Attach (EBS) -> lives outside EC2 -> flexible to attach any new EC2 instance

Amazon EBS can attach to only one EC2 instance at a time.


1) BOOT
2) DATA

### Amazon EBS Notes


Amazon Elastic Block Store (Amazon EBS) provides persistent block storage volumes for use with Amazon EC2 instances in the AWS Cloud. Each Amazon EBS volume is automatically replicated inside an Availability Zone to protect you from component failure, which offers high availability and durability. Amazon EBS volumes offer the consistent and low-latency performance that you need to run your workloads.

Amazon EBS provides a range of options that allow you to optimize storage performance and cost for your workload. These options are divided into two major categories: SSD-backed storage for transactional workloads, such as databases and boot volumes (performance depends primarily on IOPS), and hard disk drive (HDD)-backed storage for throughput-intensive workloads, such as MapReduce and log processing (performance depends primarily on MB/s).

The Elastic Volume feature of Amazon EBS allows you to dynamically increase capacity, tune performance, and change the type of live volumes with no downtime or performance impact. This allows you to easily right-size your deployment and adapt to performance changes.

### Amazon Simple Storage Service (Amazon S3)

Amazon Simple Storage Service (Amazon S3) stores data as objects within resources that are called buckets. You can store as many objects as you want within a bucket, and you can write, read, and delete objects in your bucket. Objects can be up to 5 TB in size.

You can control access to both the bucket and the objects (who can create, delete, and retrieve objects in the bucket for example), and view access logs for the bucket and its objects. You can also choose the AWS Region where a bucket is stored to optimize for latency, minimize costs, or address regulatory requirements.

Create Bucket -> upload -> Link (Default is Private) -> Permissions -> Public (Read Only)

### Amazon Elastic File System (Amazon EFS)

Reginaly Distributed File Stores -> Many EC2 insta even Different VPCs EC2 too

### Amazon EFS Notes

Amazon Elastic File System (Amazon EFS) provides simple, scalable, elastic file storage for use with AWS Cloud services and on-premises resources. It is straightforward to use, and it offers a simple interface that allows you to create and configure file systems quickly and easily.

Amazon EFS is designed to provide massively parallel shared access to thousands of Amazon EC2 instances. This enables your applications to achieve high levels of aggregate throughput and IOPS that scale as a file system grows, with consistent low latencies.

When an Amazon EFS file system is mounted on Amazon EC2 instances, it provides a standard file system interface and file system access semantics, which allows you to seamlessly integrate Amazon EFS with your existing applications and tools. Multiple Amazon EC2 instances can access an Amazon EFS file system at the same time, thus allowing Amazon EFS to provide a common data source for workloads and applications that run on more than one Amazon EC2 instance.






