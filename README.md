# Workout app

## Instructions:
1. Clone repository: git clone https://github.com/kuuseke1/workoutapp.git
1a. if using idea for cloning: if prompted, Create Idea project->Create from existing sources->Next->Next->Finish.
2. Ensure project JDK is 11
3. If using IntelliJ, open project and right-click on /server/build.gradle -> import Gradle project
4. Check Auto-import, and select use local gradle distro, select Gradle JVM to be 11-> OK
5. Wait until gradle finishes
6. To run app, from right sidebar menu Gradle->Tasks->application->bootRun
7. Wait until ready, then send a HTTP request to any endpoint to check (probably localhost:8080/workouts)
8. To stop server, stop button from top menu
9. To prepare front-ent app, navigate to /web/ folder and run "npm install"
10. Run "npm run serve", to stop use ctrl+C
