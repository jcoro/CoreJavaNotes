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


## Collections - Notes

### Describe some best use cases for iterators and for loops

We know that:
- Lists (e.g., LinkedLists and ArrayLists) have indices and are ordered.
- Sets (e.g., HashSets and TreeSets) don't have indices and are unordered.
- the Collection.add(E e) method returns a boolean and adds an element to the end of a List
- Adding elements in the middle of an ordered list requires an iterator.
- The "for each" loop uses an iterator "under the hood."
- We should never use a (plain) for loop to step through a LinkedList - each time an element is
looked up, the search starts again from the beginning.

Use a for loop:
- On arrays and ArrayLists when you don't want to traverse the entire collection or when the index
value is needed in the loop.

Use iterators or "for each" loops.
- When each element needs to be traversed and the index value isn't needed in the loop.
- Use LinkedLists when elements need to be inserted and removed in the middle, and use iterators
to facilitate this.

### What is the difference between an Iterator and a ListIterator?

Because (unlike LinkedLists, for example) Sets are unordered, the Iterator interface has
no add() method (instead, we call .add() on the Collection itself - not the Iterator).
The ListIterator<E> is a subinterface used on Lists which does have an add()
method and which doesn't return a boolean because Lists allow multiple instances of elements which
are equal.


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
