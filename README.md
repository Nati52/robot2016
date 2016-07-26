# FRC Team 449's 2016 Build Season Code
This is the repo containing all of the non-library, 2016 build season specific robot code. This code is built and deployed using [GradleRIO](https://github.com/Open-RIO/GradleRIO), and depends on Team 449's [central repo](https://github.com/blair-robot-project/449-central-repo). Instructions on how to build and deploy this code onto a RoboRIO are below.

After competion season, all subsystems, commands, and library utilities were moved to the central repo.

This is the first 449 code base to use the build-season-code-calls-central-library model. Since the 2016 build season code was applied to the model after build season, this repo only contains the final modified versions of essential files. The 2016 build season code was originally developed on yonip's repo [team449-2016](https://github.com/yonip/team449-2016).

## Building and Deploying
This project uses gradle with the GradleRIO plugin. More detailed information can be found at their Github site.

### Recomended Directory Structure
To build the 2016 robot code, clone this repo and the central repo so that they are in the same directory.

```
~/IdeaProjects
    /449-central-repo
    /robot2016
```

### Gradle Commands
This project can be built and deployed without installing gradle by using the gradle wrapper scripts included with the project. All gradle commands are run using `gradlew` (or `./gradlew` on *nix). All of these commands must be run in the `/robot2016` directory.

* Building:                             `gradlew build`
* Cleaning (local):                     `gradlew clean`
* Cleaning (remote):                    `gradlew cleanRIO`
* `dos2unix`ing the configuration file: `gradlew convertFiles`
* Deploying:                            `gradlew deploy`
