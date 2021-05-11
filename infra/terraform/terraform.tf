terraform {
  backend "s3" {
    bucket = "jpmpassos"
    key = "simios-meli-test"
    region = "us-east-1"
    profile = "terraform"
  }
}