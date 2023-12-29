terraform {
  backend "s3" {

    profile        = "default"
    encrypt        = "true"
    dynamodb_table = "task-lambda-apig-table"
  } 
}