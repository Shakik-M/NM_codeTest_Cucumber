# NM_codeTest_Cucumber
Stored codes for NM Code Challenge

How to run the framework:
fire the command in terminal
mvn verify -Denv=qa -Dbrowser=chrome -Dcucumber.filter.tags="@shopping"
mvn verify -Denv=stage -Dbrowser=chrome -Dcucumber.filter.tags="@shopping"
mvn verify -Denv=prod -Dbrowser=chrome -Dcucumber.filter.tags="@shopping"