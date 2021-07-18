import boto3
import os

s3 = boto3.client("s3")

for file in os.listdir():                              # searches file in current directory
    if '.war' in file:                                  # if .war files are present 
        upload_file_bucket = 'my-dummy-bucket'               # ur s3 bucket name
        upload_file_key = 'myfolder/' + str(file)           # ur folder path inside bucket
                                                            # files will be saved in myfolder/something.war 
        s3.upload_file(file, upload_file_bucket, upload_file_key)
