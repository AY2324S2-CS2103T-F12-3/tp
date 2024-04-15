---
layout: page
title: Carsten's Project Portfolio Page
---

### Project: TutorPro Level 1

TutorPro - Level 1 is a desktop contact management application used for managing students as a **Private Tutor**. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: `remind` command
  * What it does: Allows users to create reminders.
  * Justification: Allows users to create reminders to be viewed in a schedule.
  * Highlights: Users can see upcoming reminders easily.
* **New Feature**: `event` command
  * What it does: Allows users to create events.
  * Justification: Allows users to create events to be viewed in a schedule.
  * Highlights: Users can see upcoming events easily.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=Wyrkx&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23)

* **Project management**:
  * Suggested implementations and bugfixes

* **Enhancements to existing features**:
  * `edit` command: 
    * Made `edit` able to edit information for both `Student` and `Person`.
  * Saving and Loading:
    * Added `JsonAdaptedEvent`, `JsonAdaptedParent`, `JsonAdaptedReminder`, `JsonAdaptedEvent` and edited `JsonSerializableAddressBook` 
      to ensure that different objects can be saved and loaded.
  

* **Documentation**:
  * Added Ui.png
  * Corrected the UG for `edit` command
  * Updated the DG for saving/loading, and `add` command

* **Community**:
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/AY2324S2-CS2103T-T14-1/tp/issues/131), [2](https://github.com/AY2324S2-CS2103T-T14-1/tp/issues/129), [3](https://github.com/AY2324S2-CS2103T-T14-1/tp/issues/124))
