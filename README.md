JBehavePoC
==========

Description
-----------
This is a proof of concept of JBehave, just to study this library and the BDD concepts in Java.

Libraries used
--------------

This project uses Gradle to download its libraries and their dependencies. They are:

* *junit*, because we have tests!
* *jbehave*, obviously
* *jbehave-junit-runner*, so we can have a nice output when running our tests in Eclipse

Why Gradle?
-----------

I've already made [this same project using Maven](http://github.com/esdrasbeleza/JBehaveWithMaven).

[@marceloemanoel](http://github.com/marceloemanoel) got hungry when he saw it, as expected, and told me to use Gradle, as expected. So I used Gradle for the first time and took some [conclusions](#conclusions).

Changes
-------

There are very few changes from this project to the version that uses Maven.

The most visible changes are in the class *CalculatorStories* in order to solve Gradle questions. There's a friendly and really necessary comment in the class explaining it.

If you want to analyse the differences yourself, checkout both projects and run some diff tool.

Conclusions!
------------

* Gradle is *easier* to learn than Maven
* Gradle has *shorter configuration files* than Maven's.
* Gradle has *no XML configuration files*, and this alone can be a good reason to switch to Gradle






