# ConfigWiz
Dependency managment tool.

# Requirements
JDK 8, Scala 2.12, and sbt.

# Install:
```
$ sbt assembly
```

# Running:

```
frank@computer:~/Documents/config-wiz$ java -jar target/scala-2.12/config-wiz-assembly-1.0.jar config-wiz/
[18:20:10] - Home location: /home/frank/Documents/config-wiz/config-wiz/
[18:20:10] - Resolving: config-wiz/dependency.json
[18:20:10] - Serializing graph
[18:20:10] - Fetching config-wiz/dependency.json
[18:20:10] - Fetching /home/frank/Documents/config-wiz/config-wiz/test1@1/dependency.json
[18:20:10] - Fetching /home/frank/Documents/config-wiz/config-wiz/test@1/dependency.json
[18:20:10] - Serializing done
[18:20:10] - Writing output to: config-wiz/output/
[18:20:10] - Removing contents of directory /home/frank/Documents/config-wiz/config-wiz/output
[18:20:10] - Creating directory /home/frank/Documents/config-wiz/config-wiz/output/[1]-test@1
[18:20:10] - Copying /home/frank/Documents/config-wiz/config-wiz/test@1 to /home/frank/Documents/config-wiz/config-wiz/output/[1]-test@1
[18:20:10] - Creating directory /home/frank/Documents/config-wiz/config-wiz/output/[2]-test1@1
[18:20:10] - Copying /home/frank/Documents/config-wiz/config-wiz/test1@1 to /home/frank/Documents/config-wiz/config-wiz/output/[2]-test1@1
[18:20:10] - Done!
```
