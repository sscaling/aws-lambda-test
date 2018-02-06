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

Use [SAM](https://docs.aws.amazon.com/lambda/latest/dg/test-sam-local.html) to test locally.

Run a docker container and mount the code through as a volume:

```
docker run --rm -v "$PWD"/task:/var/task lambci/lambda:nodejs6.10
```
