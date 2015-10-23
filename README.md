# BCNF
Project in Cornell CS4320 to implement Boyce-Codd Normal Form (BCNF) decomposition algorithm.

# Authors
Giri Kuncoro (gk256@cornell.edu), Batu Inal (bi49@cornell.edu), Shubham Shukla (ss3469@cornell.edu)

# Description
The decomposition algorithm is implemented based on below idea:
1. Pick a subset of attributes `X` from the relation, in the code this is done with the help of powerset.
2. Find `X+`, closure of that sets of attributes with respect to the provided set of functional dependencies. The case where functional dependencies include attributes not in the relation is also considered. 
3. If `X` is superkey or determines only itself, try different set of attributes.
4. If all attributes sets have been tried, we are done.
5. Otherwise, separate table into two tables: `X+` and `X UNION (X+)^c` and recurse on each side.

In the end, the implementation will result empty sets that are counted as the size of attribute sets, clean all the empty sets to return correct decomposition size (number of tables). Also powerset is implemented based on a StackOverflow post, but using TreeSet instead of HashSet and overide the compare interface to avoid bugs in our tests.

# Acknowledgments
The code is implemented based on the algorithm provided in Homework 3 CS4320 instruction and some reference on Ramakrishnan and Gehrke's Database Management System book (3rd edition). The pseudocode written there is translated into Java code can be found in this repo. Closure helper function is implemented based on pseudocode provided here: http://web.cecs.pdx.edu/~maier/TheoryBook/MAIER/C04.pdf see `LINCLOSURE` on page 66. The powerset is implemented based on this SO post: http://stackoverflow.com/questions/1670862/obtaining-a-powerset-of-a-set-in-java
