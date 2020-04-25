
# Supplier Purchase Order Microservice

* Deploying an integrated Jenkins server inside of OpenShift
* Running both custom and oob Jenkins slaves as pods in OpenShift
* "One Click" instantiation of a Jenkins Pipeline using OpenShift's Jenkins Pipeline Strategy feature




##  Deployment Instructions

### 1. Create Lifecycle Stages

For the purposes of this demo, we are going to create three stages for our application to be promoted through.

- `arcaid-cicd`
- `spo-api-service-dev`
- `spo-api-service-test`
- `spo-api-service-stage`
- `spo-api-service-prod`

In the spirit of _Infrastructure as Code_ we have a YAML file that defines the `ProjectRequests` for us. This is as an alternative to running `oc new-project`, but will yeild the same result.

```
$ oc create -f  openshift/projects/projects.yml


### 2. Stand up Jenkins master in dev

For this step, the OpenShift default template set provides exactly what we need to get jenkins up and running.

```


### 4. Instantiate Pipeline

```

A _deploy template_ is provided at `openshift/templates/deployment.yml` that defines all of the resources required to run our Tomcat application. It includes:

* A `Service`
* A `Route`
* An `ImageStream`
* A `DeploymentConfig`
* A `RoleBinding` to allow Jenkins to deploy in each namespace.

This template should be instantiated once in each of the namespaces that our app will be deployed to. For this purpose, we have created a param file to be fed to `oc process` to customize the template for each environment.
```

#### Deploy the deployment template to all four projects.

```

$  oc process -f http://gogs-ci-cd.f7d0.icc-oberon.openshiftapps.com/arcadia-group/spo-api-service/raw/master/openshift/templates/deployment.yml -p=APPLICATION_NAME=spo-api-service -p NAMESPACE=spo-api-service-dev -p=SA_NAMESPACE=ci-cd  | oc apply -f-



A _build template_ is provided at `applier/templates/build.yml` that defines all the resources required to build our java app. It includes:

* A `BuildConfig` that defines a `JenkinsPipelineStrategy` build, which will be used to define out pipeline.
* A `BuildConfig` that defines a `Source` build with `Binary` input. This will build our image.
```
#### Deploy the pipeline template in build only.
```

$ oc process -f applier/templates/build.yml -p=APPLICATION_NAME=basic-spring-boot
 -p NAMESPACE=basic-spring-boot-dev -p=SOURCE_REPOSITORY_URL="https://github.com/redhat-cop/container-pipelines.git" -p=APPLICATION_SOURCE_REPO="https://github.com/redhat-cop/spring-rest.git" | oc apply -f-
buildconfig "spring-rest-pipeline" created
buildconfig "spring-rest" created


At this point you should be able to go to the Web Console and follow the pipeline by clicking in your `basic-spring-boot-build` project, and going to *Builds* -> *Pipelines*. At several points you will be prompted for input on the pipeline. You can interact with it by clicking on the _input required_ link, which takes you to Jenkins, where you can click the *Proceed* button. By the time you get through the end of the pipeline you should be able to visit the Route for your app deployed to the `myapp-prod` project to confirm that your image has been promoted through all stages.

```

## Envroinment Variables

