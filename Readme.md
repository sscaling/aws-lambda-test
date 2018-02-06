AWS Lambda test
===============

Some tests for developing Lambda functions

Pre-requisites
--------------

[AWS docs](https://docs.aws.amazon.com/lambda/latest/dg/setup.html)

Follow the getting started guide.

1.	Create user
2.	Create access key
3.	Download CLI `brew install awscli`
4.	Configure AWS CLI `aws configure` (enter access/secret key, region and 'json' as output format)
5.	Pull local lambda java docker environment. `docker pull lambci/lambda:java8` [github](https://github.com/lambci/docker-lambda)

local Nodejs
------------

Run a docker container and mount the code through as a volume:

```
docker run --rm -v "$PWD"/task:/var/task lambci/lambda:nodejs6.10
```

local Java
----------

**Simple String-length count handler**

Make package

```
mvn package
```

Run a docker container with parameters:

```
docker run --rm -v "$PWD/target/classes":/var/task lambci/lambda:java8 com.shaunscaling.lambdatest.StringHandler::countHandler '"GAH"'
```

Testing with SAM (nodejs)
-------------------------

Use [SAM](https://docs.aws.amazon.com/lambda/latest/dg/test-sam-local.html) to test locally.

In the correct directory, start SAM

```
cd products && sam local start-api
```

Execute various requests

```
curl http://localhost:3000/products
curl -XPOST http://localhost:3000/products
curl -XDELETE http://localhost:3000/products/1
curl -XPUT http://localhost:3000/products/1
curl -XPATCH http://localhost:3000/products
```

**Java - with S3 Event**

Uses `./template.yaml` to define function

```
mvn package
sam local generate-event s3 --bucket testbucket  --key testkey > s3event.json
sam local invoke  S3Handler -e s3event.json
```
