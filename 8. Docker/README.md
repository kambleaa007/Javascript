# Docker Kubernetes

[Docker] Important Notes

## [Just Docker] 07. Docker Fundamentals

### Docker
A Beginner’s Guide To Docker

Docker is a platform to develop, deploy, and run applications inside containers. If you’re a current or aspiring software developer or data scientist, Docker is in your future.

Let's understand how docker works

### What is Docker?

Docker is an open-source platform for building distributed software using “containerization,” which packages applications together with their environments to make them more portable and easier to deploy.

### Is Docker a virtual machine?

A virtual machine includes a complete operating system. It will work independently and act like a computer.

A Docker will only share the resources of the host machine to run its environments.

![Docker](https://raw.githubusercontent.com/kambleaa007/Javascript/master/8.%20Docker/pics/1.png)


### Why use Docker?

- Docker is fast.
- Docker is multi-platform.
- Containers can be built & destroyed faster.
- You keep your work-space clean, as each of your environments will be isolated
- It will be easier to deploy your project on your server to put it online

### Important Docker Vocabulary - 

1. Layer: a set of read-only files or commands that describe how to set up the underlying system beneath the container.

2. Image: an immutable layer that forms the base of the container.

3. Container: an instance of the image that can be executed as an independent application. 

4. Registry: storage and content delivery system used for distributing Docker images.

5. Repository: a collection of related #Docker images.

### Basic #Docker commands that you need to start working with containers. 
This contains 4 subsections - 

1. Creating Docker Containers
2. Running Docker Containers
3. Using Docker Utilities
4. Cleaning Up Your Docker Environment

1. Creating Docker Containers

-docker create [image] 
Create a new container from a particular image.

- docker login
Log in to the Docker Hub repository.

- docker push [username/image] 
Pull an image from the Docker Hub repository.

- docker search [term]
Search the Docker Hub repository for a particular term.

- docker tag [source] [target] 
Create a target tag or alias that refers to a source image.

2. Running Docker Containers

- docker start [container]
Start a particular container.

- docker stop [container]
Stop a particular container.

- docker exec -ti [container] [command]
Run a shell command inside a particular container.

- docker run -ti — rm — image [image] [container] [command]
Create and start a container at the same time, run a command inside it & then remove the container after executing.

- docker pause [container] 
Pause all processes running within a particular container.

3. Using Docker Utilities

- docker history [image]
Display the history of a particular image.

- docker images
List all of the images that are currently stored on the system.

- docker inspect [object]
Display low-level information about a particular Docker object.

- docker ps
List all of the containers that are currently running.

- docker version
Display the version of Docker that is currently installed on the system.

4. Cleaning Up Your Docker Environment:

- docker kill [container]
Kill a particular container.

- docker kill $(docker ps -q)
Kill all containers that are currently running.

-docker rm [container]
Delete a particular container that is not currently running.


[kubernetes] Important Notes

## kubernetes

## Docker important commands Cheatsheet.
![Docker Cheatsheet](https://raw.githubusercontent.com/kambleaa007/Javascript/master/8.%20Docker/pics/CheatSheet.png)

