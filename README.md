Mainly 3 ways to upload files in database
1. Database (BLOB) storage
2. Local file system storage
3. Cloud storage (Cloudinary / S3 / GCS) ⭐ Best practice

1)Db (blob) storage --> more secure and less frequentily used files are stored in this way
files are compressed and stored in db.
while downloading it return back byte array

2)Local file system storage  --> faster access and for frequently used files stored in this way
not scalable, we store files in local folder, that folder path is stored in db. 

3)Cloud storage --> now everyone using this approach.
storing images/videos in amazon s3 or cloudinary site, and we can retrive it from there.
but which are cost effective
