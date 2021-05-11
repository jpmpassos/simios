resource "aws_vpc" "main" {
  cidr_block = "192.168.0.0/16"

  tags = {
    Name = "medinapassos"
  }
}

resource "aws_subnet" "private_subnet" {
  count = 2

  vpc_id = "${aws_vpc.main.id}"

  cidr_block = "${cidrsubnet(aws_vpc.main.cidr_block, 8, count.index + 10 )}"
  availability_zone = "${var.availability_zones[count.index]}"

  tags = {
    Name = "medinapassos_private_subnet_${count.index}"
  }
}

resource "aws_subnet" "public_subnet" {
  count = 2

  vpc_id = "${aws_vpc.main.id}"

  cidr_block = "${cidrsubnet(aws_vpc.main.cidr_block, 8, count.index + 20 )}"
  availability_zone = "${var.availability_zones[count.index]}"
  map_public_ip_on_launch = true

  tags = {
    Name = "medinapassos_public_subnet_${count.index}"
  }
}

resource "aws_internet_gateway" "itw" {
  vpc_id = "${aws_vpc.main.id}"
}

resource "aws_route_table" "router_itw" {
  vpc_id = "${aws_vpc.main.id}"

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.itw.id}"
  }
}

resource "aws_route_table_association" "route_table_association" {
  count = 2
  route_table_id = "${aws_route_table.router_itw.id}"
  subnet_id = "${element(aws_subnet.public_subnet.*.id, count.index )}"
}