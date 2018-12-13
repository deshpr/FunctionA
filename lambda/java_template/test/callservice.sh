#!/bin/bash

# JSON object to pass to Lambda Function
msg="ServerlessComputingWithFaaS"
shift=5
json={"\"msg\"":"\"$msg\"","\"shift\"":"\"$shift\""}

echo "Invoking Lambda function using API Gateway"
time output=`curl -s -H "Content-Type: application/json" -X POST -d  $json https://dclii4c7q6.execute-api.us-west-2.amazonaws.com/dev`

echo ""
echo "CURL RESULT:"
echo $output
echo ""
echo ""

echo "Invoking Lambda function using AWS CLI"
time output=`aws lambda invoke --invocation-type RequestResponse --function-name func_a --region us-west-2 --payload $json /dev/stdout | head -n 1 | head -c -2 ; echo`
echo ""
echo "AWS CLI RESULT:"
echo $output
echo ""

# Now invoke the decryption function

res=$(echo $output | jq '.value')
echo "Encrypted value = $res"

json={"\"msg\"":"$res","\"shift\"":"\"$shift\""}

echo "Invoking Decryption Lambda function using API Gateway"
time output=`curl -s -H "Content-Type: application/json" -X POST -d  $json https://suqiqm1vmk.execute-api.us-west-2.amazonaws.com/dev/`

echo ""
echo "CURL RESULT:"
echo $output
echo ""
echo ""

echo "Invoking Decryptiion Lambda function using AWS CLI"
time output=`aws lambda invoke --invocation-type RequestResponse --function-name func_b --region us-west-2 --payload $json /dev/stdout | head -n 1 | head -c -2 ; echo`
echo ""
echo "AWS CLI RESULT:"
echo $output
echo ""


