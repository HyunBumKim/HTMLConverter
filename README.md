HTMLConverter
=============

---

#### This program converts markdown file into html file.

---

**How to use**

1.	Users perform this program through cmd

	```
	javac HTMLConverter.java
	```

2.	Input the input value by command line

	```
	java HTMLConverter -md/test.md -html/test.html -style/plain
	```

3.	HELP Option : when help command is input, it will explain about command

	```
	java HTMLConverter -help


	-md/fileName.md
	fileName: the name of md file which will be converted into html


	-html/fileName.html
	fileName: the name of html file which will be created from md file


	-style/styleName
	styleName : there are three types
	    1.  plain
	    2.  fancy
	    3.  slide
	```

4.	If users inputs wrong input, error message will be printed

	```
	WRONG INPUT : ERROR
	```
