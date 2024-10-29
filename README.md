This file can be used as a template for initializing and running spring projects.

What's included: 
1. Gradle file created from start.spring.io
2. Plugins for Spotbugs, Checkstyle and Jacoco included
3. Other dependencies like Mongo, MySql and redis.
4. Dockerfile to start mongo server and run the spring boot application within.

Usage - 

1. To build the repository - 

From the repository root, 

1. run `./gradlew build test`run the build
2. run `./gradlew bootjar` to create executable jar. The jar will be located inside build directories.

To run inside docker container, use below commands

To build docker image, use the command below - `docker build -t your_tag_name  .`

To run the generated container, use this command - `docker run -p8080:8080 your_tag_name`. This will run the server on 8080 port.. You can change the ports as per your needs. 


License - 
While this repository is licensed under APACHE 2.0 license, It is mandatory for users to share the readme.md and License file along with the changes they do in the contents.

-->0

# Make sure you are inside your repo or go to the cloned repo directory

cd aakashkumarjha295-ME_BUILDOUT_XMEME_JAVA/


# Let us add the remote repository from which we will pull the code stubs for the first module

git remote add starter-template git@gitlab.crio.do:public_content/spring-starter.git

git pull starter-template master --allow-unrelated-histories --strategy-option=ours



--> 1
# Go to the project directory

cd ~/workspace/aakashkumarjha295-ME_BUILDOUT_XMEME_JAVA/


cd sample-data

chmod +x load-sample-data.sh

./load-sample-data.sh



-->2

# Type mongo in terminal and it will take you to mongodb prompt.

mongo

# From within the mongo terminal, type the commands one by one.

show dbs

use greetings

show collections
db.greetings.find().pretty()

--> 2.1

# Ensure the sanity of the code base by executing the commands

# Make sure you are inside your repo where the gradlew directory is present

chmod +x ./gradlew

./gradlew bootrun

-->2.2

curl localhost:8081/say-hello?messageId=001

curl localhost:8081/say-hello?messageId=002

--> 2.3

# The following command should be successful.

./gradlew test



--> 3
#Bring up your server by running the command inside your cloned repository.

./gradlew bootrun


#Execute the curl commands to verify the api request and response.

# Execute the GET /memes endpoint using curl to ensure your DB is in a clean slate

# Should return an empty array.

curl --location --request GET 'http://localhost:8081/memes/'


# Execute the POST /memes endpoint using curl

curl --location --request POST 'http://<Server_URL>/memes/' \

--header 'Content-Type: application/json' \

--data-raw '{

"name": "xyz",

"url": "https://cwod-assessment-images.s3.ap-south-1.amazonaws.com/images/130.png",

"caption": "This is a meme"

}'


# Execute the GET /memes endpoint using curl

curl --location --request GET 'http://localhost:8081/memes/'


# If you have swagger enabled, make sure it is exposed at localhost:8081

curl --location --request GET 'http://localhost:8081/swagger-ui.html'


# To run the test cases locally, install the requirements.

pip3 install -r requirements.txt

pytest --pspec --disable-pytest-warnings assessment/main.py


# https://gitlab.crio.do/COHORT_ME_BUILDOUT_XMEME_JAVA_ENROLL_1727250076031/aakashkumarjha295-ME_BUILDOUT_XMEME_JAVA