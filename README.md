<h2 align="center">ECE 325: Object-Oriented Programming</h2>
<h1 align="center">Assignment 1: Using Standard Libraries</h1>
<h2 align="center">Danh Nguyen</h2>

<h3> 1. Introduction </h3>
  <p>
    Remote repository can be found here: <a href="https://github.com/danny-cpp/Days_old">https://github.com/danny-cpp/Days_old</a></br></br>
    This program is intended to calculate the days since the date of birth of a person (days old). This program leverage pre-existing standard library Calendar (java.util.Calendar). To highlight the encapsulation aspect of the OOP methodology, everything that can be implemented will not be hard-code again, and those are implemented must not be tampered with.</br></br>
    To be considered a well-functioning product, it must handle error and exception well. 
  </p>
  
<h3> 2. Design </h3>
  <p>
    The program must have an effective range, meaning it must be designed on a specific domain:
  </p>
  <ul>  
        <li> If the birth date is later than today date, it is invalid. </li>
        <li> If it is earlier than October 15, 1582; it is not supported. Since we use <a href="https://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian Calendar</a>. </li>
        <li> Invalid date is passed, it must either throw exception or recognize the error.
  </ul>
  <p>
    We have:</br>
    <i>Number of days old = Days left of birth year + Days between birth year and now + The day of this year</i></br></br>
    Details will be in the code itself
  </p>
  
