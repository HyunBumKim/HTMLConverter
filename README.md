HTMLConverter
=============

---

#### This program converts markdown file into html file.

---

***How to run***

1.	Users perform this program through cmd and Check build.xml for building html converter

2.	Check path and execute ant (jar directory is deleted because of path of readable markdown file )


	    ant


3.	Input the input value by command line

	java -jar MarkdownConv.jar -md/test.md -html/test.html -style/plain

4.	HELP Option : when help command is input, it will explain about command

	java HTMLConverter -help

	-md/fileName.md fileName: the name of md file which will be converted into html

	-html/fileName.html fileName: the name of html file which will be created from md file

	-style/styleName styleName : there are three types 1. plain 2. fancy 3. slide

5.	If users inputs wrong input, error message will be printed

	WRONG INPUT : ERROR

**How to test coverage** 
1.  After execution for ant, execute “ant cov-test”

> ant
> ant cov-test

2. Check whether it is success or fail, execute “ant cov-report” 

> ant cov-report

3.	Find report directory and watch index.html to check coverage
