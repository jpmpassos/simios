provider "aws" {
  version = "~> 2.29"
  shared_credentials_file = "~/.aws/credentials"
  profile = "terraform"
  region = "us-east-1"
}