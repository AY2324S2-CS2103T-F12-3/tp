---
layout: page
title: User Guide
---

Hi Tutors! A warm welcome to our user guide, your companion for navigating and finding the full potential of TutorPro.

## Table of Contents

- [Quick start](#quick-start)
- [Features](#features)
  - [Add new students: `add`](#adding-new-students--add)
  - [Add new parents: `addp`](#adding-new-parents--addp)
  - [Edit student's details: `edit`](#editing-a-students-details--edit)
  - [Delete student: `delete`](#deleting-existing-students--delete)
  - [Find certain student: `find`](#finding-certain-students--find)
  - [Add events: `event`](#adding-events--event)
  - [Set reminders: `remind`](#setting-reminders--remind)
  - [Clear all entries: `clear`](#clearing-all-entries--clear)
  - [List all persons](#listing-all-persons--list)
  - [Exit: `exit`](#exiting-the-program--exit)
  - [Comming Soon in next update: `schedule`](#comming-soon--schedule)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [Command Summay](#command-summary)

---

## [Quick start](#table-of-contents)

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `tutorpro.jar` from [here](https://github.com/AY2324S2-CS2103T-F12-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your TutorPro.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar tutorpro.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   - `list` : Lists all contacts.

   - `add n/John Doe p/98765432 e/johndoe@gmail.com a/Clementi Ave 123, Blk 321, #12-345 lvl/P5 sub/math-B sub/science-C` : Adds a contact named `John Doe` to your list of contacts.

   - `find John` : Finds all contacts with names containing the word 'John'.

   - `clear` : Deletes all contacts.

   - `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

---

## [Features](#table-of-contents)

<div markdown="block" class="alert alert-info">
**:information_source: Notes about the command format:** <br>

- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  E.g. in `add STUDENT_NAME`, `STUDENT_NAME` is a parameter which can be used as `add John Doe`.

- Names can be duplicated as people can have the same names.

- Phone numbers and emails must be unique.

- Items in square brackets are optional.<br>
  E.g. `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

- Items with `…`​ after them can be used multiple times including zero times.<br>
  Items with … after them can be used multiple times.
  E.g. `sub/SUBJECT-GRADE…` can be used as `sub/math-B`(i.e. 1 time), `sub/math-B sub/science-C`(i.e. 2 times), etc.

- Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  E.g. if the command specifies `help 123`, it will be interpreted as `help`.

- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Adding new Students : `add`

Add a new student with their details to your TutorPro list.

Format: `add n/STUDENT_NAME p/PHONE_NUMBER e/EMAIL_ADDRESS a/ADDRESS lvl/EDUCATION_LEVEL [sub/SUBJECT-GRADE]… [t/TAG]…  `

<div markdown="span" class="alert alert-success">
**:bulb: Tip:**<br>
A student can have 1 or more subjects.
</div>


**Examples:**
* `add n/John Doe p/98765432 e/johndoe@gmail.com a/Clementi Ave 123, Blk 321, #12-345 lvl/P5 sub/math-B sub/science-C+`
* `add n/Jany Doh p/97862354 e/janydoh@email.com a/Changi St 79, Blk 12, #03-456 lvl/S5 t/Seafood allergy`

<div markdown="span" class="alert alert-primary">
**:bulb: Caution:**
Below are some constraints to follow when inputting parameters.
<br>
**Constraints:**
<br>* For `STUDENT_NAME`, capitalization (e.g. `jOhN DoE`) or extra/leading/trailing spaces does not affect the value (e.g. `John     Doe`). The NAME should not have special characters (e.g. `#`, `@`, `!` etc.).
<br>* For `PHONE_NUMBER`, the input must be an 8-digit number and unique.
<br>* For `EMAIL`, the input must consist of the username and the domain name of the email service provider. Must be unique as well.
<br>  * Format: `username@domain.com`
<br>* For `EDUCATION_LEVEL`, the input must not contain special characters.
<br>* For `SUBJECT-GRADE`, the input must follow the following format: `<1 or more words>-<1 or more non-space characters>`
<br>  * This allows you to input subject-grade such as `Math-A*`, `Higher Chinese-B3` or `Software Engineering-A-`, where the subject is more than one word and the grade has numbers or special characters.
<br>  * Note: `SUBJECT` refers to the subject the student is receiving tuition for, while `GRADE` refers to the grade the student obtained for their most recent test on that subject.
<br>  * E.g. `math-B` indicates that the student is receiving tuition for Mathematics, and obtained a B grade for their most recent test for Mathematics.
</div>

### Adding new Parents : `addp`
Add a new parent with their details to your TutorPro list.

Format: `addp n/PARENT_NAME p/PHONE_NUMBER e/EMAIL_ADDRESS a/ADDRESS [t/TAG]…`

**Examples:**
* `addp n/Jonny Doe p/98765432 e/jonnyd@gmail.com a/Clementi Ave 123, Blk 321, #12-345`

<div markdown="span" class="alert alert-primary">
**:bulb: Caution:**
Below are some constraints to follow when inputting parameters.
<br>
**Constraints:**
<br>* For `PARENT_NAME`, capitalization (e.g. `jOhN DoE`) or extra/leading/trailing spaces does not affect the value (e.g. `John     Doe`). The NAME should not have special characters (e.g. `#`, `@`, `!` etc.).
<br>* For `PHONE_NUMBER`, the input must be an 8-digit number
</div>

### Editing a Person's details : `edit`

Edit and/or update a particular person’s details/progress.

Format: `edit INDEX cat/NEW_INFORMATION`
- `INDEX` refers to list index of the person to be edited.
- `cat/` refers to the command prefix of the category that you want to edit. You can edit more than one category in the same command.
  - For name: `n/`
  - For phone number: `p/`
  - For email: `e/`
  - For address: `a/`
  - For education level: `lvl/`
  - For subjects: `sub/`
  - For tags: `t/`

**Examples:**
For the example list shown below:
1. John Doe, P5, Math-B
2. Jany Doh, S1, Science-C
* `edit 1 sub/Math-A` Edits the subject John Doe is being tutored for and his grade to `Math` and `A` respectively.
* `edit 2 lvl/S2` Edits the education level of Jany Doh to `S2`.

<div markdown="span" class="alert alert-primary">
**:bulb: Caution:**
<br>
Editing the `subject` and `tag` categories will replace existing subjects and tags with the new information. For exmaple, <br>
- Current subjects: science-B, math-C <br>
- Edit command: `sub/science-C`<br>
- New subjects: science-c <br>
As you can see, the existing information will be replaced with new information by you.

When editing categories that the person does not have (e.g. Parents will not have subjects), the command will ignore these categories.
<br>
Also, below are some constraints to follow when inputting parameters.
<br>
**Constraints:**
<br>* For `CATEGORY`, the input must be one of the following:
<br>  * `name`, `number`, `email`, `address`, `level`, `subject` or `tags`
<br>* For `NEW_INFORMATION`, the input format depends on the category
<br>  * For `name`, capitalization (e.g. `jOhN DoE`) or extra/leading/trailing spaces does not affect the value (e.g. `John     Doe`). The NAME should not have special characters (e.g. `#`, `@`, `!` etc.).
<br>  * For `phone number`, the input must be an 8-digit number and unique.
<br>  * For `email`, the input must consist of the username and the domain name of the email service provider. It must also be unique.
<br>    * Format: `username@domain.com`
<br>  * For `level`, the input must not contain special characters (e.g. `#`, `@`, `!` etc).
<br>  * For `subject`, the input must follow the format `SUBJECT-GRADE`, as explained in the add command above.
</div>

### Deleting existing Students : `delete`

Deletes the person at the specified index from your list of contacts.

Format: `delete LIST_NUMBER`

**Example:**
1. John Doe, 98765432, Clementi Ave 123…, P5, Math-B
2. Johnny, 91234567, Jurong…, P5, Science-B
3. Johnsy Boy, 83947237, <address>..., P3, English-C

User input: `delete 3` → Johnsy Boy will be deleted.

<div markdown="span" class="alert alert-primary">
**:bulb: Caution:**
Below are some constraints to follow when inputting parameters.
<br>
**Constraints:**
<br>* For `LIST_NUMBER`, the input **must be a positive integer** 1, 2, 3, …​, and the input must be a number not greater than the size of the list.
<br>  * E.g. if the list contains 3 people, inputting `4` will print an error message.
</div>

### Finding certain Students : `find`

Find a list of persons with names matching the user input.
The entire word (i.e. `John` instead of `Joh`) should be inputted for this command to work.

Format: `find NAME`

**Examples:**
* `find John Doe`
* `find john`
* `find dOE`

<div markdown="span" class="alert alert-primary">
**:bulb: Caution:**
Below are some constraints to follow when inputting parameters.
<br>
**Constraints:**
<br>* For `NAME`, capitalization (e.g. `jOhN DoE`) or extra/leading/trailing spaces does not affect the value (e.g. `John     Doe`). The NAME should not have special characters (e.g. `#`, `@`, `!` etc.).
</div>

### Adding events : `event`

Add events to your schedule.<br>
**NOTE:** For the current version of TutorPro, you will not be able to view your events as we are still working on the [`schedule` command](#comming-soon-in-next-update--schedule) for the next update, which will be coming really soon!

Format: `event n/NAME at/TIME h/HOURS [t/TAG]...`

**Examples:**
* `event n/Bob math tutoring at/2024-03-04 12:00 h/2 t/math t/tutoring`
* `event n/John Doe science tutoring at/2024-10-10 14:00 h/1`

<div markdown="span" class="alert alert-primary">
**:bulb: Caution:**
Below are some constraints to follow when inputting parameters.
<br>
**Constraints:**
<br>* For `TIME`, the input should follow the format of `YYYY-MM-DD HH:mm`.
</div>

### Setting reminders : `remind`

Set reminders for important deadlines or milestones(e.g. O-Levels, A-Levels).<br>
**NOTE:** For the current version of TutorPro, you will not be able to view your reminders as we are still working on the [`schedule` command](#comming-soon-in-next-update--schedule) for the next update, which will be coming really soon!

Format: `remind n/DESCRIPTION at/TIME t/TAG`

**Example:**
* `remind n/Bob uni app deadline at/2024-03-04 12:00 t/urgent`

<div markdown="span" class="alert alert-primary">
**:bulb: Caution:**
Below are some constraints to follow when inputting parameters.
<br>
**Constraints:**
<br>* For `TIME`, the input should follow the format of `YYYY-MM-DD HH:mm`.
</div>

### Clearing all entries : `clear`

Clears all entries from your TutorPro list.

Format: `clear`

### Listing all persons : `list`

Shows a list of all persons in your TutorPro list.

Format: `list`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

TutorPro data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

TutorPro data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">
**:exclamation: Caution:**<br>
If your changes to the data file makes its format invalid, TutorPro will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause TutorPro to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

### Comming Soon in next update : `schedule`

Lists out events and reminders that occur in the incoming specified number of days.
If no number of days is specified, events and reminders that occur in the next 14 days will be listed.

Format: `schedule [NUMBER_OF_DAYS]`

**Example:**
* `schedule 10`
  Displays your schedule (consisting of all your events and reminders) for the next 10 days.
* `schedule`
  Displays your schedule for the next 14 days.

---

## [FAQ](#table-of-contents)

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.
**Q**: Error message says input cannot be blank but my input is not blank! What's wrong with my input?<br>
![image](https://github.com/agreatdayy/tp/assets/104555494/9da46b39-4942-414d-b9f1-4c9845555575)
**A**: Currently, TutorPro only takes in commands with ASCII characters. Please ensure that your input command only contains ASCII characters.

---

## [Known issues](#table-of-contents)

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

---

## [Command summary](#table-of-contents)

| Action       | Format, Examples                                                                                                                                                                                                           |
| ------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Add**      | `add STUDENT_NAME p/PHONE_NUMBER a/ADDRESS lvl/EDUCATION_LEVEL [sub/SUBJECT-GRADE]… [t/TAG]…​` <br> e.g. `add John Doe p/98765432 e/johndoe@gmail.com a/Clementi Ave 123, Blk 321 #10-234 lvl/p5 sub/Math-B sub/Science-B` |
| **Add parent**      | `add PARENT_NAME p/PHONE_NUMBER a/ADDRESS [t/TAG]…​` <br> e.g. `addp n/Jonny Doe p/98765432 e/jonnyd@gmail.com a/Clementi Ave 123, Blk 321, #12-345` |
| **Clear**    | `clear`                                                                                                                                                                                                                    |
| **Delete**   | `delete LIST_NUMBER` <br> e.g. `delete 3`                                             |
| **Edit**     | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [lvl/EDUCATION_LEVEL] [sub/SUBJECT-GRADE]… [t/TAG]…​`<br> e.g.`edit 2 n/James Lee e/jameslee@example.com`<br> e.g.`edit 5 sub/math-b sub/biology-c+`              |
| **Find**     | `find KEYWORD [MORE_KEYWORDS]`<br> e.g. `find James Jake`                                                                                                                                                                  |
| **List**     | `list`                                                                                                                                                                                                                     |
| **Help**     | `help`                                                                                                                                                                                                                     |
| **Event**    | `event n/NAME at/TIME h/HOURS [t/TAG]...` <br> e.g. `event n/John Doe science tutoring at/2024-10-10 h/1`                                                                                                                  |
| **Remind**   | `remind n/DESCRIPTION at/TIME t/TAG` <br> e.g. `remind n/Bob uni app deadline at/2024-03-04 12:00 t/urgent`                                                                                                                |
