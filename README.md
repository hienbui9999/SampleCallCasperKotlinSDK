# SampleCallCasperKotlinSDK
A sample project that demonstrate the call to Casper Kotlin SDK

## How to run this sample

Open IntelliJ IDEA and choose "Get from VCS"

<img width="803" alt="Screen Shot 2022-06-28 at 18 20 04" src="https://user-images.githubusercontent.com/94465107/176166750-f6622eea-d922-4ff2-826e-330abfd7bb54.png">

Enter the URL of the project: https://github.com/hienbui9999/SampleCallCasperKotlinSDK.git

<img width="1440" alt="Screen Shot 2022-06-28 at 18 20 49" src="https://user-images.githubusercontent.com/94465107/176166796-bf1f4bd3-a293-458e-9e10-9fbeee09120e.png">

Click "Clone"

Click "Trust Project"

<img width="804" alt="Screen Shot 2022-06-28 at 18 22 39" src="https://user-images.githubusercontent.com/94465107/176167030-7017fb0c-9439-4d6d-8e45-cf3fb9f68f40.png">

The project is then loaded to IntelliJ IDEA, but at first with many error. Since we have not imported the CasperKotlinSDK.jar file to the project.

<img width="1440" alt="Screen Shot 2022-06-28 at 18 24 19" src="https://user-images.githubusercontent.com/94465107/176167219-fe5ca4f2-5801-44c6-b729-826b6323612d.png">

## Import the "CasperKotlinSDK.jar" file

Get the "CasperKotlinSDK.jar" file from this address https://drive.google.com/drive/u/0/folders/1BE8G2dSK-RaiFwJqehlxujs5YCGCS7QV

Download and put it to some place in your computer, for example "Downloads" folder

<img width="920" alt="Screen Shot 2022-06-28 at 18 28 24" src="https://user-images.githubusercontent.com/94465107/176167827-cef5adc1-db6d-4e31-8471-85755a8ea598.png">

Back to the IntelliJ IDEA with the "SampleCallCasperKotlinSDK" project. Choose "File->Project Structure ..." 

<img width="1440" alt="Screen Shot 2022-06-28 at 18 29 37" src="https://user-images.githubusercontent.com/94465107/176168043-32f2b67b-aae7-4177-826e-d87a5d73be33.png">

Choose "Libaries" and do as the image below

<img width="1102" alt="Screen Shot 2022-06-28 at 18 30 11" src="https://user-images.githubusercontent.com/94465107/176168915-8c3a6e5e-2797-4cab-a319-3a0762f8c90c.png">

Next step is to add the "CasperKotlinSDK.jar" file by hitting the "+" button

<img width="1100" alt="Screen Shot 2022-06-28 at 18 33 26" src="https://user-images.githubusercontent.com/94465107/176168994-fccf3299-70f9-4d2e-9b5f-8a4cca38c1d0.png">

Browse for the "CasperKotlinSDK.jar" file that you have already downloaded in the "Downloads" folder.

<img width="1251" alt="Screen Shot 2022-06-28 at 18 34 33" src="https://user-images.githubusercontent.com/94465107/176169086-633a8483-7480-4cc1-acfe-69f960a30811.png">

Click "Open" button.

You will see the "CasperKotlinSDK.jar" file being imported.

<img width="1100" alt="Screen Shot 2022-06-28 at 18 36 21" src="https://user-images.githubusercontent.com/94465107/176169231-1391265e-1b84-48a6-bea7-38355fad5722.png">

Click "Apply" and then "OK"

Wait for a while, the project will be loaded without error, like this

<img width="1440" alt="Screen Shot 2022-06-28 at 18 37 24" src="https://user-images.githubusercontent.com/94465107/176169379-e9cb880b-4cc2-4fbc-9ff9-0d174ce2a2fa.png">

If not, please choose "File-> Invalidate Caches..."

<img width="1440" alt="Screen Shot 2022-06-28 at 18 38 03" src="https://user-images.githubusercontent.com/94465107/176169490-2132eac8-26d3-4a5c-be7e-82704fc27c72.png">

Check all the check box and hit "Invalidate and Restart"

<img width="465" alt="Screen Shot 2022-06-28 at 16 35 08" src="https://user-images.githubusercontent.com/94465107/176169584-cfc2c366-0e28-4e9f-82ca-0ae92147a3c6.png">

Wait for a while for the project to fully loaded.


Right click on any blank region in the file "Main.kt" and hit "Run MainKt"

<img width="1440" alt="Screen Shot 2022-06-28 at 18 40 17" src="https://user-images.githubusercontent.com/94465107/176169917-4bd7f3e7-8ded-428a-8319-d0f5d4967560.png">

You will then see the state root hash being retrieved and printed in the log

<img width="1440" alt="Screen Shot 2022-06-28 at 18 41 05" src="https://user-images.githubusercontent.com/94465107/176170023-105bb725-f039-4360-87b8-9e0d9c78b6c8.png">






