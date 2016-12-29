# BalloonPopup

Displays a round or squared popup attaching it to a View. Allows animations and automatic display and hide, or persistence of the balloon when updating its value. Uses the Builder pattern for maximum ease.

<br><img src="ezgif.com-0fc591cc9d.gif" ></br>

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
        compile 'com.github.BeppiMenozzi:BalloonPopup:0.2.2'
        ...
    }

### Minimal usage

    BalloonPopup bp = BalloonPopup.Builder(getApplicationContext(), myView)
                        .text("myText")
                        .show();
                        
To show it again:

    bp.showAgain();
    
To display different text:

    bp.updateText(newText);
                        
### Examples
In addition to the simple example included, this library is used in my <a href="https://github.com/BeppiMenozzi/Knob">Knob Selector library</a>, that contains useful examples and an interesting way to use this library. Test it out.

### Customize
Available methods in the Builder:

      bp = BalloonPopup.Builder(getApplicationContext(), findViewById(R.id.button))
                        .text("text")               // set the text displayed (String or resource)
                        .timeToLive(2000)           // Millseconds before closing the popup. 0 = persistent
                        .animation(fade_and_pop)    // animation style used. Available:
                                                    // pop, scale, fade, fade75
                                                    // and all the possible combinations.
                                                    // When fade75 is used (up to alpha .75) the view is slightly transparent
                        .shape(rounded_square)      // Circle (oval) or rounded square
                        .bgColor(Color.CYAN)        // unused yet
                        .fgColor(Color.RED)         // text color
                        .gravity(bg)                // gravity relative to the attach view
                        .textSize(6)                // text size
                        .offsetX(10)                // offsets to move the position accordingly
                        .offsetY(15)
                        .positionOffset(10, 15)
                        .drawable(R.drawable.bg_circle) // custom background drawable
                        .layoutRes(R.layout.customview) // custom layout for the popup window
                        .show();                    // create, display and return the balloon

    
Available methods on the balloon:

                bp.isShowing();                     // returns wether the balloon is currently visibile
                bp.restartLifeTime();               // restarts the time to live, postponing the closure
                bp.updateText();                    // updates the text and displays it again
                bp.updateTextSize();                // updates text size and displays it again
                bp.updateFgColor();                 // updates text color and displays it again
                bp.updateBgColor();                 // updates background color: available only from Lollipop (>= 21)
                bp.updateOffset();                  // updates position and displays it again
                bp.updateGravity();                 // updates gravity and displays it again
                bp.updateLifeTimeToLive();          // updates time to live
                bp.showAgain();                     // show again the previous balloon

Most of these methods ask a boolean parameter *restartLifeTime*. If this is *false*, in case of update, if the balloon is already showing, its life is not made longer and its closure remains scheduled as before. As default this parameter is *true* (so whenever an update is done, the time to live is reset).

### New in 0.2.2
* bgcolor for >= Lollipop (21)
* fixed crash if built inside onCreate()
* increased minApk from 9 to 11

### Known bugs
On emulators with version < 4.4.4 / KitKat / Api 19 it can crash.

Author
-------
* Beppi Menozzi

License
-------
    The MIT License (MIT)

    Copyright (c) 2016 Beppi Menozzi

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
