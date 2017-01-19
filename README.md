#CoreJavaNotes
This project is some sandbox coding to brush up on some Java skills and to try out some features
of Java 8. It was created in Android Studio which requires some adjustments to create pure Java projects

- Remove `include ':app'` from the root project's `settings.gradle`
- Remove `app` directory
- Create folder hierarchy for your Java code (src/main/java) and test code (src/test/java)
- Replace root project's `build.gradle` with:

```
apply plugin: 'java'

sourceCompatibility = 1.8
version = '1.0'

repositories {
    mavenCentral()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.11'
}
```

- Make sure to right-click the `test` folder and Mark Directory As > Test Sources Root.

## Useful Keyboard Shortcuts (Mac)

### Android Studio

Search Android Studio:
command + shift + A

Open javadoc documentation for the code under the cursor:
control + J

Copy the current line and paste it below:
command + D

Basic code completion:
control Space

Select line from cursor:
Shift + command + arrow

Select Line:
command + Arrow then command + Shift + Opposite Arrow

Delete Line
command Backspace

Column Selection
command + Shift + 8 Then Shift + Arrow
Mouse option + Mouse Drag

Select one word at a time:
option + Shift + Arrow

Move between open tabs:
command + Shift + [

Close file:
command + W

Goto Implementation:
command + alt + b

Goto Declaration:
command + b

Goto Type Declaration:
control + shift + b

Optimize Imports:
control + option + O

Warning Dropdown:
Options: Option + Enter

Search Everywhere:
Shift Shift

Suppress Warnings:
Option + Enter > Submenu related to the error message
I.e., Error = Field Not Used -  Safe Delete > Suppress for Field
