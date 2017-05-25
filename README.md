# ConfigWiz
ConfigWiz is a dependency manangement tool that produces a serialized list of dependencies provided with an input. The goal of this tool is to make configuration of workstations and software more manageable. ConfigWiz uses a dependency repository model where all dependencies sit within one big repository. 

# TODO

Add an upload script to programatically move new dependencies to the repo.
Add a system to configure script execution.
Add a web interface for the tool to allow for configuration of new and existing dependencies.
Allow for remote repository access.

# Requirements

JDK 8, Scala 2.12, and sbt.

# Install

To install from source run the following:
```
$ sbt assembly
```

There is also a destributed jar under target/scala-2.12/.


# Running

The environment variable CONFIG_WIZ_HOME must be set to the directory in which the dependecy.json to resolve sits.  All all directory paths must end with a forward slash `/`. 

```
frank@computer:~/Documents/config-wiz$ export CONFIG_WIZ_HOME="config-wiz/"
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
