# An Intro to TDD with Mockito #

This repo has the code for a lightning talk I made at the
[Jozi JUG](http://www.meetup.com/Jozi-JUG/) meetup on 25 March 2013.
The purpose was to show how I normally use
[Mockito](https://code.google.com/p/mockito/) to support TDD. The
application is not at all complete, but has examples of the main
Mockito features I use:

Creating a Mockito mock object `obj` of the class `Class`:

    Class obj = mock(Class.class); 
    
Stub `obj.method` to return `stubbedResponse`:

    given(obj.method(argsOrMatchers)).willReturn(stubbedResponse); 
    
Check if `obj.method` was called:

    verify(obj).method(argsOrMatchers)

Refer to the
[Mockito documentation](http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html)
for more features.
