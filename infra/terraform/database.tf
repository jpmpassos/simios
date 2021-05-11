module "rds" {
  source  = "terraform-aws-modules/rds/aws"
  version = "2.5.0"

  identifier = "medinapassos-simios-rds"

  engine = "postgres"
  engine_version = "10.6"
  instance_class = "db.t2.micro"
  allocated_storage = "100"

  name = "simios"
  username = "simiosuser"
  password = "admin123"
  port = "5432"

  vpc_security_group_ids = ["${aws_security_group.databae.id}"]

  maintenance_window = "Thu:03:30-Thu:05:30"
  backup_window = "05:30-06:30"
  storage_type = "gp2"
  multi_az = "false"
  family = "postgres10"

  subnet_ids = "${flatten(chunklist(aws_subnet.private_subnet.*.id, 1))}"
}