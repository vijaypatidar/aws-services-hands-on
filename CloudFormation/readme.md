# CloudFormation Template 

### Creating EC2 instance with security group to allow traffic from port Web(3000) and SSH(22)

1. Create EC2 instance
```json
{
    "Resources": {
        "Ec2Instance": {
            "Type": "AWS::EC2::Instance",
            "Properties": {
                "KeyName": "awsl1",
                "ImageId":"ami-08df646e18b182346",
                "InstanceType":"t2.micro"
            }
        }
    }
}
```

2. Creating Security group
```json
{
    "Resources": {
        "InstanceSecurityGroup": {
            "Type": "AWS::EC2::SecurityGroup",
            "Properties": {
                "GroupDescription": "Enable SSH access via port 22 and web via 3000",
                "SecurityGroupIngress": [
                    {
                        "IpProtocol": "tcp",
                        "FromPort": 22,
                        "ToPort": 22,
                        "CidrIp": "0.0.0.0/0"
                    },{
                        "IpProtocol": "tcp",
                        "FromPort": 3000,
                        "ToPort": 3000,
                        "CidrIp": "0.0.0.0/0"
                    }
                ]
            }
        }
    }
}
```
3. Updating ec2 template to configure SG create in step 2.
```json
{
    "Resources": {
        "Ec2Instance": {
            "Type": "AWS::EC2::Instance",
            "Properties": {
                "SecurityGroups": [
                    {
                        "Ref": "InstanceSecurityGroup"
                    }
                ],
                "KeyName": "awsl1",
                "ImageId":"ami-08df646e18b182346",
                "InstanceType":"t2.micro"
            }
        },
        "InstanceSecurityGroup": {
            "Type": "AWS::EC2::SecurityGroup",
            "Properties": {
                "GroupDescription": "Enable SSH access via port 22 and web via 3000",
                "SecurityGroupIngress": [
                    {
                        "IpProtocol": "tcp",
                        "FromPort": 22,
                        "ToPort": 22,
                        "CidrIp": "0.0.0.0/0"
                    },{
                        "IpProtocol": "tcp",
                        "FromPort": 3000,
                        "ToPort": 3000,
                        "CidrIp": "0.0.0.0/0"
                    }
                ]
            }
        }
    }
}
```
