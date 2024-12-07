@groovy.transform.TypeChecked
int answer() {
    return 'yay'
}
/*
org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
/Users/darrenkim/work/ace/groovy/voca/typechecked.groovy: 3: [Static type checking] -
Cannot return value of type java.lang.String for method returning int
@ line 3, column 12.
      return 'yay'
              ^
1 error
*/
