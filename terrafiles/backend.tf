terraform {
   backend "s3" {
    profile = "default"
    bucket = "task-lambda-apigateway-bucket-29122023"
    key = "terrafiles/terraform.tfstate"
    region = "us-east-1"
    encrypt = "true"
    dynamodb_table = "task-lambda-apigateway-table-29122023"
  }  
}