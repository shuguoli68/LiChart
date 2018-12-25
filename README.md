# LiChart
kotlin编写的自定义图表控件

To get a Git project into your build:

gradle:
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.shuguoli68:LiChart:-SNAPSHOT'
	}

maven:
Step 1. Add the JitPack repository to your build file
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
Step 2. Add the dependency
<dependency>
	    <groupId>com.github.shuguoli68</groupId>
	    <artifactId>LiChart</artifactId>
	    <version>-SNAPSHOT</version>
	</dependency>
