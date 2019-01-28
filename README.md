# androidimagevideogallery
Gallery view for Image and Video in Android.

## Features:

  Image View
  
  Video View
  
  Image Zoom
  
  Video Preview
  
  Video Play/Pause Control with Full Screen
  
  
## How to
To get a Git project into your build:

### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
### Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.sheetalkumar105:androidimagevideogallery:1.03'
	}

### Step 3. Use where you want to show gallery
	
	 ArrayList<String> paths = new ArrayList<>();
	 paths.add("Path1");
	 paths.add("Path2");
	 paths.add("Path3");
	 GalleryView.show(this,paths);
	 

## Preview:

![Sample Home](https://raw.githubusercontent.com/sheetalkumar105/androidimagevideogallery/master/assets/screen1.jpeg)

![Image View](https://raw.githubusercontent.com/sheetalkumar105/androidimagevideogallery/master/assets/screen2.jpeg)

![Video View](https://raw.githubusercontent.com/sheetalkumar105/androidimagevideogallery/master/assets/screen3.jpeg)
