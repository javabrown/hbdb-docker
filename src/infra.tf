{
  "variables": {
    "aws_access_key": "",
    "aws_secret_key": ""
  },

  "provisioners": [
    {
        "type": "shell",
        "execute_command": "echo 'ubuntu' | {{ .Vars }} sudo -E -S sh '{{ .Path }}'",
        "inline": [
            "sleep 30",
            "apt-add-repository ppa:ansible/ansible -y",
            "/usr/bin/apt-get update",
            "/usr/bin/apt-get -y install ansible",
            "mkdir /home/ubuntu/node-app",
            "chown ubuntu:ubuntu /home/ubuntu/node-app"
        ]
    },
    {
      "type": "file",
      "source": ".",
      "destination": "/home/ubuntu/node-app/"
    },
    {
      "type": "ansible-local",
      "playbook_file": "packer/ansible-playbook.yml"
    }
  ],

  "builders": [{
    "type": "amazon-ebs",
    "access_key": "{{user `aws_access_key`}}",
    "secret_key": "{{user `aws_secret_key`}}",
    "region": "ap-south-1",
    "source_ami_filter": {
      "filters": {
        "virtualization-type": "hvm",
        "name": "ubuntu/images/*ubuntu-trusty-14.04-amd64-server-*",
        "root-device-type": "ebs"
      },
      "owners": ["099720109477"],
      "most_recent": true
    },
    "instance_type": "t2.micro",
    "ssh_username": "ubuntu",
    "ami_name": "packer-example {{timestamp}}",
    "launch_block_device_mappings": [{
      "device_name": "/dev/sda1",
      "volume_size": 8,
      "volume_type": "gp2",
      "delete_on_termination": true
    }]
  }]
}