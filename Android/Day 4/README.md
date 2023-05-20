## TOAST 

TOAST is a Kotlin-based Android application that serves as a Time Of Arrival and Service Tracker. It allows users to manage appointments, track arrival times, and record service details. The app offers features such as appointment management, arrival time tracking, service recording, and history/analytics. It utilizes Kotlin, Android SDK, Android Architecture Components (including Room, LiveData, and ViewModel), RecyclerView, and Material Components to provide a user-friendly interface and reliable functionality. TOAST enhances appointment management and provides valuable insights to users, making it an efficient and convenient tool for tracking arrival times and service records.

<br>

## SYNTAX & EXAMPLE

In Android development, the Toast class is used to display a short-lived message or notification to the user. It is typically used to show brief information or feedback.

The syntax for creating and displaying a Toast is as follows:

```Kotlin
Toast.makeText(context, message, duration).show()
``` 
<br>

 ***Context***: A reference to the current Context object. It is usually obtained from an activity or application context.
 
 ***Message***: The text message to be displayed in the Toast.
 
 ***Duration***: The duration for which the Toast will be displayed. It can be either Toast.LENGTH_SHORT for a short duration or Toast.LENGTH_LONG for a longer duration.

<br>
Here's an example that demonstrates how to display a simple Toast in Kotlin:

```Kotlin
// Inside an activity or fragment
Toast.makeText(this, "Hello, Toast!", Toast.LENGTH_SHORT).show()
```
<br>
<br>
In this example, a Toast message with the text "Hello, Toast!" will be displayed for a short duration.

<br>

## APK 

### 1. [APK 1](Module4.apk)
### 2. [APK 2](OrderApp.apk)
