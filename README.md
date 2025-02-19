RUNNING THE APP:
Here's the link:
https://drive.google.com/drive/folders/1i_CJ4xochzrXjmxIs3yR4OWD3TCVxxGA?usp=drive_link

DESCRIPTION : The RTSP Video Streaming App is an Android application built using XML Layout , ExoPlayer, and RTSP streaming. The app allows users to enter an RTSP URL, stream the video, and control playback with play, pause, and fullscreen mode. The application ensures a smooth user experience with minimal latency and efficient performance.

FEATURES : 
RTSP Video Streaming: Supports live streaming from an RTSP source.
Play/Pause Functionality: Users can start and stop the stream effortlessly.
Fullscreen Mode: Toggle between fullscreen and normal mode.
Minimal Latency: Optimized for smooth playback.
Error Handling: Displays meaningful messages when streaming issues occur

DEPENDENCIES:
Media3 ExoPlayer for RTSP streaming
Material Components for modern UI elements

HOW TO SET UP :
Clone the Repository
Open in Android Studio
Build & Run the App
Connect an Android device or use an emulator.
Run the project from Android Studio.
OR
Install The APK provided.

HOW TO USE :

Enter RTSP URL in the input field.
Press Play to start streaming.
Use Fullscreen Button for immersive viewing.
Press Pause to stop streaming.

CHALLENGES FACED and SOLUTIONS :

1.Finding Valid RTSP Streaming Links :
- I surfed over the entire internet , github etc to find some valid and working RTSP links but after hours(most time consuming part of the project) of findig a working one but was not able to find one. I found some links but there was no output in those links.
  
SOLUTION:
- Creatd my own RTSP Streaming link using VLC media player
  
 HOW I SET UP OWN RTSP URL :
 
-Enable VLC’s Streaming Feature
-Open VLC Media Player.
-Click on Media > Stream.
-In the Open Media window, go to the File tab and click Add to select the video file you want to stream.
-Click on Stream at the bottom.
-Configure Streaming Output(select RTSP)
-In the Stream Output window, click Next.
-Under Destination Setup, select RTSP and click Add.
-Click Next.

-Adjust Encoding Settings
-In the Transcoding Options, check Activate Transcoding.
-Select H.264 + MP3 (TS) for compatibility.
-Click Next.

-Set RTSP Server Options
-Keep Port as 8554 (default) or change it if needed.
-Ensure Stream all elementary streams is checked.
-Click Stream to start the RTSP server.
-Verify RTSP Stream
Open Command Prompt or Terminal and run:
-netstat -an | findstr 8554    : to check if stream is working

PLAY THE STREAM : 
-Open VLC  or this App on android device  (VLC to check if stream is working)
-IN VLC ,Go to Media > Open Network Stream --OR-- in this app , directly enter the RTSP URL

The URL will look like : 
rtsp://<your-ip>:8554/stream

To get ip of your computer : 
-open command prompt and run the command:
-ipconfig.







