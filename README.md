# BalloonPopup

Displays a round or squared popup attaching it to a View. Allows animations and automatic display and hide, or persistence of the balloon when updating its value. Uses the Builder pattern for maximum ease.

<br><img src="ezgif.com-0fc591cc9d.gif" /></br>

### Setup
In your project's build.gradle file:

    allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
            ...
        }
    }

In your Application's or Module's build.gradle file:

    dependencies {
        ...
        compile 'com.github.BeppiMenozzi:Knob:1.2.2'
        ...
    }

### Minimal usage

    bp = BalloonPopup.Builder(getApplicationContext(), findViewById(R.id.button))
                        .text("myText")
                        .show();
                        
### Customize

### Known bugs
On emulators with version < 4.4.4 / KitKat / Api 19 it can crash.
