# smackoverflow

This system is designed to be used by three different users: a Course Director, an Administrator, and a PTT Director. 

The log in screen will allow a user to select their role from a drop-down list. This will tell the system what type of user is logging in, and which GUI screen to show them.

In the CourseDirector screen, the user will be able to select which classes need cover from a drop-down list. Once this is complete, the close button will close the CourseDirectorView window.

An Administrator will see the AdminView screen. In this screen the user will see the list of courses requiring cover, previously entered by the Course Director. (Note that if a Course Director has not previously entered a list of courses in to the system during this run, this screen will not show any classes to be filled.) 
The Administrator will be able to select each class, and then select a teacher to be assigned to cover the class from a drop-down menu. Once every class has had a teacher assigned to it, the Administrator can click the "Send To Training" button. This will link the teachers name with the subjects training course object. This training will happen outside our system. The close button will close the AdministratorView window.

The PTT Director will see the PTTDirectorView screen. In this screen the user will be presented with the list of courses and the teachers that have been assigned to cover them. They will also be informed that the teachers have been enrolled in training courses to allow them to cover these classes. The PTT Director will be able to approve or deny any/all of these assignments, using a checkbox. They will then click "Confirm" to confirm their selection. Once this is complete, the close button will close the CourseDirectorView window. 

The list of teachers and the course that they are covering will be written to the permenant file once the PTT Director has finished. In future releases of the application, this fill will be able to be viewed again by the PTT Director upon log in (provided it is not overwriten first).
In future realeases we would also like to implement a database, so that information could be saved along the way. Further details can be found in our Team Report.
