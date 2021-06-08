**Tip Calculator Tutorial**

You can’t learn to swim without stepping into the water. So today, we’re about to step into the sea of Android development by trying to develop a simple application of the Tip calculator. This post is to guide you through and provide information on creating this application. So let's get started!

**Note: This tutorial assumes that you are familiar with the basics of Kotlin for Android development.**

**Creating a New project**
First up, open your Android Studio and create a New Project with Empty Activity selected. Make sure that you select Kotlin as the language. This will display the new project in your IDE.
Understanding the basics
Once your project is displayed, you will see some files automatically prepared for you. On the left portion of your IDE, you’ll be able to see the Project structure, which lists all files from your project. From this project structure, we’ll initially focus on two important filed - `MainActivity.kt` and `activity_main.xml`.
`MainActivity.kt` will contain the code for your initial application while `activity_main.xml` will contain the UI portions. So basically, you must have understood - the code and business logic of your application would be in Java/Kt files while the UI elements and display information will be residing in XML files.

**We’re ready to get started**
Now, you might already be able to see the project created with a project structure similar to the image below:

So let’s start by defining the UI portions first. Navigate to the `activity_main.xml` and you might be able to see a TextView with Hello world already present.
If you conceptualize a tip calculator, you would probably come up with the following set of elements being required:
A couple of EditText’s to take input of Bill amount and Tip percentage
A couple more TextView’s or EditText’s to display the calculated Tip amount and Total bill

So let’s use ConstraintLayout as out parent layout and start defining these required view elements.

**Wait, what exactly is ConstraintLayout?**
ConstraintLayout allows one to create large and complex layouts with a flat view hierarchy (no nested view groups). It works in a nature that all child views are positioned relative to the parent or other child views, and it is also more flexible than other layouts. ConstraintLayout is also much more easy to use with Android Studio’s Layout Editor and you can create the entire UI by drag and drop instead of editing the XML.

As the name suggests, we need to have a set of constraints defined for each view to be displayed in the screen. Assume constraints to be something like a chain required to hold an frame. If the frame needs to be moved in some direction, all we would need to do is to tighten up the side of chain.

To define a view's position in ConstraintLayout, you must add at least one horizontal and one vertical constraint for the view. But often more are necessary for child view alignments. If constraints are not provided, by default all child views are drawn at the top-left of the layout.
That makes sense, let’s do this

So let’s define some TextView’s to act as labels for our EditText’s. So the end goal of our screen is to look something like the image here.

You might have noticed that I’ve used some default values (0 for bill and 15 percent for the tip.
All this UI can also be created simply by using the Android Studio’s interactive UI builder. All thanks to the support for ConstraintLayout. But do make sure that you read out the XML if you are using the UI method. So that you understand what properties were applied exactly.
Make sure that all of your views contain an ID defined to it. We’ll require this later.

~~

**Now let’s write some code to do the calculations**
Navigate to `MainActivity.kt` where we’ll be writing all our code for business logic.

Before we start, let’s understand some basics of Activity and what is Activity lifecycle.

**How can I create an Activity and what is it?**
You can create your own Activity by extending either the Activity or AppCompatActivity class. Activities are complete group displayed over the entire screen. They contain different views inside of it and act like a parent container for them.

**What is activity lifecycle?**
Since an activity is nothing more than piece of UI displayed in your phone window, activity lifecycle is the transitions which an activity goes through right from its creation to termination. Quite obvoiusly, this UI needs to be created while display, should be interactable as well as should be removed when we chose to close the screen or dismiss the application. Since users will often try to use multiple applications, keeping all these Activities simultaneously active would require large amounts of memory and processing power. Using up too many resources causes a device to lag and shortens battery life. To handle resource usage effectively, Android defines a lifecycle for each Activity to specify which state it is in and correspondingly manages its resources.

At any point of time, Android Activities can be in one of the following states:
- Initialised / Created
- Started
- Resumed
- Paused
- Destroyed
As an Activity moves between these states, corresponding callback methods are called by the OS. These methods are called lifecycle callbacks and they are where we can start writing code to interact with the Activity.
The different lifecycle callbacks are:
- onCreate
- onStart
- onResume
- onPause
- onStop
- onDestroy
We can override all of these callbacks in our Activities in order to define custom behaviour. However, the overridden implementations must call their superclass’ implementations. If this is not done, an exception will be thrown.

**Great! Let’s wrap up the calculations**
To contain the code for calculation, define a function which would take the input values and calculate the Tip amount and Total amount from it.
We’ll need a way to read the values from UI right? For that, we can use a method called findViewById which gives us the reference to views declared in XML. The IDs to be passed to this method are the ones we provided for each view. So, if your bill amount view was given an ID of billAmount, the code to get a reference to the view would simply be findViewById(R.id.billAmount).
Once we get a reference to the views, we can simply get values from them and even set values once the calculations are done. So basically, you’ll just need to “get” values from the bill and tip views and “set” calculated amounts to total tip and amount views.

~~

**What if I want my application to be available in different languages?**
This is quite an obvious required for many applications to be supporting multiple languages. In the new project you have created, changing phone language would still display all of the strings in the language you’ve declared them in.
Android provides a way to specify translations for different languages so that the appropriate resources are used to be displayed depending on the phone language. This is what we call as localization.
In the sample code provided, you can find strings.xml defined for two languages (english and french). Try to add a new strings.xml for a different language to understand this more clearly. 
To do this, you can simply right click on the strings or values folder and try to create a new Values resource file. Tap on the Locale from available qualifiers list and select a locale. Enter the file name as strings and we are good to go. In the newly created file, you can mention the strings of that language and that’s it. You’ve successfully added a new language support for your application.

I hope you had fun while building the Tip calculator app. Happy learning! :)
