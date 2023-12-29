terraform {
   backend "s3" {
    bucket = "lambda-apigateway-bucket29122023"
    key = "terraform.tfstate"
    region = "us-east-1"
    encrypt = "true"
    dynamodb_table = "task-lambda-apig-table"
  }  
}